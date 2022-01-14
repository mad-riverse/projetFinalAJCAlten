package com.back.projetfinal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.projetfinal.business.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {

	Utilisateur findByEmailAndPassword(String mail, String pass);
	
	List<Utilisateur> findByNomContaining(String filtre);
	
}
