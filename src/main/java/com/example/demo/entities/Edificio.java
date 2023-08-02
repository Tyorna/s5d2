package com.example.demo.entities;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Edificio {
	private int id;
	private String nome;
	private String indirizzo;
	private String citta;
	private Set<Postazione> postazione;
	
	public Edificio(String nome, String indirizzo, String citta) {
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}

	@Override
	public String toString() {
		return "Edificio [nome=" + nome + ", id=" + id + ", indirizzo=" + indirizzo + ", citta=" + citta
				+ ", postazione=" + postazione + "]" + "\n";
	}
}


