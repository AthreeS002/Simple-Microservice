package cc.k3521004.servicediscservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer

public class ServiceDiscServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDiscServiceApplication.class, args);
    }

}
