package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class FeatureDTO {
    private String boardFeature;
    private Long boardId;
    private String state;
    private String localisedName;
    private String localisedDescription;
    private String learnMoreLink;
    private String imageUri;
    private String featureType;
    private String localisedGroup;
    private List<PermissibleEstimationTypeDTO> permissibleEstimationTypeDTOS;
    private String featureId;
    private String learnMoreArticleId;
    private Boolean toggleLocked;
}
