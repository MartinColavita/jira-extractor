package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Branch {
    private String id;
    private List<String> issueKeys;
    private Long updateSequenceId;
    private String name;
    private Commit lastCommit;
    private String createPullRequestUrl;
    private String url;
}
