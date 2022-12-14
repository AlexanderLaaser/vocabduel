package de.htwberlin.game.inter;

import de.htwberlin.usermanagement.inter.InvalidUserException;
import de.htwberlin.usermanagement.inter.User;
import de.htwberlin.vocabmanagement.inter.InvalidListIdException;
import de.htwberlin.vocabmanagement.inter.VocabList;

public interface GameService {

    /**
     * Methode erstellt ein Game Objekt
     *
     * @param gameOwner     - Id des Spieleigentümers
     * @param gamePartner     - Id des Spielpartners
     * @param vocabList - Id der ausgesuchten VocabList
     * @return Game Objekt
     * @throws InvalidUserException for invalid User
     */
    //create a Game with 2 existing Users and one VocabList
    Game createGame(User gameOwner, User gamePartner, VocabList vocabList) throws InvalidUserException, InvalidListIdException;


    /**
     * Methode validiert übergebene User
     *
     * @param userId1 - ID des ersten Nutzers
     * @param userId2 - ID des zweiten Nutzers
     * @throws InvalidUserException invalide User
     */
    //Checkt ob 2 User gleich sind oder nicht
    void validateUserMatch(Long userId1, Long userId2) throws InvalidUserException;

    /**
     * Methode berechnet den Gewinner
     *
     * @param winningUserRound1 - Winner Runde 1
     * @param winningUserRound2 - Winner Runde 1
     * @param winningUserRound3 - Winner Runde 1
     * @return Winner ID
     */
    int calculateGameWinner(int winningUserRound1, int winningUserRound2, int winningUserRound3);

    /**
     * speichert existierendes Game in DB
     * @param game
     */
    void updateGame(Game game);

    /**
     * Initialisiert Runden Objekt
     *
     * @param game         - Game Objekt
     * @param anzahlRunden - Anzahl der zu spielenden Runden
     * @param vocabList    - Liste mit Voabeln für das Game
     * @return Runden Objekt
     */
    Game initRounds(Game game, int anzahlRunden, VocabList vocabList) throws InvalidListIdException;

    void createGameController(int gameOwnerId, int gamePartnerId, int vocablistId) throws InvalidListIdException;

    Game getGameById(int gameId);

//    /**
//     * berechnet den Gewinner durch ziehen der Rundengewinner und triggern der calculateTotalWinner() methode
//     * @param game
//     * @return winner
//     */
//    int calculateWinner(Game game);
}
