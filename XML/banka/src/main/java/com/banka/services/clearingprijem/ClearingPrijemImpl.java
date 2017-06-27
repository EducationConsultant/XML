package com.banka.services.clearingprijem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.banka.models.domain.Firma;
import com.banka.models.mt102.NalogZaGrupnaPlacanja;
import com.banka.models.mt102.NalogZaGrupnaPlacanja.Placanja.Placanje;
import com.banka.models.mt910.MT910CT;
import com.banka.repository.FirmaRepository;

@javax.jws.WebService(
        serviceName = "clearingPrijem",
        portName = "clearingPrijemSOAP",
        targetNamespace = "http://codenotfound.com/services/clearingPrijem",
        //wsdlLocation = "../wsdl/izvod.wsdl",
        endpointInterface = "com.banka.services.clearingprijem.ClearingPrijem")
public class ClearingPrijemImpl implements ClearingPrijem{

	@Autowired
	FirmaRepository firmaService;
	@Override
	public void clearingPrijem(NalogZaGrupnaPlacanja mt102, MT910CT mt910) {
		// TODO Auto-generated method stub
		List<Firma> firme=firmaService.findAll();
		for(Placanje p:mt102.getPlacanja().getPlacanje()){
			for(Firma firma:firme){
				if(firma.getBrojRacuna()==p.getRacunPoverioca()){
					firma.setUkupanIznos(firma.getUkupanIznos()+p.getUkupanIznos().floatValue());
					firmaService.save(firma);
					break;
					}
			}
		}
		
	}

}
