package com.example.api_rest_forum.repository;

import com.example.api_rest_forum.modeles.Message;
import com.example.api_rest_forum.modeles.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message,Long> {


}
