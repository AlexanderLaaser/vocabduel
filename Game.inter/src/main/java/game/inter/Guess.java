package game.inter;

public class Guess {

    private Long userID;
    private Long gameID;
    private Long roundID;
    private int guess;

    public Guess(Long userID, Long gameID, Long roundID, int guess) {
        this.userID = userID;
        this.gameID = gameID;
        this.roundID = roundID;
        this.guess = guess;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getGameID() {
        return gameID;
    }

    public void setGameID(Long gameID) {
        this.gameID = gameID;
    }

    public Long getRoundID() {
        return roundID;
    }

    public void setRoundID(Long roundID) {
        this.roundID = roundID;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }
}
