package game.inter;

import usermanagement.inter.User;

public class Guess {

    private User user;
    private Game game;
    private Round round;
    private int guess;

    public Guess(User user, Game game, Round round, int guess) {
        this.user = user;
        this.game = game;
        this.round = round;
        this.guess = guess;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }
}
