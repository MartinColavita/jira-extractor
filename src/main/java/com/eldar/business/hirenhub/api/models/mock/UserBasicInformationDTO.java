package com.eldar.business.hirenhub.api.models.mock;

public class UserBasicInformationDTO {
    private Long nationalId;
    private int nationalIdType;
    private Character gender;
    private String username;
    private String email;

    public UserBasicInformationDTO() {
    }

    public Long getNationalId() {
        return this.nationalId;
    }

    public void setNationalId(Long nationalId) {
        this.nationalId = nationalId;
    }

    public int getNationalIdType() {
        return this.nationalIdType;
    }

    public void setNationalIdType(int nationalIdType) {
        this.nationalIdType = nationalIdType;
    }

    public Character getGender() {
        return this.gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
