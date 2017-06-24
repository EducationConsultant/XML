package com.firma.services.nalogzaprenos;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.firma.models.nalogzaprenos.*;
import javax.xml.datatype.XMLGregorianCalendar;

public class NalogzaprenosWrappedImpl implements NalogzaprenosWrapped {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(NalogzaprenosWrappedImpl.class);

	@Override
	public void getNalog(long idPoruke, String duznikNalogodavac, String svrhaPlacanja, String primalacPoverilac,
			XMLGregorianCalendar datumNaloga, XMLGregorianCalendar datumValute, String racunDuznika, int modelZaduzenja,
			String pozivNaBrojZaduzenja, String racunPoverioca, int modelOdobrenja, String pozivNaBrojOdobrenja,
			BigDecimal iznos, String oznakaValute, boolean hitno) {
		
		 LOGGER.info(
               "Endpoint received nalog=[idPoruke:{},duznikNalogodavac:{}]",
               idPoruke, duznikNalogodavac);
		
	}


}
