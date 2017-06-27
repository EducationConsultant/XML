package com.firma;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.firma.converters.FakturaConverter;
import com.firma.converters.StavkaConverter;
import com.firma.models.domain.FakturaDTO;
import com.firma.models.domain.Firma;
import com.firma.models.domain.NalogZaPrenosDTO;
import com.firma.models.domain.StavkaDTO;
import com.firma.models.faktura.Faktura;
import com.firma.models.faktura.Faktura.Stavka;
import com.firma.models.nalogzaprenos.NalogZaPrenos;
import com.firma.repository.FirmaRepository;

@EnableJpaRepositories(basePackageClasses = FirmaRepository.class)
// @ComponentScan("com.firma.repository")
@EnableAutoConfiguration
@SpringBootApplication
// @ComponentScan
// @EnableAutoConfiguration

// @Configuration
// @EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class Application {

	public static void main(String[] args) throws DatatypeConfigurationException {
		FakturaConverter fakturaConverter = new FakturaConverter();
		Faktura faktura = createFaktura();
		FakturaDTO fakturaClass = fakturaConverter.copyFakturaClassFromFaktura(faktura);
		System.out.println("after mapping with orika: p1Dto = " + fakturaClass);

		Stavka stavka = createStavka();
		StavkaConverter stavkaConverter = new StavkaConverter();
		StavkaDTO stavkaClass = stavkaConverter.copyStavkaDTOFromStavka(stavka);
		System.out.println("after mapping with orika: p1Dto = " + stavkaClass);

		List<String> list = new ArrayList<String>();
		// Add the mapping configuration
		list.add("dozer-bean-mappings.xml");
		// Add to DozerMapper
		Mapper mapper = new DozerBeanMapper(list);

		GregorianCalendar gcal = new GregorianCalendar();
		XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		System.err.println("datum" + xgcal);

		NalogZaPrenos p1Domain = new NalogZaPrenos();
		p1Domain.setDatumNaloga(xgcal);
		p1Domain.setDatumValute(xgcal);
		p1Domain.setDuznikNalogodavac("c");
		p1Domain.setHitno(false);
		p1Domain.setIDPoruke(new Long(4));
		p1Domain.setIznos(new BigDecimal(200));
		p1Domain.setModelOdobrenja(22);
		p1Domain.setModelZaduzenja(22);
		p1Domain.setOznakaValute("DIN");
		p1Domain.setPozivNaBrojOdobrenja("asa");
		p1Domain.setPozivNaBrojZaduzenja("as");
		p1Domain.setPrimalacPoverilac("12");
		p1Domain.setRacunDuznika("123456789987654123");
		p1Domain.setRacunPoverioca("987456321789654123");
		p1Domain.setSvrhaPlacanja("lepo");

		NalogZaPrenosDTO p1Dto = new NalogZaPrenosDTO();

		System.err.println("before mapping with dozer: p1Dto = " + p1Dto);

		// map source: p1Domain to target:p1Dto using "dozer-bean-mappings.xml"
		// map-id: person
		//mapper.map(p1Domain, p1Dto, "person");

		System.err.println("after mapping with dozer: p1Dto = " + p1Dto);

		SpringApplication.run(Application.class, args);
	}

	private static Faktura createFaktura() throws DatatypeConfigurationException {
		Faktura faktura = new Faktura();
		faktura.setIDPoruke(new Long(1));
		faktura.setNazivDobavljaca("Dobavljac1");
		faktura.setAdresaDobavljaca("Mite Ruzica 10");
		faktura.setPIBDobavljaca("12345678");

		faktura.setNazivKupca("Kupac1");
		faktura.setAdresaKupca("Adresa kupca 1");
		faktura.setPIBKupca("12354678");

		faktura.setBrojRacuna(123456);

		GregorianCalendar gcalZ = new GregorianCalendar();
		XMLGregorianCalendar xgcalZ = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcalZ);
		System.err.println(xgcalZ);
		faktura.setDatumRacuna(xgcalZ);

		BigDecimal vrednostRobe = new BigDecimal("1115.37");
		faktura.setVrednostRobe(vrednostRobe);

		BigDecimal vrednostUsluga = new BigDecimal("55555");
		faktura.setVrednostUsluga(vrednostUsluga);

		BigDecimal ukupnoRobaIUsluga = vrednostRobe.add(vrednostUsluga);
		faktura.setUkupnoRobaIUsluge(ukupnoRobaIUsluga);

		BigDecimal ukupnoRabat = new BigDecimal("469553");
		faktura.setUkupanRabat(ukupnoRabat);

		BigDecimal ukupanPorez = new BigDecimal("11111");
		faktura.setUkupanPorez(ukupanPorez);

		faktura.setOznakaValute("DIN");

		BigDecimal iznosZaUplatu = new BigDecimal("2222");
		faktura.setIznosZaUplatu(iznosZaUplatu);

		faktura.setUplataNaRacun("12345687913");
		faktura.setDatumValute(xgcalZ);

		Firma firma = new Firma();
		firma.setAdresa("Adresica 9");
		firma.setBrojRacuna("121212");
		firma.setId(new Long(99));
		firma.setNaziv("Extra");
		firma.setPib("87965412");
		//faktura.setFirma(firma);
		
		
		return faktura;
	}

	private static Stavka createStavka() {
		Stavka stavka = new Stavka();

		stavka.setRedniBroj(new Long(1));
		stavka.setNazivRobeIliUsluge("naziv robe");
		stavka.setIznosRabata(new BigDecimal(123));
		stavka.setJedinicaMere("aaaaaa");
		stavka.setJedinicnaCena(new BigDecimal(200));
		stavka.setVrednost(new BigDecimal(90));
		stavka.setKolicina(new BigDecimal(89));
		stavka.setProcenatRabata(new BigDecimal(45));
		stavka.setUmanjenoZaRabat(new BigDecimal(90));
		stavka.setUkupanPorez(new BigDecimal(89));

		return stavka;
	}
}
