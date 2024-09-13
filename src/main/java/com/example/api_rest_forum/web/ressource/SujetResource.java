package com.example.api_rest_forum.web.ressource;

import com.example.api_rest_forum.services.SujetService;
import com.example.api_rest_forum.services.dto.SujetDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sujets")
@Slf4j
@RequiredArgsConstructor
public class SujetResource {

    private final SujetService sujetService;

    @PostMapping
    public ResponseEntity<SujetDTO> save(@RequestBody SujetDTO sujetDTO) {
        log.debug("REST Request to save sujet {}", sujetDTO);

        return new ResponseEntity<>(sujetService.saveSujet(sujetDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        log.debug("REST Request to get one {}", id);
        Optional<SujetDTO> sujetDTO = sujetService.findOne(id);
        if (sujetDTO.isPresent()) {
            return new ResponseEntity<>(sujetDTO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Sujet not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<SujetDTO>> getAll() {
        log.debug("REST Request to get all sujets");
        List<SujetDTO> sujetDTOs = sujetService.findAll();
        return new ResponseEntity<>(sujetDTOs, HttpStatus.OK);
    }

    @GetMapping("/forum/{forumId}")
    public ResponseEntity<List<SujetDTO>> getByForum(@PathVariable Long forumId) {
        log.debug("REST Request to get sujets by forum id {}", forumId);
        List<SujetDTO> sujetDTOs = sujetService.findByForumId(forumId);
        return new ResponseEntity<>(sujetDTOs, HttpStatus.OK);
    }
}
