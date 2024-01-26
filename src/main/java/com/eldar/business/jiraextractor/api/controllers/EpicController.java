package com.eldar.business.jiraextractor.api.controllers;

import com.eldar.business.jiraextractor.api.models.response.BacklogDTO;
import com.eldar.business.jiraextractor.api.models.response.EpicDTO;
import com.eldar.business.jiraextractor.api.services.contracts.EpicService;
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
@RequiredArgsConstructor
@Tag(name = "ELDAR - Epic")
@RequestMapping("/epic")
@RestController
public class EpicController extends SwaggerResponseCode {

    private final EpicService epicService;


    /** Get issues without epic
     * Returns all issues that do not belong to any epic. This only includes issues that the user has permission to view.
     * By default, the returned issues are ordered by rank.
     * Note: If you are querying a next-gen project, do not use this operation.   */
    @GetMapping("/none/issue")
    @Operation(description = "Returns all issues that do not belong to any epic. This only includes issues that the user has permission to view. By default, the returned issues are ordered by rank. Note: If you are querying a next-gen project, do not use this operation.", summary = "Get issues without epic")
    public ResponseEntity<BacklogDTO> getIssuesWithoutEpic() {
        return ResponseEntity.ok(epicService.getIssuesWithoutEpic());
    }


    /** Get epic
     * Returns the epic for a given epic ID. This epic will only be returned if the user has permission to view it.
     * Note: This operation does not work for epics in next-gen projects.*/
    @GetMapping("/{epicIdOrKey}")
    @Operation(description = "Returns the epic for a given epic ID. This epic will only be returned if the user has permission to view it. Note: This operation does not work for epics in next-gen projects.", summary = "Get epic")
    @Parameters({ @Parameter(name = "epicIdOrKey", description = " epicIdOrKey", example = "JC-107") })
    public ResponseEntity<EpicDTO> getEpic(@PathVariable String epicIdOrKey) {
        return ResponseEntity.ok(epicService.getEpic(epicIdOrKey));
    }


    /** Get issues for epic
     Returns all issues that belong to the epic, for the given epic ID.
     This only includes issues that the user has permission to view.
     By default, the returned issues are ordered by rank. */
    @GetMapping("/{epicIdOrKey}/issue")
    @Operation(description = "Returns all issues that belong to the epic, for the given epic ID. This only includes issues that the user has permission to view. By default, the returned issues are ordered by rank.", summary = "Get issues for epic")
    @Parameters({ @Parameter(name = "epicId", description = " Epic ID", example = "JC-107") })
    public ResponseEntity<BacklogDTO> getIssuesForEpic(@PathVariable String epicIdOrKey) {
        return ResponseEntity.ok(epicService.getIssuesForEpic(epicIdOrKey));
    }


}
