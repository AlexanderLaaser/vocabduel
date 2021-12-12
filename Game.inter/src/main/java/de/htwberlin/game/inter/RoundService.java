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

    /**
     * speichern einer Runde
     * @param round
     */
    void saveRound(Round round);

    /**
     * updaten einer Runde
     * @param round
     */
    void updateRound(Round round);

    /**
     * mischt die Antworten eines vocabSets für die Ausgabe auf der Gui, damit nicht immer die erste Antwort richtig ist.
     * @param vocabSet
     * @return
     */
    List<String> mixAnswers(List<String> vocabSet);
}
