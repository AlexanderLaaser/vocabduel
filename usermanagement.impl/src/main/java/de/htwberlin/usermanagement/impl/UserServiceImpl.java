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

//    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAKBA");
//    private EntityManager em = emf.createEntityManager();
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
        TransactionStatus ts = transactionManager.getTransaction(null);

        validateName(firstName);
        validateName(lastName);

        User tempUser = new User(firstName, lastName, userName, password);

        userDao.saveUser(tempUser);
        transactionManager.commit(ts);

        return tempUser;
    }

    @Override
    public User getUserById(Long id) {
        TransactionStatus ts = transactionManager.getTransaction(null);
        User user = userDao.getUserById(id);
        transactionManager.commit(ts);
        return user;
    }

    public List<User> getAllUser(){
//        em.getTransaction().begin();
//        TypedQuery<User> q = em.createQuery("SELECT u FROM User AS u", User.class);
//        List<User> allUser = q.getResultList();
//        em.getTransaction().commit();
//        return allUser;
            return null;
    }

    @Override
    public void removeUser(Long userID) {
//        User user = getUserById(userID);
//
//        em.getTransaction().begin();
//        em.remove(user);
//        em.getTransaction().commit();
    }

    @Override
    public void changePassword(Long userID, String password) throws InvalidNameException {
//        validatePassword(password);
//        User user = getUserById(userID);
//        user.setPassword(password);
//
//        em.getTransaction().begin();
//        em.persist(user);
//        em.getTransaction().commit();
    }

    @Override
    public void increaseTotalGames(Long userID) {
//        User user = getUserById(userID);
//        user.setTotalGames(user.getTotalGames()+1);
//
//        em.getTransaction().begin();
//        em.persist(user);
//        em.getTransaction().commit();
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


