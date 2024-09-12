package com.example.api_rest_forum.services.dto;

import com.example.api_rest_forum.modeles.Forum;
import com.example.api_rest_forum.modeles.Message;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter

public class SujetDTO {

    private Long id;
    String title;
    Date createdDate;

    private List<Message> messages;

    private Forum forum;
}
