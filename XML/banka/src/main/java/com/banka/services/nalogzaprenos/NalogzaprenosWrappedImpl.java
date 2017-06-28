package com.banka.services.nalogzaprenos;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.banka.models.domain.Banka;
import com.banka.models.domain.Firma;
import com.banka.models.domain.NalogZaPrenosDTO;
import com.banka.models.mt102.NalogZaGrupnaPlacanja;
import com.banka.models.mt102.NalogZaGrupnaPlacanja.Placanja;
import com.banka.models.mt102.NalogZaGrupnaPlacanja.Placanja.Placanje;
import com.banka.models.mt103.Mt103CT;
import com.banka.models.mt900.Mt900;
import com.banka.services.BankaService;
import com.banka.services.FirmaService;
import com.banka.services.NalogZaPrenosDTOService;

public class NalogzaprenosWrappedImpl implements NalogzaprenosWrapped {

	private static final Logger LOGGER = LoggerFactory.getLogger(NalogzaprenosWrappedImpl.class);

	@Autowired
	private FirmaService firmaService;

	@Autowired
	private BankaService bankaService;
	@Autowired
	private NalogZaPrenosDTOService nalogService;

	@Override
	public void getNalog(long idPoruke, String duznikNalogodavac, String svrhaPlacanja, String primalacPoverilac,
			XMLGregorianCalendar datumNaloga, XMLGregorianCalendar datumValute, String racunDuznika, int modelZaduzenja,
			String pozivNaBrojZaduzenja, String racunPoverioca, int modelOdobrenja, String pozivNaBrojOdobrenja,
			BigDecimal iznos, String oznakaValute, boolean hitno) {

		LOGGER.info("Endpoint received nalog=[idPoruke:{},duznikNalogodavac:{}]", idPoruke, duznikNalogodavac);
		System.out.println(idPoruke);
		System.out.println(duznikNalogodavac);
		System.out.println(svrhaPlacanja);
		NalogZaPrenosDTO nalog= new NalogZaPrenosDTO();
		nalog.setDatumNaloga(datumNaloga.toGregorianCalendar().getTime());
		nalog.setDatumValute(datumValute.toGregorianCalendar().getTime());
		nalog.setDuznikNalogodavac(duznikNalogodavac);
		nalog.setHitno(hitno);
		nalog.setIznos(iznos);
		nalog.setModelOdobrenja(modelOdobrenja);
		nalog.setModelZaduzenja(modelZaduzenja);
		nalog.setObradjeno(true);
		nalog.setOznakaValute(oznakaValute);
		nalog.setPozivNaBrojOdobrenja(pozivNaBrojOdobrenja);
		nalog.setPozivNaBrojZaduzenja(pozivNaBrojZaduzenja);
		nalog.setPrimalacPoverilac(primalacPoverilac);
		nalog.setRacunDuznika(racunDuznika);
		nalog.setRacunPoverioca(racunPoverioca);
		nalog.setSvrhaPlacanja(svrhaPlacanja);
		
		// ako je ista banka
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
		}else if(hitno || iznos.doubleValue()>250000){
				String endpoint = "http://localhost:7070/services/Rtgs";
				WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
				Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		
				marshaller.setContextPath("com.banka.models.mt103");

				Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
		
				unmarshaller.setContextPath("com.banka.models.mt900");
				Mt103CT send = new Mt103CT();
				String strLong = Long.toString(idPoruke);
				
				// OSTALI SU ATRIBUTI
				send.setIDPoruke(strLong);
				send.setSWIFTKodBankeDuznika(bankaDuznika.getSwiftKod());
				send.setSWIFTKodBankePoverioca(bankaPrimalac.getSwiftKod());
				send.setObracunskiRacunBankeDuznika(bankaDuznika.getObracunskiRacun());
				send.setObracunskiRacunBankePoverioca(bankaPrimalac.getObracunskiRacun());
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
				send.setObracunskiRacunBankeDuznika(bankaDuznika.getObracunskiRacun());
				send.setObracunskiRacunBankePoverioca(bankaPrimalac.getObracunskiRacun());
				send.setSWIFTKodBankeDuznika(bankaDuznika.getSwiftKod());
				send.setSWIFTKodBankePoverioca(bankaPrimalac.getSwiftKod());
				
				firmaDuznik.setUkupanIznos(firmaDuznik.getUkupanIznos()-iznos.floatValue());
				firmaService.save(firmaDuznik);
		
				webServiceTemplate.setMarshaller(marshaller);
				webServiceTemplate.setUnmarshaller(unmarshaller);
				webServiceTemplate.afterPropertiesSet();
		
				

                firmaDuznik.setUkupanIznos(firmaDuznik.getUkupanIznos()-iznos.floatValue());
                firmaService.save(firmaDuznik);
                
				webServiceTemplate.setDefaultUri(endpoint);
			    webServiceTemplate.marshalSendAndReceive(endpoint,send);
			    
			    // Funkcija stize na rtgs impl
			} else {
			    nalog.setObradjeno(true);
				String endpoint = "http://localhost:7070/services/Clearing";
				WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
				Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		
				marshaller.setContextPath("com.banka.models.mt102");

				Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
		
				unmarshaller.setContextPath("com.banka.models.mt900");
				
				NalogZaGrupnaPlacanja send = new NalogZaGrupnaPlacanja();
				send.setDatum(datumNaloga);
				send.setDatumValute(datumValute);
				send.setObracunskiRacunBankeDuznika(bankaDuznika.getObracunskiRacun());
				send.setObracunskiRacunBankePoverioca(bankaPrimalac.getObracunskiRacun());
				send.setIDPoruke("1");
				send.setSifraValute(oznakaValute);
				send.setSWIFTKodBankeDuznika(bankaDuznika.getSwiftKod());
				send.setSWIFTKodBankePoverioca(bankaPrimalac.getSwiftKod());
				//prepraviti za slanje vise placanja
				send.setUkupanIznos(iznos);
				Placanja plac=new Placanja();
				Placanje pl= new Placanje();
				pl.setDatumNaloga(datumNaloga);
				pl.setDuznikNalogodavac(duznikNalogodavac);
				pl.setIDNalogaZaPlacanje("1");
				pl.setModelOdobrenja(modelOdobrenja);
				pl.setModelZaduzenja(modelZaduzenja);
				pl.setPozivNaBrojOdobrenja(pozivNaBrojOdobrenja);
				pl.setPozivNaBrojZaduzenja(pozivNaBrojZaduzenja);
				pl.setPrimalacPoverilac(primalacPoverilac);
				pl.setRacunDuznika(racunDuznika);
				pl.setRacunPoverioca(racunPoverioca);
				pl.setSifraValute(oznakaValute);
				pl.setSvrhaPlacanja(svrhaPlacanja);
				pl.setUkupanIznos(iznos);
				plac.getPlacanje().add(pl);
				send.setPlacanja(plac);
				
				firmaDuznik.setUkupanIznos(firmaDuznik.getUkupanIznos()-iznos.floatValue());
				firmaService.save(firmaDuznik);
				
		
				webServiceTemplate.setMarshaller(marshaller);
				webServiceTemplate.setUnmarshaller(unmarshaller);
				webServiceTemplate.afterPropertiesSet();
		
				webServiceTemplate.setDefaultUri(endpoint);
			    Mt900 mt900=(Mt900) webServiceTemplate.marshalSendAndReceive(endpoint,send);
			}
        nalogService.save(nalog);
			
	}

}
