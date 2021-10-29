import game.inter.GameStatistic;

public interface GameStatisticService {

    //combine the information of game
    GameStatistic createGameStatistik();

    //Implement something, that pushes the Statistic in the terminal
    void showGameStatistic();
}
