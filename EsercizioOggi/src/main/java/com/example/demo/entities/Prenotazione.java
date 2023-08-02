package com.example.demo.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
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
@Table(name = "prenotazione")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prenotazione {
	@Id
	@GeneratedValue
	private long id;
	private LocalDate dataPrenotazione;
	
	@ManyToOne
	@JoinColumn(name = "utente", referencedColumnName = "id")
	private Utente utente;
	
	@OneToOne(mappedBy ="prenotazione")
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
