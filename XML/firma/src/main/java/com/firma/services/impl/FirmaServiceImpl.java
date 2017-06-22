package com.firma.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firma.models.domain.FakturaDTO;
import com.firma.models.domain.Firma;
import com.firma.models.domain.StavkaDTO;
import com.firma.repository.FakturaRepository;
import com.firma.repository.FirmaRepository;
import com.firma.repository.StavkaFaktureRepository;
import com.firma.services.FirmaService;

@Service
@Transactional
public class FirmaServiceImpl implements FirmaService {

	@Autowired
	private FirmaRepository firmaRepository;

	@Autowired
	private FakturaRepository fakturaRepository;

	@Autowired
	private StavkaFaktureRepository stavkaFaktureRepository;

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

		savedFaktura.setUkupanPorez(faktura.getUkupanPorez());
		savedFaktura.setUkupanRabat(faktura.getUkupanRabat());
		savedFaktura.setUkupnoRobaIUsluge(faktura.getUkupnoRobaIUsluge());
		savedFaktura.setUplataNaRacun(faktura.getUplataNaRacun());
		savedFaktura.setVrednostRobe(faktura.getVrednostRobe());
		savedFaktura.setVrednostUsluga(faktura.getVrednostUsluga());
		savedFaktura.setStatus(faktura.getStatus());

		fakturaRepository.save(savedFaktura);

		List<StavkaDTO> fakturineStavke = faktura.getStavka();

		List<StavkaDTO> noveStavke = new ArrayList<>();
		for (StavkaDTO stavka : fakturineStavke) {
			StavkaDTO newStavka = new StavkaDTO();
			newStavka.setNazivRobeIliUsluge(stavka.getNazivRobeIliUsluge());
			newStavka.setKolicina(stavka.getKolicina());
			newStavka.setJedinicaMere(stavka.getJedinicaMere());
			newStavka.setJedinicnaCena(stavka.getJedinicnaCena());
			newStavka.setProcenatRabata(stavka.getProcenatRabata());
			newStavka.setUkupanPorez(stavka.getUkupanPorez());

			BigDecimal vrednostStavke = newStavka.getJedinicnaCena().multiply(newStavka.getKolicina());
			newStavka.setVrednost(vrednostStavke);

			BigDecimal iznosRabata = newStavka.getVrednost()
					.multiply(newStavka.getProcenatRabata().divide(new BigDecimal(100)));
			newStavka.setIznosRabata(iznosRabata);

			BigDecimal umanjenoZaRabat = newStavka.getVrednost().subtract(newStavka.getIznosRabata());
			newStavka.setUmanjenoZaRabat(umanjenoZaRabat);

			newStavka.setFaktura(savedFaktura);

			stavkaFaktureRepository.save(newStavka);

			noveStavke.add(newStavka);
		}

		for (StavkaDTO s : noveStavke) {
			BigDecimal vrednostRobeF = savedFaktura.getVrednostRobe().add(s.getVrednost());
			savedFaktura.setVrednostRobe(vrednostRobeF);

			BigDecimal vrednostUslugaF = savedFaktura.getVrednostUsluga().add(s.getVrednost());
			savedFaktura.setVrednostUsluga(vrednostUslugaF);

			BigDecimal ukupnoRobaIUslugaF = savedFaktura.getUkupnoRobaIUsluge().add(s.getKolicina());
			savedFaktura.setUkupnoRobaIUsluge(ukupnoRobaIUslugaF);

			BigDecimal ukupanRabatF = savedFaktura.getUkupanRabat().add(s.getIznosRabata());
			savedFaktura.setUkupanRabat(ukupanRabatF);

			BigDecimal ukupanPorezF = savedFaktura.getUkupanPorez().add(s.getUkupanPorez());
			savedFaktura.setUkupanPorez(ukupanPorezF);

			BigDecimal iznosZaUplatuF = savedFaktura.getIznosZaUplatu();
			BigDecimal sUkupanPorez = s.getUkupanPorez();
			BigDecimal sUmanjenoZaRabat = s.getUmanjenoZaRabat();
			BigDecimal res = sUmanjenoZaRabat.add(sUkupanPorez);

			savedFaktura.setIznosZaUplatu(iznosZaUplatuF.add(res));
		}

		savedFaktura.setStavka(noveStavke);

		List<FakturaDTO> firmineFakture = firma.getFakture();
		if (firmineFakture == null) {
			firmineFakture = new ArrayList<>();
		}
		firmineFakture.add(savedFaktura);

		firma.setFakture(firmineFakture);

		return firma;
	}
}
