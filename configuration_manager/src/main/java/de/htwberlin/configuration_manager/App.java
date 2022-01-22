package de.htwberlin.configuration_manager;

import de.htwberlin.game_ui.inter.GameUiController;
import de.htwberlin.usermanagement.inter.InvalidUserException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.naming.InvalidNameException;
import java.io.IOException;

@Component
public class App {

    private static ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("de.htwberlin");

    public static void main(String[] args) throws IOException, InvalidNameException, de.htwberlin.vocabmanagement.inter.InvalidNameException, InvalidUserException {
        GameUiController ui = context.getBean(GameUiController.class);
        ui.run();

    }

}
