package de.htwberlin.usermanagement.inter;

import javax.naming.InvalidNameException;
import java.util.List;

public interface UserService {

    /**
     * Methode erstellt einen neuen User
     * @param firstName Vorname des Users
     * @param lastName Nachname des Users
     * @param userName Spielername des Users
     * @param password Passwort des Users
     * @return Rückgabe des erstellten Users
     * @throws InvalidNameException
     */
    User createUser(String firstName, String lastName, String userName, String password) throws InvalidUserException, InvalidNameException;

    /**
     *
     * @param userId Id des Users
     * @return gibt einen User zurück
     */
    User getUserById(long userId);

    /**
     * Methode löscht einen User aus der Datenbank
     * @param
     */
    void removeUser(long userid);

    /**
     * Methode erzeugt eine Liste aller vorhandenen User
     * @return
     */
    List<User> getAllExistingUser();

    /**
     * Methode verändert das Passwort eines Users
     * @param userId Id des Users
     * @param password Passswort des Users
     */
    void changePassword (long userId, String password) throws InvalidNameException;

    /**
     * Methode erhöht die Anzahl der Spiele um 1
     * @param userId - Id des Users
     */
    void increaseTotalGames(long userId);



}



