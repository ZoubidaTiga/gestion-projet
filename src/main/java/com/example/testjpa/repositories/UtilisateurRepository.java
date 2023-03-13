package com.example.testjpa.repositories;

import com.example.testjpa.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
