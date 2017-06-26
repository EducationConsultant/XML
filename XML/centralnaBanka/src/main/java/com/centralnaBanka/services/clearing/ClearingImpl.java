package com.centralnaBanka.services.clearing;

import java.math.BigDecimal;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.centralnaBanka.models.clearingprijem.ClearingPrijem;
import com.centralnaBanka.models.mt102.NalogZaGrupnaPlacanja;
import com.centralnaBanka.models.mt102.NalogZaGrupnaPlacanja.Placanja;
import com.centralnaBanka.models.mt103.Mt103CT;
import com.centralnaBanka.models.mt910.MT910CT;
import com.centralnaBanka.models.rtgsprijem.RtgsPrijem;



@javax.jws.WebService(
        serviceName = "clearing",
        portName = "ClearingSOAP",
        targetNamespace = "http://codenotfound.com/services/clearing/",
        //wsdlLocation = "../wsdl/izvod.wsdl",
        endpointInterface = "com.centralnaBanka.services.clearing.Clearing")
public class ClearingImpl implements Clearing {

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
		System.out.println(idPoruke.value);
		ClearingPrijem send= new  ClearingPrijem();
		NalogZaGrupnaPlacanja mt=new NalogZaGrupnaPlacanja();
		mt.setIDPoruke("test");
		send.setMt102(mt);
		send.setMt910(new MT910CT());
		
		String endpoint = "http://localhost:9090/services/ClearingPrijem";
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

		marshaller.setContextPath("com.centralnaBanka.models.clearingprijem");

		

		webServiceTemplate.setMarshaller(marshaller);
		webServiceTemplate.afterPropertiesSet();

		webServiceTemplate.setDefaultUri(endpoint);
	    webServiceTemplate.marshalSendAndReceive(endpoint,send);

		
	}

}
