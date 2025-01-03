package cc.k3521004.orchestratorserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrchestratorServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrchestratorServerApplication.class, args);
    }

}
