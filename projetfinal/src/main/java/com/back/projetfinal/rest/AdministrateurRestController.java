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

import com.back.projetfinal.business.Administrateur;
import com.back.projetfinal.logger.MyLogger;
import com.back.projetfinal.repo.AdministrateurRepository;

@RestController
@RequestMapping("/admin")
public class AdministrateurRestController {

	@Autowired
	AdministrateurRepository repo;

	@GetMapping("/hello")
	public String getHello() {
		MyLogger.log.info("rest service get/admin/hello call");
		return "hello";
	}

	@CrossOrigin
	@GetMapping("/admin")
	public List<Administrateur> getAllAdministrateur() {
		MyLogger.log.info("rest service get/admin/admin call");
		return repo.findAll();
	}

	@CrossOrigin
	@GetMapping("/admin/{id}")
	public Administrateur getAdministrateur(@PathVariable(name = "id") String email) {
		MyLogger.log.info("rest service get/admin/admin/id call");
		return repo.findById(email).get();
	}

	@CrossOrigin
	@PostMapping("/admin")
	public String createAdministrateur(@RequestBody Administrateur admin) {
		MyLogger.log.info("rest service post/admin/admin call");
		repo.save(admin);
		return "Administrateur ajoutÃ©";
	}

	@CrossOrigin
	@DeleteMapping("/admin/{id}") // choix : ajouter un id ou l'utiliser avec un
								// boutton
	public String delete(@PathVariable(name = "id") String email) {
		MyLogger.log.info("rest service delete/admin/admin call");
		repo.delete(repo.findById(email).get());
		return "Administrateur suprimÃ©";
	}

	@CrossOrigin
	@PutMapping("/admin")
	public String update(@RequestBody Administrateur admin) {
		MyLogger.log.info("rest service put/admin/admin call");
		repo.save(admin);
		return "Administrateur mis a jour";
	}

	@CrossOrigin
	@GetMapping("/admin/{id}/{pass}")
	public Administrateur connect(@PathVariable(name = "id") String email, @PathVariable(name = "pass") String pass) {
		MyLogger.log.info("rest service get/admin/admin/id/pass call");
		return repo.findByEmailAndPassword(email, pass);
	}

}
