package com.eldar.business.jiraextractor.api.services.impl;

import com.eldar.business.jiraextractor.api.exceptions.customs.BadRequestException;
import com.eldar.business.jiraextractor.api.models.response.IssueDTO;
import com.eldar.business.jiraextractor.api.models.response.SprintDTO;
import com.eldar.business.jiraextractor.api.services.contracts.SprintService;
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
public class SprintServiceImpl implements SprintService {

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


/** Get sprint */
    @Override
    public SprintDTO getSprint(Long sprintId) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/sprint/" + sprintId;
        return performGetRequest(apiUrl, SprintDTO.class);
    }


/** Get issues for sprint*/
    @Override
    public IssueDTO getIssuesForSprint(Long sprintId) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/sprint/" + sprintId + "/issue";
        return performGetRequest(apiUrl, IssueDTO.class);
    }

}
