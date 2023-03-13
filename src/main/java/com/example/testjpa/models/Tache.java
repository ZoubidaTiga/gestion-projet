package com.example.testjpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projet")
    private Projet projet;

    public Tache(Long id_tache, String titre){
        this.id=id_tache;
        this.titre=titre;
    }

    public Tache(Long id, String titre, Projet projet) {
    }
}