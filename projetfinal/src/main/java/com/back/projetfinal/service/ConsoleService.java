package com.back.projetfinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.back.projetfinal.business.Administrateur;
import com.back.projetfinal.business.FicheMetier;
import com.back.projetfinal.business.Test;
import com.back.projetfinal.business.Utilisateur;
import com.back.projetfinal.repo.AdministrateurRepository;
import com.back.projetfinal.repo.FicheMetierRepository;
import com.back.projetfinal.repo.UtilisateurRepository;

@Service
public class ConsoleService implements CommandLineRunner {

	@Autowired
	UtilisateurRepository repoU;
	
	@Autowired
	FicheMetierRepository repoM;
	
	@Autowired
	AdministrateurRepository repoA;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("coucou projet boot");
		//init();
		//resetAndInitBase();

	}
	
	private void resetAndInitBase(){
		FicheMetier fm = new FicheMetier();
		fm.setCodeMetier(5);
		fm.getListeCandidat().add("first");
		fm.getListeCandidat().add("two");
		
		
		Utilisateur adam = new Utilisateur();
		adam.setEmail("first");
		adam.setPassword("root");
		adam.setNom("first");
		adam.setPrenom("adam");
		adam.setTelephone("00 00 00 00 00");
		
		Utilisateur k1 = new Utilisateur();
		k1.setEmail("two");
		k1.setPassword("root");
		k1.setNom("two");
		k1.setPrenom("k1");
		k1.setTelephone("00 00 00 00 00");
		adam.getListeMetierPostule().add(5);
		k1.getListeMetierPostule().add(5);
		Administrateur dieu = new Administrateur();
		dieu.setEmail("toutpuissant@haut.com");
		dieu.setPassword("lui");
		repoU.save(adam);
		repoA.save(dieu);
		repoM.save(fm);
		
	}
	
	private void init(){
		
	}
}
