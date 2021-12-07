package de.htwberlin.usermanagement.impl;

import de.htwberlin.usermanagement.inter.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    User getUserById(Long userID);

    void increaseTotalGames(User user);

    void changePassword(User user, String password);

    void removeUser(User user);

    List<User> getAllUser();

}
