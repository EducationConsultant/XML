package com.banka.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.banka.models.domain.Banka;
import com.banka.services.BankaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/app/banka")
@ComponentScan("com.banka.services")
public class BankaController {

	@Autowired
	private BankaService bankaService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Banka> getBanka(@PathVariable Long id) {
		Banka banka = bankaService.findOne(id);

		return new ResponseEntity<Banka>(banka, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Banka> insertBanka(@RequestBody Banka banka) {

		Banka savedBanka = bankaService.save(banka);
		return new ResponseEntity<Banka>(savedBanka, HttpStatus.CREATED);

	}

}
