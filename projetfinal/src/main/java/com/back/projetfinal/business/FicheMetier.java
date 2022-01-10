package com.back.projetfinal.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

@Entity
public class FicheMetier {
	
	@Id
	private int codeMetier;

	private String nomMetier;
	
	private int salaireAnnuel;
	
	@ManyToMany(mappedBy = "listeMetierPostule")
	private List<Utilisateur> listeCandidat;
	
	private String descriptif;
	
	@Version
	private int version;

	public FicheMetier() {
	}

	public int getCodeMetier() {
		return codeMetier;
	}

	public void setCodeMetier(int codeMetier) {
		this.codeMetier = codeMetier;
	}

	public String getNomMetier() {
		return nomMetier;
	}

	public void setNomMetier(String nomMetier) {
		this.nomMetier = nomMetier;
	}

	public int getSalaireAnnuel() {
		return salaireAnnuel;
	}

	public void setSalaireAnnuel(int salaireAnnuel) {
		this.salaireAnnuel = salaireAnnuel;
	}

	public List<Utilisateur> getListeCandidat() {
		return listeCandidat;
	}

	public void setListeCandidat(List<Utilisateur> listeCandidat) {
		this.listeCandidat = listeCandidat;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "FicheMetier [codeMetier=" + codeMetier + ", nomMetier=" + nomMetier + ", salaireAnnuel=" + salaireAnnuel
				+ ", listeCandidat=" + listeCandidat + ", descriptif=" + descriptif + "]";
	}

	

}
