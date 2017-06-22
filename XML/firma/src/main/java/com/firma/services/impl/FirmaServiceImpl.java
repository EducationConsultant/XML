package com.firma.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firma.models.domain.FakturaDTO;
import com.firma.models.domain.Firma;
import com.firma.repository.FakturaRepository;
import com.firma.repository.FirmaRepository;
import com.firma.services.FirmaService;

@Service
@Transactional
public class FirmaServiceImpl implements FirmaService {

	@Autowired
	private FirmaRepository firmaRepository;

	@Autowired
	private FakturaRepository fakturaRepository;

	List<FakturaDTO> fakture = new ArrayList<FakturaDTO>();

	@Override
	public Firma findOne(Long id) {
		return firmaRepository.findOne(id);
	}

	@Override
	public Firma save(Firma firma) {
		return firmaRepository.save(firma);
	}

	@Override
	public Firma findByNaziv(String naziv) {
		return firmaRepository.findByNaziv(naziv);
	}

	@Override
	public List<Firma> find() {
		return firmaRepository.findAll();
	}

	@Override
	public Firma saveFaktura(Long id, FakturaDTO faktura) {
		Firma firma = firmaRepository.findOne(id);

		faktura.setFirma(firma);
		faktura.setVrednostRobe(new BigDecimal(0));
		faktura.setVrednostUsluga(new BigDecimal(0));
		faktura.setUkupnoRobaIUsluge(new BigDecimal(0));
		faktura.setUkupanRabat(new BigDecimal(0));
		faktura.setUkupanPorez(new BigDecimal(0));
		faktura.setIznosZaUplatu(new BigDecimal(0));

		FakturaDTO savedFaktura = new FakturaDTO();
		savedFaktura.setAdresaDobavljaca(faktura.getAdresaDobavljaca());
		savedFaktura.setAdresaKupca(faktura.getAdresaKupca());
		savedFaktura.setBrojRacuna(faktura.getBrojRacuna());
		savedFaktura.setDatumRacuna(faktura.getDatumRacuna());
		savedFaktura.setDatumValute(faktura.getDatumValute());
		savedFaktura.setFirma(faktura.getFirma());
		savedFaktura.setIdPoruke(faktura.getIdPoruke());
		savedFaktura.setIznosZaUplatu(faktura.getIznosZaUplatu());
		savedFaktura.setNazivDobavljaca(faktura.getNazivDobavljaca());
		savedFaktura.setNazivKupca(faktura.getNazivKupca());
		savedFaktura.setOznakaValute(faktura.getOznakaValute());
		savedFaktura.setPibDobavljaca(faktura.getPibDobavljaca());
		savedFaktura.setPibKupca(faktura.getPibKupca());
		savedFaktura.setStavka(faktura.getStavka());
		savedFaktura.setUkupanPorez(faktura.getUkupanPorez());
		savedFaktura.setUkupanRabat(faktura.getUkupanRabat());
		savedFaktura.setUkupnoRobaIUsluge(faktura.getUkupnoRobaIUsluge());
		savedFaktura.setUplataNaRacun(faktura.getUplataNaRacun());
		savedFaktura.setVrednostRobe(faktura.getVrednostRobe());
		savedFaktura.setVrednostUsluga(faktura.getVrednostUsluga());
		savedFaktura.setStatus(faktura.getStatus());

		fakturaRepository.save(savedFaktura);

		List<FakturaDTO> firmineFakture = firma.getFakture();
		if (firmineFakture == null) {
			firmineFakture = new ArrayList<>();
		}
		firmineFakture.add(savedFaktura);

		firma.setFakture(firmineFakture);

		return firma;
	}

}
