package com.example.api_rest_forum.services.dto;

import com.example.api_rest_forum.modeles.Sujet;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Message {

    private Long id;
    private String content;
    private String user;
    private Date createdDate;
    private Sujet sujet;
}
