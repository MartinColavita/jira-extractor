package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ValueDTO {
    private String self;
    private String id;
    private String key;
    private String name;
    private String projectTypeKey;
    private boolean simplified;
    private AvatarUrlsDTO avatarUrls;
}
