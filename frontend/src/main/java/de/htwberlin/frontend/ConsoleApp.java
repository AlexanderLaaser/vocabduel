package de.htwberlin.frontend;

import de.htwberlin.game_ui.inter.GameUiController;
import de.htwberlin.usermanagement.inter.InvalidUserException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.naming.InvalidNameException;
import java.io.IOException;

@Component
public class ConsoleApp {

    private static ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("de.htwberlin.*");

    public static void main(String[] args) throws InvalidNameException, de.htwberlin.vocabmanagement.inter.InvalidNameException, IOException, InvalidUserException {
        GameUiController ui = context.getBean(GameUiController.class);
        ui.run();
    }
}
