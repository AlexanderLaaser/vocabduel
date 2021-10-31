package game.inter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public interface RoundService {

    /**
     * asks the User for his Answer
     */
    void askForGuess();

    /**
     * calculates the Winner of the Round and gives back a Integer
     * 0=tie 1= User1 wins 2= User2 wins
     * @param winningUser
     * @return
     */
    int calculateRoundResults(int winningUser);
}
