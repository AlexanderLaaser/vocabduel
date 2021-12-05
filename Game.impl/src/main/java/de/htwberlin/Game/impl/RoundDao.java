package de.htwberlin.Game.impl;

import de.htwberlin.game.inter.Game;
import de.htwberlin.game.inter.Round;

import javax.transaction.Transactional;

public interface RoundDao {
    @Transactional
    void saveRound(Round round);

    @Transactional
    void updateRound(Round round);
}
