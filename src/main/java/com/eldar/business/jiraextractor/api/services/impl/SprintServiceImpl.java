package com.eldar.business.jiraextractor.api.services.impl;

import com.eldar.business.jiraextractor.api.models.response.BacklogDTO;
import com.eldar.business.jiraextractor.api.models.response.IssueDTO;
import com.eldar.business.jiraextractor.api.models.response.SprintDTO;
import com.eldar.business.jiraextractor.api.services.base.BaseService;
import com.eldar.business.jiraextractor.api.services.contracts.SprintService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class SprintServiceImpl extends BaseService implements SprintService {

/** Get sprint */
    @Override
    public SprintDTO getSprint(Long sprintId) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/sprint/" + sprintId;
        return performGetRequest(apiUrl, SprintDTO.class);
    }


/** Get issues for sprint*/
    @Override
    public BacklogDTO getIssuesForSprint(Long sprintId) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/sprint/" + sprintId + "/issue";
        return performGetRequest(apiUrl, BacklogDTO.class);
    }

}
