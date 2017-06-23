package com.firma.converters;

import com.firma.models.domain.StavkaDTO;
import com.firma.models.faktura.Faktura.Stavka;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class StavkaConverter {

	private final static MapperFacade mapper;

	static {
		final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.classMap(StavkaDTO.class, Stavka.class).field("redniBroj", "redniBroj")
				.field("nazivRobeIliUsluge", "nazivRobeIliUsluge").field("kolicina", "kolicina")
				.field("jedinicaMere", "jedinicaMere").field("jedinicnaCena", "jedinicnaCena")
				.field("vrednost", "vrednost").field("procenatRabata", "procenatRabata")
				.field("iznosRabata", "iznosRabata").field("umanjenoZaRabat", "umanjenoZaRabat")
				.field("ukupanPorez", "ukupanPorez").byDefault().register();
		mapper = mapperFactory.getMapperFacade();
	}

	public StavkaConverter() {
	}

	public Stavka copyStavkaFromStavkaDTO(final StavkaDTO stavkaClass) {
		Stavka stavka = mapper.map(stavkaClass, Stavka.class);
		return stavka;
	}

	public StavkaDTO copyStavkaDTOFromStavka(final Stavka stavka) {
		StavkaDTO stavkaClass = mapper.map(stavka, StavkaDTO.class);
		return stavkaClass;
	}

}
