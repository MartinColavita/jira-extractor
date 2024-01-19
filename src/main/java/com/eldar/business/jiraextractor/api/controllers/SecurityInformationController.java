package com.eldar.business.jiraextractor.api.controllers;

import com.eldar.business.jiraextractor.api.models.response.VulnerabilityDTO;
import com.eldar.business.jiraextractor.api.models.response.WorkspaceDTO;
import com.eldar.business.jiraextractor.api.models.response.WorkspacesDTO;
import com.eldar.business.jiraextractor.api.services.contracts.SecurityInformationService;
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
@Tag(name = "ELDAR - Security Information")
@RequestMapping("/securityInformation")
@RestController
public class SecurityInformationController extends SwaggerResponseCode {

    private final SecurityInformationService securityInformationService;



    /** Get linked Security Workspaces
     * Retrieve all Security Workspaces linked with the Jira site.
     * The result will be what is currently stored, ignoring any pending updates or deletes.
     * Only Connect apps that define the jiraSecurityInfoProvider module can access this resource.
     * This resource requires the 'READ' scope for Connect apps.*/
    @GetMapping("/linkedWorkspaces")
    @Operation(description = "Retrieve all Security Workspaces linked with the Jira site. The result will be what is currently stored, ignoring any pending updates or deletes.", summary = "Get linked Security Workspaces")
    public ResponseEntity<WorkspacesDTO> getLinkedSecurityWorkspaces() {
        log.info("#### endpoint getLinkedSecurityWorkspaces");
        return ResponseEntity.ok(securityInformationService.getLinkedSecurityWorkspaces());
    }


    /** Get a linked Security Workspace by ID
     * Retrieve a specific Security Workspace linked to the Jira site for the given workspace ID.
     * The result will be what is currently stored, ignoring any pending updates or deletes.
     * Only Connect apps that define the jiraSecurityInfoProvider module can access this resource. This resource requires the 'READ' scope for Connect apps.*/
    @GetMapping("/linkedWorkspaces/{workspaceId}")
    @Operation(description = "Retrieve a specific Security Workspace linked to the Jira site for the given workspace ID. The result will be what is currently stored, ignoring any pending updates or deletes.", summary = "Get a linked Security Workspace by ID")
    @Parameters({ @Parameter(name = "workspaceId",  description = "The ID of the workspace to retrieve.") })
    public ResponseEntity<WorkspaceDTO> getLinkedSecurityWorkspaceById(@PathVariable Long workspaceId) {
        log.info("#### endpoint getLinkedSecurityWorkspaceById");
        return ResponseEntity.ok(securityInformationService.getLinkedSecurityWorkspaces(workspaceId));
    }


    /** Get a Vulnerability by ID
     Retrieve the currently stored Vulnerability data for the given ID.
     The result will be what is currently stored, ignoring any pending updates or deletes.
     Only Connect apps that define the jiraSecurityInfoProvider module can access this resource. This resource requires the 'READ' scope for Connect apps.*/
    @GetMapping("/vulnerabilities/{vulnerabilityId}")
    @Operation(description = "Retrieve the currently stored Vulnerability data for the given ID. The result will be what is currently stored, ignoring any pending updates or deletes.", summary = "Get a Vulnerability by ID")
    @Parameters({ @Parameter(name = "vulnerabilityId",  description = "The ID of the vulnerability to retrieve.") })
    public ResponseEntity<VulnerabilityDTO> getVulnerabilityById(@PathVariable Long vulnerabilityId) {
        log.info("#### endpoint getVulnerabilityById");
        return ResponseEntity.ok(securityInformationService.getVulnerability(vulnerabilityId));
    }





}
