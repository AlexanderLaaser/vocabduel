package de.htwberlin.game.inter;

public interface GameStatisticService {

    /**
     * Erstellt eine GameStatistik Objekt
     * @return GameStatistik Objekt
     */
    GameStatistic createGameStatistic();


    /**
     * Gibt ein Objekt einer GameStatistik zurück
     * @return GameStatistik Objekt
     */
    GameStatistic getGameStatsById(int GamestatId);
}
