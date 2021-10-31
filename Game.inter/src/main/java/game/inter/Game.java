package game.inter;

import usermanagement.inter.User;
import vocabmanagement.inter.Category;
import vocabmanagement.inter.VocabList;

import java.util.List;

public class Game {

    private int gameID;
    private User GameOwner;
    private User GamePartner;
    private List<Round> Round;
    private VocabList vocablist;
    private GameStatistic gameStatistic;
    private Category gameCategory;

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

    public List<game.inter.Round> getRound() {
        return Round;
    }

    public void setRound(List<game.inter.Round> round) {
        Round = round;
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
