package com.mbdev.depost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DepositApplication {
    public static void main(String[] args) {
        SpringApplication.run(DepositApplication.class, args);

    }
}
