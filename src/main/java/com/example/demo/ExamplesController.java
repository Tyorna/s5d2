package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info") 
public class ExamplesController {

	@GetMapping("/italiano")
	public String italiano() {
		return "Puoi prenotare più postazioni ma mai due nello stesso giorno. Nel caso la"
				+ " postazione fosse gia prenotata non ti farà eseguire la prenotazione";
	}

	@GetMapping("/inglese")
	public String inglese() {
		return "You can book multiple seats but never two on the same day. If the station is already booked, "
				+ "it will not allow you to make the booking";
	}

	@GetMapping("/lingua")
	public String queryParams(@RequestParam(required =false) String lingua) {
		if (lingua != null){
			if (lingua.contentEquals("italiano")) {
			return "Puoi prenotare più postazioni ma mai due nello stesso giorno. Nel caso la"
					+ " postazione fosse gia prenotata non ti farà eseguire la prenotazione";
		} else if (lingua.contentEquals("english")){
			return "You can book multiple seats but never two on the same day. If the station is already booked, "
					+ "it will not allow you to make the booking";
		} else {
			return "Errore, lingua impostata sbagliata";
		}} else {
			return "Errore devi inserire una lingua";
		}
	}
}
