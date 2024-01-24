package com.eldar.business.jiraextractor.api.services.impl;

import com.eldar.business.jiraextractor.api.models.response.BacklogDTO;
import com.eldar.business.jiraextractor.api.models.response.UserDTO;
import com.eldar.business.jiraextractor.api.models.response.UsersDTO;
import com.eldar.business.jiraextractor.api.services.base.BaseService;
import com.eldar.business.jiraextractor.api.services.contracts.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl extends BaseService implements UserService {


/** All active jira users */
    @Override
    public List<UserDTO> getAllUsers() {
        String apiUrl = jiraUrl + "/rest/api/3/users?includeInactive=false";
        return performGetRequest(apiUrl, new ParameterizedTypeReference<List<UserDTO>>() {});
    }


/** All Tasks ASSIGNED Per user */
    @Override
    public BacklogDTO getAllTasksPerUser(String user) {
        String apiUrl = jiraUrl + "/rest/api/3/search?jql=assignee=\"" + user + "\"";
        return performGetRequest(apiUrl, BacklogDTO.class);
    }


/** All ONGOING Tasks For a specific User
    %s is a placeholder that is replaced with the arguments provided in String.format().*/
    @Override
    public BacklogDTO getAllOngoingTasksPerUser(String user) throws UnsupportedCharsetException {
        String apiUrl = jiraUrl + "/rest/api/2/search?jql=status = 'In Progress' AND assignee=\"" + user + "\"";

        return performGetRequest(apiUrl, BacklogDTO.class);
    }


    /** All tasks LOCKED to a specific user */
    @Override
    public BacklogDTO getAllLockedTasksPerUser(String user) {
        String apiUrl = jiraUrl + "/rest/api/2/search?jql=status = 'Blocked' AND assignee=\"" + user + "\"";
        return performGetRequest(apiUrl, BacklogDTO.class);
    }


/** Number of tasks per sprint for a specific user
 * %s is a placeholder that is replaced with the arguments provided in String.format().*/
    @Override
    public BacklogDTO getTasksPerSprintPerUser(String user, String sprint) {
        String apiUrl = jiraUrl + "/rest/api/2/search?jql=assignee = \"" + user + "\" AND Sprint = \"" + sprint + "\"";
        return performGetRequest(apiUrl, BacklogDTO.class);
    }


/** all tasks ASSIGNED by the given user in a specific project and sprint */
    @Override
    public BacklogDTO getTasksPerSprintPerUserPerProject(String user, String sprint, String project) {
        String apiUrl = jiraUrl + "/rest/api/2/search?jql=assignee = \"" + user + "\" AND project = \"" + project + "\" AND Sprint = \"" + sprint + "\"";
        return performGetRequest(apiUrl, BacklogDTO.class);
    }


/** all IN PROGRESS tasks of a given user for a specific project and sprint */
    @Override
    public BacklogDTO getInProgressTasksPerSprintPerUserPerProject(String user, String sprint, String project) {
        String apiUrl = jiraUrl + "/rest/api/2/search?jql=assignee = \"" + user + "\" AND project = \"" + project + "\" AND status = 'In Progress' AND Sprint = \"" + sprint + "\"";
        return performGetRequest(apiUrl, BacklogDTO.class);
    }


/** all tasks COMPLETED by the given user in a specific project and sprint*/
    @Override
    public BacklogDTO getCompletedTasksPerSprintPerUserPerProject(String user, String sprint, String project) {
        String apiUrl = jiraUrl + "/rest/api/2/search?jql=assignee = \"" + user + "\" AND project = \"" + project + "\" AND status = 'Done' AND Sprint = \"" + sprint + "\"";
        return performGetRequest(apiUrl, BacklogDTO.class);
    }


/** all BLOCKED tasks of a given user for a specific project and sprint */
    @Override
    public BacklogDTO getBlockedTasksPerSprintPerUserPerProject(String user, String sprint, String project) {
        String apiUrl = jiraUrl + "/rest/api/2/search?jql=assignee = \"" + user + "\" AND project = \"" + project + "\" AND status = 'Blocked' AND Sprint = \"" + sprint + "\"";
        return performGetRequest(apiUrl, BacklogDTO.class);
    }

}
