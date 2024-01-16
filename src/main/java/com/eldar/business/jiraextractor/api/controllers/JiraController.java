package com.eldar.business.jiraextractor.api.controllers;


import com.eldar.business.jiraextractor.api.models.response.*;
import com.eldar.business.jiraextractor.api.services.contracts.JiraService;
import com.eldar.business.jiraextractor.utils.swaggerconf.SwaggerResponseCode;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/jiraextractor")
@SecurityRequirement(name = "Bearer Authentication")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "ELDAR - Jira Extractor")
public class JiraController extends SwaggerResponseCode {

    private final JiraService jiraService;



    /** Get Board by id
     * This board will only be returned if the user has permission to view it. */
    @GetMapping("/get-board/{boardId}")
    @Operation(description = "Get specific board", summary = "Get specific board by id")
    @Parameters({ @Parameter(name = "boardId", description = " Board ID", example = "186") })
    public ResponseEntity<BoardDTO> getBoard(@PathVariable Long boardId) {
        log.info(" #### endpoint getBoard ####");
        return ResponseEntity.ok(jiraService.getBoard(boardId));
    }


    /** Get board by filter id
     * Returns any boards which use the provided filter id.
     * This method can be executed by users without a valid software license in order to find which boards are using a particular filter.*/
    @GetMapping("/get-board-by-filter/{filterId}")
    @Operation(description = "Returns any boards which use the provided filter id. This method can be executed by users without a valid software license in order to find which boards are using a particular filter", summary = "Get board by filter id")
    @Parameters({ @Parameter(name = "filterId", description = " Filter ID", example = "164") })
    public ResponseEntity<BoardFilterDTO> getBoardByFilter(@PathVariable Long filterId) {
        log.info(" #### endpoint getBoardByFilter ####");
        return ResponseEntity.ok(jiraService.getBoardByFilter(filterId));
    }


    /** Get all boards.
     * This only includes boards that the user has permission to view */
    @GetMapping("/get-boards")
    @Operation(description = "Returns all boards. This only includes boards that the user has permission to view", summary = "Get all boards")
    public ResponseEntity<BoardsDTO> getAllBoards() {
        log.info(" #### endpoint get-Boards ####");
        return ResponseEntity.ok(jiraService.getAllBoards());
    }


    /** Get issues for backlog
     * Returns all issues from the board's backlog, for the given board ID.
     * This only includes issues that the user has permission to view. By default, the returned issues are ordered by rank.*/
    @GetMapping("/get-issues-for-backlog/{boardId}")
    @Operation(description = "Returns all issues from the board's backlog, for the given board ID. This only includes issues that the user has permission to view. By default, the returned issues are ordered by rank.", summary = "Get issues for backlog")
    @Parameters({ @Parameter(name = "boardId", description = " Board ID", example = "186") })
    public ResponseEntity<BacklogDTO> getIssuesForBacklog(@PathVariable Long boardId) {
        log.info(" #### endpoint getIssuesForBacklog ####");
        return ResponseEntity.ok(jiraService.getIssuesForBacklog(boardId));
    }


    /** Get epics
     * Returns all epics from the board, for the given board ID. This only includes epics that the user has permission to view.
     * Note, if the user does not have permission to view the board, no epics will be returned at all.  */
    @GetMapping("/get-epics/{boardId}")
    @Operation(description = "Returns all epics from the board, for the given board ID. This only includes epics that the user has permission to view. Note, if the user does not have permission to view the board, no epics will be returned at all.", summary = "Get epics for board")
    @Parameters({ @Parameter(name = "boardId", description = " Board ID", example = "186") })
    public ResponseEntity<EpicsDTO> getEpics(@PathVariable Long boardId) {
        log.info(" #### endpoint getEpics ####");
        return ResponseEntity.ok(jiraService.getEpics(boardId));
    }




}
