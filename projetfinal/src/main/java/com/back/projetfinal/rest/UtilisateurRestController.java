package com.back.projetfinal.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.projetfinal.business.Utilisateur;
import com.back.projetfinal.logger.MyLogger;
import com.back.projetfinal.repo.UtilisateurRepository;

@RestController
@RequestMapping("/user")
public class UtilisateurRestController {
	
	@Autowired
	UtilisateurRepository repo;
	
	@GetMapping("/hello")
	public String getHello(){
		MyLogger.log.info("rest service get/user/hello call");
		return "hello";
	}

	@GetMapping("/user")
	public List<Utilisateur> getAllUtilisateur(){
		MyLogger.log.info("rest service get/user/user call");
		return repo.findAll();
	}
	
	@GetMapping("/user/{id}")
	public Utilisateur getUtilisateur(@PathVariable(name="id") String pseudo){
		MyLogger.log.info("rest service get/user/hello/id call");
		return repo.findById(pseudo).get();
	}
	
	@PostMapping("/user")
	public String createUtilisateur(@RequestBody Utilisateur user){
		MyLogger.log.info("rest service post/user/user call");
		repo.save(user);
		return "Utilisateur ajouté";
	}
	
	@DeleteMapping("/user")
	public String delete(@RequestBody Utilisateur user) {
		MyLogger.log.info("rest service delete/user/user call");
		repo.delete(repo.findById(user.getEmail()).get());
		return "Utilisateur suprimé";
	}
	
	@PutMapping("/user")
	public String update(@RequestBody Utilisateur user) {
		MyLogger.log.info("rest service put/user/user call");
		repo.save(user);
		return "Utilisateur mis a jour";
	}
	
	
}
