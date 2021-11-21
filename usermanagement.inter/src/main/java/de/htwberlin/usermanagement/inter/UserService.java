package de.htwberlin.usermanagement.inter;

import javax.naming.InvalidNameException;

public interface UserService {

    /**
     * Erstellt ein User Objekt
     * @param userID - ID des Nutzers
     * @param firstName - Vorname des Nutzers
     * @param lastName - Nachname des Nutzers
     * @param userName - Benutzer des Nutzers im System
     * @param password - Passwort des Nutzers
     * @return Es wird ein User Objekt erstellt und zurückgegeben
     * @throws InvalidNameException
     */
    User createUser(long userID, String firstName, String lastName, String userName, String password) throws InvalidNameException;

    /**
     *
     * @param userID - ID des Nutzers
     * @return Es wird ein User Objekt zurückgegeben
     */
    User getUserById(long userID);

    /**
     * Methode die einen User aus der Liste (später Datenbank löscht)
     * @param userID
     */
    void removeUser(int userID);

    /**
     * Verantwortlich für die Änderung des Passworts
     * @param userID - ID des Nutzers
     * @param password - passswort des Nutzers
     */
    void changePassword (int userID, String password);

    /**
     * Verantwortlich für die Erhöhung der gespielten Spiele
     * @param userID - ID des Nutzers
     */
    void increaseTotalGames(int userID);
}



