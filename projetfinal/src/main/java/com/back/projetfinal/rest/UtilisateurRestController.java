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
import com.back.projetfinal.repo.UtilisateurRepository;

@RestController
@RequestMapping("/user")
public class UtilisateurRestController {

	@Autowired
	UtilisateurRepository repo;

	@GetMapping("/hello")
	public String getHello() {
		MyLogger.log.info("rest service get/user/hello call");
		return "hello";
	}

	@CrossOrigin
	@GetMapping("/user")
	public List<Utilisateur> getAllUtilisateur() {
		MyLogger.log.info("rest service get/user/user call");
		return repo.findAll();
	}

	@CrossOrigin
	@GetMapping("/user/{id}")
	public Utilisateur getUtilisateur(@PathVariable(name = "id") String email) {
		MyLogger.log.info("rest service get/user/user/id call");
		return repo.findById(email).get();
	}

	@CrossOrigin
	@PostMapping("/user")
	public String createUtilisateur(@RequestBody Utilisateur user) {
		MyLogger.log.info("rest service post/user/user call");
		repo.save(user);
		return "Utilisateur ajouté";
	}

	@CrossOrigin
	@DeleteMapping("/user/{id}")
	public String delete(@PathVariable(name = "id") String email) {
		MyLogger.log.info("rest service delete/user/user call");
		repo.delete(repo.findById(email).get());
		return "Utilisateur suprimé";
	}

	@CrossOrigin
	@PutMapping("/user")
	public String update(@RequestBody Utilisateur user) {
		MyLogger.log.info("rest service put/user/user call");
		repo.save(user);
		return "Utilisateur mis a jour";
	}

	@CrossOrigin
	@GetMapping("/user/{id}/{pass}")
	public Utilisateur connect(@PathVariable(name = "id") String email, @PathVariable(name = "pass") String pass) {
		MyLogger.log.info("rest service get/user/user/id/pass call");
		return repo.findByEmailAndPassword(email, pass);
	}
	
	
//	@CrossOrigin
//	@GetMapping("/user/{id}/offer")
//	public List<FicheMetier> getFicheMetierByUtilisateur(@PathVariable(name = "id") String email, @PathVariable(name = "pass") String pass) {
//		MyLogger.log.info("rest service get/user/user/id/pass call");
//		return repo.findById(email).get().getListeMetierPostule();
//	}
}
