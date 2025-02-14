package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class DescriptionDTO {
    private String description;
    private String type;
    private String version;
    private ContentDTO[] content;

    public DescriptionDTO(String description) {
        this.description = description;
    }

}
