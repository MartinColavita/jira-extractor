package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;


@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class FieldsDTO {
    private boolean flagged;
    private SprintDTO sprint;
    private List<SprintDTO> closedSprints;
    private String description;
    private ProjectDTO project;
    private List<CommentDTO> comment;
    private EpicDTO epic;
    private List<WorklogDTO> worklog;
    private int updated;
    private TimetrackingDTO timetracking;
}
