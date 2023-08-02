package com.example.demo.entities;

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
public class Postazione {
	private long idPostazione;
	private String descrizione;
	private TipoPost tipo;
	private int maxOccupanti;
	private Edificio edificio;
	private Prenotazione prenotazione;
	
	public Postazione(String descrizione, TipoPost tipo, int maxOccupanti, Edificio edificio) {
		this.descrizione =  descrizione;
		this.tipo = tipo;
		this.maxOccupanti = maxOccupanti;
		this.edificio = edificio;
	}

	@Override
	public String toString() {
		return "Postazione [id della Postazione=" + idPostazione + ", descrizione=" + descrizione + ", tipo=" + tipo
				+ ", numero massimo di persone=" + maxOccupanti + ", edificio=" + edificio + ", prenotazione=" + prenotazione + "]";
	}
	
}
