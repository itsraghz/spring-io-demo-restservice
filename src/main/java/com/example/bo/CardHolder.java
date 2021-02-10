package com.example.bo;

import com.example.bo.meta.CorporateMetaData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode
public class CardHolder {

    /* For Tracking */
    private long id;

    /* Actual Domain Values */
    private String orgId;
    private String corporateId;
    private String cardNumber;
    private String firstName;
    private String lastName;
    private String cardType; // C - Corporate, I - Individual
    private String isBlocked; // Y, N
    private String status; // A, D
    private double balance;
    private Date expiryDate;

    /* Audit Columns */
    private Date createdDate = new Date();
    private String createdBy = "SYSTEM";
    private Date modifiedDate;
    private String modifiedBy;

    private CorporateMetaData metaData;

    public void update() {
        if(this.getModifiedBy()==null || this.getModifiedBy().trim().length()==0) {
            this.setModifiedBy("SYSTEM");
        }
        this.setModifiedDate(new Date());
    }
}
