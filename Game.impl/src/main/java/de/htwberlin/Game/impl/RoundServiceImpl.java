package de.htwberlin.Game.impl;

import de.htwberlin.game.inter.Game;
import de.htwberlin.game.inter.Round;
import de.htwberlin.game.inter.RoundService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RoundServiceImpl implements RoundService {

    //calculates the Winner of the Round and gives back a Integer
    //0=tie 1= User1 wins 2= User2 wins
    @Override
    public int calculateRoundResults(Round round){
        return 0;
    }

    @Override
    public Game createRound(int roundId, Game game, Map vocabSet){
        Round round = new Round(roundId, game, vocabSet);

        return game;


    }

    @Override
    public void initNextQuestion(Round round){

    }
}
