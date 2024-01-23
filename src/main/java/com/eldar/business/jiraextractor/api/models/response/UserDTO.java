package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class UserDTO {
    private String self;
    private String accountId;
    private String emailAddress;
    private AvatarUrlsDTO avatarUrls;
    private String displayName;
    private boolean active;
    private String timeZone;
    private String accountType;
    private String locale;
}
