package de.htwberlin.Game.impl;
import de.htwberlin.game.inter.Game;
import de.htwberlin.game.inter.GameService;
import de.htwberlin.game.inter.Round;
import de.htwberlin.usermanagement.inter.InvalidUserException;
import de.htwberlin.usermanagement.inter.User;
import de.htwberlin.usermanagement.inter.UserService;
import de.htwberlin.vocabmanagement.inter.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Controller
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

        int gameID = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben sie eine Vocballist ID an. Auswahl 1, 2 ,3 oder 4");

        int eingabe = 1;
        //eingabe = scanner.nextInt();
        System.out.println("Sie haben Liste " + eingabe +" gewählt");

        User mockuser1 = new User(user1Id,"Peter", "Test","Supertester123", "qwer");
        User mockuser2 = new User(user2Id,"Peter", "Test","Supertester123", "qwer");

        //Game game = new Game(gameID, userService.getUserById(user1Id), userService.getUserById(user2Id), vocabList.getVocabListByID(vocablistId));
        Game game = new Game(gameID, mockuser1, mockuser2, vocabList.getVocabListByID(vocablistId));

        Game gameRound1 = initRounds(game, 3, vocabList.getVocabListByID(vocablistId));

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
    public Round initRounds(int gameId, int roundId, int AnzahlRunden, VocabList vocabList) {
        return null;
    }

    @Override
    public int getVocabListByCategory(String SearchCategoryName) {
        //Methode würde Vocablisten DB durchsuchen und eine VocablistenID zurückgeben
        return 1;

    }

    @Override
    public Round initRounds(int RoundId, int AnzahlRunden, Game game) {
        return null;
    }

    @Override
    public Game initRounds(Game game, int maxRounds, VocabList vocabList){

        for (int i = 0; i < maxRounds; i++) {
            //create VocabSet
            Map vocabSet = null;

            Round round = new Round(1, vocabSet);

        }

        Map CustomVocabListmock = generateCustomVocabSet(maxRounds);
        Round round = new Round(1, game,CustomVocabListmock);

        //game.add round()

        return game;

    }
}
