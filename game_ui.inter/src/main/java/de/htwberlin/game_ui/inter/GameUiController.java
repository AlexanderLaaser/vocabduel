package de.htwberlin.game_ui.inter;

import javax.naming.InvalidNameException;
import java.io.IOException;

public interface GameUiController {
    /**
     *
     * @throws IOException
     * @throws InvalidNameException
     * @throws de.htwberlin.vocabmanagement.inter.InvalidNameException
     * @throws de.htwberlin.usermanagement.inter.InvalidUserException
     */
    void run() throws IOException, InvalidNameException, de.htwberlin.vocabmanagement.inter.InvalidNameException, de.htwberlin.usermanagement.inter.InvalidUserException;
}
