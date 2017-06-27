package com.firma.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firma.models.domain.FakturaDTO;
import com.firma.models.domain.FakturaStatus;
import com.firma.models.domain.Firma;
import com.firma.models.domain.StavkaDTO;
import com.firma.models.faktura.Faktura;
import com.firma.repository.FakturaRepository;
import com.firma.repository.StavkaFaktureRepository;
import com.firma.services.FakturaService;

@Service
@Transactional
public class FakturaServiceImpl implements FakturaService {

	@Autowired
	private FakturaRepository fakturaRepository;

	@Autowired
	private StavkaFaktureRepository stavkaFaktureRepository;

	@Override
	public FakturaDTO save(FakturaDTO faktura) {
		faktura.setVrednostRobe(new BigDecimal(0));
		faktura.setVrednostUsluga(new BigDecimal(0));
		faktura.setUkupnoRobaIUsluge(new BigDecimal(0));
		faktura.setUkupanRabat(new BigDecimal(0));
		faktura.setUkupanPorez(new BigDecimal(0));
		faktura.setIznosZaUplatu(new BigDecimal(0));

		return fakturaRepository.save(faktura);
	}

	@Override
	public List<FakturaDTO> find() {
		return fakturaRepository.findAll();
	}

	@Override
	public FakturaDTO findOne(Long id) {
		return fakturaRepository.findOne(id);
	}

	@Override
	public FakturaDTO saveStavka(Long id, StavkaDTO stavka) {

		FakturaDTO faktura = this.findOne(id);

		BigDecimal vrednostStavke = stavka.getJedinicnaCena().multiply(stavka.getKolicina());
		stavka.setVrednost(vrednostStavke);

		BigDecimal iznosRabata = stavka.getVrednost().multiply(stavka.getProcenatRabata().divide(new BigDecimal(200)));
		stavka.setIznosRabata(iznosRabata);

		BigDecimal umanjenoZaRabat = stavka.getVrednost().subtract(stavka.getIznosRabata());
		stavka.setUmanjenoZaRabat(umanjenoZaRabat);

		List<StavkaDTO> stavkeFaktura = faktura.getStavka();
		stavkaFaktureRepository.save(stavka);
		stavkeFaktura.add(stavka);

		for (StavkaDTO s : stavkeFaktura) {
			BigDecimal vrednostRobeF = faktura.getVrednostRobe().add(s.getVrednost());
			faktura.setVrednostRobe(vrednostRobeF);

			BigDecimal vrednostUslugaF = faktura.getVrednostUsluga().add(s.getVrednost());
			faktura.setVrednostUsluga(vrednostUslugaF);

			BigDecimal ukupnoRobaIUslugaF = faktura.getUkupnoRobaIUsluge().add(s.getKolicina());
			faktura.setUkupnoRobaIUsluge(ukupnoRobaIUslugaF);

			BigDecimal ukupanRabatF = faktura.getUkupanRabat().add(s.getIznosRabata());
			faktura.setUkupanRabat(ukupanRabatF);

			BigDecimal ukupanPorezF = faktura.getUkupanPorez().add(s.getUkupanPorez());
			faktura.setUkupanPorez(ukupanPorezF);

			BigDecimal iznosZaUplatuF = faktura.getIznosZaUplatu();
			BigDecimal sUkupanPorez = s.getUkupanPorez();
			BigDecimal sUmanjenoZaRabat = s.getUmanjenoZaRabat();
			BigDecimal res = sUmanjenoZaRabat.add(sUkupanPorez);

			faktura.setIznosZaUplatu(iznosZaUplatuF.add(res));
		}

		faktura.setStavka(stavkeFaktura);

		return faktura;
	}

	@Override
	public List<FakturaDTO> findByFirma(Firma firma) {
		System.err.println("IDFIRME" + firma.getId());
		List<FakturaDTO> faktureSve = firma.getFakture();
		List<FakturaDTO> fakturePrimljene = new ArrayList<FakturaDTO>();

		for (FakturaDTO f : faktureSve) {
			if (f.getStatus().equals(FakturaStatus.PRIMLJENO)) {
				if (!fakturePrimljene.contains(f)) {
					fakturePrimljene.add(f);
					System.err.println("IDFAKTURE:" + f.getIdPoruke() + "STATUS" + f.getStatus());

				}
			}
		}
		return fakturePrimljene;
	}

}
