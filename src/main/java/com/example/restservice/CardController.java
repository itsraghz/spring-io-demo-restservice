package com.example.restservice;

import com.example.bo.CardHolder;
import com.example.bo.Corporate;
import com.example.bo.ProgramAdmin;
import com.example.util.CorpPGAdminUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/acrs")
public class CardController {

    private static final Logger logger
            = LoggerFactory.getLogger(CardController.class);

    @Value("${server.port}")
    private int serverPortFromConfigFile;

    String ip = InetAddress.getLocalHost().getHostAddress();
    String hostName = InetAddress.getLocalHost().getHostName();

    /*@LocalServerPort
    private int localServerPort;*/

    @Autowired
    private ServerProperties serverProperties;

    //private int localServerPort = serverProperties.getPort();

    public CardController() throws UnknownHostException {
    }

    @GetMapping(path = "/print-caller-address")
    public String getCallerAddress(HttpServletRequest request) {
        return getIPAddress(request);
    }

    public String getIPAddress(HttpServletRequest request) {
        String address = null;
        if(request.getHeader("X-Forwarded-For") != null){
            address = request.getHeader("X-Forwarded-For");
        }else{
            address = request.getRemoteAddr();
        }

        logger.info("IP Address :: " + address);
        return address;
    }

    private String getURL(String hostName, String ipAddr, int portNo, String urlToAppend) {
        String urlWithHostName = "http://" + hostName + ":" + portNo + "/" + urlToAppend;
        String urlWithIPAddress = "http://" + ipAddr + ":" + portNo + "/" + urlToAppend;

        return urlWithIPAddress  + " | " + urlWithHostName;
    }

    @GetMapping("/")
    public List<String> defaultMethod() {
        int localServerPort = serverProperties.getPort();
        logger.info("Request received for the default - '/'");
        logger.info("[**] Server is running on IP Address # "  + ip);
        logger.info("[**] Server is running on HostName : ["  + hostName + "]");
        logger.info("[**] Server is listening on Port (serverPortFromConfigFile) # "  + serverPortFromConfigFile);
        logger.info("[**] Server is listening on Port # (serverProperties) "  + localServerPort);

        //String hostNameAndPort = "http://" + hostName + ":" + localServerPort + "/";
        //String ipAddressAndPort = "http://" + ip + ":" + localServerPort + "/";
        List<String> urlsList =  new ArrayList<>();
        urlsList.add("Welcome to ACRS Backend Services. Please try with any of the following URLs with the change in host and port #");
        //urlsList.add("http://localhost:8080/swagger-ui.html");
        urlsList.add(getURL(hostName, ip, localServerPort, "swagger-ui.html"));
        urlsList.add("-------------------------------------");
        //urlsList.add("GET - http://localhost:8080/acrs/corporates/");
        urlsList.add("GET - " + getURL(hostName, ip, localServerPort, "acrs/corporates"));
        urlsList.add("GET - " + getURL(hostName, ip, localServerPort, "acrs/corporates/486"));
        urlsList.add("GET - " + getURL(hostName, ip, localServerPort, "acrs/corporates/cards"));
        urlsList.add("GET - " + getURL(hostName, ip, localServerPort, "acrs/corporates/661/cards"));
        urlsList.add("-------------------------------------");
        urlsList.add("PUT - " + getURL(hostName, ip, localServerPort, "acrs/corporates/1"));
        urlsList.add("PUT - " + getURL(hostName, ip, localServerPort, "acrs/corporates/1/Raghs"));
        urlsList.add("GET - " + getURL(hostName, ip, localServerPort, "acrs/cardHolders/"));
        urlsList.add("GET - " + getURL(hostName, ip, localServerPort, "acrs/cardHolders/corporate/486"));
        urlsList.add("PUT - " + getURL(hostName, ip, localServerPort, "acrs/cardHolder/1"));
        urlsList.add("PUT - " + getURL(hostName, ip, localServerPort, "/arcs/cardHolder/1/Raghs"));
        urlsList.add("GET - " + getURL(hostName, ip, localServerPort, "acrs/pgAdmins/"));
        urlsList.add("GET - " + getURL(hostName, ip, localServerPort, "acrs/pgAdmins/1"));
        urlsList.add("GET - " + getURL(hostName, ip, localServerPort, "acrs/pgAdmins/corporate/540"));
        urlsList.add("PUT - " + getURL(hostName, ip, localServerPort, "acrs/pgAdmins/1"));
        urlsList.add("PUT - " + getURL(hostName, ip, localServerPort, "/arcs/pgAdmins/1/Raghs"));
        urlsList.add("GET - " + getURL(hostName, ip, localServerPort, "acrs/corporates/pgAdmins"));
        urlsList.add("GET - " + getURL(hostName, ip, localServerPort, "acrs/corporates/123/pgAdmins"));

        for(String url: urlsList) {
            if(!url.startsWith("--")) {
                logger.info(url);
            }
        }

        return urlsList;
    }

