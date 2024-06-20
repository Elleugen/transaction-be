package com.example.transactions.model;

import jakarta.persistence.*;

@Entity
public class Corporate {
    @Id
    private String corporateAccountNo;
    private String corporateName;

    // getters and setters

    public String getCorporateAccountNo() {
        return corporateAccountNo;
    }

    public void setCorporateAccountNo(String corporateAccountNo) {
        this.corporateAccountNo = corporateAccountNo;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }
}
