package ifrs.edu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface ClientSomething {
    @GET
     @Path("/{km}")
     @Produces(MediaType.TEXT_PLAIN)
     public Double paraMetros(@PathParam("km") Double km);
}
