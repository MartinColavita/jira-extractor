package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class IssueDTO {
    private String expand;
    private String id;
    private String self;
    private String key;
    private FieldsDTO fields;
}
