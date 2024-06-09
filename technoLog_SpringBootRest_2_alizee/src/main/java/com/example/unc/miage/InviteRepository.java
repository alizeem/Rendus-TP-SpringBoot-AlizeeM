package com.example.unc.miage;


import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;

public interface InviteRepository extends CrudRepository<Invite, Long> {
	ArrayList<Invite> findByNomAndPrenom(String nom, String prenom);
	ArrayList<Invite> findByNom(String nom);
}
