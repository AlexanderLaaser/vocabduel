package de.htwberlin.game.inter;

import java.util.Map;

public interface RoundService {

    /**
     * calculates the Winner of the Round and gives back a Integer
     * 0=tie 1= User1 wins 2= User2 wins
     * @param round is the actual Round
     * @return integer contains the number of the winning Round User
     */

    int calculateRoundResults(Round round);

    Game createRound(int roundId, Game game, Map vocabSet);

    void initNextQuestion(Round round);
}
