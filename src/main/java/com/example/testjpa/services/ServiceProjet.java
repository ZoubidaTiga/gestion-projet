package com.example.testjpa.services;

import com.example.testjpa.exceptions.ProjectNotFoundException;
import com.example.testjpa.models.Projet;
import com.example.testjpa.models.Tache;
import com.example.testjpa.repositories.ProjetRepository;
import com.example.testjpa.repositories.TacheRepository;
import org.hibernate.annotations.NamedQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceProjet implements IServiceProjet{

    @Autowired
    ProjetRepository projetRepository;
    @Autowired
    TacheRepository tacheRepository;
    @Autowired
    ServiceTache serviceTache;

    @Override
    public List<Projet> recherche() {
        List<Projet> projets=projetRepository.findAll ();
        List<Projet> sorted =
                projets.stream ()
                        .sorted ((o1, o2) -> (int) (o1.getId ()-o2.getId ())).toList ();
        return sorted;
    }

    @Override
    public void addProject(String titre, String description) {
        projetRepository.saveWithUtilisateur (titre,description);
    }


}
