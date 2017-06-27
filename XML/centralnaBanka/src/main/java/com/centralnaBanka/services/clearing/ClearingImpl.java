package com.centralnaBanka.services.clearing;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.centralnaBanka.models.clearingprijem.ClearingPrijem;
import com.centralnaBanka.models.domain.Banka;
import com.centralnaBanka.models.mt102.NalogZaGrupnaPlacanja;
import com.centralnaBanka.models.mt102.NalogZaGrupnaPlacanja.Placanja;
import com.centralnaBanka.models.mt910.MT910CT;
import com.centralnaBanka.services.BankaService;



@javax.jws.WebService(
        serviceName = "clearing",
        portName = "ClearingSOAP",
        targetNamespace = "http://codenotfound.com/services/clearing/",
        //wsdlLocation = "../wsdl/izvod.wsdl",
        endpointInterface = "com.centralnaBanka.services.clearing.Clearing")
public class ClearingImpl implements Clearing {

	@Autowired
	BankaService bankaService;
	@Override
	public void clearing(Holder<String> idPoruke,
			Holder<String> swiftKodBankeDuznika,
			Holder<String> obracunskiRacunBankeDuznika,
			String swiftKodBankePoverioca,
			String obracunskiRacunBankePoverioca, BigDecimal ukupanIznos,
			Holder<String> sifraValute,
			Holder<XMLGregorianCalendar> datumValute,
			XMLGregorianCalendar datum, Placanja placanja,
			Holder<String> idPorukeNaloga, Holder<BigDecimal> iznos) {
		// TODO Auto-generated method stub
		iznos.value=ukupanIznos;
		idPorukeNaloga.value=idPoruke.value;
		System.out.println(idPoruke.value);
		Banka bankaDuznika = new Banka();
		Banka bankaPrimalac = new Banka();
		List<Banka> banke = bankaService.find();
		for(Banka b:banke){
			if(b.getObracunskiRacun().equals(obracunskiRacunBankeDuznika))
				bankaDuznika=b;
			if(b.getObracunskiRacun().equals(obracunskiRacunBankePoverioca))
				bankaPrimalac=b;
		}
		//prebaciti novac banki
		
		bankaDuznika.setStanjeRacuna(bankaDuznika.getStanjeRacuna()-iznos.value.longValue());
		bankaPrimalac.setStanjeRacuna(bankaPrimalac.getStanjeRacuna()+iznos.value.longValue());
		bankaService.save(bankaDuznika.getId(),bankaDuznika);
		bankaService.save(bankaPrimalac.getId(), bankaPrimalac);
		
		ClearingPrijem send= new  ClearingPrijem();
		NalogZaGrupnaPlacanja mt=new NalogZaGrupnaPlacanja();
		mt.setIDPoruke("test");
		mt.setDatum(datum);
		mt.setDatumValute(datumValute.value);
		mt.setObracunskiRacunBankeDuznika(obracunskiRacunBankePoverioca);
		mt.setObracunskiRacunBankePoverioca(obracunskiRacunBankePoverioca);
		mt.setPlacanja(placanja);
		mt.setSifraValute(sifraValute.value);
		mt.setSWIFTKodBankeDuznika(swiftKodBankeDuznika.value);
		mt.setSWIFTKodBankePoverioca(swiftKodBankePoverioca);
		mt.setUkupanIznos(ukupanIznos);
		
		
		send.setMt102(mt);
		MT910CT mt910=new MT910CT();
		mt910.setDatumValute(datum);
		mt910.setIDPoruke("1");
		mt910.setIDPorukeNaloga(idPorukeNaloga.value);
		mt910.setIznos(iznos.value);
		mt910.setObracunskiRacunBankePoverioca(obracunskiRacunBankePoverioca);
		mt910.setSifraValute(sifraValute.value);
		mt910.setSWIFTKodBankePoverioca(swiftKodBankePoverioca);
		
		send.setMt910(mt910);
		
		String endpoint = "http://localhost:9090/services/ClearingPrijem";
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

		marshaller.setContextPath("com.centralnaBanka.models.clearingprijem");

		

		webServiceTemplate.setMarshaller(marshaller);
		webServiceTemplate.setUnmarshaller(marshaller);
		webServiceTemplate.afterPropertiesSet();

		webServiceTemplate.setDefaultUri(endpoint);
	    webServiceTemplate.marshalSendAndReceive(endpoint,send);

		
	}

}
