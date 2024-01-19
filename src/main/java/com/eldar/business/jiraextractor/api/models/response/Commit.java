package com.eldar.business.jiraextractor.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Commit {
    private String id;
    private List<String> issueKeys;
    private Long updateSequenceId;
    private String hash;
    private List<String> flags;
    private String message;
    private Author author;
    private int fileCount;
    private String url;
    private List<File> files;
    private String authorTimestamp;
    private String displayId;
}
