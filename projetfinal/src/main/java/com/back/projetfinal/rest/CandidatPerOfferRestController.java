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

import com.back.projetfinal.business.CandidatPerOffer;
import com.back.projetfinal.business.Utilisateur;
import com.back.projetfinal.logger.MyLogger;
import com.back.projetfinal.repo.CandidatPerOfferRepository;

@RestController
@RequestMapping("/link")
public class CandidatPerOfferRestController {
	
	@Autowired
	private CandidatPerOfferRepository repo;

	@GetMapping("/hello")
	public String getHello(){
		MyLogger.log.info("rest service get/join/hello call");
		return "hello";
	}

	@CrossOrigin
	@GetMapping("/link")
	public List<CandidatPerOffer> getAllCandidatPerOffer(){
		MyLogger.log.info("rest service get/join/link call");
		return repo.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/link/{id}")
	public CandidatPerOffer getCandidatPerOfferById(@PathVariable(name="id") int id){
		MyLogger.log.info("rest service get/join/link/id call");
		return repo.findById(id).get();
	}
	
	@CrossOrigin
	@PostMapping("/link")
	public String createCandidatPerOffer(@RequestBody CandidatPerOffer candidatPerOffer){
		MyLogger.log.info("rest service post/join/link call");
		repo.save(candidatPerOffer);
		return "relation ajouté";
	}
	
	@CrossOrigin
	@DeleteMapping("/link/{id}") // choix : ajouter un id ou l'utiliser avec un boutton
	public String delete(@PathVariable(name = "id") int candidatPerOffer) {
		MyLogger.log.info("rest service delete/join/link call");
		repo.delete(repo.findById(candidatPerOffer).get());
		return "relation suprimé";
	}
	
	@CrossOrigin
	@PutMapping("/link")
	public String update(@RequestBody CandidatPerOffer candidatPerOffer) {
		MyLogger.log.info("rest service put/join/link call");
		repo.save(candidatPerOffer);
		return "relation mis a jour";
	}
	
	@CrossOrigin
	@GetMapping("/link/user")
	public List<CandidatPerOffer> getUtilisateurForOffer(@RequestBody Utilisateur utilisateur){
		MyLogger.log.info("rest service get/join/link/id call");
		return repo.findByUtilisateur(utilisateur);
	}

}
