package com.example.api_rest_forum.services.impl;

public interface EntityMapper<D,E> {

    D toDto(E entity);
    E toEntity(D dto);

}
