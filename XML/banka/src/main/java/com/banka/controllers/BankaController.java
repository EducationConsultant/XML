package com.banka.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.banka.models.domain.Banka;
import com.banka.models.domain.Firma;
import com.banka.services.BankaService;
import com.banka.services.FirmaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api/banka")
@ComponentScan("com.banka.services")
public class BankaController {

	@Autowired
	private BankaService bankaService;

	@Autowired
	private FirmaService firmaService;
	
	// izlistaj sve banke
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Banka>> getBanke() {
		List<Banka> banke = bankaService.find();
		return new ResponseEntity<List<Banka>>(banke, HttpStatus.OK);
	}

	
	
	// nadji banku pod zeljenim id-em
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Banka> getBanka(@PathVariable Long id) {
		Banka banka = bankaService.findOne(id);

		return new ResponseEntity<Banka>(banka, HttpStatus.OK);
	}

	
	// unosi banku
	// OVO POZIVA SAMO CENTRALNA BANKA- AUTOMATSKI!!!
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Banka> insertBanka(@RequestBody Banka banka) {

		Banka savedBanka = bankaService.save(banka);
		return new ResponseEntity<Banka>(savedBanka, HttpStatus.CREATED);

	}
	
	// povezuje firmu sa bankom
	// OVO SE POZIVA IZ FIRME - AUTOMATSKI!!!
	@RequestMapping(value="/{nazivBanke}", method = RequestMethod.POST)
	public ResponseEntity<Banka> ubaciFirmu(@PathVariable String nazivBanke, @RequestBody Firma firma) {
		firmaService.save(firma);
		Banka banka = bankaService.findByNaziv(nazivBanke);
		bankaService.save(banka);
		banka.getFirme().add(firma);
		Banka savedBanka = bankaService.save(banka);

		return new ResponseEntity<Banka>(savedBanka, HttpStatus.CREATED);
	}

}
