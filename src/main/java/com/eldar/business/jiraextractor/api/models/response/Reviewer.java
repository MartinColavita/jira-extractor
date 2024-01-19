package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Reviewer {
    private String name;
    private String approvalStatus;
    private String url;
    private String avatar;
    private String email;
    private String accountId;
}
