package com.example.api_rest_forum.web.ressource;

import com.example.api_rest_forum.services.ForumService;
import com.example.api_rest_forum.services.dto.ForumDTO;
import com.example.api_rest_forum.services.dto.MessageDTO;
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
    ResponseEntity<ForumDTO> save(@RequestBody ForumDTO forum){
        log.debug("Rest Request to save forum");
        return new ResponseEntity<>(forumService.save(forum), HttpStatus.CREATED);
    }
    @GetMapping
    List<ForumDTO> listForum(){
        log.debug("REST Request to get all forum");
        return forumService.findAll();
    }
    @GetMapping("/{id}")
    ResponseEntity<?>getOneForum(@PathVariable Long id){
        log.debug("REST Request to get one forum by id,{}",id);
        Optional<ForumDTO> forum = forumService.findOne(id);
        if (forum.isPresent()){
            return new ResponseEntity<>(forum.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Foum not found",HttpStatus.NOT_FOUND);
        }
    }
}
