package com.example.bo;

import com.example.bo.meta.CorporateMetaData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode
public class Corporate {

    /* For Tracking */
    private long id;

    private String orgId;
    private String corpId;
    private String name;
    private String city;
    private String country;

    private List<CardHolder> cardHolderList = new ArrayList<>();

    /* Audit Columns */
    private Date createdDate = new Date();
    private String createdBy = "SYSTEM";
    private Date modifiedDate;
    private String modifiedBy;

    private CorporateMetaData metaData;
}
