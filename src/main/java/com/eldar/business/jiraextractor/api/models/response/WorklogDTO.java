package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class WorklogDTO {
    private String self;
    private AuthorDTO author;
    private AuthorDTO updateAuthor;
    private BodyDTO comment;
    private String updated;
    private VisibilityDTO visibility;
    private String started;
    private String timeSpent;
    private int timeSpentSeconds;
    private String id;
    private String issueId;
}
