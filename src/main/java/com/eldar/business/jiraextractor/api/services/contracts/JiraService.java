package com.eldar.business.jiraextractor.api.services.contracts;


import com.eldar.business.jiraextractor.api.models.response.*;

public interface JiraService {
    BoardDTO getBoard(Long boardId);
    BoardFilterDTO getBoardByFilter(Long boardId);
    BoardsDTO getAllBoards();
    BacklogDTO getIssuesForBacklog(Long boardId);
    EpicsDTO getEpics(Long boardId);

}
