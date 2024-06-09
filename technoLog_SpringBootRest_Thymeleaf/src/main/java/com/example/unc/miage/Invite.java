package com.example.unc.miage;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Invite implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private Date date;
	private String nom;
	private String prenom;
	private String email;
	
	public Invite() {
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Invite(long id, String nom, String prenom, String email) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.date = new Date();
	}
	
	// Méthode pour obtenir la date formatée
    public String getFormattedDate() {
        // Convertir java.util.Date en java.time.LocalDate
        LocalDate localDate = this.date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Formater la date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        return localDate.format(formatter);
    }
	
    @Override
    public String toString() {
        // Formater la date directement dans la méthode toString()
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        return nom + " " + prenom + " " + formatter.format(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }
}
