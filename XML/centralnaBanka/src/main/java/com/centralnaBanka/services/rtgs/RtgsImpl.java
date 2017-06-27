package com.centralnaBanka.services.rtgs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.centralnaBanka.models.mt103.Mt103CT;
import com.centralnaBanka.models.mt910.MT910CT;
import com.centralnaBanka.models.rtgsprijem.RtgsPrijem;

@javax.jws.WebService(
        serviceName = "rtgs",
        portName = "rtgsSOAP",
        targetNamespace = "http://codenotfound.com/services/rtgs",
        //wsdlLocation = "../wsdl/izvod.wsdl",
        endpointInterface = "com.centralnaBanka.services.rtgs.Rtgs")
public class RtgsImpl implements Rtgs {

	@Override
	public void rtgs(Holder<String> idPoruke,
			Holder<String> swiftKodBankeDuznika,
			Holder<String> obracunskiRacunBankeDuznika,
			String swiftKodBankePoverioca,
			String obracunskiRacunBankePoverioca, String duznikNalogodavac,
			String svrhaPlacanja, String primalacPoverilac,
			XMLGregorianCalendar datumNaloga,
			Holder<XMLGregorianCalendar> datumValute, String racunDuznika,
			int modelZaduzenja, String pozivNaBrojZaduzenja,
			String racunPoverioca, int modelOdobrenja,
			String pozivNaBrojOdobrenja, Holder<BigDecimal> iznos,
			Holder<String> sifraValute, Holder<String> idPorukeNaloga) {
		// TODO Auto-generated method stub
		RtgsPrijem send= new  RtgsPrijem();
		Mt103CT mt=new Mt103CT();
		
		mt.setIDPoruke(idPoruke.value);
		mt.setSWIFTKodBankeDuznika(swiftKodBankeDuznika.value);
		mt.setObracunskiRacunBankeDuznika(obracunskiRacunBankeDuznika.value);
		mt.setSWIFTKodBankePoverioca(swiftKodBankePoverioca);
	//	mt.set
		
		
		
		mt.setDuznikNalogodavac("test");
		send.setMt103(mt);
		send.setMt910(new MT910CT());
		
		String endpoint = "http://localhost:9090/services/RtgsPrijem";
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

		marshaller.setContextPath("com.centralnaBanka.models.rtgsprijem");

		

		webServiceTemplate.setMarshaller(marshaller);
		webServiceTemplate.afterPropertiesSet();

		webServiceTemplate.setDefaultUri(endpoint);
	    webServiceTemplate.marshalSendAndReceive(endpoint,send);

		
		System.out.println(idPoruke.value);
	}

}
