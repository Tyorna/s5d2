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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Postazione;
import com.example.demo.entities.TipoPost;
import com.example.demo.services.PostazioneService;

@RestController
@RequestMapping("/postazioni")
public class PostazioneController {
	@Autowired
	private PostazioneService pService;

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Postazione save(@RequestBody Postazione postazione) {
		Postazione newPostazione = pService.save(postazione);
		return newPostazione;
	}

	@GetMapping("")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Postazione> getPostazioni() {
		return pService.getPostazione();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public Postazione getPostazioneById(@PathVariable int id) throws Exception {
		return pService.findById(id).orElseThrow(() -> new Exception("Postazione non trovata!"));

	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePostazioneById(@PathVariable int id) {
		pService.deletePostazione(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Postazione updatePostazioneById(@PathVariable int id, @RequestBody Postazione postazione) throws Exception {
		return pService.updatePostazione(id, postazione).orElseThrow(() -> new Exception("Postazione non trovato"));
	}
	
	@GetMapping("/search")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Postazione> postazioniCercate(@RequestParam TipoPost tipoPost,
			@RequestParam String citta) {
		return pService.getPostazioneByTipoAndCitta(tipoPost, citta);
	}
}
