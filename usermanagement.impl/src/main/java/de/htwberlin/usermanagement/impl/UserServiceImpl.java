package de.htwberlin.usermanagement.impl;

import de.htwberlin.usermanagement.inter.User;
import de.htwberlin.usermanagement.inter.UserService;

import javax.naming.InvalidNameException;
import java.util.LinkedList;

public class UserServiceImpl implements UserService {

    public LinkedList<User> userList = new LinkedList<User>();

    //@Override
    public User createUser(int userID, String firstName, String lastName, String userName, String password, int totalGames, int gamesWon, int gamesLost) throws InvalidNameException {
        validateName(firstName);
        validateName(lastName);
        validateName(userName);
        validatePassword(password);
        User createdUser = new User();
        userList.add(createdUser);

        return createdUser;

    }

    //@Override
    public User getUserById(int userID) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserID() == userID) {
                return userList.element();
            }
        } return null;
    }

    @Override
    public User createUser(long userID, String firstName, String lastName, String userName, String password) throws InvalidNameException {
        return null;
    }

    @Override
    public User getUserById(long userID) {
        return null;
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
}

