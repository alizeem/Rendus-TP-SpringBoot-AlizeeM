package com.example.unc.miage;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvitesController {
	
	@Autowired
	private InviteRepository inviteRepository;

	
	@RequestMapping("/defaut")
	public Invite getDefaut() {
		return new Invite("spring", "sav", "sav.spring@gmail.com");
	}
	
	@RequestMapping("/all")
	ArrayList<Invite> getAll() {
		return (ArrayList<Invite>)inviteRepository.findAll();
	}
	
	@GetMapping("/{invite}") // Maps requêtes GET
	public ArrayList<Invite> rechercheInvite(@PathVariable String nom) {
		ArrayList<Invite> liste = inviteRepository.findByNom(nom);
        return liste;
    }
	
	@GetMapping
	public ArrayList<Invite> rechercheInviteParGet(@RequestParam String nom, @RequestParam String prenom){
		ArrayList<Invite> liste = inviteRepository.findByNomAndPrenom(nom, prenom);
        return liste;
    }
	
	@PostMapping(path="/ajoute")
	public String ajouteInviteParPost(@RequestParam String nom, @RequestParam String prenom, @RequestParam String email) {
		System.out.println("Dans POST");
		Invite i = new Invite(nom, prenom, email);
		inviteRepository.save(i);
		return "Saved";
	}

}
