
import java.util.List;

public class Game {

    private int gameID;
    private List<usermanagement.inter.User> User;
    private List<Game.inter.Round> Round;
    private Vocablist vocablist;
    private GameStatistic gameStatus;
    private List<String> gameCategory;

    public Game(int gameID, List<usermanagement.inter.User> user, List<Game.inter.Round> round, Vocablist vocablist,
                GameStatistic gameStatus, List<String> gameCategory) {
        this.gameID = gameID;
        User = user;
        Round = round;
        this.vocablist = vocablist;
        this.gameStatus = gameStatus;
        this.gameCategory = gameCategory;
    }

    private void matchUser(){

    }

    private void createRounds(){

    }

    private List<String> generateQuestionSet(){
        return null;
    }


    public int getGameID() {
        return gameID;
    }

    public List<usermanagement.inter.User> getUser() {
        return User;
    }

    public List<Game.inter.Round> getRound() {
        return Round;
    }

    public Vocablist getVocablist() {
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

    public void setRound(List<Game.inter.Round> round) {
        Round = round;
    }

    public void setVocablist(Vocablist vocablist) {
        this.vocablist = vocablist;
    }

    public void setGameStatus(GameStatistic gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setGameCategory(List<String> gameCategory) {
        this.gameCategory = gameCategory;
    }
}
