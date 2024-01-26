package com.eldar.business.jiraextractor.api.services.contracts;

import com.eldar.business.jiraextractor.api.models.response.IssueDTO;
import com.eldar.business.jiraextractor.api.models.response.IssueEstimationDTO;

public interface IssueService {
    IssueDTO getIssue(String issueIdOrKey);
    IssueEstimationDTO getIssueEstimationForBoard(String issueIdOrKey, Long boardId);
}
