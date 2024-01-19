package com.eldar.business.jiraextractor.api.services.contracts;


import com.eldar.business.jiraextractor.api.models.response.*;

public interface BoardService {
    BoardDTO getBoard(Long boardId);
    BoardFilterDTO getBoardByFilter(Long boardId);
    BoardsDTO getAllBoards();
    BacklogDTO getIssuesForBacklog(Long boardId);
    EpicsDTO getEpics(Long boardId);
    BacklogDTO getIssuesWithoutEpic(Long boardId);
    BacklogDTO getBoardIssuesForEpic(Long boardId, Long epicId);
    FeaturesDTO getFeatures(Long boardId);
    BacklogDTO getIssuesForBoard(Long boardId);
    ProjectsDTO getProjects(Long boardId);
    ProjectsDTO getProjectsFull(Long boardId);
    ProjectsFullDTO getReports(Long boardId);
    SprintsDTO getSprints(Long boardId);
    BacklogDTO getBoardIssuesForSprint(Long boardId, Long sprintId);
    VersionsDTO getVersions(Long boardId);

}
