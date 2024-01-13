package com.eldar.business.jiraextractor.api.models.mock;

public class UserDataDTO extends UserBasicInformationDTO {
    private String cardNumber;
    private String expirationDate;
    private String cvv;

    public UserDataDTO() {
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return this.cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
