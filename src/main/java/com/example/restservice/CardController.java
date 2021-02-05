package com.example.restservice;

import com.example.bo.CardHolder;
import com.example.bo.Corporate;
import com.example.util.CorpPGAdminUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController {

    @GetMapping("/corporates")
    public List<Corporate> getAllCorporates() {
        System.out.println("/corporates - GET request received");
        return CorpPGAdminUtil.corporateList;
    }

    @GetMapping("/cardHolders/")
    public List<CardHolder> getAllCardHolders() {
        System.out.println("/cardHolders - GET request received");
        return CorpPGAdminUtil.cardHolderList;
    }

    @GetMapping("/cardHolders/{orgId}")
    public List<CardHolder> getAllCardHolders(@PathVariable(name="orgId")String orgId) {
        System.out.println("/cardHolders/{orgId} - GET request received, PathVariable orgId :: " + orgId);
        return CorpPGAdminUtil.getCardHoldersByOrgId(orgId);
    }
}
