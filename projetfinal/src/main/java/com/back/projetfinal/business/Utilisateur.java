package com.back.projetfinal.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//a discuté si on utilise Joined ou ca. différence de manipulation des permition admin
public class Utilisateur {
	
	@Id
	protected String email;
	
	protected String password;
	
	protected String nom;
	
	protected String prenom;
	
	protected String telephone;
	
	@ManyToMany
	@JoinTable(name = "candidat_offre",
	joinColumns ={@JoinColumn(name = "candidat_email")}, inverseJoinColumns = {@JoinColumn(name = "code_metier")})
	private List<FicheMetier> listeMetierPostule;
	
	@Version
	protected int version;

	public Utilisateur() {
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<FicheMetier> getListeMetierPostule() {
		return listeMetierPostule;
	}

	public void setListeMetierPostule(List<FicheMetier> listeMetierPostule) {
		this.listeMetierPostule = listeMetierPostule;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Utilisateur [email=" + email + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom
				+ ", telephone=" + telephone + "]";
	}


}
