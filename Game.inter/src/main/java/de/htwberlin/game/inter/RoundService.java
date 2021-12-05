package de.htwberlin.game.inter;

import org.springframework.transaction.TransactionStatus;

import java.util.ArrayList;
import java.util.List;

public interface RoundService {

    /**
     * calculates the Winner of the Round and gives back a Integer
     * 0=tie 1= User1 wins 2= User2 wins
     * @param round is the actual Round
     * @return integer contains the number of the winning Round User
     */

    void calculateRoundResults(Round round);

    Round createRound(int roundId, ArrayList vocabSet);
    void saveRound(Round round);

    void initNextQuestion(Round round);

    List<String> mixAnswers(Round round);
}
