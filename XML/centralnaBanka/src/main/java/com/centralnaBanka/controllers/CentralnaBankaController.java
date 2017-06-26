package com.centralnaBanka.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.centralnaBanka.models.domain.Banka;
import com.centralnaBanka.models.domain.CentralnaBanka;
import com.centralnaBanka.services.BankaService;
import com.centralnaBanka.services.CentralnaBankaService;


@RestController
@RequestMapping("/api/centralnabanka")
@ComponentScan("com.centralnaBanka.services")
public class CentralnaBankaController {

	@Autowired
	private BankaService bankaService;
	
	@Autowired
	private CentralnaBankaService cbService;

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CentralnaBanka>> getCB() {
		List<CentralnaBanka> cbanke = cbService.find();
		return new ResponseEntity<List<CentralnaBanka>>(cbanke, HttpStatus.OK);

	}
	
	@RequestMapping(value="/{idC}", method = RequestMethod.GET)
	public ResponseEntity<List<Banka>> getBanke(@PathVariable Long idC) {
		List<Banka> banke = cbService.findBanke(idC);
		return new ResponseEntity<List<Banka>>(banke, HttpStatus.OK);

	}
	
	
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<CentralnaBanka> insertCentralnaBanka(@RequestBody CentralnaBanka cb) {
		CentralnaBanka savedBanka = cbService.save(cb);
		return new ResponseEntity<CentralnaBanka>(savedBanka, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{idC}", method = RequestMethod.POST)
	public ResponseEntity<Banka> insertBanka(@PathVariable Long idC, @RequestBody Banka banka) {
		Banka savedBanka = bankaService.save(idC, banka);
		return new ResponseEntity<Banka>(savedBanka, HttpStatus.CREATED);
	}
}
