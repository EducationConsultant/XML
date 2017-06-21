package com.firma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firma.models.faktura.FakturaClass;
import com.firma.models.faktura.FakturaClass.StavkaClass;
import com.firma.services.FakturaService;

@RestController
@RequestMapping("/api/faktura")
public class FakturaController {

	@Autowired
	private FakturaService fakturaService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FakturaClass> getFaktura(@PathVariable Long id) {
		FakturaClass faktura = fakturaService.findOne(id);

		return new ResponseEntity<FakturaClass>(faktura, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<FakturaClass> insertFaktura(@RequestBody FakturaClass faktura) {

		FakturaClass savedFaktura = fakturaService.save(faktura);
		return new ResponseEntity<FakturaClass>(savedFaktura, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<FakturaClass> insertStavka(@PathVariable Long id, @RequestBody StavkaClass stavka) {

		FakturaClass fakturaToUpdate = fakturaService.saveStavka(id, stavka);

		return new ResponseEntity<FakturaClass>(fakturaToUpdate, HttpStatus.CREATED);

	}

	// TODO Model firme. Rest endpoit za dodavanje firmi
	// Slanje fakture. Controller sa enpointom. primer
	// api/{firmaA}/faktura/{firmaB} -, id firme

}
