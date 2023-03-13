package com.example.testjpa.repositories;

import com.example.testjpa.models.Projet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.*;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {

    @Modifying
    @Transactional
    void saveWithUtilisateur(@Param("titre") String titre, @Param("description") String description);
}
