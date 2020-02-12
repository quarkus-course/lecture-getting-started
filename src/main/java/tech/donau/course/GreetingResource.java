package tech.donau.course;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/hello")
public class GreetingResource {

    public static final String TOKEN = "dev";

    @GET
    @Path("/html")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello " + UUID.randomUUID().toString();
    }

    @GET
    @Path("/html/{id}/details")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("id") String id) {
        return "hello "+ id;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addHello(@HeaderParam("token") String hName, @QueryParam("token") String aName) {
        String token = hName != null ? hName : aName;
        if (!TOKEN.equals(token)) {
            throw new RuntimeException("Unauthorized");
        }
        return "<b>Text</b>";
    }

}