package de.htwberlin.Game.impl;
import de.htwberlin.game.inter.Game;
import de.htwberlin.game.inter.GameService;
import de.htwberlin.game.inter.Round;
import de.htwberlin.usermanagement.inter.InvalidUserException;
import de.htwberlin.usermanagement.inter.User;
import de.htwberlin.usermanagement.inter.UserService;
import de.htwberlin.vocabmanagement.inter.VocabList;
import de.htwberlin.vocabmanagement.inter.VocabListService;

import java.util.List;
import java.util.Map;

public class GameServiceImpl implements GameService {

    private UserService userService;
    private VocabList vocabList;
    private VocabListService vocabListService;

    @Override
    public Game createGame(int user1, int user2, int vocablistId) throws InvalidUserException {
        User userObj1 = userService.getUserById(user1);
        User userObj2 = userService.getUserById(user2);
        VocabList vocabListObj = vocabList.getVocabListByID(vocablistId);
        validateUserMatch(user1,user2);

        Game game = new Game(1,userObj1,userObj2,vocabListObj);
        return game;

    }

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
    public int getVocabListByCategory(String SearchCategoryName) {
        //Methode würde Vocablisten DB durchsuchen und eine VocablistenID zurückgeben
        return 1;

    }

    @Override
    public Round initRounds(int RoundId, int AnzahlRunden, Game game){
        Map CustomVocabListmock = generateCustomVocabSet(AnzahlRunden);
        Round round = new Round(RoundId,game,CustomVocabListmock);

        return round;

    }
}
