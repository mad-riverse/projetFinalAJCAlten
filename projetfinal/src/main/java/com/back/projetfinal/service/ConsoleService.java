package com.back.projetfinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.back.projetfinal.business.Administrateur;
import com.back.projetfinal.business.Test;
import com.back.projetfinal.business.Utilisateur;
import com.back.projetfinal.repo.UtilisateurRepository;

@Service
public class ConsoleService implements CommandLineRunner {

	@Autowired
	UtilisateurRepository repo;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("coucou projet boot");
		//init();
		//resetAndInitBase();

	}
	
	private void resetAndInitBase(){
		Utilisateur adam = new Utilisateur();
		adam.setEmail("first");
		adam.setPassword("root");
		adam.setNom("first");
		adam.setPrenom("adam");
		adam.setTelephone("00 00 00 00 00");
		Administrateur dieu = new Administrateur();
		dieu.setEmail("toutpuissant@haut.com");
		dieu.setPassword("lui");
		//repo.save(adam);
		//repo.save(dieu);
	}
	
	private void init(){
		
	}
}
