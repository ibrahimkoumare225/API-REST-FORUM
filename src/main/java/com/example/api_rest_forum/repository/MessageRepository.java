package com.example.api_rest_forum.repository;

import com.example.api_rest_forum.modeles.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
