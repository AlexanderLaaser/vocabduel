import game.inter.GuessService;
import org.junit.Before;

/***
 * Ausarbeitung erfolgt nach Implementierung der Datenquelle.
 * Im weiteren Verlauf des Projekts wird die Testklasse implementiert.
 */
public class GuessServiceTest {

    private GuessService guessService;

    @Before
    public void setUp(){
        this.guessService = new GuessServiceImpl();
    }
}
