package com.firma.endpoint;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.firma.models.nalogzaprenos.NalogZaPrenos;
import com.firma.services.nalogzaprenos.NalogzaprenosWrapped;
import com.firma.services.nalogzaprenos.NalogzaprenosWrappedImpl;
import com.firma.services.nalogzaprenos.Nalogzaprenos_Service;

@Configuration
public class NalogzaprenosEndpointConfig {

	
    @Bean
    public ServletRegistrationBean cxfServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/services/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }
    
    
    @Bean
    public NalogzaprenosWrapped nalogzaprenoswrapped() {
    	return new NalogzaprenosWrappedImpl();  //endpoint
    }
    
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), nalogzaprenoswrapped());        
        endpoint.setServiceName(nalogzaprenos_service().getServiceName());
        //System.err.println("lokacija wsdla:" + nalogzaprenos_service().getWSDLDocumentLocation().toString());
        //endpoint.setWsdlLocation(nalogzaprenos_service().getWSDLDocumentLocation().toString());
       // endpoint.setWsdlLocation("../wsdl/nalogzaprenos.wsdl");
        endpoint.publish("/nalogzaprenos");   // define the last part of our WebService-URI.
        return endpoint;
    }
    
    @Bean
    public Nalogzaprenos_Service nalogzaprenos_service() {
        return new Nalogzaprenos_Service();
    }

}