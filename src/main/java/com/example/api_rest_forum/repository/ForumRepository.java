package com.example.api_rest_forum.repository;

import com.example.api_rest_forum.modeles.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepository extends JpaRepository<Forum, Long> {
}
