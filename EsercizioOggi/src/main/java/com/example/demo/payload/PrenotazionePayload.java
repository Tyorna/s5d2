package com.example.demo.payload;

import java.time.LocalDate;

import com.example.demo.entities.Postazione;
import com.example.demo.entities.Utente;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PrenotazionePayload {
	private LocalDate dataPrenotazione;
	private Utente utente;
	private Postazione postazione;
}
