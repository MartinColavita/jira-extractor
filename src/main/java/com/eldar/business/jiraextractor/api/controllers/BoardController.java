package com.eldar.business.jiraextractor.api.controllers;


import com.eldar.business.jiraextractor.api.models.response.*;
import com.eldar.business.jiraextractor.api.services.contracts.BoardService;
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


@SecurityRequirement(name = "Bearer Authentication")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "ELDAR - Board")
@RequestMapping("/board")
@RestController
public class BoardController extends SwaggerResponseCode {

    private final BoardService boardService;



    /** Get Board by id
     * This board will only be returned if the user has permission to view it. */
    @GetMapping("/{boardId}")
    @Operation(description = "Get specific board", summary = "Get specific board by id")
    @Parameters({ @Parameter(name = "boardId", description = " Board ID", example = "186") })
    public ResponseEntity<BoardDTO> getBoard(@PathVariable Long boardId) {
        log.info(" #### endpoint getBoard ####");
        return ResponseEntity.ok(boardService.getBoard(boardId));
    }


    /** Get board by filter id
     * Returns any boards which use the provided filter id.
     * This method can be executed by users without a valid software license in order to find which boards are using a particular filter.*/
    @GetMapping("/filter/{filterId}")
    @Operation(description = "Returns any boards which use the provided filter id. This method can be executed by users without a valid software license in order to find which boards are using a particular filter", summary = "Get board by filter id")
    @Parameters({ @Parameter(name = "filterId", description = " Filter ID", example = "164") })
    public ResponseEntity<BoardFilterDTO> getBoardByFilter(@PathVariable Long filterId) {
        log.info(" #### endpoint getBoardByFilter ####");
        return ResponseEntity.ok(boardService.getBoardByFilter(filterId));
    }


    /** Get all boards.
     * This only includes boards that the user has permission to view */
    @GetMapping("/boards")
    @Operation(description = "Returns all boards. This only includes boards that the user has permission to view", summary = "Get all boards")
    public ResponseEntity<BoardsDTO> getAllBoards() {
        log.info(" #### endpoint get-Boards ####");
        return ResponseEntity.ok(boardService.getAllBoards());
    }


    /** Get issues for backlog
     * Returns all issues from the board's backlog, for the given board ID.
     * This only includes issues that the user has permission to view. By default, the returned issues are ordered by rank.*/
    @GetMapping("/{boardId}/backlog")
    @Operation(description = "Returns all issues from the board's backlog, for the given board ID. This only includes issues that the user has permission to view. By default, the returned issues are ordered by rank.", summary = "Get issues for backlog")
    @Parameters({ @Parameter(name = "boardId", description = " Board ID", example = "164") })
    public ResponseEntity<BacklogDTO> getIssuesForBacklog(@PathVariable Long boardId) {
        log.info(" #### endpoint getIssuesForBacklog ####");
        return ResponseEntity.ok(boardService.getIssuesForBacklog(boardId));
    }


    /** Get epics
     * Returns all epics from the board, for the given board ID. This only includes epics that the user has permission to view.
     * Note, if the user does not have permission to view the board, no epics will be returned at all.  */
    @GetMapping("/{boardId}/epic")
    @Operation(description = "Returns all epics from the board, for the given board ID. This only includes epics that the user has permission to view. Note, if the user does not have permission to view the board, no epics will be returned at all.", summary = "Get epics for board")
    @Parameters({ @Parameter(name = "boardId", description = " Board ID", example = "164") })
    public ResponseEntity<EpicsDTO> getEpics(@PathVariable Long boardId) {
        log.info(" #### endpoint getEpics ####");
        return ResponseEntity.ok(boardService.getEpics(boardId));
    }


