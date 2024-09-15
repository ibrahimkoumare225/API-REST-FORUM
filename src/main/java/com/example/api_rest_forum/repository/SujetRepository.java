package com.example.api_rest_forum.repository;

import com.example.api_rest_forum.modeles.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SujetRepository extends JpaRepository<Sujet, Long> {

    Optional<Sujet> findBySlug(String slug);

}
