package de.htwberlin.game.inter;

import de.htwberlin.usermanagement.inter.User;
import de.htwberlin.vocabmanagement.inter.Category;
import de.htwberlin.vocabmanagement.inter.VocabList;

import org.springframework.stereotype.Component;

@Component
public class Game {

    private int gameID;
    private User GameOwner;
    private User GamePartner;
    private VocabList vocablist;
    private GameStatistic gameStatistic;
    private Category gameCategory;
    private Round round;

    public Game(int gameID, User gameOwner, User gamePartner, VocabList vocablist) {
        this.gameID = gameID;
        GameOwner = gameOwner;
        GamePartner = gamePartner;
        this.vocablist = vocablist;

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
}
