package de.htwberlin.usermanagement.impl;

import de.htwberlin.usermanagement.inter.User;
import de.htwberlin.usermanagement.inter.UserService;

import org.springframework.stereotype.Component;

import javax.naming.InvalidNameException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


@Component
public class UserServiceImpl implements UserService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAKBA");
    private EntityManager em = emf.createEntityManager();

    @Override
    public User createUser(String firstName, String lastName, String userName, String password) throws InvalidNameException {
        validateName(firstName);
        validateName(lastName);

        User tempUser = new User(firstName, lastName, userName, password);
        em.getTransaction().begin();
        em.persist(tempUser);
        em.getTransaction().commit();

        return tempUser;
    }

    @Override
    public User getUserById(Long id) {
        em.getTransaction().begin();
        TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.userID=:id", User.class);
        q.setParameter("id", id);
        List<User> userResult = q.getResultList();
        em.getTransaction().commit();
        if (!userResult.isEmpty()) {
            User user = userResult.get(0);
            return user;
        } else {
            return null;
        }
    }

    public List<User> getAllUser(){
        em.getTransaction().begin();
        TypedQuery<User> q = em.createQuery("SELECT u FROM User AS u", User.class);
        List<User> allUser = q.getResultList();
        em.getTransaction().commit();
        return allUser;
    }

    @Override
    public void removeUser(Long userID) {
        User user = getUserById(userID);

        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    @Override
    public void changePassword(Long userID, String password) throws InvalidNameException {
        validatePassword(password);
        User user = getUserById(userID);
        user.setPassword(password);

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void increaseTotalGames(Long userID) {
        User user = getUserById(userID);
        user.setTotalGames(user.getTotalGames()+1);

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
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


