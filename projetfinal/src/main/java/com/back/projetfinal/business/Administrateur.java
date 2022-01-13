package com.back.projetfinal.business;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Administrateur{
	
	@Id
	private String email;
	
	private String password;
	
	private String nom;
	
	private String telephone;
	
	@Version
	private int version;

	public Administrateur() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Administrateur [email=" + email + ", password=" + password + ", nom=" + nom + ", telephone=" + telephone
				+ "]";
	}
	
	

}
