package com.back.projetfinal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.projetfinal.business.FicheMetier;

public interface FicheMetierRepository extends JpaRepository<FicheMetier, Integer> {

	List<FicheMetier> findByNomMetierContaining(String filtre);
}
