package de.htwberlin.Game.impl;

import de.htwberlin.game.inter.GameStatistic;
import de.htwberlin.game.inter.GameStatisticService;

public class GameStatisticImpl implements GameStatisticService {

    //combine the information of game
    @Override
    public GameStatistic createGameStatistic(){

        GameStatistic gameStats = new GameStatistic();
        return gameStats;
    }

    //Implement something, that pushes the Statistic in the terminal
    @Override
    public GameStatistic getGameStatsById(int GameStatId){
        return null;
    }


}