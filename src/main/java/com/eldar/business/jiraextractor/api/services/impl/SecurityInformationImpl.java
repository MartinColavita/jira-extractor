package com.eldar.business.jiraextractor.api.services.impl;

import com.eldar.business.jiraextractor.api.models.response.VulnerabilityDTO;
import com.eldar.business.jiraextractor.api.models.response.WorkspaceDTO;
import com.eldar.business.jiraextractor.api.models.response.WorkspacesDTO;
import com.eldar.business.jiraextractor.api.services.base.BaseService;
import com.eldar.business.jiraextractor.api.services.contracts.SecurityInformationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class SecurityInformationImpl extends BaseService implements SecurityInformationService {

/** Get linked Security Workspaces*/
    @Override
    public WorkspacesDTO getLinkedSecurityWorkspaces() {
        String apiUrl = jiraUrl + "/rest/security/1.0/linkedWorkspaces";
        return performGetRequest(apiUrl, WorkspacesDTO.class);
    }


/** Get a linked Security Workspace by ID*/
    @Override
    public WorkspaceDTO getLinkedSecurityWorkspaces(Long workspaceId) {
        String apiUrl = jiraUrl + "/rest/security/1.0/linkedWorkspaces/" + workspaceId;
        return performGetRequest(apiUrl, WorkspaceDTO.class);
    }


/** Get a Vulnerability by ID*/
    @Override
    public VulnerabilityDTO getVulnerability(Long vulnerabilityId) {
        String apiUrl = jiraUrl + "/rest/security/1.0/vulnerabilities/" + vulnerabilityId;
        return performGetRequest(apiUrl, VulnerabilityDTO.class);
    }

}