    @GetMapping("/corporates")
    public List<Corporate> getAllCorporates() {
        logger.info("/corporates - GET request received");
        List<Corporate> corporateList = CorpPGAdminUtil.corporateList;
        CorpPGAdminUtil.addMetaDataForCorporate(corporateList);
        return corporateList;
    }

    @GetMapping("/corporates/{orgId}")
    public Corporate getCorporateByOrgId(@PathVariable(name="orgId")String orgId) {
        logger.info("/corporates/{orgId} - GET request received, PathVariable orgId :: " + orgId);
        return CorpPGAdminUtil.getCorporateByOrgId(orgId);
    }

    @GetMapping("/corporates/cards")
    public List<Corporate> getCorpCards() {
        logger.info("/corporates/cards - GET request received");
        return CorpPGAdminUtil.addCardHolderToCorporate();
    }

    @GetMapping("/corporates/{orgId}/cards")
    public Corporate getCorpCardsForOrgId(@PathVariable(name="orgId")String orgId) {
        logger.info("/corporates/{orgId}/cards - GET request received, PathVariable orgId :: " + orgId);
        return CorpPGAdminUtil.addCardHolderToCorporateForOrgId(orgId);
    }

    @PutMapping("/corporates/{orgId}")
    //@PutMapping("/corporates/{orgId}/{userName}")
    public void updateCorporate(@PathVariable(name="orgId") String orgId,
                                @RequestBody Corporate corporateParam) {
        logger.info("/corporate/{orgId}/ - PUT request received, PathVariable orgId :: " + orgId);
        logger.info("PathVariable corporateParam :: " + corporateParam);

        CorpPGAdminUtil.updateCorporate(orgId, null, corporateParam);
    }

    @PutMapping("/corporates/{orgId}/{userName}")
    public void updateCorporate(@PathVariable(name="orgId") String orgId,
                                @PathVariable(name="userName", required = false) String userName,
                                @RequestBody Corporate corporateParam) {
        logger.info("/corporate/{orgId}/{userName} - PUT request received, PathVariable orgId :: " + orgId + ", userName :: " + userName);
        logger.info("PathVariable corporateParam :: " + corporateParam);

        CorpPGAdminUtil.updateCorporate(orgId, userName, corporateParam);
    }

    // ////////////////////////////////////////////////////////////////////////////////
    //                                  CardHolders                                  //
    // ////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/cardHolders")
    public List<CardHolder> getAllCardHolders() {
        logger.info("/cardHolders - GET request received");
        List<CardHolder> cardHolderList = CorpPGAdminUtil.cardHolderList;
        CorpPGAdminUtil.addMetadataForCardHolders(cardHolderList);
        return cardHolderList;
    }

    @GetMapping("/cardHolders/{Id}")
    public CardHolder getCardHolder(@PathVariable(name="Id")String Id) {
        logger.info("/cardHolders/{Id} - GET request received, PathVariable Id :: " + Id);

        return CorpPGAdminUtil.getCardHolderById(Id);
    }

    @GetMapping("/cardHolders/corporate/{orgId}")
    public List<CardHolder> getAllCardHolders(@PathVariable(name="orgId")String orgId) {
        logger.info("/cardHolders/corporate/{orgId} - GET request received, PathVariable orgId :: " + orgId);
        List<CardHolder> cardHolderList = CorpPGAdminUtil.getCardHoldersByOrgId(orgId);
        CorpPGAdminUtil.addMetadataForCardHolders(cardHolderList);
        return cardHolderList;
    }

