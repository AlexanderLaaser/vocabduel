package de.htwberlin.Game.impl;

import de.htwberlin.game.inter.Game;
import de.htwberlin.game.inter.GameService;
import de.htwberlin.game.inter.Round;
import de.htwberlin.usermanagement.inter.InvalidUserException;
import de.htwberlin.usermanagement.inter.User;
import de.htwberlin.usermanagement.inter.UserService;
import de.htwberlin.vocabmanagement.inter.*;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

@Component
public class GameServiceImpl implements GameService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAKBA");
    private EntityManager em = emf.createEntityManager();

    private UserService uService;
    private VocabList vL;
    private VocabListService vLService;
    private Game g;


    @Override
    public Game createGame(Long user1Id, Long user2Id, int vocablistId) throws InvalidUserException {
        // boolean usersExist = userService.allUserExist(int user1Id, int user2Id);
        boolean usersExist = true;

        if(!usersExist){
            //throw new UserNotFoundException();
            throw new InvalidUserException("One User is not existing");
        }

        //durch JPA autocreate ersetzten
        int gameID = 1;

        User mockuser1 = new User("Peter", "Test","Supertester123", "qwer");
        User mockuser2 = new User("Peter", "Test","Supertester123", "qwer");

        //Game game = new Game(gameID, userService.getUserById(user1Id), userService.getUserById(user2Id), vocabList.getVocabListByID(vocablistId));
        Game game = new Game(gameID, mockuser1, mockuser2, getVocabList(1L));
        em.getTransaction().begin();

        game = initRounds(game, 3, getVocabList(1L));
//         Game gameRound1 = initRounds(game, 3, vLService.getVocabListByID(vocablistId));
        try{
            em.persist(game);
        }
        catch (Exception e){
            System.out.println(e);
        }

        em.getTransaction().commit();
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
        VocabItem tVI1 = new VocabItem("Test1", testListVI);
        VocabItem tVI2 = new VocabItem("Test2", testListVI2);
        VocabItem tVI3 = new VocabItem("Test3", testListVI3);
        VocabItem tVI4 = new VocabItem("Test4", testListVI4);

        //create ItemList for Vocablist
        List<VocabItem> testItemList = new ArrayList<>();
        testItemList.add(tVI1);
        testItemList.add(tVI2);
        testItemList.add(tVI3);
        testItemList.add(tVI4);

        //create Vocablist
        Map<String,List<VocabItem>> testMap = new HashMap<String, List<VocabItem>>();
        testMap.put("Test", testItemList);

        VocabList testVocabList = new VocabList(testItemList, new Language("German"),
                new Language("English"), new Category("Test"));

        return testVocabList;

    };

    @Override
    public void validateUserMatch(Long userId1, Long userId2) throws InvalidUserException {
        User userObj1 = uService.getUserById(userId1);
        User userObj2 = uService.getUserById(userId2);

        if(userObj1.getUserID() == userObj2.getUserID()){
            throw new InvalidUserException("Die angegebenen Nutzer sind ungültig!");
        }
    }

    @Override
    public void updateUserDataAfterGame(Long userId) {
        // Einzelbeispiel zum Updaten der gespielten Spiele
        User userObj1 = uService.getUserById(userId);
        uService.increaseTotalGames(userId);
    }

//    @Override
//    public int calculateWinner(Game game){
//
//        ArrayList<Round> rounds = game.getRounds();
//        int winningUserRound1 = rounds.get(0).getWinningUser();
//        int winningUserRound2 = rounds.get(1).getWinningUser();
//        int winningUserRound3 = rounds.get(2).getWinningUser();
//
//        return calculateTotalWinner(roundWinner1, roundWinner2, roundWinner3);
//
//    }

    @Override
    public int calculateTotalWinner(int winningUserRound1, int winningUserRound2, int winningUserRound3) {

        int winningUser = 0;
        winningUser = winningUser + addEndWinner(winningUserRound1);
        winningUser = winningUser + addEndWinner(winningUserRound2);
        winningUser = winningUser + addEndWinner(winningUserRound3);

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

    public int addEndWinner(int winningUser){
        int winning;
        if(winningUser == 2) winning = -1;
        if(winningUser == 1) return winning = 1;
        else return winning = 0;
    }

    @Override
    public Map<String, List<String>> generateCustomVocabSet(int anzahlRunden) {
        return null;
    }

    @Override
    public int getVocabListByCategory(String SearchCategoryName) {
        //Methode würde Vocablisten DB durchsuchen und eine VocablistenID zurückgeben
        return 1;

    }

    @Override
    public Game initRounds(Game game, int maxRounds, VocabList vocabList){

        LinkedHashMap<String, List<String>>  TestList;


        for (int i = 0; i < maxRounds; i++) {
            // create VocabSet
            // Map vocabSet = null;
            // vocabSet = generateVocabSets(maxRounds, vocabList, vocabSet);
            ArrayList<String> fakeAnswerList = new ArrayList<String>(Arrays.asList(
                    "Frage" + i+1, "richtige Antwort", "falsche Antwort 1", "falsche Antwort 2", "falsche Antwort 3"));
            Round round = new Round(i, fakeAnswerList);
            round.setRightAnswer(fakeAnswerList.get(1));
//          round.setRightAnswer(vocabSet.get(1));
            game.getRounds().add(round);

        }

        return game;

    }

    public Map generateVocabSets(int maxRounds, VocabList vocablist, Map vocabSet){
        Long listId = vocablist.getListID();
        List<VocabItem> vListItems = vLService.getAllItemsInVocabList(listId);
        List<String> questions = new ArrayList<String>();
        int vocabLLength = 3;
        for(int i = 0; i < maxRounds; i++){
            int randomItem = getRandomNumberUsingNextInt(0, vocabLLength);
            String Item = vListItems.get(randomItem).toString();
            vocabSet.put(i, Item);
        }
        return vocabSet;
    }
    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

}
