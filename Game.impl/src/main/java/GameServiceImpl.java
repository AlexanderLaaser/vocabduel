import game.inter.Game;
import game.inter.GameService;
import usermanagement.inter.User;
import vocabmanagement.inter.VocabList;


import java.util.List;

public class GameServiceImpl implements GameService {

    //Aks the User for the Category and the Language and the List
    @Override
    public void chooseCategoryLanguageList(){

    }

    //create a Game with 2 User and VocabList

    @Override
    public Game createGame(User user1, User user2, VocabList vocablist) {
        // wird im weiteren Verlauf ein Game zurückgeben
        return null;
    }

    //find 2 user and match them for a game
    @Override
    public List<User> matchUser(){
        List<User> userList = null;
        userList.add(new User());
        userList.add(new User());

        return userList;
    }

    //generate the Vocabluary for the Rounds
    @Override
    public VocabList generateCustomVocabSet(VocabList vocablist){


        return vocablist;
    }

    @Override
    public void InitRounds(){

    }

    @Override
    public void calcualteTotalWinner(){

    }


}
