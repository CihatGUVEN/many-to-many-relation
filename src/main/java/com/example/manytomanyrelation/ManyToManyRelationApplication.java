package com.example.manytomanyrelation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class ManyToManyRelationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManyToManyRelationApplication.class, args);
    }

}
