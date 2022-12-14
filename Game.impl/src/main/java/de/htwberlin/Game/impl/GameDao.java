package de.htwberlin.Game.impl;

import de.htwberlin.game.inter.Game;

import javax.transaction.Transactional;

public interface GameDao {

    @Transactional
    void saveGame(Game game);

    @Transactional
    void updateGame(Game game);

    @Transactional
    public void deleteGame(Game game);

    @Transactional
    public Game getGameById(int gameId);
}
