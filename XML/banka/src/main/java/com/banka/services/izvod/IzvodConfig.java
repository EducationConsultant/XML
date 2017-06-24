package com.banka.services.izvod;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IzvodConfig {

	 @Bean
	    public ServletRegistrationBean cxfServlet() {
	        return new ServletRegistrationBean(new CXFServlet(), "/services/*");
	    }

	    @Bean(name = Bus.DEFAULT_BUS_ID)
	    public SpringBus springBus() {
	        return new SpringBus();
	    }    
	    
	    @Bean
	    public Izvod IzvodService() {
	    	return new IzvodImpl();
	    }
	    
	    @Bean
	    public Endpoint endpoint() {
	        EndpointImpl endpoint = new EndpointImpl(springBus(), IzvodService());
	        endpoint.publish("/Izvod");
	        endpoint.setWsdlLocation("../wsdl/izvod.wsdl");
	        return endpoint;
	    }
}
