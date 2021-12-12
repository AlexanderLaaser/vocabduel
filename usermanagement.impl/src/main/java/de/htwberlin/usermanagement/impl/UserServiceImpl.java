package de.htwberlin.usermanagement.impl;

import de.htwberlin.usermanagement.inter.InvalidUserException;
import de.htwberlin.usermanagement.inter.User;
import de.htwberlin.usermanagement.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import javax.naming.InvalidNameException;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private PlatformTransactionManager transactionManager;

    @Autowired
    public UserServiceImpl(UserDao userDao, PlatformTransactionManager transactionManager){
        super();
        this.userDao = userDao;
        this.transactionManager = transactionManager;
    }

    @Override
    public List<User> getAllExistingUser() {
        TransactionStatus ts = transactionManager.getTransaction(null);
        List<User> listOfUsers = userDao.getAllUser();
        transactionManager.commit(ts);

        return listOfUsers;
    }

    @Override
    public User createUser(String firstName, String lastName, String userName, String password) throws InvalidUserException {
        User tempUser = new User(firstName, lastName, userName, password);
        TransactionStatus ts = transactionManager.getTransaction(null);
        userDao.saveUser(tempUser);
        transactionManager.commit(ts);
        return tempUser;
    }

    @Override
    public User getUserById(long userId) {
        TransactionStatus ts = transactionManager.getTransaction(null);
        User userWithID = userDao.getUserById(userId);
        transactionManager.commit(ts);
        return userWithID;
    }


    public List<User> getAllUser(){
        TransactionStatus ts = transactionManager.getTransaction(null);
        List<User> userList = userDao.getAllUser();
        transactionManager.commit(ts);
        return userList;
    }

    @Override
    public void removeUser(long userId) {
        TransactionStatus ts = transactionManager.getTransaction(null);
        User toBeRemovedUser = userDao.getUserById(userId);
        userDao.removeUser(toBeRemovedUser);
        transactionManager.commit(ts);
    }

    @Override
    public void changePassword(long userId, String password) {
        TransactionStatus ts = transactionManager.getTransaction(null);
        User toBeUpdatedUser = userDao.getUserById(userId);
        toBeUpdatedUser.setPassword(password);
        userDao.changePassword(toBeUpdatedUser);
        transactionManager.commit(ts);
    }

    @Override
    public void increaseTotalGames(long userID) {
        TransactionStatus ts = transactionManager.getTransaction(null);
        User toBeUpdatedUser = userDao.getUserById(userID);
        toBeUpdatedUser.setTotalGames(+1);
        userDao.increaseTotalGames(toBeUpdatedUser);
        transactionManager.commit(ts);
    }
}


