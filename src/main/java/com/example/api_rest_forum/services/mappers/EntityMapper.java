package com.example.api_rest_forum.services.mappers;

public interface EntityMapper<D,E> {

    D toDto(E entity);
    E toEntity(D dto);

}
