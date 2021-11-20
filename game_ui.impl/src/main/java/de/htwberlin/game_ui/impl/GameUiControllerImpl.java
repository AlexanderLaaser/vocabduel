package de.htwberlin.game_ui.impl;

import de.htwberlin.game_ui.inter.GameUiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GameUiControllerImpl implements GameUiController {

    private GameUiView gameUiView;

    public GameUiControllerImpl() {
        super();
    }

    // bedeutet das temporär ein Instanz der Klasse GameUiView erstellt wird
    @Autowired
    public GameUiControllerImpl(GameUiView gameuiView) {
        super();
        this.gameUiView = gameuiView;
    }

    public void setGameView(GameUiView gameView) {
        this.gameUiView = gameView;
    }

    @Override
    public void run() {
        gameUiView.printWelcome();
    }
}
