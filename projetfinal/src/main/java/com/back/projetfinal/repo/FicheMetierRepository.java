package com.back.projetfinal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.projetfinal.business.FicheMetier;

public interface FicheMetierRepository extends JpaRepository<FicheMetier, Integer> {

}
