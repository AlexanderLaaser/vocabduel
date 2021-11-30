package de.htwberlin.game.inter;

import de.htwberlin.usermanagement.inter.User;
import de.htwberlin.vocabmanagement.inter.Category;
import de.htwberlin.vocabmanagement.inter.VocabList;

import java.util.HashSet;
import java.util.Set;

public class Game {

    private int gameID;
    private User GameOwner;
    private User GamePartner;
    private VocabList vocablist;
    private GameStatistic gameStatistic;
    private Category gameCategory;
    private Set<Round> rounds;

    public Game(int gameID, User gameOwner, User gamePartner, VocabList vocablist) {
        this.gameID = gameID;
        GameOwner = gameOwner;
        GamePartner = gamePartner;
        this.vocablist = vocablist;
        if (this.rounds == null) {
            this.rounds = new HashSet<Round>();
        }

    }
    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public User getGameOwner() {
        return GameOwner;
    }

    public void setGameOwner(User gameOwner) {
        GameOwner = gameOwner;
    }

    public User getGamePartner() {
        return GamePartner;
    }

    public void setGamePartner(User gamePartner) {
        GamePartner = gamePartner;
    }

    public VocabList getVocablist() {
        return vocablist;
    }

    public void setVocablist(VocabList vocablist) {
        this.vocablist = vocablist;
    }

    public GameStatistic getGameStatistic() {
        return gameStatistic;
    }

    public void setGameStatistic(GameStatistic gameStatistic) {
        this.gameStatistic = gameStatistic;
    }

    public Category getGameCategory() {
        return gameCategory;
    }

    public void setGameCategory(Category gameCategory) {
        this.gameCategory = gameCategory;
    }

    public Set<Round> getRounds() {
        return rounds;
    }

    public void setRounds(Set<Round> rounds) {
        this.rounds = rounds;
    }

}
