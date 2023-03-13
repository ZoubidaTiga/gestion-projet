package com.example.testjpa.repositories;

import com.example.testjpa.models.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {
}
