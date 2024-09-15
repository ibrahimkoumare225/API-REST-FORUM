package com.example.api_rest_forum.web.ressource;

import com.example.api_rest_forum.services.SujetService;
import com.example.api_rest_forum.services.dto.SujetDTO;
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

@RestController
@RequestMapping("/api/sujets")
@Slf4j
@RequiredArgsConstructor
public class SujetResource {

    private final SujetService sujetService;

    @PostMapping("/{id}")
    @ApiResponse(responseCode = "201", description= "Request to save subject")
    @Operation(summary = "subject new save", description = "this endpoint allow to save subject")
    public ResponseEntity<SujetDTO> saveSubjectById(@RequestBody SujetDTO subjectDTO,@PathVariable Long id){
        log.debug("REST Request to save Subject : {}", subjectDTO);
        return new  ResponseEntity<>(sujetService.createByIdForum(subjectDTO,id), HttpStatus.CREATED);
    }

    @PostMapping("/slug/{slug}")
    @ApiResponse(responseCode = "201", description= "Request to save subject")
    @Operation(summary = "subject new save", description = "this endpoint allow to save subject")
    public ResponseEntity<SujetDTO> saveSubjectBySlug(@RequestBody SujetDTO subjectDTO,@PathVariable String slug){
        log.debug("REST Request to save Subject : {}", subjectDTO);
        return new  ResponseEntity<>(sujetService.createBySlugForum(subjectDTO,slug), HttpStatus.CREATED);
    }


    @GetMapping
    @Operation(summary = "find all subject", description = "this endpoint allow to get all subject")
    public List<SujetDTO> findAllSubject(){
        log.debug("REST Request to get all Subjects");
        return sujetService.findAll();
    }

    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Request to get subject"),
            @ApiResponse(responseCode = "404", description = "subject not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @Operation(summary = "get subject by id", description = "this endpoint allow to get subject by id")
    public ResponseEntity<?> findByIdSubject(@PathVariable Long id){
        log.debug("REST Request to get by id Subject : {}", id);
        Optional<SujetDTO> subjectDTO = sujetService.findById(id);
        if(subjectDTO.isPresent()){
            return new ResponseEntity<>(subjectDTO.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Subject not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/slug/{slug}")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Request to get subject"),
            @ApiResponse(responseCode = "404", description = "subject not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @Operation(summary = "get subject by slug", description = "this endpoint allow to get subject by slug")
    public ResponseEntity<?> findBySlugSubject(@PathVariable String slug){
        log.debug("REST Request to get by slug Subject : {}", slug);
        Optional<SujetDTO> subjectDTO = sujetService.findBySlug(slug);
        if(subjectDTO.isPresent()){
            return new ResponseEntity<>(subjectDTO.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Subject not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/forum/{id}")
    @Operation(summary = "find by id forum", description = "this endpoint allow to find by id forum")
    public List<SujetDTO> findByForumId(@PathVariable Long id){
        log.debug("REST Request to get all Subjects by forum id : {}", id);
        return sujetService.findByForumId(id);
    }

    @GetMapping("/forum/slug/{slug}")
    @Operation(summary = "find by slug forum", description = "this endpoint allow to find by slug forum")
    public List<SujetDTO> findByForumSlug(@PathVariable String slug){
        log.debug("REST Request to get all Subjects by forum slug : {}", slug);
        return sujetService.findByForumSlug(slug);
    }
}
