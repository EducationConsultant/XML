package com.firma;




import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.firma.models.nalogzaprenos.NalogZaPrenos;
import com.firma.models.nalogzaprenos.NalogZaPrenosIzvedeno;
import com.firma.repository.FirmaRepository;

@EnableJpaRepositories(basePackageClasses=FirmaRepository.class)
@EnableAutoConfiguration
@SpringBootApplication
//@ComponentScan
//@EnableAutoConfiguration

//@Configuration
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class Application {

	
	public static void main(String[] args) throws DatatypeConfigurationException {
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

		    //map source: p1Domain to target:p1Dto using "dozer-bean-mappings.xml" map-id: person
		    mapper.map(p1Domain, p1Dto, "person");

		    System.err.println("after mapping with dozer: p1Dto = " + p1Dto);
		
		
		
		
		SpringApplication.run(Application.class, args);
	}
}


