package de.htwberlin.Game.impl;

import de.htwberlin.game.inter.Game;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class GameDaoImpl implements GameDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveGame(Game game){
        em.persist(game);
    }

    @Override
    public void updateGame(Game game) {
        em.merge(game);
    }
}
