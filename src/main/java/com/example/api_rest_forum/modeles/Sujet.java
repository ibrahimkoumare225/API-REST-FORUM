package com.example.api_rest_forum.modeles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Sujet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private Instant createdDate;

    @Column(unique = true)
    private String slug;

    @OneToMany(mappedBy = "sujet")
    private List<Message> messages;

    @ManyToOne
    @JoinColumn(name = "forum_id")
    private Forum forum;
}
