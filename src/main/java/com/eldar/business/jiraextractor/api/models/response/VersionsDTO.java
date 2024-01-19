package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VersionsDTO {
    private int maxResults;
    private int startAt;
    private boolean isLast;
    private List<Object> values; // Reemplazar Object con la clase que representa los objetos de "values"
}
