package de.htwberlin.usermanagement.impl;

import de.htwberlin.usermanagement.inter.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    User getUserById(Long userId);

    User getUserByUsername(String username);

    void increaseTotalGames(User user);

    void increaseGamesWon(User user);

    void increaseGamesLost(User user);

    void changePassword(User user);

    void removeUser(User user);

    List<User> getAllUser();

}
