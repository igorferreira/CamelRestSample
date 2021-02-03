package com.github.igorferreira.camelrestsample;


import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfiguration extends RouteBuilder {

    @Value("${server.port:8080}")
    private int portNum;

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("servlet")
                .port(portNum)
                .bindingMode(RestBindingMode.json)
                .apiContextPath("swagger")
                .apiVendorExtension(true)
                .apiProperty("api.title", "User API")
                .apiProperty("api.version", "1.0.0")
                .apiProperty("cors", "true");

    }
}



