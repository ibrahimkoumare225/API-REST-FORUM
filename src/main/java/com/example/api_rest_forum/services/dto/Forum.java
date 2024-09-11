package com.example.api_rest_forum.services.dto;

import com.example.api_rest_forum.modeles.Sujet;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Forum {

    private Long id;

    private String title;

    private String description;
    private Date createdDate;

    private List<Sujet> sujets;
}
