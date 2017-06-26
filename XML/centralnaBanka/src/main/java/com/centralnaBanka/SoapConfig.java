package com.centralnaBanka;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.centralnaBanka.services.rtgs.Rtgs;
import com.centralnaBanka.services.rtgs.RtgsImpl;

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
    public Rtgs RtgsService() {
    	return new RtgsImpl();
    }
    
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), RtgsService());
        endpoint.publish("/Rtgs");
        
        endpoint.setWsdlLocation("../wsdl/rtgs.wsdl");
        return endpoint;
    }
}
