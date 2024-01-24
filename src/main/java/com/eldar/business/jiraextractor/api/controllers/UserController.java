package com.eldar.business.jiraextractor.api.controllers;

import com.eldar.business.jiraextractor.api.models.response.BacklogDTO;
import com.eldar.business.jiraextractor.api.models.response.UserDTO;
import com.eldar.business.jiraextractor.api.models.response.UsersDTO;
import com.eldar.business.jiraextractor.api.services.contracts.UserService;
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

import java.util.List;


@SecurityRequirement(name = "Bearer Authentication")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "ELDAR - User")
@RequestMapping("/user")
@RestController
public class UserController extends SwaggerResponseCode {

    private final UserService userService;


    /** All active jira users */
    @GetMapping("/all")
    @Operation(summary = "All active jira users", description = "All active jira users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        log.info(" #### endpoint getAllUsers ####");
        return ResponseEntity.ok(userService.getAllUsers());
    }


    /** All Tasks ASSIGNED Per user */
    @GetMapping("/tasks/{user}")
    @Operation(summary = "All Tasks ASSIGNED Per user", description = "All Tasks ASSIGNED Per user")
    @Parameters({@Parameter(name = "user", description = "Jira User", example = "Martin Colavita")})
    public ResponseEntity<BacklogDTO> getAllTasksPerUser(@PathVariable String user) {
        log.info(" #### endpoint getAllTasksPerUser ####");
        return ResponseEntity.ok(userService.getAllTasksPerUser(user));
    }


    /** All ONGOING Tasks For a specific User */
    @GetMapping("/tasks/ongoing/{user}")
    @Operation(summary = "All ONGOING Tasks For a specific User", description = "All ONGOING Tasks For a specific User")
    @Parameters({@Parameter(name = "user", description = "Jira User", example = "Martin Colavita")})
    public ResponseEntity<BacklogDTO> getAllOngoingTasksPerUser(@PathVariable String user) {
        log.info(" #### endpoint getAllOngoingTasksPerUser ####");
        return ResponseEntity.ok(userService.getAllOngoingTasksPerUser(user));
    }


    /** All tasks LOCKED to a specific user */
    @GetMapping("/tasks/locked/{user}")
    @Operation(summary = "All tasks LOCKED to a specific user", description = "All tasks LOCKED to a specific user")
    @Parameters({@Parameter(name = "user", description = "Jira User", example = "Martin Colavita") })
    public ResponseEntity<BacklogDTO> getAllLockedTasksPerUser(@PathVariable String user) {
        log.info(" #### endpoint getAllLockedTasksPerUser ####");
        return ResponseEntity.ok(userService.getAllLockedTasksPerUser(user));
    }


    /** Number of tasks per sprint for a specific user */
    @GetMapping("/tasks/{user}/{sprint}")
    @Operation(summary = "Number of tasks per sprint for a specific user", description = "Number of tasks per sprint for a specific user")
    @Parameters({
            @Parameter(name = "user", description = "Jira User", example = "Martin Colavita"),
            @Parameter(name = "sprint", description = "Jira Sprint", example = "Tablero Sprint 1") })
    public ResponseEntity<BacklogDTO> getTasksPerSprintPerUser(@PathVariable String user, @PathVariable String sprint) {
        log.info(" #### endpoint getTasksPerSprintPerUser ####");
        return ResponseEntity.ok(userService.getTasksPerSprintPerUser(user, sprint));
    }


    /** all tasks ASSIGNED by the given user in a specific project and sprint */
    @GetMapping("/tasks/{user}/{project}/{sprint}")
    @Operation(summary = "all tasks ASSIGNED by the given user in a specific project and sprint", description = "all tasks ASSIGNED by the given user in a specific project and sprint")
    @Parameters({
            @Parameter(name = "user", description = "Jira User", example = "Martin Colavita"),
            @Parameter(name = "project", description = "Jira Project", example = "EJE"),
            @Parameter(name = "sprint", description = "Jira Sprint", example = "Tablero Sprint 1") })
    public ResponseEntity<BacklogDTO> getTasksPerSprintPerUserPerProject(@PathVariable String user, @PathVariable String project, @PathVariable String sprint) {
        log.info(" #### endpoint getTasksPerSprintPerUserPerProject ####");
        return ResponseEntity.ok(userService.getTasksPerSprintPerUserPerProject(user, sprint, project));
    }


    /** all IN PROGRESS tasks of a given user for a specific project and sprint */
    @GetMapping("/tasks/inprogress/{user}/{project}/{sprint}")
    @Operation(summary = "all IN PROGRESS tasks of a given user for a specific project and sprint", description = "all IN PROGRESS tasks of a given user for a specific project and sprint")
    @Parameters({
            @Parameter(name = "user", description = "Jira User", example = "Martin Colavita"),
            @Parameter(name = "project", description = "Jira Project", example = "EJE"),
            @Parameter(name = "sprint", description = "Jira Sprint", example = "Tablero Sprint 1") })
    public ResponseEntity<BacklogDTO> getInProgressTasksPerSprintPerUserPerProject(@PathVariable String user, @PathVariable String project, @PathVariable String sprint) {
        log.info(" #### endpoint getInProgressTasksPerSprintPerUserPerProject ####");
        return ResponseEntity.ok(userService.getInProgressTasksPerSprintPerUserPerProject(user, sprint, project));
    }


    /** all tasks COMPLETED by the given user in a specific project and sprint*/
    @GetMapping("/tasks/completed/{user}/{project}/{sprint}")
    @Operation(summary = "all tasks COMPLETED by the given user in a specific project and sprint", description = "all tasks COMPLETED by the given user in a specific project and sprint")
    @Parameters({
            @Parameter(name = "user", description = "Jira User", example = "Martin Colavita"),
            @Parameter(name = "project", description = "Jira Project", example = "EJE"),
            @Parameter(name = "sprint", description = "Jira Sprint", example = "Tablero Sprint 1") })
    public ResponseEntity<BacklogDTO> getCompletedTasksPerSprintPerUserPerProject(@PathVariable String user, @PathVariable String project, @PathVariable String sprint) {
        log.info(" #### endpoint getCompletedTasksPerSprintPerUserPerProject ####");
        return ResponseEntity.ok(userService.getCompletedTasksPerSprintPerUserPerProject(user, sprint, project));
    }


    /** all BLOCKED tasks of a given user for a specific project and sprint */
    @GetMapping("/tasks/blocked/{user}/{project}/{sprint}")
    @Operation(summary = "all BLOCKED tasks of a given user for a specific project and sprint", description = "all BLOCKED tasks of a given user for a specific project and sprint")
    @Parameters({
            @Parameter(name = "user", description = "Jira User", example = "Martin Colavita"),
            @Parameter(name = "project", description = "Jira Project", example = "EJE"),
            @Parameter(name = "sprint", description = "Jira Sprint", example = "Tablero Sprint 1") })
    public ResponseEntity<BacklogDTO> getBlockedTasksPerSprintPerUserPerProject(@PathVariable String user, @PathVariable String project, @PathVariable String sprint) {
        log.info(" #### endpoint getBlockedTasksPerSprintPerUserPerProject ####");
        return ResponseEntity.ok(userService.getBlockedTasksPerSprintPerUserPerProject(user, sprint, project));
    }

}
