package game.inter;

import usermanagement.inter.User;
import vocabmanagement.inter.VocabList;

import java.util.List;

/***
 *
 */
public interface GameService {

    /***create a Game with 2 User and VocabList
     *
     * @param user1
     * @param user2
     * @param vocablist
     * @return
     */
    Game createGame(User user1, User user2, VocabList vocablist);

    //find 2 user and match them for a gamee

    /***
     *
     * @return List<User>
     */
    List<User> matchUser();

    //generate the Vocabluary for the Rounds

    /***
     *
     * @param vocablist
     * @return
     */
    VocabList generateCustomVocabSet(VocabList vocablist);

    //Aks the User for the Category and the Language and the List

    /***
     *
     */
    void chooseCategoryLanguageList();

    /***
     *
     * @return
     */
    Round InitRound();

    /***
     *
     * @param userList
     * @param gameID
     * @param roundNumber
     * @return
     */
    Round InitRound(List<User> userList, int gameID, int roundNumber);


    /***
     *
     * @param winningUserRound1
     * @param winningUserRound2
     * @param winningUserRound3
     * @returnthe Game winner as integer
     *      * 0= tie
     *      * 1= User1 wins
     *      * 2= User2 wins
     */
    int calcualteTotalWinner(int winningUserRound1, int winningUserRound2, int winningUserRound3);
}
