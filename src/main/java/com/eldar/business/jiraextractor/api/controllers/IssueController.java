package com.eldar.business.jiraextractor.api.controllers;

import com.eldar.business.jiraextractor.api.models.response.IssueDTO;
import com.eldar.business.jiraextractor.api.models.response.IssueEstimationDTO;
import com.eldar.business.jiraextractor.api.services.contracts.IssueService;
import com.eldar.business.jiraextractor.utils.swaggerconf.SwaggerResponseCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "Bearer Authentication")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "ELDAR - Issue")
@RequestMapping("/issue")
@RestController
public class IssueController extends SwaggerResponseCode {

    private final IssueService issueService;


    /** Get issue
     * Returns a single issue, for a given issue ID or issue key.
     * Issues returned from this resource include Agile fields, like sprint, closedSprints, flagged, and epic */
    @GetMapping("/{issueIdOrKey}")
    @Operation(description = "Returns a single issue, for a given issue ID or issue key. Issues returned from this resource include Agile fields, like sprint, closedSprints, flagged, and epic", summary = "Get issue")
    @Parameters({ @Parameter(name = "issueIdOrKey", description = " Issue ID or Issue Key", example = "164") })
    public ResponseEntity<IssueDTO> getIssue(@PathVariable Long issueIdOrKey) {
        log.info(" #### endpoint getIssue ####");
        return ResponseEntity.ok(issueService.getIssue(issueIdOrKey));
    }


    /** Get issue estimation for board
     Returns the estimation of the issue and a fieldId of the field that is used for it.
     boardId param is required. This param determines which field will be updated on a issue.
     Original time internally stores and returns the estimation as a number of seconds.
     The field used for estimation on the given board can be obtained from board configuration resource*/
    @GetMapping("/{issueIdOrKey}/estimation")
    @Operation(description = "Returns the estimation of the issue and a fieldId of the field that is used for it. boardId param is required. This param determines which field will be updated on a issue. Original time internally stores and returns the estimation as a number of seconds. The field used for estimation on the given board can be obtained from board configuration resource", summary = "Get issue estimation for board")
    @Parameters({   @Parameter(name = "issueIdOrKey", description = " Issue ID or Issue Key", example = ""),
            @Parameter(name = "boardId", description = " Board ID", example = "") })
    public ResponseEntity<IssueEstimationDTO> getIssueEstimationForBoard(@PathVariable Long issueIdOrKey, @PathVariable Long boardId) {
        log.info(" #### endpoint getIssueEstimationForBoard ####");
        return ResponseEntity.ok(issueService.getIssueEstimationForBoard(issueIdOrKey, boardId));
    }

}
