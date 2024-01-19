package com.eldar.business.jiraextractor.api.services.contracts;

import com.eldar.business.jiraextractor.api.models.response.IssueDTO;
import com.eldar.business.jiraextractor.api.models.response.IssueEstimationDTO;

public interface IssueService {
    IssueDTO getIssue(Long issueIdOrKey);
    IssueEstimationDTO getIssueEstimationForBoard(Long boardId, Long issueId);
}
