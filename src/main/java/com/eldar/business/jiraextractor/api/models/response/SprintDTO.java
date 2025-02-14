package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SprintDTO {
    private String id;
    private String self;
    private String state;
    private String name;
    private String startDate;
    private String endDate;
    private String completeDate;
    private String createdDate;
    private int originBoardId;
    private String goal;
}