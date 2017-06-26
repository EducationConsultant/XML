package com.firma.controllers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.firma.models.domain.FakturaDTO;
import com.firma.models.domain.FakturaStatus;
import com.firma.models.domain.Firma;
import com.firma.models.domain.NalogZaPrenosDTO;
import com.firma.models.nalogzaprenos.NalogZaPrenos;
import com.firma.services.FirmaService;
import com.firma.services.NalogZaPrenosDTOService;

@RestController
@RequestMapping("/api/firma")
public class FirmaController {

	@Autowired
	private FirmaService firmaService;

	@Autowired
	private NalogZaPrenosDTOService nalogService;

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

	@RequestMapping(value = "/{firmaBS}/faktura", method = RequestMethod.POST)
	public void prijemFakutre(@PathVariable String firmaBS, @RequestBody FakturaDTO faktura) {
		Long firmaB = Long.parseLong(firmaBS);

		Firma f = firmaService.findOne(firmaB);

		// Ovde ce konkretna firma da primi fakturu i da je sacuva
		faktura.setStatus(FakturaStatus.PRIMLJENO);
		firmaService.saveFaktura(firmaB, faktura);

		NalogZaPrenosDTO nalogzaprenos = new NalogZaPrenosDTO();
		nalogzaprenos.setDatumNaloga(faktura.getDatumRacuna());
		nalogzaprenos.setDatumValute(faktura.getDatumValute());
		nalogzaprenos.setIznos(faktura.getIznosZaUplatu());
		nalogzaprenos.setOznakaValute(faktura.getOznakaValute());
		nalogzaprenos.setRacunDuznika("123654789987456321");
		nalogzaprenos.setRacunPoverioca(faktura.getUplataNaRacun());
		nalogzaprenos.setDuznikNalogodavac(faktura.getNazivKupca());
		nalogzaprenos.setPrimalacPoverilac(faktura.getNazivDobavljaca());
		nalogzaprenos.setSvrhaPlacanja("racun za februar");
		nalogzaprenos.setModelOdobrenja(97);
		nalogzaprenos.setModelZaduzenja(97);
		nalogzaprenos.setPozivNaBrojOdobrenja("12456");
		nalogzaprenos.setPozivNaBrojZaduzenja("7895");
		nalogzaprenos.setHitno(false);
		NalogZaPrenosDTO nalog = nalogService.save(nalogzaprenos);

		NalogZaPrenos n = new NalogZaPrenos();
		
		String endpoint = "http://localhost:8080/services/nalogzaprenos";
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

		marshaller.setContextPath("com.firma.models.nalogzaprenos");

		List<String> list = new ArrayList<String>();
		// Add the mapping configuration
		list.add("dozer-bean-mappings.xml");
		// Add to DozerMapper
		Mapper mapper = new DozerBeanMapper(list);
		mapper.map(nalog, n, "person");
		System.err.println("after mapping with dozer: p1Dto = " + n);

		webServiceTemplate.setMarshaller(marshaller);
		webServiceTemplate.setUnmarshaller(marshaller);
		webServiceTemplate.afterPropertiesSet();

		webServiceTemplate.setDefaultUri(endpoint);
	    webServiceTemplate.marshalSendAndReceive(endpoint,n);
		

	}

}
