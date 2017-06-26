package com.banka.services.nalogzaprenos;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.banka.models.nalogzaprenos.*;
import javax.xml.datatype.XMLGregorianCalendar;

public class NalogzaprenosWrappedImpl implements NalogzaprenosWrapped {

	private static final Logger LOGGER = LoggerFactory.getLogger(NalogzaprenosWrappedImpl.class);

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

		
		
		//gadjam banku - exposuje servis za primanje naloga za prenos
		//promeni port - - npr resttemplate,  iz fimre gadjam taj endpoint, uokviru 
		// iz firme uputi soap request banci, prosledji obj koji je nalog za prenos
		// nalog upucujem banci, banka ima  javno vdiljivi soap servis   = sa strane banke
		// gadjam soap endpoint
	}

}
