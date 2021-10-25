package game.inter;
import usermanagement.inter.User;

public class GameStatistic {

    private int gameID;
    private String username;
    private User gameWinner;
    private int wins;
    private int losses;
    private int ties;

    public GameStatistic(int gameID, String username, User gameWinner,
                         int wins, int losses, int ties) {
        this.gameID = gameID;
        this.username = username;
        this.gameWinner = gameWinner;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
    }

    private void createStatistic(){

    }
    //return Statistic???
    private void getStatistic() {

    }


    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User getGameWinner() {
        return gameWinner;
    }

    public void setGameWinner(User gameWinner) {
        this.gameWinner = gameWinner;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }
}
