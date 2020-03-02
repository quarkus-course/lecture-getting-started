package tech.donau.course;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import tech.donau.course.data.Crypto;
import tech.donau.course.service.CryptoService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("crypto")
public class CurrencyResource {

    @Inject
    @RestClient
    CryptoService cryptoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Crypto> getCryptoInfo(@QueryParam("id") String id) {
        return cryptoService.getCurrencyInfo(id);
    }
}
