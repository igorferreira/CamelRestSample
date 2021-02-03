package com.github.igorferreira.camelrestsample;

import javax.ws.rs.core.MediaType;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class RestRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        rest("/api/").id("api-route-test")
                .consumes(MediaType.APPLICATION_JSON)
                .produces(MediaType.APPLICATION_JSON)
                .post("/test")
                .type(Request.class)
                .to("direct:test");

        rest("/api/").id("api-route-todos")
	        	.get("/todos")
	        	.to("direct:todos");
    }
}
