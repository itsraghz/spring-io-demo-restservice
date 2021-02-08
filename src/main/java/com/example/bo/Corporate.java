package com.example.bo;

import com.example.bo.meta.CorporateMetaData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

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

    /* Audit Columns */
    private Date createdDate = new Date();
    private String createdBy = "SYSTEM";
    private Date modifiedDate;
    private String modifiedBy;

    private CorporateMetaData metaData;

}
