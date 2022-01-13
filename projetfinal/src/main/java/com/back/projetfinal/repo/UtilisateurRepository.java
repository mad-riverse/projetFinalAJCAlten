package com.back.projetfinal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.projetfinal.business.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {

	Utilisateur findByEmailAndPassword(String mail, String pass);
	
}
