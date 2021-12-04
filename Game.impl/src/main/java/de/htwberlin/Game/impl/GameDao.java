package de.htwberlin.Game.impl;

import de.htwberlin.game.inter.Game;

import javax.transaction.Transactional;

public interface GameDao {

    @Transactional
    void saveGame(Game game);
}
