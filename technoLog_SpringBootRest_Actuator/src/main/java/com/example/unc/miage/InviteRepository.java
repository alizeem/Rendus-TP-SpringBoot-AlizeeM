package com.example.unc.miage;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InviteRepository extends CrudRepository<Invite, Long> {
    ArrayList<Invite> findByNomAndPrenom(String nom, String prenom);
    ArrayList<Invite> findByNom(String nom);
    Invite findByNomAndPrenomAndEmail(String nom, String prenom, String email);
    
    @Query("SELECT i FROM Invite i GROUP BY i.nom, i.prenom, i.email HAVING COUNT(i) > 1")
    Collection<Invite> rechercherDoublons();
}
