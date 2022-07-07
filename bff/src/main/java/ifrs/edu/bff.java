package ifrs.edu;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/")
public class bff {
    //Rest Client
    @Inject
    @RestClient
    ClientSomething backend;
    
    //JWT
    @Inject
    @Claim(standard = Claims.full_name)
    String fullname;
    
    @RolesAllowed({ "Admin" })
    @Path("/{km}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Double kmToMeter(@PathParam("km") Double km) {
        return backend.paraMetros(km);
    }
}
