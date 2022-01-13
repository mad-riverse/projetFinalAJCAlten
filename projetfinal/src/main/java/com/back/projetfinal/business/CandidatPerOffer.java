package com.back.projetfinal.business;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Version;

@Entity
public class CandidatPerOffer {

	@Id
	private int id;
	
	
	private String utilisateurEmail;
	
	
	private int ficheMetierCode;
	
//	@Column(nullable=true)
//	private boolean isValided;
	
	@Version
	private int version;

	public CandidatPerOffer() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public boolean isValided() {
//		return isValided;
//	}
//
//	public void setValided(boolean isValided) {
//		this.isValided = isValided;
//	}

	public String getUtilisateurEmail() {
		return utilisateurEmail;
	}

	public void setUtilisateurEmail(String utilisateurEmail) {
		this.utilisateurEmail = utilisateurEmail;
	}

	public int getFicheMetierCode() {
		return ficheMetierCode;
	}

	public void setFicheMetierCode(int ficheMetierCode) {
		this.ficheMetierCode = ficheMetierCode;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "CandidatPerOffer [id=" + id + ", utilisateurEmail=" + utilisateurEmail + ", ficheMetierCode="
				+ ficheMetierCode + "]";
	}

	
	
	
	
}
