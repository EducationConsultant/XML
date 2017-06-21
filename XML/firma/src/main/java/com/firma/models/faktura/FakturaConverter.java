//package com.firma.models.faktura;
//
//import ma.glasnost.orika.MapperFacade;
//import ma.glasnost.orika.MapperFactory;
//import ma.glasnost.orika.impl.DefaultMapperFactory;
//
//public class FakturaConverter {
//
//	private final static MapperFacade mapper;
//
//	static {
//		final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
//		mapperFactory.classMap(FakturaClass.class, Faktura.class).field("municipality", "city").byDefault().register();
//		mapper = mapperFactory.getMapperFacade();
//	}
//
//	public FakturaConverter() {
//	}
//
//	public Faktura copyFakturaFromFakturaClass(final FakturaClass fakturaClass) {
//		Faktura faktura = mapper.map(fakturaClass, Faktura.class);
//		return faktura;
//	}
//
//	public FakturaClass copyFakturaClassFromFaktura(final Faktura faktura) {
//		FakturaClass fakturaClass = mapper.map(faktura, FakturaClass.class);
//		return fakturaClass;
//	}
//
//}
