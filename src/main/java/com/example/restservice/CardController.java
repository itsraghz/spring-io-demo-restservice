package com.example.restservice;

import com.example.bo.CardHolder;
import com.example.bo.Corporate;
import com.example.bo.ProgramAdmin;
import com.example.util.CorpPGAdminUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/acrs")
public class CardController {

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

        System.out.println("IP Address :: " + address);
        return address;
    }

    @GetMapping("/")
    public List<String> defaultMethod() {
        System.out.println("Request received for the default - '/'");
        List<String> urlsList =  new ArrayList<>();
        urlsList.add("Welcome to ACRS Backend Services. Please try with any of the following URLs with the change in host and port #");
        urlsList.add("GET - http://localhost:8080/acrs/corporates/");
        urlsList.add("GET - http://localhost:8080/acrs/corporates/486");
        urlsList.add("GET - http://localhost:8080/acrs/corporates/cards");
        urlsList.add("GET - http://localhost:8080/acrs/corporates/661/cards");
        urlsList.add("-------------------------------------");
        urlsList.add("PUT - http://localhost:8080/acrs/corporates/1");
        urlsList.add("PUT - http://localhost:8080/acrs/corporates/1/Raghs");
        urlsList.add("GET - http://localhost:8080/acrs/cardHolders/");
        urlsList.add("GET - http://localhost:8080/acrs/cardHolders/corporate/486");
        urlsList.add("PUT - http://localhost:8080/acrs/cardHolder/1");
        urlsList.add("PUT - http://localhost:8080/arcs/cardHolder/1/Raghs");
        urlsList.add("GET - http://localhost:8080/acrs/pgAdmins/");
        urlsList.add("GET - http://localhost:8080/acrs/pgAdmins/1");
        urlsList.add("GET - http://localhost:8080/acrs/pgAdmins/corporate/540");
        urlsList.add("PUT - http://localhost:8080/acrs/pgAdmins/1");
        urlsList.add("PUT - http://localhost:8080/arcs/pgAdmins/1/Raghs");

        for(String url: urlsList) {
            if(!url.startsWith("--")) {
                System.out.println(url);
            }
        }

        return urlsList;
    }

    @GetMapping("/corporates")
    public List<Corporate> getAllCorporates() {
        System.out.println("/corporates - GET request received");
        List<Corporate> corporateList = CorpPGAdminUtil.corporateList;
        CorpPGAdminUtil.addMetaDataForCorporate(corporateList);
        return corporateList;
    }

    @GetMapping("/corporates/{orgId}")
    public Corporate getCorporateByOrgId(@PathVariable(name="orgId")String orgId) {
        System.out.println("/corporates/{orgId} - GET request received, PathVariable orgId :: " + orgId);
        return CorpPGAdminUtil.getCorporateByOrgId(orgId);
    }

    @GetMapping("/corporates/cards")
    public List<Corporate> getCorpCards() {
        System.out.println("/corporates/cards - GET request received");
        return CorpPGAdminUtil.addCardHolderToCorporate();
    }

    @GetMapping("/corporates/{orgId}/cards")
    public Corporate getCorpCardsForOrgId(@PathVariable(name="orgId")String orgId) {
        System.out.println("/corporates/{orgId}/cards - GET request received, PathVariable orgId :: " + orgId);
        return CorpPGAdminUtil.addCardHolderToCorporateForOrgId(orgId);
    }

    @PutMapping("/corporates/{orgId}")
    //@PutMapping("/corporates/{orgId}/{userName}")
    public void updateCorporate(@PathVariable(name="orgId") String orgId,
                                @RequestBody Corporate corporateParam) {
        System.out.println("/corporate/{orgId}/ - PUT request received, PathVariable orgId :: " + orgId);
        System.out.println("PathVariable corporateParam :: " + corporateParam);

        CorpPGAdminUtil.updateCorporate(orgId, null, corporateParam);
    }

    @PutMapping("/corporates/{orgId}/{userName}")
    public void updateCorporate(@PathVariable(name="orgId") String orgId,
                                @PathVariable(name="userName", required = false) String userName,
                                @RequestBody Corporate corporateParam) {
        System.out.println("/corporate/{orgId}/{userName} - PUT request received, PathVariable orgId :: " + orgId + ", userName :: " + userName);
        System.out.println("PathVariable corporateParam :: " + corporateParam);

        CorpPGAdminUtil.updateCorporate(orgId, userName, corporateParam);
    }

    // ////////////////////////////////////////////////////////////////////////////////
    //                                  CardHolders                                  //
    // ////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/cardHolders")
    public List<CardHolder> getAllCardHolders() {
        System.out.println("/cardHolders - GET request received");
        List<CardHolder> cardHolderList = CorpPGAdminUtil.cardHolderList;
        CorpPGAdminUtil.addMetadataForCardHolders(cardHolderList);
        return cardHolderList;
    }

    @GetMapping("/cardHolders/{Id}")
    public CardHolder getCardHolder(@PathVariable(name="Id")String Id) {
        System.out.println("/cardHolders/{Id} - GET request received, PathVariable Id :: " + Id);

        return CorpPGAdminUtil.getCardHolderById(Id);
    }

    @GetMapping("/cardHolders/corporate/{orgId}")
    public List<CardHolder> getAllCardHolders(@PathVariable(name="orgId")String orgId) {
        System.out.println("/cardHolders/corporate/{orgId} - GET request received, PathVariable orgId :: " + orgId);
        List<CardHolder> cardHolderList = CorpPGAdminUtil.getCardHoldersByOrgId(orgId);
        CorpPGAdminUtil.addMetadataForCardHolders(cardHolderList);
        return cardHolderList;
    }

    @PutMapping("/cardHolders/{Id}")
    public void updateCardHolder(@PathVariable(name="Id") String Id,
                                @RequestBody CardHolder cardHolderParam) {
        System.out.println("/cardHolder/{Id}/ - PUT request received, PathVariable Id :: " + Id);
        System.out.println("PathVariable corporateParam :: " + cardHolderParam);

        CorpPGAdminUtil.updateCardHolder(Id, null, cardHolderParam);
    }

    @PutMapping("/cardHolders/{Id}/{userName}")
    public void updateCardHolder(@PathVariable(name="Id") String Id,
                                @PathVariable(name="userName", required = false) String userName,
                                @RequestBody CardHolder cardHolderParam) {
        System.out.println("/cardHolder/{Id}/{userName} - PUT request received, PathVariable Id :: " + Id + ", userName :: " + userName);
        System.out.println("PathVariable cardHolderParam :: " + cardHolderParam);

        CorpPGAdminUtil.updateCardHolder(Id, userName, cardHolderParam);
    }

    // ////////////////////////////////////////////////////////////////////////////////
    //                                  PG Admin                                     //
    // ////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/pgAdmins")
    public List<ProgramAdmin> getAllPGAdmins() {
        System.out.println("/pgAdmins - GET request received");
        List<ProgramAdmin> _pgAdminsList = CorpPGAdminUtil.pgAdminList;
        CorpPGAdminUtil.addMetadataForPGAdmin(_pgAdminsList);
        return _pgAdminsList;
    }

    @GetMapping("/pgAdmins/{Id}")
    public ProgramAdmin getPGAdmins(@PathVariable(name="Id")String Id) {
        System.out.println("/pgAdmins/{Id} - GET request received, PathVariable Id :: " + Id);

        return CorpPGAdminUtil.getPGAdminById(Id);
    }

    @GetMapping("/pgAdmins/corporate/{orgId}")
    public List<ProgramAdmin> getAllPGAdmins(@PathVariable(name="orgId")String orgId) {
        System.out.println("/pgAdmins/corporate/{orgId} - GET request received, PathVariable orgId :: " + orgId);
        List<ProgramAdmin> _pgAdminsList = CorpPGAdminUtil.getPGAdminsByOrgId(orgId);
        CorpPGAdminUtil.addMetadataForPGAdmin(_pgAdminsList);
        return _pgAdminsList;
    }

    @PutMapping("/pgAdmins/{Id}")
    public void updatePGAdmin(@PathVariable(name="Id") String Id,
                                 @RequestBody ProgramAdmin pgAdminParam) {
        System.out.println("/pgAdmins/{Id}/ - PUT request received, PathVariable Id :: " + Id);
        System.out.println("PathVariable pgAdminParam :: " + pgAdminParam);

        CorpPGAdminUtil.updatePGAdmin(Id, null, pgAdminParam);
    }

    @PutMapping("/pgAdmins/{Id}/{userName}")
    public void updatePGAdmin(@PathVariable(name="Id") String Id,
                                 @PathVariable(name="userName", required = false) String userName,
                                 @RequestBody ProgramAdmin pgAdminParam) {
        System.out.println("/cardHolder/{Id}/{userName} - PUT request received, PathVariable Id :: " + Id + ", userName :: " + userName);
        System.out.println("PathVariable cardHolderParam :: " + pgAdminParam);

        CorpPGAdminUtil.updatePGAdmin(Id, userName, pgAdminParam);
    }


}