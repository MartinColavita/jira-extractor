package com.eldar.business.jiraextractor.api.models.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class LocationDTO {
    private long projectId;
    private String displayName;
    private String projectName;
    private String projectKey;
    private String projectTypeKey;
    private String avatarURI;
    private String name;
}
