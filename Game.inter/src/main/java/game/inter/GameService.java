package game.inter;

import game.inter.Game;
import usermanagement.inter.User;
import vocabmanagement.inter.VocabList;

import java.util.List;

public interface GameService {
    //create a Game with 2 User and VocabList
    Game createGame(User user1, User user2, VocabList vocablist);

    //find 2 user and match them for a gamee
    List<User> matchUser();

    //generate the Vocabluary for the Rounds
    VocabList generateCustomVocabSet(VocabList vocablist);

    //Aks the User for the Category and the Language and the List
    void chooseCategoryLanguageList();

    void InitRounds();

    void calcualteTotalWinner();
}
