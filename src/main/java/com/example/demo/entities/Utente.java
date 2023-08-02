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
public class Utente {
	private long id;
	private String UserName;
	private String nomeCompleto;
	private String email;
	private Set<Prenotazione> prenotazione;
	
	public Utente(String UserName, String nomeCompleto, String email) {
		this.UserName = UserName;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Utente [nome utente=" + nomeCompleto + ", id=" + id + ", email=" + email
				+ ", numero prenotazione=" + prenotazione + "]" + "\n";
	}
}
