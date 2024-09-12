package com.example.api_rest_forum.services.mappers;
import com.example.api_rest_forum.modeles.Sujet;
import com.example.api_rest_forum.services.dto.SujetDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SujetMapper extends EntityMapper<SujetDTO, Sujet>{
}
