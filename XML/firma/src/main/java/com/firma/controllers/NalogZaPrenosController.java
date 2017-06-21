package com.firma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firma.models.entities.Firma;
import com.firma.models.nalogzaprenos.NalogZaPrenos;
import com.firma.models.nalogzaprenos.NalogZaPrenosIzvedeno;
import com.firma.services.NalogZaPrenosService;

@RestController
@RequestMapping("/api/nalogzaprenos")
public class NalogZaPrenosController {

	@Autowired
	private NalogZaPrenosService nalogZaPrenosService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<NalogZaPrenosIzvedeno> insertNalogZaPrenos(@RequestBody NalogZaPrenosIzvedeno nalogZaPrenos) {

		NalogZaPrenosIzvedeno savedNalogZaPrenos = nalogZaPrenosService.save(nalogZaPrenos);
		return new ResponseEntity<NalogZaPrenosIzvedeno>(savedNalogZaPrenos, HttpStatus.CREATED);

	}
}
