package ayou.api;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/v1/")
public class Api extends ResourceConfig {

    public Api() {
        packages("ayou.api");
    }

}

