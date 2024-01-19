package com.eldar.business.jiraextractor.api.services.impl;

import com.eldar.business.jiraextractor.api.models.response.IssueDTO;
import com.eldar.business.jiraextractor.api.models.response.IssueEstimationDTO;
import com.eldar.business.jiraextractor.api.services.base.BaseService;
import com.eldar.business.jiraextractor.api.services.contracts.IssueService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class IssueServiceImpl extends BaseService implements IssueService {

/** Get issue*/
    @Override
    public IssueDTO getIssue(Long issueIdOrKey) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/issue/" + issueIdOrKey;
        return performGetRequest(apiUrl, IssueDTO.class);
    }


/** Get issue estimation for board*/
    @Override
    public IssueEstimationDTO getIssueEstimationForBoard(Long boardId, Long issueId) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/issue/" + issueId + "/estimation?boardId=" + boardId;
        return performGetRequest(apiUrl, IssueEstimationDTO.class);
    }


}
