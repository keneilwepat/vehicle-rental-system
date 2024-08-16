package za.co.protogen.gateawayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDiscoveryClient
public class GateawayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateawayServiceApplication.class, args);
    }

}
