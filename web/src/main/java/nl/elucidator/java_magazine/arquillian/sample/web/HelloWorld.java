package nl.elucidator.java_magazine.arquillian.sample.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Class HelloWorld.
 */
public class HelloWorld {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("name") final String name) {
        return "Hello " + name;
    }
}
