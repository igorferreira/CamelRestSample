package com.github.igorferreira.camelrestsample;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class TodosRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:todos").routeId("todos")
	        .to("http://jsonplaceholder.typicode.com/todos?bridgeEndpoint=true")
	        .unmarshal()
	        .json(true)
	        .log(">>> response: ${body}");


    }
}
