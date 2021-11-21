package de.htwberlin.game.inter;

import de.htwberlin.usermanagement.inter.User;

import java.util.Map;

public class Round {

    private int roundID;
    private Game game;
    private Map vocabSet;
    private int roundNumber;
    private User winningUser;

    public Round(int roundID, Game game, Map vocabSet) {
        this.roundID = roundID;
        this.game = game;
        this.vocabSet = vocabSet;
    }

    public Round(int roundID, Map vocabSet) {
        this.roundID = roundID;
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

    public User getWinningUser() {
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

    public void setWinningUser(User winningUser) {
        this.winningUser = winningUser;
    }

    public Map getVocabSet() {
        return vocabSet;
    }

    public void setVocabSet(Map vocabSet) {
        this.vocabSet = vocabSet;
    }
}
