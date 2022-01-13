package com.back.projetfinal.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.persistence.JoinColumn;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//a discuté si on utilise Joined ou ca. différence de manipulation des permition admin
public class Utilisateur {
	
	@Id
	private String email;
	
	private String password;
	
	private String nom;
	
	private String prenom;
	
	private String telephone;
	
	@ElementCollection
	@CollectionTable(
			name="offer",
			joinColumns={@JoinColumn(name="utilisateur_email")})
	@Column(name="liste_offer")
	private List<Integer> listeMetierPostule = new ArrayList<Integer>();
	
	@Version
	private int version;

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

	public List<Integer> getListeMetierPostule() {
		return listeMetierPostule;
	}

	public void setListeMetierPostule(List<Integer> listeMetierPostule) {
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
