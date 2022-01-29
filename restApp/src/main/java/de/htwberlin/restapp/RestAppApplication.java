package de.htwberlin.restapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"de.*"})
@ComponentScan(basePackages = {"de.htwberlin.vocabmanagement.controller","de.htwberlin.vocabmanagement.impl","de.htwberlin.restapp"})
public class RestAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestAppApplication.class, args);
    }

}
