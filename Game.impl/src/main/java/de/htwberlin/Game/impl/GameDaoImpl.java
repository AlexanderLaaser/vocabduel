package de.htwberlin.Game.impl;

import de.htwberlin.game.inter.Game;
import de.htwberlin.game.inter.Round;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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

    @Override
    public void deleteGame(Game game){
        List<Round> rounds = game.getRounds();
        Round round1 = rounds.get(0);
        Round round2 = rounds.get(1);
        Round round3 = rounds.get(2);
        em.remove(round1);
        em.remove(round2);
        em.remove(round3);

        em.remove(game);
    }

    @Override
    public Game getGameById(Long gameId){
        TypedQuery<Game> g = (TypedQuery<Game>) em.createQuery("SELECT g.gameId FROM Game g WHERE g.gameID like: gameId ");
        g.setParameter("gameId", gameId);
        Game game = g.getSingleResult();
        return game;
    }
}
