package com.example.bo;

import com.example.bo.meta.CorporateMetaData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode
public class ProgramAdmin {

    /* For Tracking */
    private long id;

    private String orgId;
    private String corporateId;
    private String pgAdminId;
    private String pgAdminName;
    private String billingEntity;
    private String accessRights;
    private String status; // A, D
    // C - Central PA, A - Authorizing Officer, P - Primary PA, M - Master PA, N - NonPA
    private String pgAdminType;

    /* Audit Columns */
    private Date createdDate = new Date();
    private String createdBy = "SYSTEM";
    private Date modifiedDate;
    private String modifiedBy;

    private CorporateMetaData metaData;
}
