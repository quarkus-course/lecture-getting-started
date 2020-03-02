package tech.donau.course.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import tech.donau.course.data.Crypto;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.Collection;

@Path("api")
@ApplicationScoped
@RegisterRestClient(configKey = "crypto_api")
public interface CryptoService {

    @GET
    @Path("/ticker")
    public Collection<Crypto> getCurrencyInfo(@QueryParam("id") String id);

}
