package com.rayes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Collections;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootRandomSequencesApp {
    public static void main(String[] args) {
        SpringApplication application =new SpringApplication(SpringBootRandomSequencesApp.class);
        application.setDefaultProperties(Collections.singletonMap("server.port", "8088"));
        application.run(args);
    }
}
