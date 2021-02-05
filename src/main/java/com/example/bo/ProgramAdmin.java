package com.example.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class ProgramAdmin {

    private String org;
    private String corporateId;
    private String pgAdminId;
    private String billingEntity;
    private String accessRights;
    private String status; // A, D
    // C - Central PA, A - Authorizing Officer, P - Primary PA, M - Master PA, N - NonPA
    private String pgAdminType;
}
