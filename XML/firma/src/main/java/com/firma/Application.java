package com.firma;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.firma.models.faktura.Zaglavlje;
import com.firma.models.faktura.ZaglavljeClass;
import com.firma.models.faktura.ZaglavljeConverter;
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

		GregorianCalendar gcal = new GregorianCalendar();
		XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		System.err.println(xgcal);
		zaglavlje.setDatumRacuna(xgcal);

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
		zaglavlje.setDatumValute(xgcal);

		// map source: p1Domain to target:p1Dto using orika
		ZaglavljeClass zaglavljeClass = zaglavljeConverter.copyZaglavljeClassFromZaglavlje(zaglavlje);

		System.out.println("after mapping with orika: p1Dto = " + zaglavljeClass);

		SpringApplication.run(Application.class, args);
	}
}
