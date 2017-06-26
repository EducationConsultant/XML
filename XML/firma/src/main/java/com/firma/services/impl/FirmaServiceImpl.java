package com.firma.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.firma.models.domain.Banka;
import com.firma.models.domain.FakturaDTO;
import com.firma.models.domain.Firma;
import com.firma.models.domain.StavkaDTO;
import com.firma.models.nalogzaprenos.NalogZaPrenos;
import com.firma.repository.FakturaRepository;
import com.firma.repository.FirmaRepository;
import com.firma.repository.StavkaFaktureRepository;
import com.firma.services.BankaService;
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

	@Autowired
	private BankaService bankaService;

	@Autowired
	private FirmaService firmaService;

	List<FakturaDTO> fakture = new ArrayList<FakturaDTO>();

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

	@Override
	public void posaljiNalog(NalogZaPrenos n) {

		String endpoint = "http://localhost:9090/services/nalogzaprenos";
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.firma.models.nalogzaprenos");
		webServiceTemplate.setMarshaller(marshaller);
		webServiceTemplate.setUnmarshaller(marshaller);
		webServiceTemplate.afterPropertiesSet();
		webServiceTemplate.setDefaultUri(endpoint);
		webServiceTemplate.marshalSendAndReceive(endpoint, n);

	}

	@Override
	public Firma podesiBanku(String nazivBanke, Firma firma) {
		
		RestTemplate restTemplate = new RestTemplate();
		Banka b = (Banka) restTemplate.getForObject("http://localhost:7070/api/centralnabanka/nazivBanke/" + nazivBanke,
				Banka.class);
		Banka banka = new Banka();
		banka.setNaziv(b.getNaziv());
		banka.setObracunskiRacun(b.getObracunskiRacun());
		banka.setSifra(b.getSifra());
		banka.setSwiftKod(b.getSwiftKod());
		banka.setNaziv(nazivBanke);
		Banka saved = bankaService.save(banka);
		firma.setBanka(saved);
		Firma savedFirma = firmaService.save(firma);

		restTemplate.postForObject("http://localhost:9090/api/banka/" + nazivBanke, firma, Firma.class);

		return savedFirma;
	}
}
