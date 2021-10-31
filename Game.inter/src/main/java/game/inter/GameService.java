package game.inter;
import usermanagement.inter.InvalidUserException;

public interface GameService {

    /**
     * Methode erstellt ein Game Objekt
     * @param userId1 - Id des Spieleigentümers
     * @param userId2 - Id des Spielpartners
     * @param vocabListId - Id der ausgesuchten VocabList
     * @return Game Objekt
     * @throws InvalidUserException
     */
    //create a Game with 2 existing Users and one VocabList
    Game createGame(int userId1, int userId2, int vocabListId) throws InvalidUserException;

    /**
     * Initialisiert Runden Objekt
     * @param RoundId - Id der Runde
     * @param AnzahlRunden - Anzahl der zu spielenden Runden
     * @param game - Game Objekt
     * @return Runden Objekt
     */
    Round InitRounds(int RoundId, int AnzahlRunden, Game game);

    /**
     * Methode gibt Category ID einer Vocablist mit dem Category Namen des params categoryName
     * @param categoryName - gesuchter Name der VocabList
     * @return ID der VocabList mit dem Namen categoryName
     */
    int getVocabListByCategory(String categoryName);

    /**
     * Methode validiert übergebene User
     * @param userId1 - ID des ersten Nutzers
     * @param userId2 - ID des zweiten Nutzers
     * @throws InvalidUserException
     */
    //Checkt ob 2 User gleich sind oder nicht
    public void validateUserMatch(int userId1,int userId2) throws InvalidUserException;

    /**
     * Methode aktualisiert Spieler Daten nach einem Game
     * @param userId - Id des zu aktualisierenden Nutzers
     */
    public void UpdateUserDataAfterGame(int userId);

    /**
     * Methode berechnet den Gewinner
     * @param winningUserRound1 - Winner Runde 1
     * @param winningUserRound2 - Winner Runde 1
     * @param winningUserRound3 - Winner Runde 1
     * @return Winner ID
     */
    int calculateTotalWinner(int winningUserRound1, int winningUserRound2, int winningUserRound3);
}
