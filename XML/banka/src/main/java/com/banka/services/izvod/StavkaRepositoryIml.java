package com.banka.services.izvod;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import com.banka.models.presek.GetPresekResponse.Stavke.Stavka;

public class StavkaRepositoryIml {
	public StavkaRepositoryIml() {
		super();
		init();
	}
	    private ArrayList<Stavka> lista;
	    
	    public ArrayList<Stavka> find(String nalog){
	    	ArrayList<Stavka> ret= new ArrayList<Stavka>();
	    	for(Stavka s:lista){
	    		if(s.getDuznikNalogodavac().equals(nalog) || s.getPrimalacPoverilac().equals(nalog))
	    			ret.add(s);
	    	}
	    	
	    	return ret;
	    }
	    @PostConstruct
	    public void init(){
	    	lista=new ArrayList<Stavka>();
	    		Stavka stavka=new Stavka();
	    		try {
					stavka.setDatumNaloga(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
					stavka.setDatumValute(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
		            
	    		} catch (DatatypeConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            stavka.setDuznikNalogodavac("1");
	            stavka.setPrimalacPoverilac("a");
	            stavka.setIznos(new BigDecimal(3));
	            stavka.setModelZaduzenja(4);
	            stavka.setPozivNaBrojOdobrenja("a");
	            stavka.setRacunDuznika("a");
	            stavka.setSmer("a");
	            stavka.setSvrhaPlacanja("a");
	            lista.add(stavka);
	             stavka=new Stavka();
	    		try {
					stavka.setDatumNaloga(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
					stavka.setDatumValute(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
		            
	    		} catch (DatatypeConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            stavka.setDuznikNalogodavac("1");
	            stavka.setPrimalacPoverilac("a");
	            stavka.setIznos(new BigDecimal(55));
	            stavka.setModelZaduzenja(3);
	            stavka.setPozivNaBrojOdobrenja("ab");
	            stavka.setRacunDuznika("ab");
	            stavka.setSmer("ab");
	            stavka.setSvrhaPlacanja("ab");
	            lista.add(stavka); stavka=new Stavka();
	    		try {
					stavka.setDatumNaloga(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
					stavka.setDatumValute(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
		            
	    		} catch (DatatypeConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            stavka.setDuznikNalogodavac("a");
	            stavka.setPrimalacPoverilac("1");
	            stavka.setIznos(new BigDecimal(55));
	            stavka.setModelZaduzenja(3);
	            stavka.setPozivNaBrojOdobrenja("ab");
	            stavka.setRacunDuznika("ab");
	            stavka.setSmer("ab");
	            stavka.setSvrhaPlacanja("ab");
	            lista.add(stavka);
	    	
	    }
}
