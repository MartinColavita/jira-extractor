package com.eldar.business.jiraextractor.api.models.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CommentDTO {
    private String self;
    private String id;
    private AuthorDTO author;
    private BodyDTO body;
    private AuthorDTO updateAuthor;
    private String created;
    private String updated;
    private VisibilityDTO visibility;
}
