package org.fordsworth.StudentManagement.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

@Path("/")
public class WelcomeResource {

    @Inject
    Template welcome; // Maps to templates/welcome.html

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance renderWelcome() {
        return welcome.instance();
    }
}
