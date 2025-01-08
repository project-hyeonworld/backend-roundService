package io.roundservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RoundServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoundServiceApplication.class, args);
    }

}
