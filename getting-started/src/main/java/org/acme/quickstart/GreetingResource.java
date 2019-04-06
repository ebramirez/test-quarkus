package org.acme.quickstart;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
}