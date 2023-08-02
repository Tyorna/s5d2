package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Utente;
import com.example.demo.services.UtenteService;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

	@Autowired
	private UtenteService uService;

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Utente save(@RequestBody Utente utente) {
		Utente newUtente = uService.save(utente);
		return newUtente;
	}

	@GetMapping("")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Utente> getUtenti() {
		return uService.getUtenti();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public Utente getById(@PathVariable int id) throws Exception {
		return uService.findById(id).orElseThrow(() -> new Exception("Utente non trovato!"));

	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUtenteById(@PathVariable int id) {
		uService.deleteUtente(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Utente updateUtente(@PathVariable int id, @RequestBody Utente utente) throws Exception {
		return uService.updateUtente(id, utente).orElseThrow(() -> new Exception("Utente non trovato!"));
	}
}
