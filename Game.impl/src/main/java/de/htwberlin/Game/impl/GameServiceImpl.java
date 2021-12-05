package de.htwberlin.Game.impl;

import de.htwberlin.game.inter.Game;
import de.htwberlin.game.inter.GameService;
import de.htwberlin.game.inter.Round;
import de.htwberlin.usermanagement.inter.InvalidUserException;
import de.htwberlin.usermanagement.inter.User;
import de.htwberlin.usermanagement.inter.UserService;
import de.htwberlin.vocabmanagement.inter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import java.util.*;

@Service
public class GameServiceImpl implements GameService {

    private GameDao gameDao;
    private PlatformTransactionManager transactionManager;
    private RoundDao roundDao;
    private VocabListService vocabListService;
    private  UserService uService;

    @Autowired
    public GameServiceImpl(GameDao gameDao, PlatformTransactionManager transactionManager, RoundDao roundDao,
                            VocabListService vocabListService) {
        super();
        this.gameDao = gameDao;
        this.transactionManager = transactionManager;
        this.roundDao = roundDao;
        this.vocabListService = vocabListService;
    }




    @Override
    public Game createGame(User gameOwner, User gamePartner, VocabList vocabList) throws InvalidUserException {

        // boolean usersExist = userService.allUserExist(int user1Id, int user2Id);
        boolean usersExist = true;


        if(!usersExist){
            //throw new UserNotFoundException();
            throw new InvalidUserException("One User is not existing");
        }

        Game game = new Game(gameOwner, gamePartner, vocabList);
        game = initRounds(game, 3, vocabList);

        TransactionStatus ts = transactionManager.getTransaction(null);
        gameDao.saveGame(game);
        transactionManager.commit(ts);
        return game;

    }

    public void updateGame(Game game){
        TransactionStatus ts = transactionManager.getTransaction(null);
        gameDao.updateGame(game);
        transactionManager.commit(ts);
    }

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

    @Override
    public int calculateGameWinner(int winningUserRound1, int winningUserRound2, int winningUserRound3) {

        int winningUser = 0;
        winningUser = winningUser + addEndWinner(winningUserRound1);
        winningUser = winningUser + addEndWinner(winningUserRound2);
        winningUser = winningUser + addEndWinner(winningUserRound3);

        return winningUser;
    }

    public int addEndWinner(int winningUser){
        int winning = 0;
        if(winningUser == 2) winning = -1;
        if(winningUser == 1) winning = 1;
        return winning;
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

        for (int i = 0; i < maxRounds; i++) {
            TransactionStatus ts = transactionManager.getTransaction(null);
            // create VocabSet
            // Map vocabSet = null;
            // vocabSet = generateVocabSets(maxRounds, vocabList, vocabSet);
          //  ArrayList<String> fakeAnswerList = new ArrayList<String>(Arrays.asList(
          //          "Frage" + i+1, "richtige Antwort", "falsche Antwort 1", "falsche Antwort 2", "falsche Antwort 3"));

            Map<Integer, List<String>> allVocabSetsNeeded = vocabListService.createRandomVocabsets(vocabList.getListID());
            List<String> vocabSetAlternative = allVocabSetsNeeded.get(i);
  /*         List<String> tempVocabSet = vocabListService.createQuestionList(vocabList.getListID());
            List<String> vocabSet = new ArrayList<>();
            for(int k = 0; k<5; k++){
                vocabSet.add(tempVocabSet.get(k));
            }

   */
            Round round = new Round(vocabSetAlternative);
            round.setRightAnswer(vocabSetAlternative.get(1));
            roundDao.saveRound(round);
            transactionManager.commit(ts);
//          round.setRightAnswer(vocabSet.get(1));
            game.getRounds().add(round);
        }
        return game;
    }

    public Map generateVocabSets(int maxRounds, VocabList vocablist, Map vocabSet){
        Long listId = vocablist.getListID();
        List<VocabItem> vListItems = vocabListService.getAllItemsInVocabList(listId);
        List<String> questions = new ArrayList<String>();
        int vocabLLength = 3;
        for(int i = 0; i < maxRounds; i++){
            int randomItem = getRandomNumber(0, vocabLLength);
            String Item = vListItems.get(randomItem).toString();
            vocabSet.put(i, Item);
        }
        return vocabSet;
    }
    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

}
