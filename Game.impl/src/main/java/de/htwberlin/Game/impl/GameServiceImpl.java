package de.htwberlin.Game.impl;

import de.htwberlin.game.inter.Game;
import de.htwberlin.game.inter.GameService;
import de.htwberlin.game.inter.Round;
import de.htwberlin.usermanagement.inter.InvalidUserException;
import de.htwberlin.usermanagement.inter.User;
import de.htwberlin.usermanagement.inter.UserService;
import de.htwberlin.vocabmanagement.inter.InvalidListIdException;
import de.htwberlin.vocabmanagement.inter.VocabList;
import de.htwberlin.vocabmanagement.inter.VocabListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class GameServiceImpl implements GameService {

    private GameDao gameDao;
    private PlatformTransactionManager transactionManager;
    private RoundDao roundDao;
    private VocabListService vocabListService;
    private UserService uService;

    @Autowired
    public GameServiceImpl(GameDao gameDao, PlatformTransactionManager transactionManager, RoundDao roundDao,
                            VocabListService vocabListService, UserService uService) {
        super();
        this.gameDao = gameDao;
        this.transactionManager = transactionManager;
        this.roundDao = roundDao;
        this.vocabListService = vocabListService;
        this.uService = uService;
    }

    @Override
    public Game createGame(User gameOwner, User gamePartner, VocabList vocabList) throws InvalidUserException, InvalidListIdException {

        Game game = new Game(gameOwner, gamePartner, vocabList);
        game = initRounds(game, 9, vocabList);

        addGame(gameOwner, gamePartner, vocabList);

//        TransactionStatus ts = transactionManager.getTransaction(null);
//        gameDao.saveGame(game);
//        transactionManager.commit(ts);
        return game;

    }

    @Override
    public Game initRounds(Game game, int maxRounds, VocabList vocabList) throws InvalidListIdException {
        Map<Integer, List<String>> allVocabSets = vocabListService.createRandomVocabsets(vocabList.getListID());

        for (int i = 0; i < maxRounds; i = i+3) {
            TransactionStatus ts = transactionManager.getTransaction(null);

            List<String> vocabSet1 = allVocabSets.get(i);
            List<String> vocabSet2 = allVocabSets.get(i+1);
            List<String> vocabSet3 = allVocabSets.get(i+2);

            List<String> rightAnswers = new ArrayList<>();
            rightAnswers.add(vocabSet1.get(1));
            rightAnswers.add(vocabSet2.get(1));
            rightAnswers.add(vocabSet3.get(1));

            Round round = new Round(vocabSet1, vocabSet2, vocabSet3);

            round.setRightAnswer(rightAnswers);
            roundDao.saveRound(round);
            transactionManager.commit(ts);
            game.getRounds().add(round);
        }
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

    public void addGame(User gameOwner, User gamePartner, VocabList vocablist ){
        //List of API Calls

        RestTemplate restTemplate = new RestTemplate();

        Long gameOwnerId =gameOwner.getUserID();
        Long gamePartnerId = gamePartner.getUserID();
        Long vocablistId = vocablist.getListID();

        final String finalURL = "http://localhost:8080/game/add/" +
                gameOwnerId.toString() + "/" +
                gamePartnerId.toString() + "/" +
                vocablistId.toString();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters",headers);

        ResponseEntity<String> result = restTemplate.exchange(finalURL, HttpMethod.POST, entity,String.class);
        System.out.println(result);

    }

    @Override
    public Game getGameById(int gameId){
        TransactionStatus ts = transactionManager.getTransaction(null);
        Game game = gameDao.getGameById(gameId);
        transactionManager.commit(ts);

        return game;
    }

    @Override
    public void createGameController(int gameOwnerId, int gamePartnerId, int vocabListId) throws InvalidListIdException {

        Long gameOwnerId2 = Long.valueOf(gameOwnerId);
        Long gamePartnerId2 = Long.valueOf(gamePartnerId);
        Long vocabListId2 = Long.valueOf(vocabListId);

        VocabList vocablist = vocabListService.getVocabListByID(vocabListId2);
        Game game = new Game(uService.getUserById(gameOwnerId2), uService.getUserById(gamePartnerId2), vocablist);
        game = initRounds(game, 9, vocablist);

        TransactionStatus ts = transactionManager.getTransaction(null);
        gameDao.saveGame(game);
        transactionManager.commit(ts);

    }
}
