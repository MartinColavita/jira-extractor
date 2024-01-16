package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class AuthorDTO {
    private String self;
    private String accountId;
    private String displayName;
    private boolean active;
}
