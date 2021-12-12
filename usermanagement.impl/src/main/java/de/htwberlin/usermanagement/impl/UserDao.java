package de.htwberlin.usermanagement.impl;

import de.htwberlin.usermanagement.inter.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    User getUserById(Long userId);

    void increaseTotalGames(User user);

    void changePassword(User user);

    void removeUser(User user);

    List<User> getAllUser();

}
