import game.inter.GameStatisticService;
import org.junit.Before;
import org.junit.Test;

public class GameStatisticServiceTest {

    private GameStatisticService gameStatService = new GameStatisticImpl();

    @Before
    public void setUp() {
        this.gameStatService = new GameStatisticImpl();
    }

    @Test
    public void showGameStatisticTest(){
        //funktionallität der Klassen muss noch näher spezifiziert werden für einen Test
    }

}
