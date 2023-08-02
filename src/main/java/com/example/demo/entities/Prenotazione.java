package com.example.demo.entities;

import java.time.LocalDate;

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
public class Prenotazione {
	private long id;
	private LocalDate dataPrenotazione;
	private Utente utente;
	private Postazione postazione;
	
	public Prenotazione(LocalDate dataPrenotazione, Utente utente, Postazione postazione ) {
		this.dataPrenotazione =  dataPrenotazione;
		this.utente = utente;
		this.postazione = postazione;
	}

	@Override
	public String toString() {
		return "Prenotazione [data della prenotazionee=" + dataPrenotazione + ", id=" + id + ", utente=" + utente
				+ ", numero postazione=" + postazione + "]" + "\n";
	}
}
