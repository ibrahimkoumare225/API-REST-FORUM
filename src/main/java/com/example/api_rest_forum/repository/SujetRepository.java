package com.example.api_rest_forum.repository;

import com.example.api_rest_forum.modeles.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SujetRepository extends JpaRepository<Sujet, Long> {
    List<Sujet> findByForumId(Long forumId);
}
