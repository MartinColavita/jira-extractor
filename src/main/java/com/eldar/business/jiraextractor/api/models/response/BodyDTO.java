package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class BodyDTO {
    private String type;
    private int version;
    private List<ContentDTO> content;
}
