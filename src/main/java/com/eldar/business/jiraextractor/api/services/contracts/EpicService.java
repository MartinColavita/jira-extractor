package com.eldar.business.jiraextractor.api.services.contracts;

import com.eldar.business.jiraextractor.api.models.response.BacklogDTO;
import com.eldar.business.jiraextractor.api.models.response.EpicDTO;

public interface EpicService {
    BacklogDTO getIssuesWithoutEpic();
    EpicDTO getEpic(Long epicIdOrKey);
    BacklogDTO getIssuesForEpic(Long epicIdOrKey);
}
