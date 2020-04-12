package tech.donau.course;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        info = @Info(
                title = "Getting Started API",
                description = "Our test API description",
                version = "1.2"
        ),
        servers = @Server(
                url = "dev.donau.tech"
        )
)
public class QuarkusApplication extends Application {
}
