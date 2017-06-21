package com.firma;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.firma.models.faktura.Zaglavlje;
import com.firma.models.faktura.ZaglavljeClass;
import com.firma.models.faktura.ZaglavljeConverter;

import com.firma.models.nalogzaprenos.NalogZaPrenos;
import com.firma.models.nalogzaprenos.NalogZaPrenosIzvedeno;

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
		ZaglavljeConverter zaglavljeConverter = new ZaglavljeConverter();
		Zaglavlje zaglavlje = new Zaglavlje();
		zaglavlje.setIDPoruke("prvaPoruka");
		zaglavlje.setNazivDobavljaca("Dobavljac1");
		zaglavlje.setAdresaDobavljaca("Mite Ruzica 10");
		zaglavlje.setPIBDobavljaca("12345678");

		zaglavlje.setNazivKupca("Kupac1");
		zaglavlje.setAdresaKupca("Adresa kupca 1");
		zaglavlje.setPIBKupca("12354678");

		zaglavlje.setBrojRacuna(123456);

		GregorianCalendar gcalZ = new GregorianCalendar();
		XMLGregorianCalendar xgcalZ = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcalZ);
		System.err.println(xgcalZ);
		zaglavlje.setDatumRacuna(xgcalZ);

		BigDecimal vrednostRobe = new BigDecimal("1115.37");
		zaglavlje.setVrednostRobe(vrednostRobe);

		BigDecimal vrednostUsluga = new BigDecimal("55555");
		zaglavlje.setVrednostUsluga(vrednostUsluga);

		BigDecimal ukupnoRobaIUsluga = vrednostRobe.add(vrednostUsluga);
		zaglavlje.setUkupnoRobaIUsluge(ukupnoRobaIUsluga);

		BigDecimal ukupnoRabat = new BigDecimal("469553");
		zaglavlje.setUkupanRabat(ukupnoRabat);

		BigDecimal ukupanPorez = new BigDecimal("11111");
		zaglavlje.setUkupanPorez(ukupanPorez);

		zaglavlje.setOznakaValute("DIN");

		BigDecimal iznosZaUplatu = new BigDecimal("2222");
		zaglavlje.setIznosZaUplatu(iznosZaUplatu);

		zaglavlje.setUplataNaRacun("12345687913");
		zaglavlje.setDatumValute(xgcalZ);

		// map source: p1Domain to target:p1Dto using orika
		ZaglavljeClass zaglavljeClass = zaglavljeConverter.copyZaglavljeClassFromZaglavlje(zaglavlje);

		List<String> list = new ArrayList<String>();
		// Add the mapping configuration
		list.add("dozer-bean-mappings.xml");
		// Add to DozerMapper
		Mapper mapper = new DozerBeanMapper(list);

		GregorianCalendar gcal = new GregorianCalendar();
		XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		System.err.println("datum" + xgcal);

		Date date = xgcal.toGregorianCalendar().getTime();

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

		NalogZaPrenosIzvedeno p1Dto = new NalogZaPrenosIzvedeno();

		System.err.println("before mapping with dozer: p1Dto = " + p1Dto);

		// map source: p1Domain to target:p1Dto using "dozer-bean-mappings.xml"
		// map-id: person
		mapper.map(p1Domain, p1Dto, "person");

		System.err.println("after mapping with dozer: p1Dto = " + p1Dto);

		System.out.println("after mapping with orika: p1Dto = " + zaglavljeClass);

		SpringApplication.run(Application.class, args);
	}
}
