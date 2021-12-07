package de.htwberlin.usermanagement.impl;

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
    public User createUser(String firstName, String lastName, String userName, String password) throws InvalidNameException {
        User tempUser = new User(firstName, lastName, userName, password);
        TransactionStatus ts = transactionManager.getTransaction(null);
        userDao.saveUser(tempUser);
        transactionManager.commit(ts);
        return tempUser;
    }

    @Override
    public User getUserById(Long userID) {
        TransactionStatus ts = transactionManager.getTransaction(null);
        User userWithID = userDao.getUserById(userID);
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
    public void removeUser(User user) {
        TransactionStatus ts = transactionManager.getTransaction(null);
        userDao.removeUser(user);
        transactionManager.commit(ts);
    }

    @Override
    public void changePassword(User user, String password) {
        TransactionStatus ts = transactionManager.getTransaction(null);
        user.setPassword(password);
        userDao.changePassword(user, password);
        transactionManager.commit(ts);
    }

    @Override
    public void increaseTotalGames(Long userID) {
        TransactionStatus ts = transactionManager.getTransaction(null);
        User userList = userDao.getUserById(userID);
        userList.setTotalGames(+1);
        userDao.increaseTotalGames(userList);
        transactionManager.commit(ts);
    }
//
//
//    public void validateName(String name) throws InvalidNameException {
//        if (name == null || name.contains(" ") || name == "") {
//            throw new InvalidNameException("Der Name darf nicht leer sein.");
//        } else if (!name.matches("[a-zA-Z_?]*")) {
//            throw new InvalidNameException("Der Name darf keine Sonderzeichen oder Nummern enthalten.");
//        }
//    }
//
//    public void validatePassword(String password) throws InvalidNameException {
//        if (password == null || password.contains(" ") || password == "") {
//            throw new InvalidNameException("Das Password darf nicht leer sein.");
//        } else if (password.length() <= 6) {
//            throw new InvalidNameException("Das Passwort ist zu kurz.");
//        }
//        else if (password == "Passwort" || password == "passwort" || password == "kennwort") {
//            throw new InvalidNameException("Das Passwort ist zu leicht zu erraten.");
//        }
//    }

}


