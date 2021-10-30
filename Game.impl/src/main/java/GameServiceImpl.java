import game.inter.Game;
import game.inter.GameService;
import game.inter.Round;
import usermanagement.inter.User;
import vocabmanagement.inter.VocabList;


import java.util.List;

public class GameServiceImpl implements GameService {

    //Aks the User for the Category and the Language and the List
    @Override
    public void chooseCategoryLanguageList(){

    }

    @Override
    public Round InitRound() {
        return null;
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
    public Round InitRound(List<User> userList, int gameID, int roundNumber){

        return null;
    }


    @Override
    public int calcualteTotalWinner(int winningUserRound1, int winningUserRound2, int winningUserRound3){
        int winningUser = 0;
        if (winningUserRound1 == 2){
            winningUser=+1;
        }else if(winningUserRound1 == 3){
            winningUser =-1;
        }
        if (winningUserRound2 == 2){
            winningUser=+1;
        } else if(winningUserRound1 == 3){
        winningUser =-1;
        }
        if (winningUserRound3 == 2){
            winningUser=+1;
        } else if(winningUserRound1 == 3){
        winningUser =-1;
        }

        if(winningUser == 0){
            System.out.println("Its a tie");
        }
        if(winningUser < 0){
            System.out.println("Player 2 won");
        }
        if(winningUser > 0){
            System.out.println("Player 1 won");
        }

      return winningUser;
    }


}
