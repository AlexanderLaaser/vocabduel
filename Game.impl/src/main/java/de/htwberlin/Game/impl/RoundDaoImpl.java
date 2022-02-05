package de.htwberlin.Game.impl;

import de.htwberlin.game.inter.Game;
import de.htwberlin.game.inter.Round;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

    @Override
    public void deleteRound(Round round){
        em.remove(round);
    }

    @Override
    public Round getRoundById(int id){
//        TypedQuery<Round> r = (TypedQuery<Round>) em.createQuery("SELECT r.roundId FROM Round r WHERE r.roundId like: roundId ");
//        r.setParameter("roundId", roundId);
//        Round round = r.getSingleResult();
        System.err.println(id);
        Round round = em.find(Round.class, id);
        System.err.println(round.getClass());
        return round;
    }


}
