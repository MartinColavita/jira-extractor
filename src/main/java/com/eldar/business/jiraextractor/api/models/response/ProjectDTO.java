package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ProjectDTO {
    private String self;
    private String id;
    private String key;
    private String name;
    private AvatarUrlsDTO avatarUrls;
    private ProjectCategoryDTO projectCategory;
    private boolean simplified;
    private String style;
    private InsightDTO insight;
}
