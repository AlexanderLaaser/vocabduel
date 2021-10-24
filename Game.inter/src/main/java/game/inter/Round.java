package game.inter;

import java.util.List;

public class Round {

    private int roundID;
    private Game game;
    private List<String> vocabSet;
    private int roundNumber;
    private int winningUser;

    public Round(int roundID, Game game, List<String> vocabSet,
                 int roundNumber, int winningUser) {
        this.roundID = roundID;
        this.game = game;
        this.vocabSet = vocabSet;
        this.roundNumber = roundNumber;
        this.winningUser = winningUser;
    }

    private void askGuess(){

    }


    public int getRoundID() {
        return roundID;
    }

    public Game getGame() {
        return game;
    }

    public List<String> getVocabSet() {
        return vocabSet;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getWinningUser() {
        return winningUser;
    }

    public void setRoundID(int roundID) {
        this.roundID = roundID;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setVocabSet(List<String> vocabSet) {
        this.vocabSet = vocabSet;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void setWinningUser(int winningUser) {
        this.winningUser = winningUser;
    }
}
