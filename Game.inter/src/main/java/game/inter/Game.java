package game.inter;
import usermanagement.inter.User;

import java.util.List;

public class Game {

    private int gameID;
    private List<User> User;
    private List<Round> Round;
    private List<String> vocablist;
    private GameStatistic gameStatus;
    private List<String> gameCategory;

    public Game(int gameID, List<usermanagement.inter.User> user, List<game.inter.Round> round, List<String> vocablist, GameStatistic gameStatus, List<String> gameCategory) {
        this.gameID = gameID;
        User = user;
        Round = round;
        this.vocablist = vocablist;
        this.gameStatus = gameStatus;
        this.gameCategory = gameCategory;
    }

    public int getGameID() {
        return gameID;
    }

    public List<usermanagement.inter.User> getUser() {
        return User;
    }

    public List<game.inter.Round> getRound() {
        return Round;
    }

    public List<String> getVocablist() {
        return vocablist;
    }

    public GameStatistic getGameStatus() {
        return gameStatus;
    }

    public List<String> getGameCategory() {
        return gameCategory;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public void setUser(List<usermanagement.inter.User> user) {
        User = user;
    }

    public void setRound(List<game.inter.Round> round) {
        Round = round;
    }

    public void setVocablist(List<String> vocablist) {
        this.vocablist = vocablist;
    }

    public void setGameStatus(GameStatistic gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setGameCategory(List<String> gameCategory) {
        this.gameCategory = gameCategory;
    }
}
