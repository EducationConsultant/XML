package com.firma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firma.models.domain.FakturaDTO;
import com.firma.models.domain.Firma;
import com.firma.models.domain.StavkaDTO;
import com.firma.services.FirmaService;


@RestController
@RequestMapping("/api/firma")
public class FirmaController {

	@Autowired
	private FirmaService firmaService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Firma>> getFirme() {
		List<Firma> firme = firmaService.find();

		return new ResponseEntity<List<Firma>>(firme, HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Firma> getFirma(@PathVariable Long id) {

		Firma firma = firmaService.findOne(id);

		return new ResponseEntity<Firma>(firma, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Firma> insertFirma(@RequestBody Firma firma) {

		Firma savedFirma = firmaService.save(firma);
		return new ResponseEntity<Firma>(savedFirma, HttpStatus.CREATED);

	}
	
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
//	public ResponseEntity<Firma> insertFaktura(@PathVariable Long id, @RequestBody FakturaDTO faktura) {
//
//		Firma firmaToUpdate = firmaService.saveFaktura(id, faktura);
//
//		return new ResponseEntity<Firma>(firmaToUpdate, HttpStatus.CREATED);
//
//	}
	
	
	
	@RequestMapping(value = "/{id1}/{id2}", method = RequestMethod.POST)
	public ResponseEntity<Firma> sendFaktura(@PathVariable Long id1,@PathVariable Long id2, @RequestBody FakturaDTO faktura) {

		Firma firmaToUpdate = firmaService.sendFaktura(id1, id2, faktura);

		return new ResponseEntity<Firma>(firmaToUpdate, HttpStatus.CREATED);

	}
	

	
	


}
