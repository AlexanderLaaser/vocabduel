package de.htwberlin.usermanagement.impl;

import de.htwberlin.usermanagement.inter.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveUser(User user) {em.persist(user);
    }

    @Override
    public User getUserById(Long id) {
        TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.userID=:id", User.class);
        q.setParameter("id", id);
        List<User> userResult = q.getResultList();
        if (!userResult.isEmpty()) {
            User user = userResult.get(0);
            return user;
        } else {
            return null;
        }
    }

    @Override
    public User getUserByUsername(String username) {
        TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.userName=:username", User.class);
        q.setParameter("username", username);
        List<User> userResult = q.getResultList();
        if (!userResult.isEmpty()) {
            User user = userResult.get(0);
            return user;
        } else {
            return null;
        }
    }

    public List<User> getAllUser() {
        TypedQuery<User> q = em.createQuery("SELECT u FROM User AS u", User.class);
        List<User> allUser = q.getResultList();
        return allUser;
    }

    @Override
    public void removeUser(User user) {em.remove(user);}

    @Override
    public void changePassword(User user) {em.persist(user);}

    @Override
    public void increaseTotalGames(User user) {em.persist(user);}

    @Override
    public void increaseGamesWon(User user) {em.persist(user);}

    @Override
    public void increaseGamesLost(User user) {em.persist(user);}

}
