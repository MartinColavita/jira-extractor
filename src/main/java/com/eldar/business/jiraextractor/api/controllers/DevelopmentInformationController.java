/*
package com.eldar.business.jiraextractor.api.controllers;

import com.eldar.business.jiraextractor.api.models.response.RepositoryDTO;
import com.eldar.business.jiraextractor.api.services.contracts.DevelopmentInformationService;
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
@Tag(name = "ELDAR - Development Information")
@RequestMapping("/developmentInformation")
@RestController
public class DevelopmentInformationController {

    private final DevelopmentInformationService developmentInformationService;


    */
/** Get repository
     * For the specified repository ID, retrieves the repository and the most recent 400 development information entities.
     * The result will be what is currently stored, ignoring any pending updates or deletes.*//*

    @GetMapping("/repository/{repositoryId}")
    @Operation(description = "For the specified repository ID, retrieves the repository and the most recent 400 development information entities. The result will be what is currently stored, ignoring any pending updates or deletes.", summary = "Get repository")
    @Parameters({ @Parameter(name = "repositoryId", description = " Repository ID", example = "") })
    public ResponseEntity<RepositoryDTO> getRepository(@PathVariable Long repositoryId) {
        log.info(" #### endpoint getRepository ####");
        return ResponseEntity.ok(developmentInformationService.getRepository(repositoryId));
    }

}
*/
