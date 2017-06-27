package com.banka.services.nalogzaprenos;

import java.math.BigDecimal;

import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.banka.models.domain.Firma;
import com.banka.models.mt103.Mt103CT;
import com.banka.services.BankaService;
import com.banka.services.FirmaService;

public class NalogzaprenosWrappedImpl implements NalogzaprenosWrapped {

	private static final Logger LOGGER = LoggerFactory.getLogger(NalogzaprenosWrappedImpl.class);

	@Autowired
	private FirmaService firmaService;
	
	@Autowired
	private BankaService bankaService;
	
	@Override
	public void getNalog(long idPoruke, String duznikNalogodavac,
			String svrhaPlacanja, String primalacPoverilac,
			XMLGregorianCalendar datumNaloga,
			XMLGregorianCalendar datumValute, 
			String racunDuznika, int modelZaduzenja,
			String pozivNaBrojZaduzenja
			, String racunPoverioca, int modelOdobrenja,
			String pozivNaBrojOdobrenja,
			BigDecimal iznos, String oznakaValute, boolean hitno) {

		LOGGER.info("Endpoint received nalog=[idPoruke:{},duznikNalogodavac:{}]", idPoruke, duznikNalogodavac);
		System.out.println(idPoruke);
		System.out.println(duznikNalogodavac);
		System.out.println(svrhaPlacanja);
		
			// ako je ista banka
			//dodaj vezu ka banci i proveru da li je ista banka u pitanju
		Firma firmaDuznik = firmaService.findByNaziv(duznikNalogodavac);
		Firma firmaPrimalac = firmaService.findByNaziv(primalacPoverilac);
			
		if(!hitno){
				float ukupanIznosFirmeDuznika = firmaDuznik.getUkupanIznos() - iznos.floatValue();
				float ukupanIznosFirmePrimaoca = firmaPrimalac.getUkupanIznos() + iznos.floatValue();
				firmaDuznik.setUkupanIznos(ukupanIznosFirmeDuznika);
				firmaPrimalac.setUkupanIznos(ukupanIznosFirmePrimaoca);
				firmaService.save(firmaPrimalac);
				firmaService.save(firmaDuznik);
		}
		
		
		if(hitno || iznos.doubleValue()>250000){
				String endpoint = "http://localhost:7070/services/Rtgs";
				WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
				Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		
				marshaller.setContextPath("com.banka.models.mt103");
		
				Mt103CT send = new Mt103CT();
				String strLong = Long.toString(idPoruke);
				
				// OSTALI SU ATRIBUTI
				send.setIDPoruke(strLong);
				send.setDuznikNalogodavac(duznikNalogodavac);
				send.setSvrhaPlacanja(svrhaPlacanja);
				send.setPrimalacPoverilac(primalacPoverilac);
				send.setDatumNaloga(datumNaloga);
				send.setDatumValute(datumValute);
				send.setRacunDuznika(racunDuznika);
				send.setModelZaduzenja(modelZaduzenja);
				send.setPozivNaBrojZaduzenja(pozivNaBrojZaduzenja);
				send.setRacunPoverioca(racunPoverioca);
				send.setModelOdobrenja(modelOdobrenja);
				send.setPozivNaBrojOdobrenja(pozivNaBrojOdobrenja);
				send.setIznos(iznos);
				send.setSifraValute(oznakaValute);
				
		
				webServiceTemplate.setMarshaller(marshaller);
				webServiceTemplate.afterPropertiesSet();
		
				webServiceTemplate.setDefaultUri(endpoint);
			    webServiceTemplate.marshalSendAndReceive(endpoint,send);
			    
			    // Funkcija stize na rtgs impl
			}
			// mogao bi da se  napise webtemplate da se posalje objekat obe firme, aplikaciji firma, i da se tamo stanje u tabelama izmeni
		
	}

}
