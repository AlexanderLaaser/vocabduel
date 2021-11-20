package de.htwberlin.Game.impl;

import de.htwberlin.game.inter.Round;
import de.htwberlin.game.inter.RoundService;

public class RoundServiceImpl implements RoundService {

    //calculates the Winner of the Round and gives back a Integer
    //0=tie 1= User1 wins 2= User2 wins
    @Override
    public int calculateRoundResults(Round round){
        return 0;
    }

    @Override
    public void createRound(){

    }

    @Override
    public void initNextQuestion(Round round){

    }
}
