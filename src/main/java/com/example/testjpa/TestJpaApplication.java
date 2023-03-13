package com.example.testjpa;

import com.example.testjpa.models.Projet;
import com.example.testjpa.models.Tache;
import com.example.testjpa.models.Utilisateur;
import com.example.testjpa.services.IServiceProjet;
import com.example.testjpa.services.IServiceTache;
import com.example.testjpa.services.IServiceUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TestJpaApplication implements CommandLineRunner {
    @Autowired
    public IServiceProjet serviceProjet;
    @Autowired
    public IServiceTache serviceTache;
    @Autowired
    public IServiceUtilisateur serviceUtilisateur;
    public static void main(String[] args) {
        SpringApplication.run (TestJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Projet> projets= serviceProjet.recherche();
        projets.forEach(e-> System.out.println(e.getId()+" --  "+e.getTitre()));

        List<Utilisateur> utilisateurs= serviceUtilisateur.recherche();
        utilisateurs.forEach(e-> System.out.println(e.getId()+" --  "+e.getNom()));

        Tache tache=new Tache (5L,"tache1");

        Tache tache1=serviceTache.addTacheToProject (tache, 1L);
        serviceTache.deleteTacheByProjet (3L);
        serviceUtilisateur.delete (6L);

        serviceProjet.addProject ("titre","desc");
    }
}
