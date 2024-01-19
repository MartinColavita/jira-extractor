package com.eldar.business.jiraextractor.api.services.contracts;


import com.eldar.business.jiraextractor.api.models.response.VulnerabilityDTO;
import com.eldar.business.jiraextractor.api.models.response.WorkspaceDTO;
import com.eldar.business.jiraextractor.api.models.response.WorkspacesDTO;

public interface SecurityInformationService {
    WorkspacesDTO getLinkedSecurityWorkspaces();
    WorkspaceDTO getLinkedSecurityWorkspaces(Long workspaceId);
    VulnerabilityDTO getVulnerability(Long vulnerabilityId);
}
