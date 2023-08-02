package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "postazioni")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Postazione {
	@Id
	@GeneratedValue
	private long idPostazione;
	private String descrizione;
	@Enumerated(EnumType.STRING)
	private TipoPost tipo;
	private int maxOccupanti;
	
	@ManyToOne
	@JoinColumn(name = "edificio", referencedColumnName = "id")
	private Edificio edificio;
	
	@OneToOne
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
