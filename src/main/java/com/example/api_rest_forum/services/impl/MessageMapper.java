package com.example.api_rest_forum.services.impl;

import com.example.api_rest_forum.modeles.Message;
import com.example.api_rest_forum.services.dto.MessageDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper extends EntityMapper<MessageDTO, Message>{
}
