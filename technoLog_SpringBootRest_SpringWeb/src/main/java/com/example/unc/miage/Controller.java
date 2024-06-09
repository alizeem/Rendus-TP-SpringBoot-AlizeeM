package com.example.unc.miage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class Controller {
 
	@GetMapping(value = "/invite")
	public Invite getStudent() {
		return new Invite(1, "Dupond","Jean","j.dupond");
	}
	
	@GetMapping(value = "/getinvitestring")
	private String getStudentString() {
		String uri = "http://localhost:8080/invite";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result; 
	}
	
	@GetMapping(value = "/getinvite")
	private Invite getStudentObject() {
		String uri = "http://localhost:8080/invite";
		RestTemplate restTemplate = new RestTemplate();
		Invite result = restTemplate.getForObject(uri, Invite.class);
		return result; 
	}
}
