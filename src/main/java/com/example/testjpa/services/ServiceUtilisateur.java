package com.example.testjpa.services;

import com.example.testjpa.models.Tache;
import com.example.testjpa.models.Utilisateur;
import com.example.testjpa.repositories.TacheRepository;
import com.example.testjpa.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUtilisateur implements IServiceUtilisateur{
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Override
    public List<Utilisateur> recherche() {
        List<Utilisateur> taches=utilisateurRepository.findAll();
        List<Utilisateur> sorted =
                taches.stream()
                        .sorted((o1, o2) -> (int) (o1.getId()-o2.getId())).toList();
        return sorted;
    }

    @Override
    public void delete(Long idUser) {
        utilisateurRepository.deleteById (idUser);
    }
}
