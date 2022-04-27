package dev.alvarocar.web2_guia4;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {
  @GET
  @Produces("text/plain")
  public String hello() {
    return "Hello, World!";
  }
}