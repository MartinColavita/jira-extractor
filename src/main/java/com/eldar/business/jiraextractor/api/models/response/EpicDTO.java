package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class EpicDTO {
    private String id;
    private String self;
    private String name;
    private String summary;
    private ColorDTO color;
    private boolean done;
}
