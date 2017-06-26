package com.firma.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firma.models.domain.FakturaDTO;
import com.firma.models.domain.NalogZaPrenosDTO;
import com.firma.models.nalogzaprenos.NalogZaPrenos;
import com.firma.repository.NalogZaPrenosDTORepository;
import com.firma.services.NalogZaPrenosDTOService;

@Service
@Transactional
public class NalogZaPrenosDTOImpl implements NalogZaPrenosDTOService {

	@Autowired
	private NalogZaPrenosDTORepository repository;

	@Override
	public NalogZaPrenosDTO findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public NalogZaPrenosDTO save(NalogZaPrenosDTO nalogZaPrenos) {
		return repository.save(nalogZaPrenos);
	}

	@Override
	public List<NalogZaPrenosDTO> find() {
		return repository.findAll();
	}

	@Override
	public NalogZaPrenos kreirajNalog(FakturaDTO faktura) {
		
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
		NalogZaPrenosDTO nalog = this.save(nalogzaprenos);

		NalogZaPrenos n = new NalogZaPrenos();
		List<String> list = new ArrayList<String>();
		list.add("dozer-bean-mappings.xml");
		Mapper mapper = new DozerBeanMapper(list);
		mapper.map(nalog, n, "person");
		
		return n;
	}

}
