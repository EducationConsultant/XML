package com.banka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banka.models.domain.NalogZaPrenosDTO;
import com.banka.services.NalogZaPrenosDTOService;

@RestController
@RequestMapping("/api/nalogzaprenos")
public class NalogZaPrenosDTOController {

	@Autowired
	private NalogZaPrenosDTOService nalogZaPrenosService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<NalogZaPrenosDTO> insertNalogZaPrenos(@RequestBody NalogZaPrenosDTO nalogZaPrenos) {

		NalogZaPrenosDTO savedNalogZaPrenos = nalogZaPrenosService.save(nalogZaPrenos);
		return new ResponseEntity<NalogZaPrenosDTO>(savedNalogZaPrenos, HttpStatus.CREATED);

	}
}
