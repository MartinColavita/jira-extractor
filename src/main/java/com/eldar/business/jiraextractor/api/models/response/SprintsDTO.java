package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SprintsDTO {
    private int maxResults;
    private int startAt;
    private int total;
    private boolean isLast;
    private List<SprintDTO> values;
}
