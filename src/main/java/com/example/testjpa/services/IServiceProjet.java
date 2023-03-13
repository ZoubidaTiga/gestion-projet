package com.example.testjpa.services;

import com.example.testjpa.exceptions.ProjectNotFoundException;
import com.example.testjpa.models.Projet;
import com.example.testjpa.models.Tache;

import java.util.List;

public interface IServiceProjet {
    List<Projet> recherche();
    void addProject(String titre, String description);


}
