package cat.aoc.dcoc.cocref.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cat.aoc.dcoc.cocref.service.DCOCService;
import jakarta.xml.ws.Endpoint;

@Configuration
public class WebServiceConfiguration {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new DCOCService());
        endpoint.publish("/dcoc");
        return endpoint;
    }
}