package com.example.api_rest_forum.services.dto;

import com.example.api_rest_forum.modeles.Forum;
import com.example.api_rest_forum.modeles.Message;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class SujetDTO {

    private Long id;

    private String title;

    private Instant createdDate;

    private String slug;

    @JsonIgnore
    private List<MessageDTO> messages;

    @JsonIgnore
    private ForumDTO forum;
}
