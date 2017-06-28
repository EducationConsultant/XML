package com.centralnaBanka.services.rtgs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.centralnaBanka.models.domain.Banka;
import com.centralnaBanka.models.mt103.Mt103CT;
import com.centralnaBanka.models.mt910.MT910CT;
import com.centralnaBanka.models.rtgsprijem.RtgsPrijem;
import com.centralnaBanka.services.BankaService;

@javax.jws.WebService(
        serviceName = "rtgs",
        portName = "rtgsSOAP",
        targetNamespace = "http://codenotfound.com/services/rtgs",
        //wsdlLocation = "../wsdl/izvod.wsdl",
        endpointInterface = "com.centralnaBanka.services.rtgs.Rtgs")
public class RtgsImpl implements Rtgs {

	@Autowired
	BankaService bankaService;
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
		
		Banka bankaDuznika = new Banka();
		Banka bankaPrimalac = new Banka();
		List<Banka> banke = bankaService.find();
		for(Banka b:banke){
			if(b.getObracunskiRacun().equals(obracunskiRacunBankeDuznika.value))
				bankaDuznika=b;
			if(b.getObracunskiRacun().equals(obracunskiRacunBankePoverioca))
				bankaPrimalac=b;
		}
		//pazi, ja kontam skoro sve radi, imas ti zalbi
		
		bankaDuznika.setStanjeRacuna(bankaDuznika.getStanjeRacuna()-iznos.value.longValue());
		bankaPrimalac.setStanjeRacuna(bankaPrimalac.getStanjeRacuna()+iznos.value.longValue());
		//bankaService.save(bankaDuznika.getCentralnaBanka().getId(),bankaDuznika);
		//bankaService.save(bankaPrimalac.getCentralnaBanka().getId(), bankaPrimalac);
		
		mt.setIDPoruke(idPoruke.value);
		mt.setSWIFTKodBankeDuznika(swiftKodBankeDuznika.value);
		mt.setObracunskiRacunBankeDuznika(obracunskiRacunBankeDuznika.value);
		mt.setSWIFTKodBankePoverioca(swiftKodBankePoverioca);
		mt.setObracunskiRacunBankePoverioca(obracunskiRacunBankePoverioca);
		mt.setDuznikNalogodavac(duznikNalogodavac);
		mt.setSvrhaPlacanja(svrhaPlacanja);
		mt.setPrimalacPoverilac(primalacPoverilac);
		mt.setDatumNaloga(datumNaloga);
		mt.setDatumValute(datumValute.value);
		mt.setRacunDuznika(racunDuznika);
		mt.setModelZaduzenja(modelZaduzenja);
		mt.setRacunPoverioca(racunPoverioca);
		mt.setModelOdobrenja(modelOdobrenja);
		mt.setPozivNaBrojOdobrenja(pozivNaBrojOdobrenja);
		mt.setIznos(iznos.value);
		mt.setSifraValute(sifraValute.value);
		mt.setIDPoruke(idPorukeNaloga.value);
		
		send.setMt103(mt);
		
		MT910CT mt9 = new MT910CT();
		
		mt9.setIDPoruke(idPoruke.value);
		mt9.setSWIFTKodBankePoverioca(swiftKodBankePoverioca);
		mt9.setObracunskiRacunBankePoverioca(obracunskiRacunBankePoverioca);
		mt9.setIDPorukeNaloga(idPorukeNaloga.value);
		mt9.setIznos(iznos.value);
		mt9.setSifraValute(sifraValute.value);
		
		
		send.setMt910(mt9);
		
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
