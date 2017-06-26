package com.banka.services.clearingprijem;

import com.banka.models.mt102.NalogZaGrupnaPlacanja;
import com.banka.models.mt910.MT910CT;

@javax.jws.WebService(
        serviceName = "clearingPrijem",
        portName = "clearingPrijemSOAP",
        targetNamespace = "http://codenotfound.com/services/clearingPrijem",
        //wsdlLocation = "../wsdl/izvod.wsdl",
        endpointInterface = "com.banka.services.clearingprijem.ClearingPrijem")
public class ClearingPrijemImpl implements ClearingPrijem{

	@Override
	public void clearingPrijem(NalogZaGrupnaPlacanja mt102, MT910CT mt910) {
		// TODO Auto-generated method stub
		System.out.println(mt102.getIDPoruke());
	}

}
