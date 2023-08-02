package com.example.demo.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PrenotazionePayload {
	private LocalDate giornoPrenotazione;
	private int utenteId;
	private int postazioneId;
}