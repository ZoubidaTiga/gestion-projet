package com.example.testjpa.services;

import com.example.testjpa.models.Projet;
import com.example.testjpa.models.Tache;
import com.example.testjpa.repositories.ProjetRepository;
import com.example.testjpa.repositories.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTache implements IServiceTache{
    @Autowired
    private TacheRepository tacheRepository;

    @Autowired
    private ProjetRepository projetRepository;

    @Override
    public List<Tache> recherche() {
        List<Tache> taches=tacheRepository.findAll ();
        List<Tache> sorted =
                taches.stream ()
                        .sorted ((o1, o2) -> (int) (o1.getId()-o2.getId ())).toList ();
        return sorted;
    }

    @Override
    public void delete(Tache tache) {
        tacheRepository.delete(tache);
    }



    @Override
    public Tache addTacheToProject(Tache tache, Long project_id) {
        Projet projet = projetRepository.findById(project_id).get();
        Tache tache1 = new Tache(tache.getId(),tache.getTitre(), tache.getDescription(),projet);
        return tacheRepository.save(tache1);
    }

    @Override
    public void deleteTacheByProjet(Long idProject) {
        List<Tache> allTaches=tacheRepository.findAll ();
        for(Tache tache:allTaches){
            if(tache.getProjet().getId() == idProject){
                delete(tache);
            }
        }

    }
}
