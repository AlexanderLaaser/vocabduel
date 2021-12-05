package de.htwberlin.Game.impl;

import de.htwberlin.game.inter.Game;
import de.htwberlin.game.inter.Round;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoundDaoImpl implements RoundDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveRound(Round round){
        em.persist(round);
    }
    @Override
    public void updateRound(Round round){
        em.merge(round);
    }


}
