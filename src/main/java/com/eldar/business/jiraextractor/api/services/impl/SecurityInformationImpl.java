package com.eldar.business.jiraextractor.api.services.impl;

import com.eldar.business.jiraextractor.api.exceptions.customs.BadRequestException;
import com.eldar.business.jiraextractor.api.models.response.VulnerabilityDTO;
import com.eldar.business.jiraextractor.api.models.response.WorkspaceDTO;
import com.eldar.business.jiraextractor.api.models.response.WorkspacesDTO;
import com.eldar.business.jiraextractor.api.services.contracts.SecurityInformationService;
import com.eldar.business.jiraextractor.config.RestTemplateConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Base64;


@Slf4j
@RequiredArgsConstructor
@Service
public class SecurityInformationImpl implements SecurityInformationService {

    private final RestTemplateConfig restTemplateConfig;

    @Value("${jira.url}")
    private String jiraUrl;

    @Value("${jira.username}")
    private String jiraUsername;

    @Value("${jira.token}")
    private String jiraToken;



    /** Creates and returns the headers required for authentication in Jira. */
    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + Base64.getEncoder().encodeToString((jiraUsername + ":" + jiraToken).getBytes()));
        log.info("----> headers: {}", headers);
        return headers;
    }


    /** Performs a GET request to the Jira API with the provided URL and specified response type.
     * @param apiUrl       The URL of the Jira API for the GET request.
     * @param responseType The expected response type.
     * @throws BadRequestException If the response is not successful (status code other than 2xx). */
    private <T> T performGetRequest(String apiUrl, Class<T> responseType) {
        try {
            log.info("----> apiUrl: {}", apiUrl);
            ResponseEntity<T> response = restTemplateConfig.restTemplate().exchange(apiUrl, HttpMethod.GET, new org.springframework.http.HttpEntity<>(createHeaders()), responseType);
            log.info("----> response: {}", response);
            if (!response.getStatusCode().is2xxSuccessful()) {
                log.info("----> Error response: {}", response.getStatusCode());
                throw new BadRequestException("Error making request to Jira".split(","));
            }
            return response.getBody();
        } catch (BadRequestException e) {
            log.error("Error making request to Jira", e);
            throw e;
        }
    }


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
