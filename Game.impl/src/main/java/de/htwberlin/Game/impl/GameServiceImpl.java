package de.htwberlin.Game.impl;

import de.htwberlin.game.inter.Game;
import de.htwberlin.game.inter.GameService;
import de.htwberlin.game.inter.Round;
import de.htwberlin.usermanagement.inter.InvalidUserException;
import de.htwberlin.usermanagement.inter.User;
import de.htwberlin.usermanagement.inter.UserService;
import de.htwberlin.vocabmanagement.inter.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GameServiceImpl implements GameService {

    private UserService userService;
    private VocabList vocabList;
    private VocabListService vocabListService;
    private Game game;

    @Override
    public Game createGame(int user1Id, int user2Id, int vocablistId) throws InvalidUserException {
        // boolean usersExist = userService.allUserExist(int user1Id, int user2Id);
        boolean usersExist = true;

        if(!usersExist){
            //throw new UserNotFoundException();
            throw new InvalidUserException("One User is not existing");
        }

        //durch JPA autocreate ersetzten
        int gameID = 1;

        User mockuser1 = new User(user1Id,"Peter", "Test","Supertester123", "qwer");
        User mockuser2 = new User(user2Id,"Peter", "Test","Supertester123", "qwer");

        //Game game = new Game(gameID, userService.getUserById(user1Id), userService.getUserById(user2Id), vocabList.getVocabListByID(vocablistId));
        Game game = new Game(gameID, mockuser1, mockuser2, getVocabList(1L));
        System.out.println(game);

        initRounds(game, 3, vocabList);
       // Game gameRound1 = initRounds(game, 3, vocabList.getVocabListByID(vocablistId));

        return game;

    }
    public VocabList getVocabList(Long id){

//          if id null create Test bundle for Testing
//          delete later for getVocablist by ID

        //create Testlists for VocabItem
        List<String> testListVI, testListVI2, testListVI3, testListVI4;
        testListVI = testListVI2 = testListVI3 = testListVI4 = new ArrayList<>();
        testListVI.add("test-engl1");
        testListVI.add("different1");
        testListVI2.add("test-engl2");
        testListVI2.add("different2");
        testListVI2.add("moredifferent2");
        testListVI3.add("test-engl3");
        testListVI4.add("test-engl4");
        testListVI4.add("different4");

        //Test VocabItems for Itemlist with ID, vocabname and translationList
        VocabItem tVI1 = new VocabItem(1L, "Test1", testListVI);
        VocabItem tVI2 = new VocabItem(2L, "Test2", testListVI2);
        VocabItem tVI3 = new VocabItem(3L, "Test3", testListVI3);
        VocabItem tVI4 = new VocabItem(4L, "Test4", testListVI4);

        //create ItemList for Vocablist
        List<VocabItem> testItemList = new ArrayList<>();
        testItemList.add(tVI1);
        testItemList.add(tVI2);
        testItemList.add(tVI3);
        testItemList.add(tVI4);

        //create Vocablist
        Map<String,List<VocabItem>> testMap = new HashMap<String, List<VocabItem>>();
        testMap.put("Test", testItemList);

        VocabList testVocabList = new VocabList(1L, new Language(1, "German"),
                new Language(2, "English"),
                new Category(1L, "Test"), testMap );

        return testVocabList;

    };

    @Override
    public void validateUserMatch(int userId1, int userId2) throws InvalidUserException {
        User userObj1 = userService.getUserById(userId1);
        User userObj2 = userService.getUserById(userId2);

        if(userObj1.getUserID() == userObj2.getUserID()){
            throw new InvalidUserException("Die angegebenen Nutzer sind ungültig!");
        }
    }

    @Override
    public void updateUserDataAfterGame(int userId) {
        // Einzelbeispiel zum Updaten der gespielten Spiele
        User userObj1 = userService.getUserById(userId);
        userService.increaseTotalGames(userId);
    }

    @Override
    public int calculateTotalWinner(int winningUserRound1, int winningUserRound2, int winningUserRound3) {
        int winningUser = 0;
        if (winningUserRound1 == 2){
            winningUser =+ 1;
        }else if(winningUserRound1 == 3){
            winningUser =- 1;
        }
        if (winningUserRound2 == 2){
            winningUser =+ 1;
        } else if(winningUserRound1 == 3){
            winningUser =- 1;
        }
        if (winningUserRound3 == 2){
            winningUser=+ 1;
        } else if(winningUserRound1 == 3){
            winningUser =- 1;
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

        //User userObj1 = userService.getUserById(userId);

        return winningUser;
    }

    @Override
    public Map<String, List<String>> generateCustomVocabSet(int anzahlRunden) {
        return null;
    }

    @Override
    public Round initRounds(int gameId, int roundId, int AnzahlRunden, VocabList vocabList) {
        return null;
    }

    @Override
    public int getVocabListByCategory(String SearchCategoryName) {
        //Methode würde Vocablisten DB durchsuchen und eine VocablistenID zurückgeben
        return 1;

    }

    @Override
    public Game initRounds(Game game, int maxRounds, VocabList vocabList){

        for (int i = 0; i < maxRounds; i++) {
            //create VocabSet
            Map vocabSet = null;
            Round round = new Round(i, game, vocabSet);
            game.getRounds().add(round);

        }
        return game;

    }
}
