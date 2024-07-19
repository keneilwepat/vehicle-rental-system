package za.co.protogen.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationProperties {

    @Value("${server.port}")
    private int port;

    public int getPort() {
        return port;
    }
}
