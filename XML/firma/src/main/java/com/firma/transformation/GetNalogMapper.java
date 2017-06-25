package com.firma.transformation;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.codenotfound.services.nalogzaprenos.Nalogzaprenos;
import com.firma.models.nalogzaprenos.NalogZaPrenos;

public final class GetNalogMapper {

	private static com.firma.models.nalogzaprenos.ObjectFactory objectFactoryGeneral = new com.firma.models.nalogzaprenos.ObjectFactory();
	
	public static NalogZaPrenos mapGeneralOutlook2Nalogzaprenos() throws DatatypeConfigurationException {

		NalogZaPrenos nalogzaprenosReturn = objectFactoryGeneral.createNalogZaPrenos();
		
		GregorianCalendar gcal = new GregorianCalendar();
		XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		
		nalogzaprenosReturn.setDatumNaloga(xgcal);
		nalogzaprenosReturn.setDatumValute(xgcal);
		nalogzaprenosReturn.setDuznikNalogodavac("Duznan");
		nalogzaprenosReturn.setHitno(false);
		nalogzaprenosReturn.setIDPoruke(new Long(2));
		nalogzaprenosReturn.setIznos(new BigDecimal(52));
		nalogzaprenosReturn.setModelOdobrenja(97);
		nalogzaprenosReturn.setModelZaduzenja(97);
		nalogzaprenosReturn.setOznakaValute("DIN");
		nalogzaprenosReturn.setPozivNaBrojOdobrenja("123456");
		nalogzaprenosReturn.setPozivNaBrojZaduzenja("789");
		nalogzaprenosReturn.setPrimalacPoverilac("Prima rdjavi");
		nalogzaprenosReturn.setRacunDuznika("987456321123654789");
		nalogzaprenosReturn.setRacunPoverioca("987456321123654789");
		nalogzaprenosReturn.setSvrhaPlacanja("poklon");
		
		return nalogzaprenosReturn;

	}

}