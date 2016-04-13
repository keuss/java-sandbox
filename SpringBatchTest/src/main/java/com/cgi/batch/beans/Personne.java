package com.cgi.batch.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Personne {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Personne.class);

	
	
	
	/**
	 * default constructor for log creation ...
	 */
	public Personne() {
		LOGGER.info("new Personne with id {}", id);
	}
	
	
	private int id;
	private String nom;
	private String prenom;
	private String civilite;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCivilite() {
		return civilite;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", civilite=" + civilite + "]";
	}
	
	

}