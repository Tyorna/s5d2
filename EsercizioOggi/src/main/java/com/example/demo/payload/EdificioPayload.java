package com.example.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EdificioPayload {
	private String nome;
	private String indirizzo;
	private String citta;
}
