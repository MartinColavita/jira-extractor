package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class RepositoryDTO {
    private String name;
    private String description;
    private String forkOf;
    private String url;
    private List<Commit> commits;
    private List<Branch> branches;
    private List<PullRequest> pullRequests;
    private String avatar;
    private String avatarDescription;
    private String id;
    private Long updateSequenceId;
}
