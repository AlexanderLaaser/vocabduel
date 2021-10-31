package game.inter;

import game.inter.Game;
import usermanagement.inter.InvalidUserException;
import usermanagement.inter.User;
import vocabmanagement.inter.Category;
import vocabmanagement.inter.VocabList;

import java.util.List;

public interface GameService {

    /**
     *
     * @param userId1
     * @param userId2
     * @param vocabListId
     * @return
     * @throws InvalidUserException
     */
    //create a Game with 2 existing Users and one VocabList
    Game createGame(int userId1, int userId2, int vocabListId) throws InvalidUserException;

    /**
     *
     * @param RoundId
     * @param AnzahlRunden
     * @param game
     * @return
     */
    Round InitRounds(int RoundId, int AnzahlRunden, Game game);

    /**
     *
     */
    void calculateTotalWinner();

    /**
     *
     * @param categoryName
     * @return
     */
    int getVocabListByCategory(String categoryName);

    /**
     *
     * @param userId1
     * @param userId2
     * @throws InvalidUserException
     */
    //Checkt ob 2 User gleich sind oder nicht
    public void validateUserMatch(int userId1,int userId2) throws InvalidUserException;

    /**
     *
     * @param userId
     */
    public void UpdateUserDataAfterGame(int userId);

    /**
     *
     * @param winningUserIdRound1
     * @param winningUserIdRound2
     * @param winningUserIdRound3
     * @return
     */
    int calcualteTotalWinner(int winningUserIdRound1, int winningUserIdRound2, int winningUserIdRound3);
}
