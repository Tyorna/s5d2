package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Postazione;
import com.example.demo.entities.TipoPost;
import com.example.demo.entities.Utente;

@Service
public class PostazioneService {
	private List<Postazione> postazioni = new ArrayList<>();

	public Postazione save(Postazione postazione) {
		Random rndm = new Random();
		postazione.setIdPostazione(rndm.nextLong());
		this.postazioni.add(postazione);
		return postazione;
	}

	public List<Postazione> getPostazione() {
		return this.postazioni;
	}
	
	public Optional<Postazione> findById(int id) {
		Postazione u = null;

		for (Postazione postazione : postazioni) {
			if (postazione.getIdPostazione() == id)
				u = postazione;
		}

		return Optional.ofNullable(u);
	}
	
	public List<Postazione> getPostazioneByTipoAndCitta(TipoPost tipoPost, String citta) {
		List<Postazione> postazioneTrovata = postazioni.stream()
				.filter(postazione -> postazione.getTipo() == tipoPost
						&& postazione.getEdificio().getCitta().equalsIgnoreCase(citta))
				.collect(Collectors.toList());
		if (!postazioneTrovata.isEmpty()) {
			return postazioneTrovata;
		} else {
			return null;
		}
	}
	
	public Optional<Postazione> updatePostazione(int id, Postazione postazione) {
		Postazione p = null;
		for (Postazione updatePostazione : postazioni) {
			if (updatePostazione.getIdPostazione() == id) {
				p = updatePostazione;
				p.setIdPostazione(id);
				p.setDescrizione(postazione.getDescrizione());
				p.setTipo(postazione.getTipo());
				p.setMaxOccupanti(postazione.getMaxOccupanti());
				p.setEdificio(postazione.getEdificio());
			}
		}

		return Optional.ofNullable(p);
	}

	public void deletePostazione(int id) {
		ListIterator<Postazione> iterator = this.postazioni.listIterator();
		while (iterator.hasNext()) {
			Postazione currentPostazione = iterator.next();
			if (currentPostazione.getIdPostazione() == id) {
				iterator.remove();
			}
		}
	}
}
