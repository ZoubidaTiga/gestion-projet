package com.example.testjpa.services;

import com.example.testjpa.models.Tache;

import java.util.List;

public interface IServiceTache {
    List<Tache> recherche();
    void  delete(Tache tache);

    Tache addTacheToProject(Tache tache, Long project_id);

    void deleteTacheByProjet(Long idProject);
}
