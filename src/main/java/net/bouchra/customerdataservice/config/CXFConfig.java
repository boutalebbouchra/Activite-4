package net.bouchra.customerdataservice.config;

import lombok.AllArgsConstructor;
import net.bouchra.customerdataservice.web.CustomerSoapController;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class CXFConfig {

    private Bus bus;
    private CustomerSoapController customerSoapController;

    @Bean
    public EndpointImpl endpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, customerSoapController);
        endpoint.publish("/CustomerService");
        return endpoint;
    }
}
