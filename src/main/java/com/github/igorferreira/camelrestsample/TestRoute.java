package com.github.igorferreira.camelrestsample;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class TestRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:test").routeId("direct-route")
        .tracing()
        .convertBodyTo(Request.class)
        .log(">>> id: ${body.id}")
        .log(">>> name: ${body.name}")
        .process( e -> {
        	Message message = e.getMessage();
        	Request req  = message.getBody(Request.class);
        	message.setBody(Response.builder()
        			.id(req.getId())
        			.mensagem("Hello " + req.getName()).build());
        	e.setMessage(message);
        })
        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
        //.setHeader(Exchange.CONTENT_TYPE,constant(MediaType.APPLICATION_JSON))
        ;
    }
}
