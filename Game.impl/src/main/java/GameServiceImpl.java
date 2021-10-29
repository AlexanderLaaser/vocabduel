import usermanagement.inter.User;
import vocabmanagement.inter.VocabList;


import java.util.List;

public class GameServiceImpl implements GameService {


    //create a Game with 2 User and VocabList
    @Override
    public void createGame(User user1, User user2, VocabList vocablist){
        System.out.println("User created");

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


}
