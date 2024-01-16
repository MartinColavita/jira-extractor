package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class TimetrackingDTO {
    private String originalEstimate;
    private String remainingEstimate;
    private String timeSpent;
    private int originalEstimateSeconds;
    private int remainingEstimateSeconds;
    private int timeSpentSeconds;
}
