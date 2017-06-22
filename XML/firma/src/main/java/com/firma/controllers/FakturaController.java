package com.firma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firma.models.domain.FakturaDTO;
import com.firma.models.domain.FakturaDTO.StavkaClass;
import com.firma.services.FakturaService;

@RestController
@RequestMapping("/api/faktura")
public class FakturaController {

	@Autowired
	private FakturaService fakturaService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FakturaDTO> getFaktura(@PathVariable Long id) {
		FakturaDTO faktura = fakturaService.findOne(id);

		return new ResponseEntity<FakturaDTO>(faktura, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<FakturaDTO> insertFaktura(@RequestBody FakturaDTO faktura) {

		FakturaDTO savedFaktura = fakturaService.save(faktura);
		return new ResponseEntity<FakturaDTO>(savedFaktura, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<FakturaDTO> insertStavka(@PathVariable Long id, @RequestBody StavkaClass stavka) {

		FakturaDTO fakturaToUpdate = fakturaService.saveStavka(id, stavka);

		return new ResponseEntity<FakturaDTO>(fakturaToUpdate, HttpStatus.CREATED);

	}

	// TODO Model firme. Rest endpoit za dodavanje firmi
	// Slanje fakture. Controller sa enpointom. primer
	// api/{firmaA}/faktura/{firmaB} -, id firme

}
