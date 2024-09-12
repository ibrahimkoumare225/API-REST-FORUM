package com.example.api_rest_forum.modeles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Forum {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false, unique = true)
    private String title;

    private String description;
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @OneToMany(mappedBy = "forum", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sujet> sujets;
}