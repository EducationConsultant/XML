package com.firma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.firma.models.domain.FakturaDTO;
import com.firma.models.domain.FakturaStatus;
import com.firma.models.domain.Firma;
import com.firma.models.domain.StavkaDTO;
import com.firma.services.FakturaService;
import com.firma.services.FirmaService;

@RestController
@RequestMapping("/api/faktura")
public class FakturaController {

	@Autowired
	private FakturaService fakturaService;

	@Autowired
	private FirmaService firmaService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FakturaDTO> getFaktura(@PathVariable Long id) {
		FakturaDTO faktura = fakturaService.findOne(id);

		return new ResponseEntity<FakturaDTO>(faktura, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<FakturaDTO>> getFakture() {
		List<FakturaDTO> fakture = fakturaService.find();

		return new ResponseEntity<List<FakturaDTO>>(fakture, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<FakturaDTO> insertFaktura(@RequestBody FakturaDTO faktura) {

		FakturaDTO savedFaktura = fakturaService.save(faktura);
		return new ResponseEntity<FakturaDTO>(savedFaktura, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<FakturaDTO> insertStavka(@PathVariable Long id, @RequestBody StavkaDTO stavka) {

		FakturaDTO fakturaToUpdate = fakturaService.saveStavka(id, stavka);

		return new ResponseEntity<FakturaDTO>(fakturaToUpdate, HttpStatus.CREATED);

	}

	// firmaA - id firme koja salje fakturu
	// firmaB - id firme kojoj se salje faktura
	@RequestMapping(value = "/{firmaA}/{firmaB}", method = RequestMethod.POST)
	public ResponseEntity<Firma> slanjeFakture(@PathVariable Long firmaA, @PathVariable Long firmaB,
			@RequestBody FakturaDTO faktura) {

		RestTemplate restTemplate = new RestTemplate();
		// sacuvace
		faktura.setStatus(FakturaStatus.POSLATO);
		Firma firma = firmaService.saveFaktura(firmaA, faktura); // fakuru

		String firmaBS = String.valueOf(firmaB);

		restTemplate.postForObject("http://localhost:8080/api/firma/" + firmaBS + "/faktura", faktura,
				FakturaDTO.class);

		return new ResponseEntity<Firma>(firma, HttpStatus.OK);

	}

	// TODO Model firme. Rest endpoit za dodavanje firmi
	// Slanje fakture. Controller sa enpointom. primer
	// api/{firmaA}/faktura/{firmaB} -, id firme

}
