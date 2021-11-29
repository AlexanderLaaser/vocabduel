package game.inter;

public interface RoundService {

    /***
     * asks the User for his Answer
     * stores the Answer
     *
     */
    int askForGuess();

    //calculates the Winner of the Round and gives back a Integer

    /***
     *
     * @return Round winner as int
     * 1= tie
     * 2= User1 wins
     * 3= User2 wins
     * 3= User2 wins
     */
    int calculateRoundResults();

}
