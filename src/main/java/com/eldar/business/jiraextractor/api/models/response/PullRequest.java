package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PullRequest {
    private String id;
    private List<String> issueKeys;
    private Long updateSequenceId;
    private String status;
    private String title;
    private Author author;
    private int commentCount;
    private String sourceBranch;
    private String sourceBranchUrl;
    private String lastUpdate;
    private String destinationBranch;
    private String destinationBranchUrl;
    private List<Reviewer> reviewers;
    private String url;
    private String displayId;
    private int taskCount;
}
