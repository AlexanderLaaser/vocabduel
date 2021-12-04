package de.htwberlin.usermanagement.impl;

import de.htwberlin.usermanagement.inter.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveUser(User user){
        em.persist(user);
    }
}
