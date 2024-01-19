package com.eldar.business.jiraextractor.api.controllers;

import com.eldar.business.jiraextractor.api.models.response.IssueDTO;
import com.eldar.business.jiraextractor.api.models.response.SprintDTO;
import com.eldar.business.jiraextractor.api.services.contracts.SprintService;
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
@Tag(name = "ELDAR - Sprint")
@RequestMapping("/sprint")
@RestController
public class SprintController extends SwaggerResponseCode {

    private final SprintService sprintService;


    /** Get sprint
     * Returns the sprint for a given sprint ID.
     * The sprint will only be returned if the user can view the board that the sprint was created on, or view at least one of the issues in the sprint.*/
    @GetMapping("/{sprintId}")
    @Operation(description = "Returns the sprint for a given sprint ID. The sprint will only be returned if the user can view the board that the sprint was created on, or view at least one of the issues in the sprint.", summary = "Get sprint")
    @Parameters({ @Parameter(name = "sprintId", description = " Sprint ID", example = "") })
    public ResponseEntity<SprintDTO> getSprint(@PathVariable Long sprintId) {
        log.info(" #### endpoint getSprint ####");
        return ResponseEntity.ok(sprintService.getSprint(sprintId));
    }


    /** Get issues for sprint
     * Returns all issues in a sprint, for a given sprint ID.
     * This only includes issues that the user has permission to view.
     * By default, the returned issues are ordered by rank.*/
    @GetMapping("/{sprintId}/issue")
    @Operation(description = "Returns all issues in a sprint, for a given sprint ID. This only includes issues that the user has permission to view. By default, the returned issues are ordered by rank.", summary = "Get issues for sprint")
    @Parameters({ @Parameter(name = "sprintId", description = " Sprint ID", example = "") })
    public ResponseEntity<IssueDTO> getIssuesForSprint(@PathVariable Long sprintId) {
        log.info(" #### endpoint getIssuesForSprint ####");
        return ResponseEntity.ok(sprintService.getIssuesForSprint(sprintId));
    }

}
