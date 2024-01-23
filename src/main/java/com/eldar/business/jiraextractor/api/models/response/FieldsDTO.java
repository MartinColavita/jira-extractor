package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.Map;


@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class FieldsDTO {
    private boolean flagged;
    private SprintDTO sprint;
    private List<SprintDTO> closedSprints;
    private DescriptionDTO description;
    private ProjectDTO project;
    private CommentDTO comment;
    private EpicDTO epic;
    private WorklogContainerDTO worklog;
    private String updated;
    private TimetrackingDTO timetracking;
    private StatusDTO status;
    private PriorityDTO priority;
    private UserDTO assignee;
    private UserDTO reporter;
    private VotesDTO votes;
    private IssueTypeDTO issuetype;
    private Map<String, Object> customfield; // Para manejar los campos customfield_XXXX
}
