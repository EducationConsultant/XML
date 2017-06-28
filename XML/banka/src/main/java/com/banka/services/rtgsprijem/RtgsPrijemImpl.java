package com.banka.services.rtgsprijem;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.banka.models.domain.Firma;
import com.banka.models.mt103.Mt103CT;
import com.banka.models.mt910.MT910CT;
import com.banka.repository.FirmaRepository;


@javax.jws.WebService(
        serviceName = "rtgsPrijem",
        portName = "rtgsSOAP",
        targetNamespace = "http://codenotfound.com/services/rtgsPrijem",
        //wsdlLocation = "../wsdl/izvod.wsdl",
        endpointInterface = "com.banka.services.rtgsprijem.RtgsPrijem")
public class RtgsPrijemImpl implements RtgsPrijem{

	@Autowired
	FirmaRepository firmaService;

	@Override
	public void rtgsPrijem(Mt103CT mt103, MT910CT mt910) {
		// TODO Auto-generated method stub
		List<Firma> firme=firmaService.findAll();
		for(Firma f:firme){
			if(f.getBrojRacuna().equals(mt103.getRacunPoverioca())){
				f.setUkupanIznos(f.getUkupanIznos()+mt103.getIznos().floatValue());
				firmaService.save(f);
				break;
			}
		}
		System.out.println(mt103.getIznos()+"");
		System.out.println(mt103.getDuznikNalogodavac());
	}

}
