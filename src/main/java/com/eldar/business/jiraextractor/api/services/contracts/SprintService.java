package com.eldar.business.jiraextractor.api.services.contracts;

import com.eldar.business.jiraextractor.api.models.response.IssueDTO;
import com.eldar.business.jiraextractor.api.models.response.SprintDTO;

public interface SprintService {
    SprintDTO getSprint(Long sprintId);
    IssueDTO getIssuesForSprint(Long sprintId);
}
