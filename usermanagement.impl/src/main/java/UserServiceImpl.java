import usermanagement.inter.User;
import usermanagement.inter.UserService;

import javax.naming.InvalidNameException;

public class UserServiceImpl implements UserService {

    @Override
    public User createUser(int userID, String firstName, String lastName, String userName, String password) throws InvalidNameException {
        validateUserID(userID);
        validateName(firstName);
        validateName(lastName);
        validateName(userName);
        validatePassword(password);

        return new User(userID, firstName, lastName, userName, password, 1, 1, 1);
    }

    public void validateUserID(int userID) {
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
    public User getUserById(int userID) {
        return null;
    }

    @Override
    public void removeUser(int userID) {
        //getUserByID(userID);
        //System.out.println("User entfernt");
    }

    @Override
    public void changePassword(int userID, String password) {
        //getUserById(userID);
        //newUser.setPassword(password);
    }

    @Override
    public void increaseTotalGames(int userID) {
        //getUserById(userID);
        //newUser.setTotalGames(+1);
    }
}

