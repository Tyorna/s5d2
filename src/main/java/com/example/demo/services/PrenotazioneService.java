package com.example.demo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Postazione;
import com.example.demo.entities.Prenotazione;
import com.example.demo.entities.TipoPost;
import com.example.demo.entities.Utente;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PrenotazioneService {
	private List<Prenotazione> prenotazioni = new ArrayList<>();

	@Autowired
	private UtenteService uService;

	@Autowired
	private PostazioneService pService;
	
	public Prenotazione save(Prenotazione prenotazione) {
		Random rndm = new Random();
		prenotazione.setId(rndm.nextLong());
		this.prenotazioni.add(prenotazione);
		return prenotazione;
	}
	
	public boolean utentePrenotazioni(int utenteId, LocalDate dataPrenotazione) {
		boolean cerca = prenotazioni.stream().filter(prenotazione -> prenotazione.getUtente().getId() == utenteId)
				.noneMatch(prenotazione -> prenotazione.getDataPrenotazione().equals(dataPrenotazione));
		log.info("Prenotazione per l'utente: " + cerca);
		return cerca;
	}
	
	public boolean postazionePrenotazioni(int postazioneId, LocalDate dataPrenotazione) {
		boolean cerca = prenotazioni.stream()
				.filter(prenotazione -> prenotazione.getPostazione().getIdPostazione() == postazioneId)
				.noneMatch(prenotazione -> prenotazione.getDataPrenotazione().equals(dataPrenotazione));
		log.info("postazione disponibile: " + cerca);
		return cerca;
	}
	
//	public Prenotazione saveConUtenteAndPostazione(LocalDate dataPrenotazione, int utenteId, int postazioneId) throws Exception {
//		Random rnd = new Random();
//		Utente utenteCercato = uService.findById(utenteId).orElseThrow(() -> new Exception("Utente non trovato"));
//		Postazione postazioneCercata = pService.findById(postazioneId)
//				.orElseThrow(() -> new Exception("Postazione non trovata"));
//		if (utentePrenotazioni(utenteId, dataPrenotazione) && postazionePrenotazioni(postazioneId, dataPrenotazione)) {
//			Prenotazione newPrenotazione = new Prenotazione();
//			newPrenotazione.setId(rnd.nextInt());
//			newPrenotazione.setDataPrenotazione(dataPrenotazione);
//			newPrenotazione.setUtente(utenteCercato);
//			newPrenotazione.setPostazione(postazioneCercata);
//			this.prenotazioni.add(newPrenotazione);
//			return newPrenotazione;
//		} else {
//			return null;
//		}
//	}
	
	public boolean dataMassima(LocalDate dataPrenotazione) {
		boolean cerca = LocalDate.now().isBefore(dataPrenotazione.minusDays(2));
		log.info("Data massima: " + cerca);
		return cerca;
	}
	
	public Prenotazione saveConUtenteAndPostazioneAndDataMax(LocalDate dataPrenotazione, int utenteId, int postazioneId) throws Exception {
		Random rnd = new Random();
		Utente utenteCercato = uService.findById(utenteId).orElseThrow(() -> new Exception("Utente non trovato"));
		Postazione postazioneCercata = pService.findById(postazioneId)
				.orElseThrow(() -> new Exception("Postazione non trovata"));
		if (utentePrenotazioni(utenteId, dataPrenotazione) && postazionePrenotazioni(postazioneId, dataPrenotazione) && dataMassima(dataPrenotazione)) {
			Prenotazione newPrenotazione = new Prenotazione();
			newPrenotazione.setId(rnd.nextInt());
			newPrenotazione.setDataPrenotazione(dataPrenotazione);
			newPrenotazione.setUtente(utenteCercato);
			newPrenotazione.setPostazione(postazioneCercata);
			this.prenotazioni.add(newPrenotazione);
			return newPrenotazione;
		} else {
			return null;
		}
	}

	public List<Prenotazione> getPrenotazioni() {
		return this.prenotazioni;
	}
	
	public Optional<Prenotazione> findById(int id) {
		Prenotazione u = null;

		for (Prenotazione prenotazione : prenotazioni) {
			if (prenotazione.getId() == id)
				u = prenotazione;
		}

		return Optional.ofNullable(u);
	}
}
