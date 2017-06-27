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

	
	// nadji firmu pod zeljenim id-em
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FakturaDTO> getFaktura(@PathVariable Long id) {
		FakturaDTO faktura = fakturaService.findOne(id);

		return new ResponseEntity<FakturaDTO>(faktura, HttpStatus.OK);
	}

	
	// izlistaj sve fakture PRIMLJENE, jer se za primljenu fakturu kreira nalog
	//localhost:8080/api/faktura/prikaz/1
	@RequestMapping(value="/prikaz/{idFirme}",method = RequestMethod.GET)
	public ResponseEntity<List<FakturaDTO>> getFakture(@PathVariable Long idFirme) {
		Firma firma = firmaService.findOne(idFirme);
		List<FakturaDTO> fakture = fakturaService.findByFirma(firma);
		return new ResponseEntity<List<FakturaDTO>>(fakture, HttpStatus.OK);
	}

	
	// unos stavke u fakturu
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

		Firma dobavljac = firmaService.findOne(firmaA);
		Firma kupac = firmaService.findOne(firmaB);

		faktura.setStatus(FakturaStatus.POSLATO);
		faktura.setNazivDobavljaca(dobavljac.getNaziv());
		faktura.setAdresaDobavljaca(dobavljac.getAdresa());
		faktura.setPibDobavljaca(dobavljac.getPib());
		String brojRacunaS = dobavljac.getBrojRacuna();
		faktura.setUplataNaRacun(brojRacunaS);

		faktura.setNazivKupca(kupac.getNaziv());
		faktura.setAdresaKupca(kupac.getAdresa());
		faktura.setPibKupca(kupac.getPib());
		faktura.setBrojRacuna(kupac.getBrojRacuna());

		RestTemplate restTemplate = new RestTemplate();
		Firma firmaUpdate = firmaService.saveFaktura(firmaA, faktura);

		String firmaBS = String.valueOf(firmaB);
		restTemplate.postForObject("http://localhost:8080/api/firma/" + firmaBS + "/faktura", faktura,
				FakturaDTO.class);

		return new ResponseEntity<Firma>(firmaUpdate, HttpStatus.OK);

	}


}
