package com.eldar.business.jiraextractor.api.services.impl;

import com.eldar.business.jiraextractor.api.exceptions.customs.BadRequestException;
import com.eldar.business.jiraextractor.api.models.response.*;
import com.eldar.business.jiraextractor.api.services.contracts.JiraService;
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
public class JiraServiceImpl implements JiraService {

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


/** Get Board by id */
    @Override
    public BoardDTO getBoard(Long boardId) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/board/" + boardId;
        return performGetRequest(apiUrl, BoardDTO.class);
    }


/** Get board by filter id */
    @Override
    public BoardFilterDTO getBoardByFilter(Long filterId) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/board/filter/" + filterId;
        return performGetRequest(apiUrl, BoardFilterDTO.class);
    }


/** Get all boards. */
    @Override
    public BoardsDTO getAllBoards() {
        String apiUrl = jiraUrl + "/rest/agile/1.0/board";
        return performGetRequest(apiUrl, BoardsDTO.class);
    }


/** Get issues for backlog */
    @Override
    public BacklogDTO getIssuesForBacklog(Long boardId) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/board/" + boardId + "/backlog";
        return performGetRequest(apiUrl, BacklogDTO.class);
    }


/** Get epics */
    @Override
    public EpicsDTO getEpics(Long boardId) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/board/" + boardId + "/epic";
        return performGetRequest(apiUrl, EpicsDTO.class);
    }


/** Get issues for board*/
    @Override
    public BacklogDTO getIssuesForBoard(Long boardId) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/board/" + boardId + "/issue";
        return performGetRequest(apiUrl, BacklogDTO.class);
    }


/** Get projects */
    @Override
    public ProjectsDTO getProjects(Long boardId) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/board/" + boardId + "/project";
        return performGetRequest(apiUrl, ProjectsDTO.class);
    }


/** Get projects full*/
    @Override
    public ProjectsDTO getProjectsFull(Long boardId) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/board/" + boardId + "/project/full";
        return performGetRequest(apiUrl, ProjectsDTO.class);
    }


/** Get reports for board*/
    @Override
    public ProjectsFullDTO getReports(Long boardId) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/board/" + boardId + "/reports";
        return performGetRequest(apiUrl, ProjectsFullDTO.class);
    }


/** Get all sprints */
    @Override
    public SprintsDTO getSprints(Long boardId) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/board/" + boardId + "/sprint";
        return performGetRequest(apiUrl, SprintsDTO.class);
    }


/** Get board issues for sprint*/
    @Override
    public BacklogDTO getBoardIssuesForSprint(Long boardId, Long sprintId) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/board/" + boardId + "/sprint/" + sprintId + "/issue";
        return performGetRequest(apiUrl, BacklogDTO.class);
    }


/** Get all versions */
    @Override
    public VersionsDTO getVersions(Long boardId) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/board/" + boardId + "/version";
        return performGetRequest(apiUrl, VersionsDTO.class);
    }

/** Get issues without epic for board */
    @Override
    public BacklogDTO getIssuesWithoutEpic(Long boardId) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/board/" + boardId + "/epic/none/issue";
        return performGetRequest(apiUrl, BacklogDTO.class);
    }


/** Get board issues for epic */
    @Override
    public BacklogDTO getBoardIssuesForEpic(Long boardId, Long epicId) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/board/" + boardId + "/epic/" + epicId + "/issue";
        return performGetRequest(apiUrl, BacklogDTO.class);
    }


/** Get features for board */
    @Override
    public FeaturesDTO getFeatures(Long boardId) {
        String apiUrl = jiraUrl + "/rest/agile/1.0/board/" + boardId + "/features";
        return performGetRequest(apiUrl, FeaturesDTO.class);
    }


}
