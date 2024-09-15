package com.example.api_rest_forum.web.ressource;

import com.example.api_rest_forum.services.ForumService;
import com.example.api_rest_forum.services.dto.ForumDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/forums")
public class ForumRessource {
    private final ForumService forumService;

    @PostMapping
    @ApiResponse(responseCode = "201", description= "Request to save forum")
    @Operation(summary = "forum new save", description = "this endpoint allow to save forum")
    public ResponseEntity<ForumDTO> saveForum(@RequestBody ForumDTO forumDTO){
        log.debug("REST Request to save forum : {}", forumDTO);
        return new ResponseEntity<>(forumService.save(forumDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Request to get forum"),
            @ApiResponse(responseCode = "404", description = "forum not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @Operation(summary = "get one by id", description = "this endpoint allow to get one id")
    public ResponseEntity<?> getOneById(@PathVariable Long id){
        log.debug("REST Request to get by id forum : {}", id);
        Optional<ForumDTO> forumDTO = forumService.finOneById(id);
        if (forumDTO.isPresent()){
            return new ResponseEntity<>(forumDTO.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>("forum not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/slug/{slug}")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Request to get forum by slug"),
            @ApiResponse(responseCode = "404", description = "forum not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @Operation(summary = "get one by slug", description = "this endpoint allow to get one slug")
    public ResponseEntity<?> getOneBySlug(@PathVariable String slug){
        log.debug("REST Request to get by slug forum : {}", slug);
        Optional<ForumDTO> forumDTO = forumService.finOneBySlug(slug);
        if (forumDTO.isPresent()){
            return new ResponseEntity<>(forumDTO.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>("forum not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "get all forum", description = "this endpoint allow to get all forum")
    public List<ForumDTO> getAll(){
        log.debug("REST Request to get all forum");
        return forumService.findAll();
    }
}
