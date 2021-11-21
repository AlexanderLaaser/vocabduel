package de.htwberlin.game_ui.inter;

import javax.naming.InvalidNameException;
import java.io.IOException;

public interface GameUiController {

    void run() throws IOException, InvalidNameException, de.htwberlin.vocabmanagement.inter.InvalidNameException;
}
