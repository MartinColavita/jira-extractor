package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class BoardDTO {
    private long id;
    private String self;
    private String name;
    private String type;
    private LocationDTO location;
}
