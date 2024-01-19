package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class StatusDTO {
    private String self;
    private String description;
    private String iconUrl;
    private String name;
    private String id;
    private StatusCategoryDTO statusCategory;
}
