package com.eldar.business.jiraextractor.api.services.contracts;

import com.eldar.business.jiraextractor.api.models.response.BacklogDTO;
import com.eldar.business.jiraextractor.api.models.response.EpicDTO;

public interface EpicService {
    BacklogDTO getIssuesWithoutEpic();
    EpicDTO getEpic(String epicIdOrKey);
    BacklogDTO getIssuesForEpic(String epicIdOrKey);
}
