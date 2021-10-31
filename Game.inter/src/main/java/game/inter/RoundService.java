package game.inter;

public interface RoundService {

    /**
     * asks the User for his Answer
     * @return an integer contains the answer of the user
     */
    int askForGuess();

    /**
     * calculates the Winner of the Round and gives back a Integer
     * 0=tie 1= User1 wins 2= User2 wins
     * @param winningUser is the winning user of the round
     * @return integer contains the number of the winning Round User
     */
    int calculateRoundResults(int winningUser);

    //calculates the Winner of the Round and gives back a Integer
    //0=tie 1= User1 wins 2= User2 wins
    int calculateRoundResults();

    void createRound();
}
