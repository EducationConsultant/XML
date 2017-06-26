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
import com.banka.services.nalogzaprenos.NalogzaprenosWrapped;
import com.banka.services.nalogzaprenos.NalogzaprenosWrappedImpl;
import com.banka.services.nalogzaprenos.Nalogzaprenos_Service;
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
	    
	    @Bean
	    public NalogzaprenosWrapped nalogzaprenoswrapped() {
	    	return new NalogzaprenosWrappedImpl();  //endpoint
	    }
	    
	    @Bean
	    public Endpoint endpoint3() {
	        EndpointImpl endpoint = new EndpointImpl(springBus(), nalogzaprenoswrapped());        
	        endpoint.setServiceName(nalogzaprenos_service().getServiceName());
	        endpoint.publish("/nalogzaprenos");   // define the last part of our WebService-URI.
	        return endpoint;
	    }
	    
	    @Bean
	    public Nalogzaprenos_Service nalogzaprenos_service() {
	        return new Nalogzaprenos_Service();
	    }
}
