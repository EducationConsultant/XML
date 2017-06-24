package com.firma.endpoint;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.firma.services.nalogzaprenos.NalogzaprenosWrappedImpl;

@Configuration
public class EndpointConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new NalogzaprenosWrappedImpl());
        endpoint.publish("/nalogzaprenos");
        return endpoint;
    }
}