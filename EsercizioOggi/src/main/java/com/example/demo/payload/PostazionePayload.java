package com.example.demo.payload;

import com.example.demo.entities.TipoPost;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostazionePayload {
	private String descrizione;
	private TipoPost tipo;
	private int maxOccupanti;
}
