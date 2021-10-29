import game.inter.Game;
import game.inter.GameStatistic;

public class GameStatisticImpl implements GameStatisticService {

    private GameStatistic gameStats = new GameStatistic();

    //combine the information of game
    @Override
    public GameStatistic createGameStatistik(){

        return gameStats;
    }

    //Implement something, that pushes the Statistic in the terminal
    @Override
    public void showGameStatistic(){

    }


}
