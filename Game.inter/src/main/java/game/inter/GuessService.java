package game.inter;

public interface GuessService {

    /***creates a Guess of User per Round
     *
     * @param userID
     * @param gameID
     * @param roundID
     * @return Guess from a user for a specific Round for a game
     */
    Guess createGuess(Long userID, Long gameID, Long roundID);
}
