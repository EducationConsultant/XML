package com.firma.converters;

import com.firma.models.domain.FakturaDTO;
import com.firma.models.faktura.Faktura;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class FakturaConverter {

	private final static MapperFacade mapper;

	static {
		final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.classMap(FakturaDTO.class, Faktura.class).field("idPoruke", "IDPoruke")
				.field("nazivDobavljaca", "nazivDobavljaca").field("adresaDobavljaca", "adresaDobavljaca")
				.field("pibDobavljaca", "PIBDobavljaca").field("nazivKupca", "nazivKupca")
				.field("adresaKupca", "adresaKupca").field("pibKupca", "PIBKupca").field("brojRacuna", "brojRacuna")
				.field("datumRacuna", "datumRacuna").field("vrednostRobe", "vrednostRobe")
				.field("vrednostUsluga", "vrednostUsluga").field("ukupnoRobaIUsluge", "ukupnoRobaIUsluge")
				.field("ukupanRabat", "ukupanRabat").field("ukupanPorez", "ukupanPorez")
				.field("oznakaValute", "oznakaValute").field("iznosZaUplatu", "iznosZaUplatu")
				.field("uplataNaRacun", "uplataNaRacun").field("datumValute", "datumValute")
				//.field("firma", "firma")
				.field("stavka{}", "stavka{}").byDefault().register();
		mapper = mapperFactory.getMapperFacade();
	}

	public FakturaConverter() {
	}

	public Faktura copyFakturaFromFakturaClass(final FakturaDTO fakturaClass) {
		Faktura faktura = mapper.map(fakturaClass, Faktura.class);
		return faktura;
	}

	public FakturaDTO copyFakturaClassFromFaktura(final Faktura faktura) {
		FakturaDTO fakturaClass = mapper.map(faktura, FakturaDTO.class);
		return fakturaClass;
	}

}
