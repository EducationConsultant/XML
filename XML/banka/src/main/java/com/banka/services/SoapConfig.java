package com.banka.services;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.banka.services.izvod.Izvod;
import com.banka.services.izvod.IzvodImpl;
import com.banka.services.rtgsprijem.RtgsPrijem;
import com.banka.services.rtgsprijem.RtgsPrijemImpl;

@Configuration
public class SoapConfig {
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

	    
	    @Bean
	    public RtgsPrijem RtgsPrijem_Service() {
	    	return new RtgsPrijemImpl();
	    }
	    
	    @Bean
	    public Endpoint endpoint2() {
	        EndpointImpl endpoint = new EndpointImpl(springBus(), RtgsPrijem_Service());
	        endpoint.publish("/RtgsPrijem");
	        endpoint.setWsdlLocation("../wsdl/rtgsPrijem.wsdl");
	        return endpoint;
	    }
}
