import usermanagement.inter.User;
import usermanagement.inter.UserService;

import javax.naming.InvalidNameException;
import java.util.LinkedList;

public class UserServiceImpl implements UserService {

    /**
     * temporäre Liste als DB Ersatz. Im weiteren Verlauf des Projekts würden die Listenoperationen als DB-Kommunikation dienen
     */
    public LinkedList<User> userList = new LinkedList<User>();

    @Override
    public User createUser(long userID, String firstName, String lastName, String userName, String password) throws InvalidNameException {
        validateUserID(userID);
        validateName(firstName);
        validateName(lastName);
        validateName(userName);
        validatePassword(password);

        User createdUser = new User(userID, firstName, lastName, userName, password);
        userList.add(createdUser);

        return createdUser;
    }

    public void validateUserID(Long userID) {
        //check if userID exists
    }

    public void validateName(String name) throws InvalidNameException {
        if (name == null || name.contains(" ") || name == "") {
            throw new InvalidNameException("Der Name darf nicht leer sein.");
        } else if (!name.matches("[a-zA-Z_?]*")) {
            throw new InvalidNameException("Der Name darf keine Sonderzeichen oder Nummern enthalten.");
        }
    }

    public void validatePassword(String password) throws InvalidNameException {
        if (password == null || password.contains(" ") || password == "") {
            throw new InvalidNameException("Das Password darf nicht leer sein.");
        } else if (password.length() <= 6) {
            throw new InvalidNameException("Das Passwort ist zu kurz.");
        }
        else if (password == "Passwort" || password == "passwort" || password == "kennwort") {
            throw new InvalidNameException("Das Passwort ist zu leicht zu erraten.");
        }
    }

    @Override
    public User getUserById(long userID) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserID() == userID) {
                return userList.element();
            }
        } return null;

    }

    @Override
    public void removeUser(int userID) {
        userList.remove(getUserById(userID));
    }

    @Override
    public void changePassword(int userID, String password) {
        getUserById(userID).setPassword(password);
    }

    @Override
    public void increaseTotalGames(int userID) {
        getUserById(userID).setTotalGames(+1);
    }
}

