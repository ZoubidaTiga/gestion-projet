package com.example.testjpa.services;

import com.example.testjpa.models.Utilisateur;

import java.util.List;

public interface IServiceUtilisateur {
    List<Utilisateur> recherche();
    void delete(Long idUser);
}
