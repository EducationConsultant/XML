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
import com.firma.models.domain.NalogZaPrenosDTO;
import com.firma.models.faktura.Faktura;
import com.firma.models.nalogzaprenos.NalogZaPrenos;
import com.firma.services.FakturaService;
import com.firma.services.FirmaService;
import com.firma.services.NalogZaPrenosDTOService;

@RestController
@RequestMapping("/api/nalogzaprenos")
public class NalogZaPrenosDTOController {

	@Autowired
	private FirmaService firmaService;
	
	@Autowired
	private NalogZaPrenosDTOService nalogService;
	
	@Autowired 
	private FakturaService fakturaService;

	@RequestMapping(value = "/{idFakture}", method = RequestMethod.POST)
	public void insertNalogZaPrenos(@PathVariable Long idFakture, @RequestBody NalogZaPrenosDTO nalogZaPrenos) {

		FakturaDTO faktura = fakturaService.findOne(idFakture);
		
		//slanje naloga
		NalogZaPrenos n = nalogService.kreirajNalog(faktura, nalogZaPrenos);
		firmaService.posaljiNalog(n);
		

	}
}
