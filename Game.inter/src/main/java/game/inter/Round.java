package game.inter;

import java.util.HashMap;
import java.util.List;

public class Round {

    private int roundID;
    private Game game;
    private HashMap vocabSet;
    private int roundNumber;
    private int winningUser;

    public Round(int roundID, Game game, HashMap vocabSet) {
        this.roundID = roundID;
        this.game = game;
        this.vocabSet = vocabSet;
    }

    public int getRoundID() {
        return roundID;
    }

    public Game getGame() {
        return game;
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

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void setWinningUser(int winningUser) {
        this.winningUser = winningUser;
    }

    public HashMap getVocabSet() {
        return vocabSet;
    }

    public void setVocabSet(HashMap vocabSet) {
        this.vocabSet = vocabSet;
    }
}
