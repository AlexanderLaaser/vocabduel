package de.htwberlin.game.inter;

import java.util.ArrayList;

public interface RoundService {

    /**
     * calculates the Winner of the Round and gives back a Integer
     * 0=tie 1= User1 wins 2= User2 wins
     * @param round is the actual Round
     * @return integer contains the number of the winning Round User
     */

    void calculateRoundResults(Round round);

    Round createRound(int roundId, ArrayList vocabSet);

    void initNextQuestion(Round round);

    ArrayList<String> mixAnswers(Round round);
}
