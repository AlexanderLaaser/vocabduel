package usermanagement.inter;
import javax.naming.InvalidNameException;


public interface UserService {

    /**
     * Erstellung eines Users
     * @param userID        Eineindeutige Zuweisung des Users
     * @param firstName     Vorname des Users
     * @param lastName      Nachname des Users
     * @param userName      Benutzername des Users
     * @param password      Passwort des Users
     * @param totalGames    Gesamtanzahl der gespielten Spiele des Users
     * @param gamesLost     Anzahl der verlorenen Spiele des Users
     * @param gamesWon      Anzahl der gewonnen Spiele des Users
     * @return              Rückgabe des erstellten Users.
     * @throws InvalidNameException
     */
    User createUser(int userID, String firstName, String lastName, String userName, String password, int totalGames, int gamesLost, int gamesWon) throws InvalidNameException;

    /**
     * Herraussuchen eines Users nach der UserID
     * @param userID Eineindeutige Zuweisung des Users
     * @return
     */
    User getUserById(int userID);

    /**
     * Entfernen eines Users nach der UserID
     * @param userID
     */
    void removeUser(int userID);

    /**
     * Änderung des Passworts eines Users nach der UserID.
     * @param userID    Herraussuchen des Users
     * @param password  Neuvergabe des Passworts
     */
    void changePassword (int userID, String password);

    /**
     * Erhöhung der Spielanzahl
     * @param userID    Herraussuchen des Users
     */
    void increaseTotalGames(int userID);
}



