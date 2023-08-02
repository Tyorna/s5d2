package com.example.demo.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Utente {
	@Id
	@GeneratedValue
	private long id;
	private String nomeCompleto;
	private String email;
	
	@OneToMany(mappedBy = "utente")
	private Set<Prenotazione> prenotazione;
	
	public Utente(String nomeCompleto, String email) {
		this.nomeCompleto = nomeCompleto;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Utente [nome utente=" + nomeCompleto + ", id=" + id + ", email=" + email
				+ ", numero prenotazione=" + prenotazione + "]" + "\n";
	}
}
