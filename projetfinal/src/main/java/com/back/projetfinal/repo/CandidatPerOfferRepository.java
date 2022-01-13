package com.back.projetfinal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.projetfinal.business.CandidatPerOffer;
import com.back.projetfinal.business.FicheMetier;
import com.back.projetfinal.business.Utilisateur;


public interface CandidatPerOfferRepository extends JpaRepository<CandidatPerOffer, Integer> {
	
	List<CandidatPerOffer> findByUtilisateur(Utilisateur utilisateur);
	
	List<CandidatPerOffer> findByFicheMetier(FicheMetier ficheMetier);

}
