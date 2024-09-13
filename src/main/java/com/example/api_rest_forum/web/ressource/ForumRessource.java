package com.example.api_rest_forum.web.ressource;

import com.example.api_rest_forum.services.ForumService;
import com.example.api_rest_forum.services.dto.ForumDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/forums")
public class ForumRessource {
    private final ForumService forumService;

    @PostMapping
    ResponseEntity<ForumDTO> save(@RequestBody ForumDTO forum){
        return new ResponseEntity<>(forumService.save(forum), HttpStatus.CREATED);
    }
    @GetMapping("/")
    List<ForumDTO> listForum(){
        return forumService.findAll();
    }
    @GetMapping("/{id}")
    ResponseEntity<?>getOneForum(@PathVariable Long id){
        Optional<ForumDTO> forum = forumService.findOne(id);
        if (forum.isPresent()){
            return new ResponseEntity<>(forum.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Foum not found",HttpStatus.NOT_FOUND);
        }
    }
}
