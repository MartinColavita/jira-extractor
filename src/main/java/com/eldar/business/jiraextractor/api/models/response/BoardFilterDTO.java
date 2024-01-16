package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class BoardFilterDTO {
    private int maxResults;
    private int startAt;
    private int total;
    private boolean isLast;
    private BoardFilterValuesDTO[] values;
}
