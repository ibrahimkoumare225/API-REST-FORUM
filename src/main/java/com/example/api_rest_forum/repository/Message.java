package com.example.api_rest_forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Message extends JpaRepository<com.example.api_rest_forum.modeles.Message,Long> {
}
