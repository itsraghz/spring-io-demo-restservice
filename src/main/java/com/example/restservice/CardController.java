package com.example.restservice;

import com.example.bo.CardHolder;
import com.example.bo.Corporate;
import com.example.bo.ProgramAdmin;
import com.example.util.CorpPGAdminUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/acrs")
public class CardController {

    @GetMapping("/")
    public List<String> defaultMethod() {
        System.out.println("Request received for the default - '/'");
        List<String> urlsList =  new ArrayList<>();
        urlsList.add("Welcome to ACRS Backend Services. Please try with any of the following URLs with the change in host and port #");
        urlsList.add("http://localhost:8080/acrs/corporates/");
        urlsList.add("http://localhost:8080/acrs/corporates/486");
        urlsList.add("http://localhost:8080/acrs/cardHolders/");
        urlsList.add("http://localhost:8080/acrs/cardHolders/486");
        urlsList.add("http://localhost:8080/acrs/pgAdmins/");
        urlsList.add("http://localhost:8080/acrs/pgAdmins/486");
        urlsList.add("http://localhost:8080/acrs/corporates/cards");
        urlsList.add("http://localhost:8080/acrs/corporates/661/cards");
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

    @GetMapping("/cardHolders")
    public List<CardHolder> getAllCardHolders() {
        System.out.println("/cardHolders - GET request received");
        List<CardHolder> cardHolderList = CorpPGAdminUtil.cardHolderList;
        CorpPGAdminUtil.addMetadataForCardHolders(cardHolderList);
        return cardHolderList;
    }

    @GetMapping("/cardHolders/{orgId}")
    public List<CardHolder> getAllCardHolders(@PathVariable(name="orgId")String orgId) {
        System.out.println("/cardHolders/{orgId} - GET request received, PathVariable orgId :: " + orgId);
        List<CardHolder> cardHolderList = CorpPGAdminUtil.getCardHoldersByOrgId(orgId);
        CorpPGAdminUtil.addMetadataForCardHolders(cardHolderList);
        return cardHolderList;
    }

    @GetMapping("/pgAdmins")
    public List<ProgramAdmin> getAllPGAdmins() {
        System.out.println("/pgAdmins - GET request received");
        List<ProgramAdmin> _pgAdminsList = CorpPGAdminUtil.pgAdminList;
        CorpPGAdminUtil.addMetadataForPGAdmin(_pgAdminsList);
        return _pgAdminsList;
    }

    @GetMapping("/pgAdmins/{orgId}")
    public List<ProgramAdmin> getAllPGAdmins(@PathVariable(name="orgId")String orgId) {
        System.out.println("/pgAdmins/{orgId} - GET request received, PathVariable orgId :: " + orgId);
        List<ProgramAdmin> _pgAdminsList = CorpPGAdminUtil.getPGAdminsByOrgId(orgId);
        CorpPGAdminUtil.addMetadataForPGAdmin(_pgAdminsList);
        return _pgAdminsList;
    }
}