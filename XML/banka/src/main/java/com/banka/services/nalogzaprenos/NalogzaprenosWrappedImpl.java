package com.banka.services.nalogzaprenos;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.banka.models.domain.Banka;
import com.banka.models.domain.Firma;
import com.banka.models.nalogzaprenos.*;
import com.banka.repository.FirmaRepository;
import com.banka.services.BankaService;
import com.banka.services.FirmaService;

import javax.xml.datatype.XMLGregorianCalendar;

public class NalogzaprenosWrappedImpl implements NalogzaprenosWrapped {

	private static final Logger LOGGER = LoggerFactory.getLogger(NalogzaprenosWrappedImpl.class);

	@Autowired
	private FirmaService firmaService;

	@Autowired
	private BankaService bankaService;

	@Override
	public void getNalog(long idPoruke, String duznikNalogodavac, String svrhaPlacanja, String primalacPoverilac,
			XMLGregorianCalendar datumNaloga, XMLGregorianCalendar datumValute, String racunDuznika, int modelZaduzenja,
			String pozivNaBrojZaduzenja, String racunPoverioca, int modelOdobrenja, String pozivNaBrojOdobrenja,
			BigDecimal iznos, String oznakaValute, boolean hitno) {

		LOGGER.info("Endpoint received nalog=[idPoruke:{},duznikNalogodavac:{}]", idPoruke, duznikNalogodavac);
		System.out.println(idPoruke);
		System.out.println(duznikNalogodavac);
		System.out.println(svrhaPlacanja);

		// ako je ista banka
		// dodaj vezu ka banci i proveru da li je ista banka u pitanju
		Firma firmaDuznik = firmaService.findByNaziv(duznikNalogodavac);
		Firma firmaPrimalac = firmaService.findByNaziv(primalacPoverilac);
		Banka bankaDuznika = new Banka();
		Banka bankaPrimalac = new Banka();

		List<Banka> banke = bankaService.find();
		for (int i = 0; i < banke.size(); i++) {
			List<Firma> firme = banke.get(i).getFirme();
			for (Firma f : firme) {
				if (f.getNaziv().equals(duznikNalogodavac)) {
					bankaDuznika = banke.get(i);
					System.err.println("Banka duznika: " + bankaDuznika.getNaziv());
					break;
				}
			}
		}

		for (int j = 0; j < banke.size(); j++) {
			List<Firma> firme = banke.get(j).getFirme();
			for (Firma f : firme) {
				if (f.getNaziv().equals(primalacPoverilac)) {
					bankaPrimalac = banke.get(j);
					System.err.println("Banka primaoca: " + bankaPrimalac.getNaziv() );
					break;
				}
			}
		}

		if(bankaDuznika.getNaziv().equals(bankaPrimalac.getNaziv()))  {
			float ukupanIznosFirmeDuznika = firmaDuznik.getUkupanIznos() - iznos.floatValue();
			float ukupanIznosFirmePrimaoca = firmaPrimalac.getUkupanIznos() + iznos.floatValue();
			firmaDuznik.setUkupanIznos(ukupanIznosFirmeDuznika);
			firmaPrimalac.setUkupanIznos(ukupanIznosFirmePrimaoca);
			firmaService.save(firmaPrimalac);
			firmaService.save(firmaDuznik);	
		}
		

	}

}
