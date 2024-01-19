package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class WorklogContainerDTO {
    private int startAt;
    private int maxResults;
    private int total;
    private List<WorklogDTO> worklogs;
}