    /** Get issues without epic for board
     Returns all issues that do not belong to any epic on a board, for a given board ID.
     This only includes issues that the user has permission to view.
     By default, the returned issues are ordered by rank.*/
    @GetMapping("/{boardId}/epic/none/issue")
    @Operation(description = "Returns all issues that do not belong to any epic on a board, for a given board ID. This only includes issues that the user has permission to view. By default, the returned issues are ordered by rank.", summary = "Get issues without epic for board")
    @Parameters({ @Parameter(name = "boardId", description = " Board ID", example = "186") })
    public ResponseEntity<BacklogDTO> getIssuesWithoutEpic(@PathVariable Long boardId) {
        log.info(" #### endpoint getIssuesWithoutEpic ####");
        return ResponseEntity.ok(boardService.getIssuesWithoutEpic(boardId));
    }


    /** Get board issues for epic
     * Returns all issues that belong to an epic on the board, for the given epic ID and the board ID.
     * This only includes issues that the user has permission to view.
     * By default, the returned issues are ordered by rank.*/
    @GetMapping("/{boardId}/epic/{epicId}/issue")
    @Operation(description = "Returns all issues that belong to an epic on the board, for the given epic ID and the board ID. This only includes issues that the user has permission to view. By default, the returned issues are ordered by rank.", summary = "Get board issues for epic")
    @Parameters({   @Parameter(name = "boardId", description = " Board ID", example = "164"),
            @Parameter(name = "epicId", description = " Epic ID", example = "20386") })
    public ResponseEntity<BacklogDTO> getBoardIssuesForEpic(@PathVariable Long boardId, @PathVariable Long epicId) {
        log.info(" #### endpoint getBoardIssuesForEpic ####");
        return ResponseEntity.ok(boardService.getBoardIssuesForEpic(boardId, epicId));
    }


    /** Get features for board */
    @GetMapping("/{boardId}/features")
    @Operation(description = "Returns features from the board ID", summary = "Get features for board")
    @Parameters({ @Parameter(name = "boardId", description = " Board ID", example = "164") })
    public ResponseEntity<FeaturesDTO> getFeatures(@PathVariable Long boardId) {
        log.info(" #### endpoint getFeatureDTOS ####");
        return ResponseEntity.ok(boardService.getFeatures(boardId));
    }


    /** Get issues for board
     Returns all issues from a board, for a given board ID.
     This only includes issues that the user has permission to view. An issue belongs to the board if its status is mapped to the board's column.
     Epic issues do not belongs to the scrum boards. By default, the returned issues are ordered by rank.*/
    @GetMapping("/{boardId}/issue")
    @Operation(description = "Returns all issues from a board, for a given board ID. This only includes issues that the user has permission to view. An issue belongs to the board if its status is mapped to the board's column. Epic issues do not belongs to the scrum boards. By default, the returned issues are ordered by rank.", summary = "Get issues for board")
    @Parameters({ @Parameter(name = "boardId", description = " Board ID", example = "164") })
    public ResponseEntity<BacklogDTO> getIssuesForBoard(@PathVariable Long boardId) {
        log.info(" #### endpoint getIssuesForBoard ####");
        return ResponseEntity.ok(boardService.getIssuesForBoard(boardId));
    }


    /** Get projects
     * Returns all projects that are associated with the board, for the given board ID. If the user does not have permission to view the board, no projects will be returned at all.
     * Returned projects are ordered by the name.
     * A project is associated with a board if the board filter contains reference the project or there is an issue from the project that belongs to the board.
     * The board filter contains reference the project only if JQL query guarantees that returned issues will be returned from the project set defined in JQL.
     * An issue belongs to the board if its status is mapped to the board's column. Epic issues do not belongs to the scrum boards.*/
    @GetMapping("/{boardId}/project")
    @Operation(description = "Returns all projects that are associated with the board, for the given board ID. If the user does not have permission to view the board, no projects will be returned at all. Returned projects are ordered by the name. ", summary = "Get projects")
    @Parameters({ @Parameter(name = "boardId", description = " Board ID", example = "164") })
    public ResponseEntity<ProjectsDTO> getProjects(@PathVariable Long boardId) {
        log.info(" #### endpoint getProjects ####");
        return ResponseEntity.ok(boardService.getProjects(boardId));
    }


