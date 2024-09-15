package com.example.api_rest_forum.services.dto;

import com.example.api_rest_forum.modeles.Sujet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ForumDTO {

    private Long id;

    private String title;

    private String slug;

    private String description;

    private Instant createdDate;

    @JsonIgnore
    private List<SujetDTO> sujets;
}
