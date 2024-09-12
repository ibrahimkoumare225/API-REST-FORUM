package com.example.api_rest_forum.services.impl;

import com.example.api_rest_forum.modeles.Forum;
import com.example.api_rest_forum.services.dto.ForumDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ForumMapper extends EntityMapper<ForumDTO, Forum> {
}