    @PutMapping("/cardHolders/{Id}")
    public void updateCardHolder(@PathVariable(name="Id") String Id,
                                @RequestBody CardHolder cardHolderParam) {
        logger.info("/cardHolder/{Id}/ - PUT request received, PathVariable Id :: " + Id);
        logger.info("PathVariable corporateParam :: " + cardHolderParam);

        CorpPGAdminUtil.updateCardHolder(Id, null, cardHolderParam);
    }

    @PutMapping("/cardHolders/{Id}/{userName}")
    public void updateCardHolder(@PathVariable(name="Id") String Id,
                                @PathVariable(name="userName", required = false) String userName,
                                @RequestBody CardHolder cardHolderParam) {
        logger.info("/cardHolder/{Id}/{userName} - PUT request received, PathVariable Id :: " + Id + ", userName :: " + userName);
        logger.info("PathVariable cardHolderParam :: " + cardHolderParam);

        CorpPGAdminUtil.updateCardHolder(Id, userName, cardHolderParam);
    }

    // ////////////////////////////////////////////////////////////////////////////////
    //                                  PG Admin                                     //
    // ////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/pgAdmins")
    public List<ProgramAdmin> getAllPGAdmins() {
        logger.info("/pgAdmins - GET request received");
        List<ProgramAdmin> _pgAdminsList = CorpPGAdminUtil.pgAdminList;
        CorpPGAdminUtil.addMetadataForPGAdmin(_pgAdminsList);
        return _pgAdminsList;
    }

    @GetMapping("/pgAdmins/{Id}")
    public ProgramAdmin getPGAdmins(@PathVariable(name="Id")String Id) {
        logger.info("/pgAdmins/{Id} - GET request received, PathVariable Id :: " + Id);

        return CorpPGAdminUtil.getPGAdminById(Id);
    }

    @GetMapping("/pgAdmins/corporate/{orgId}")
    public List<ProgramAdmin> getAllPGAdmins(@PathVariable(name="orgId")String orgId) {
        logger.info("/pgAdmins/corporate/{orgId} - GET request received, PathVariable orgId :: " + orgId);
        List<ProgramAdmin> _pgAdminsList = CorpPGAdminUtil.getPGAdminsByOrgId(orgId);
        CorpPGAdminUtil.addMetadataForPGAdmin(_pgAdminsList);
        return _pgAdminsList;
    }

    @PutMapping("/pgAdmins/{Id}")
    public void updatePGAdmin(@PathVariable(name="Id") String Id,
                                 @RequestBody ProgramAdmin pgAdminParam) {
        logger.info("/pgAdmins/{Id}/ - PUT request received, PathVariable Id :: " + Id);
        logger.info("PathVariable pgAdminParam :: " + pgAdminParam);

        CorpPGAdminUtil.updatePGAdmin(Id, null, pgAdminParam);
    }

    @PutMapping("/pgAdmins/{Id}/{userName}")
    public void updatePGAdmin(@PathVariable(name="Id") String Id,
                                 @PathVariable(name="userName", required = false) String userName,
                                 @RequestBody ProgramAdmin pgAdminParam) {
        logger.info("/cardHolder/{Id}/{userName} - PUT request received, PathVariable Id :: " + Id + ", userName :: " + userName);
        logger.info("PathVariable cardHolderParam :: " + pgAdminParam);

        CorpPGAdminUtil.updatePGAdmin(Id, userName, pgAdminParam);
    }
    @GetMapping("/corporates/pgAdmins")
    public List<Corporate> getCorpPGAdmins() {
        logger.info("/corporates/pgAdmins - GET request received");
        return CorpPGAdminUtil.addPGAdminToCorporate();
    }

    @GetMapping("/corporates/{orgId}/pgAdmins")
    public Corporate getCorpPGAdminsForOrgId(@PathVariable(name="orgId")String orgId) {
        logger.info("/corporates/{orgId}/pgAdmins - GET request received, PathVariable orgId :: " + orgId);
        return CorpPGAdminUtil.addPGAdminToCorporateForOrgId(orgId);
    }
}