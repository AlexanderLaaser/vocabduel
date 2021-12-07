package de.htwberlin.usermanagement.inter;

import javax.naming.InvalidNameException;

public interface UserService {

    /**
     * Erstellt ein User Objekt
     * @param firstName - Vorname des Nutzers
     * @param lastName - Nachname des Nutzers
     * @param userName - Benutzer des Nutzers im System
     * @param password - Passwort des Nutzers
     * @return Es wird ein User Objekt erstellt und zurückgegeben
     * @throws InvalidNameException
     */
    User createUser(String firstName, String lastName, String userName, String password) throws InvalidNameException;

    /**
     *
     * @param userID - ID des Nutzers
     * @return Es wird ein User Objekt zurückgegeben
     */
    User getUserById(Long userID);

    /**
     * Methode die einen User aus der Liste (später Datenbank löscht)
     * @param user
     */
    void removeUser(User user);

    /**
     * Verantwortlich für die Änderung des Passworts
     * @param user
     * @param password - passswort des Nutzers
     */
    void changePassword (User user, String password) throws InvalidNameException;

    /**
     * Verantwortlich für die Erhöhung der gespielten Spiele
     * @param userID - ID des Nutzers
    void increaseTotalGames(Long userID);
     */
    void increaseTotalGames(Long userID);

}



