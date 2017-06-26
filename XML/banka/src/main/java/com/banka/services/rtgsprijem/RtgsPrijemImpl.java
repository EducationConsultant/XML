package com.banka.services.rtgsprijem;

import java.math.BigDecimal;

import javax.xml.datatype.XMLGregorianCalendar;

import com.banka.models.mt103.Mt103CT;
import com.banka.models.mt910.MT910CT;


@javax.jws.WebService(
        serviceName = "rtgsPrijem",
        portName = "rtgsSOAP",
        targetNamespace = "http://codenotfound.com/services/rtgsPrijem",
        //wsdlLocation = "../wsdl/izvod.wsdl",
        endpointInterface = "com.banka.services.rtgsprijem.RtgsPrijem")
public class RtgsPrijemImpl implements RtgsPrijem{

	

	@Override
	public void rtgsPrijem(Mt103CT mt103, MT910CT mt910) {
		// TODO Auto-generated method stub
		System.out.println(mt103.getDuznikNalogodavac());
	}

}
