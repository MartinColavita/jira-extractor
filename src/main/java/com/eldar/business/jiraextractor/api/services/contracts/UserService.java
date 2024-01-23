package com.eldar.business.jiraextractor.api.services.contracts;

import com.eldar.business.jiraextractor.api.models.response.BacklogDTO;
import com.eldar.business.jiraextractor.api.models.response.UserDTO;
import com.eldar.business.jiraextractor.api.models.response.UsersDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    BacklogDTO getAllTasksPerUser(String user);
    BacklogDTO getAllOngoingTasksPerUser(String user);
    BacklogDTO getAllLockedTasksPerUser(String user);
    BacklogDTO getTasksPerSprintPerUser(String user, String sprint);
    BacklogDTO getTasksPerSprintPerUserPerProject(String user, String sprint, String project);
    BacklogDTO getInProgressTasksPerSprintPerUserPerProject(String user, String sprint, String project);
    BacklogDTO getCompletedTasksPerSprintPerUserPerProject(String user, String sprint, String project);
    BacklogDTO getBlockedTasksPerSprintPerUserPerProject(String user, String sprint, String project);
}
