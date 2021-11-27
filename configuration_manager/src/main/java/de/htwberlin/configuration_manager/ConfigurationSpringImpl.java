package de.htwberlin.configuration_manager;

import de.htwberlin.game_ui.impl.GameUiControllerImpl;
import de.htwberlin.game_ui.inter.GameUiController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.naming.InvalidNameException;
import java.io.IOException;


public class ConfigurationSpringImpl {

    private static ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("de.htwberlin");

    public static void main(String[] args) throws IOException, InvalidNameException, de.htwberlin.vocabmanagement.inter.InvalidNameException {
        GameUiController ui = context.getBean(GameUiController.class);
          ui.run();
    }

}
