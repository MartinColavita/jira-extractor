package com.eldar.business.jiraextractor.api.services.impl;

import com.eldar.business.jiraextractor.api.models.response.*;
import com.eldar.business.jiraextractor.api.services.base.BaseService;
import com.eldar.business.jiraextractor.api.services.contracts.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class BoardServiceImpl extends BaseService implements BoardService {


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
