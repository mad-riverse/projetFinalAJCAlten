package com.back.projetfinal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.projetfinal.business.Administrateur;

public interface AdministrateurRepository extends JpaRepository<Administrateur, String> {

	Administrateur findByEmailAndPassword(String mail, String pass);
}
