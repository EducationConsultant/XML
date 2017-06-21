package com.firma.models.faktura;

import com.firma.models.faktura.Faktura.Stavka;
import com.firma.models.faktura.FakturaClass.StavkaClass;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class StavkaConverter {

	private final static MapperFacade mapper;
	
	static {
		final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.classMap(StavkaClass.class, Stavka.class)
				.field("redniBroj", "redniBroj")
				.field("nazivRobeIliUsluge", "nazivRobeIliUsluge")
				.field("kolicina", "kolicina")
				.field("jedinicaMere", "jedinicaMere")
				.field("jedinicnaCena", "jedinicnaCena")
				.field("vrednost", "vrednost")
				.field("procenatRabata", "procenatRabata")
				.field("iznosRabata", "iznosRabata")
				.field("umanjenoZaRabat", "umanjenoZaRabat")
				.field("ukupanPorez", "ukupanPorez")
				.byDefault().register();
		mapper = mapperFactory.getMapperFacade();
	}

	
	
	public StavkaConverter() {}
	
	public Stavka copyStavkaFromStavkaClass(final StavkaClass stavkaClass) {
		Stavka stavka = mapper.map(stavkaClass, Stavka.class);
		return stavka;
	}

	public StavkaClass copyStavkaClassFromStavka(final Stavka stavka) {
		StavkaClass stavkaClass = mapper.map(stavka, StavkaClass.class);
		return stavkaClass;
	}
	
}
