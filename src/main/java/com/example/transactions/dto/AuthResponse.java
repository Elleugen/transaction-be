package com.example.transactions.dto;

public class AuthResponse {

    private String accessToken;
    private String corporateAccountNo;
    private String corporateName;
    private String userId;
    private String userName;
    private String role;
    private String phoneNo;
    private String email;

    public AuthResponse(String accessToken, String corporateAccountNo, String corporateName, String userId, String userName, String role, String phoneNo, String email) {
        this.accessToken = accessToken;
        this.corporateAccountNo = corporateAccountNo;
        this.corporateName = corporateName;
        this.userId = userId;
        this.userName = userName;
        this.role = role;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getCorporateAccountNo() {
        return corporateAccountNo;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getRole() {
        return role;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }
}
