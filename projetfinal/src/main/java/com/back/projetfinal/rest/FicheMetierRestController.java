package com.back.projetfinal.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.projetfinal.business.FicheMetier;
import com.back.projetfinal.business.Utilisateur;
import com.back.projetfinal.logger.MyLogger;
import com.back.projetfinal.repo.FicheMetierRepository;

@RestController
@RequestMapping("/jobs")
public class FicheMetierRestController {
	
	@Autowired
	private FicheMetierRepository repo;

	@GetMapping("/hello")
	public String getHello(){
		MyLogger.log.info("rest service get/jobs/job call");
		return "hello";
	}

	@CrossOrigin
	@GetMapping("/job")
	public List<FicheMetier> getAllFicheMetier(){
		MyLogger.log.info("rest service get/jobs/job call");
		return repo.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/job/{id}")
	public FicheMetier getFicheMetierById(@PathVariable(name="id") int codeMetier){
		MyLogger.log.info("rest service get/jobs/job/id call");
		return repo.findById(codeMetier).get();
	}
	
	@CrossOrigin
	@PostMapping("/job")
	public String createFicheMetier(@RequestBody FicheMetier metier){
		MyLogger.log.info("rest service post/jobs/job call");
		repo.save(metier);
		return "Fiche Metier ajouté";
	}
	
	@CrossOrigin
	@DeleteMapping("/job/{id}") // choix : ajouter un id ou l'utiliser avec un boutton
	public String delete(@PathVariable(name = "id") Integer codeMetier) {
		MyLogger.log.info("rest service delete/jobs/job call");
		repo.delete(repo.findById(codeMetier).get());
		return "Fiche Metier suprimé";
	}
	
	@CrossOrigin
	@PutMapping("/job")
	public String update(@RequestBody FicheMetier metier) {
		MyLogger.log.info("rest service put/jobs/job call");
		repo.save(metier);
		return "Fiche Metier mis a jour";
	}
	
//	@CrossOrigin
//	@GetMapping("/job/user/{id}")
//	public List<String> getUtilisateurByFicheMetier(@PathVariable(name="id") int codeMetier){
//		MyLogger.log.info("rest service get/jobs/job/id call");
//		return repo.findById(codeMetier).get().getListeCandidat();
//	}

}
