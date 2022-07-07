package ifrs.edu;

import java.util.Arrays;
import java.util.HashSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;

@Path("/")
public class auth {

    @Path("/auth")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String name() {
        return Jwt.issuer("http://localhost:8080")
        .upn("ratomorto@riseup.net")
        .groups(new HashSet<>(Arrays.asList("Admin")))
        .claim(Claims.full_name, "Robert Silveira")
        .sign();        
    }
}
