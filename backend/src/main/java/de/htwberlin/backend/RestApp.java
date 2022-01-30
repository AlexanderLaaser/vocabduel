package de.htwberlin.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"de.htwberlin.vocabmanagement.controller","de.htwberlin.vocabmanagement.impl", "de.htwberlin.backend","de.htwberlin.game_ui.inter","de.htwberlin.game_ui.impl","de.htwberlin.game.inter","de.htwberlin.Game.impl","de.htwberlin.usermanagement.inter","de.htwberlin.usermanagement.impl"})
public class RestApp {

    public static void main(String[] args) {
        SpringApplication.run(RestApp.class, args);
    }

}
