public interface RoundService {
    //asks the User for his Answer
    void askForGuess();

    //calculates the Winner of the Round and gives back a Integer
    //0=tie 1= User1 wins 2= User2 wins
    int calculateRoundResults(int winningUser);

    void createRound();
}
