package com.example.unc.miage;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BienvenueInviteController {
	@Value("${conference.name: à tout le monde}")
	private String conference;
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/") // URL: http://localhost:8080
	public String home() {
		return "<h1>Bienvenue " + conference + "</h1>";
	}
	
	@RequestMapping("/bienvenue")
	public Invite bienvenue(@RequestParam(value = "nom", defaultValue = "Palmer") String nom,
							@RequestParam(value = "prenom", defaultValue = "Jack") String prenom,
							@RequestParam(value = "email", defaultValue = "help.dev@spring.io") String email) {
		return new Invite(counter.incrementAndGet(), nom, prenom, email);
	}
	
	@RequestMapping("/{invite}")
	public String bienvenueInvite(@PathVariable String invite) {
		return "<H1> Bienvenue " + invite + "</H1>";
	}
	
	@RequestMapping("/test/{nombre}")
	public String testNombre(@PathVariable int nombre) {
		nombre++ ;
		return "<H1> Nombre reçu + 1: " + nombre + "</H1>";
	}
}
