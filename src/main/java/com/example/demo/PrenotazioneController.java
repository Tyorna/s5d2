package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Prenotazione;
import com.example.demo.entities.PrenotazionePayload;
import com.example.demo.services.PrenotazioneService;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

	@Autowired
	private PrenotazioneService pService;

//	@PostMapping("")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Prenotazione save(@RequestBody Prenotazione prenotazione) {
//		Prenotazione newUtente = pService.save(prenotazione);
//		return newUtente;
//	}
	
//		@PostMapping("")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Prenotazione saveConControlloUtenteAndPrenotazione(@RequestBody PrenotazionePayload pl) throws Exception {
//		LocalDate giornoPrenotazione = pl.getGiornoPrenotazione();
//		int utenteId = pl.getUtenteId();
//		int postazioneId = pl.getPostazioneId();
//
//		Prenotazione newPrenotazione = pService.saveConUtenteAndPostazione(giornoPrenotazione, utenteId, postazioneId);
//		return newPrenotazione;
//	}
		
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Prenotazione saveConTuttiControlli(@RequestBody PrenotazionePayload pl) throws Exception {
		LocalDate giornoPrenotazione = pl.getGiornoPrenotazione();
		int utenteId = pl.getUtenteId();
		int postazioneId = pl.getPostazioneId();

		Prenotazione newPrenotazione = pService.saveConUtenteAndPostazioneAndDataMax(giornoPrenotazione, utenteId, postazioneId);
		return newPrenotazione;
	}
	
	@GetMapping("")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Prenotazione> getPrenotazioni() {
		return pService.getPrenotazioni();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public Prenotazione getPrenotazioneById(@PathVariable int id) throws Exception {
		return pService.findById(id).orElseThrow(() -> new Exception("Postazione non trovata!"));

	}
}