    /** Get projects full
     * Returns all projects that are statically associated with the board, for the given board ID.
     * Returned projects are ordered by the name.
     * A project is associated with a board if the board filter contains reference the project.
     * The board filter contains reference the project only if JQL query guarantees that returned issues will be returned from the project set defined in JQL.*/
    @GetMapping("/{boardId}/project/full")
    @Operation(description = "Returns all projects that are statically associated with the board, for the given board ID. Returned projects are ordered by the name. ", summary = "Get projects full")
    @Parameters({ @Parameter(name = "boardId", description = " Board ID", example = "164") })
    public ResponseEntity<ProjectsDTO> getProjectsFull(@PathVariable Long boardId) {
        log.info(" #### endpoint getProjectsFull ####");
        return ResponseEntity.ok(boardService.getProjectsFull(boardId));
    }


    /** Get reports for board
     * Returns all reports associated with the board, for the given board ID. */
    @GetMapping("/{boardId}/reports")
    @Operation(description = "Returns all reports associated with the board, for the given board ID. ", summary = "Get reports for board")
    @Parameters({ @Parameter(name = "boardId", description = " Board ID", example = "164") })
    public ResponseEntity<ProjectsFullDTO> getReports(@PathVariable Long boardId) {
        log.info(" #### endpoint getReports ####");
        return ResponseEntity.ok(boardService.getReports(boardId));
    }


    /** Get all sprints
     * Returns all sprints from a board, for a given board ID.
     * This only includes sprints that the user has permission to view.*/
    @GetMapping("/{boardId}/sprint")
    @Operation(description = "Returns all sprints from a board, for a given board ID. This only includes sprints that the user has permission to view.", summary = "Get all sprints")
    @Parameters({ @Parameter(name = "boardId", description = " Board ID", example = "164") })
    public ResponseEntity<SprintsDTO> getSprints(@PathVariable Long boardId) {
        log.info(" #### endpoint getSprints ####");
        return ResponseEntity.ok(boardService.getSprints(boardId));
    }


    // TODO -> no funciona la consulta | "Client must be authenticated to access this resource."
    /** Get board issues for sprint
     * Get all issues you have access to that belong to the sprint from the board.
     * Issue returned from this resource contains additional fields like: sprint, closedSprints, flagged and epic.
     * Issues are returned ordered by rank. JQL order has higher priority than default rank.*/
    @GetMapping("/{boardId}/sprint/{sprintId}/issue")
    @Operation(description = "Get all issues you have access to that belong to the sprint from the board. Issue returned from this resource contains additional fields like: sprint, closedSprints, flagged and epic. Issues are returned ordered by rank. JQL order has higher priority than default rank.", summary = "Get board issues for sprint")
    @Parameters({   @Parameter(name = "boardId", description = " Board ID", example = "164"),
            @Parameter(name = "sprintId", description = " Sprint ID", example = "20386") })
    public ResponseEntity<BacklogDTO> getBoardIssuesForSprint(@PathVariable Long boardId, @PathVariable Long sprintId) {
        log.info(" #### endpoint getBoardIssuesForSprint ####");
        return ResponseEntity.ok(boardService.getBoardIssuesForSprint(boardId, sprintId));
    }


    /** Get all versions
     * Returns all versions from a board, for a given board ID.
     * This only includes versions that the user has permission to view.
     * Note, if the user does not have permission to view the board, no versions will be returned at all.
     * Returned versions are ordered by the name of the project from which they belong and then by sequence defined by user. */
    @GetMapping("/{boardId}/version")
    @Operation(description = "Returns all versions from a board, for a given board ID. This only includes versions that the user has permission to view. Note, if the user does not have permission to view the board, no versions will be returned at all. Returned versions are ordered by the name of the project from which they belong and then by sequence defined by user.", summary = "Get all versions")
    @Parameters({ @Parameter(name = "boardId", description = " Board ID", example = "164") })
    public ResponseEntity<VersionsDTO> getVersions(@PathVariable Long boardId) {
        log.info(" #### endpoint getVersions ####");
        return ResponseEntity.ok(boardService.getVersions(boardId));
    }


}


