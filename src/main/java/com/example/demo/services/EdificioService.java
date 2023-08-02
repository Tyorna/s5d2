package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.demo.entities.Edificio;

public class EdificioService {
	private List<Edificio> edifici = new ArrayList<>();

	public Edificio save(Edificio edificio) {
		Random rndm = new Random();
		edificio.setId(rndm.nextInt());
		this.edifici.add(edificio);
		return edificio;
	}

	public List<Edificio> getUtenti() {
		return this.edifici;
	}
}
