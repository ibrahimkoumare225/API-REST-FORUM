package com.example.api_rest_forum.services.dto;

import com.example.api_rest_forum.modeles.Sujet;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MessageDTO {

    private Long id;
    private String content;
    private Date createdDate;
    private Sujet sujet;
}
