package game.inter;

import game.inter.GameStatistic;

public interface GameStatisticService {

    //combine the information of game

    /***
     *
     * @return the Statistic from the Game
     */
    GameStatistic createGameStatistik();

    //Implement something, that pushes the Statistic in the terminal

    /***
     * shows Gamestatistik
     *
     */
    void showGameStatistic();
}
