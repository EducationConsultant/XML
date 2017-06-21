package com.firma.models.faktura;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class FakturaConverter {

	private final static MapperFacade mapper;

	static {
		final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.classMap(FakturaClass.class, Faktura.class).field("idPoruke", "IDPoruke")
				.field("nazivDobavljaca", "nazivDobavljaca").field("adresaDobavljaca", "adresaDobavljaca")
				.field("pibDobavljaca", "PIBDobavljaca").field("nazivKupca", "nazivKupca")
				.field("adresaKupca", "adresaKupca").field("pibKupca", "PIBKupca").field("brojRacuna", "brojRacuna")
				.field("datumRacuna", "datumRacuna").field("vrednostRobe", "vrednostRobe")
				.field("vrednostUsluga", "vrednostUsluga").field("ukupnoRobaIUsluge", "ukupnoRobaIUsluge")
				.field("ukupanRabat", "ukupanRabat").field("ukupanPorez", "ukupanPorez")
				.field("oznakaValute", "oznakaValute").field("iznosZaUplatu", "iznosZaUplatu")
				.field("uplataNaRacun", "uplataNaRacun").field("datumValute", "datumValute").byDefault().register();
		mapper = mapperFactory.getMapperFacade();
	}

	public FakturaConverter() {
	}

	public Faktura copyFakturaFromFakturaClass(final FakturaClass fakturaClass) {
		Faktura faktura = mapper.map(fakturaClass, Faktura.class);
		return faktura;
	}

	public FakturaClass copyFakturaClassFromFaktura(final Faktura faktura) {
		FakturaClass fakturaClass = mapper.map(faktura, FakturaClass.class);
		return fakturaClass;
	}

}
