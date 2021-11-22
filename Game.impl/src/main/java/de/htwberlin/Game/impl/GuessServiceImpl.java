package de.htwberlin.Game.impl;

import de.htwberlin.game.inter.Guess;
import de.htwberlin.game.inter.GuessService;
import org.springframework.stereotype.Component;

@Component
public class GuessServiceImpl implements GuessService {

    @Override
    public Guess createGuess(Long userID, Long gameID, Long roundID){
        return null;
    }

}
