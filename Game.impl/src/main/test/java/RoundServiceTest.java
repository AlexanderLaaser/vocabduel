import game.inter.RoundService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoundServiceTest {

    private RoundService roundService = new RoundServiceImpl();

    @Before
    public void setUp() {
        this.roundService = new RoundServiceImpl();
    }

    @Test
    public void askForGuessTest(){
        // Arrange
        int testGuess;
        // Act
        testGuess = roundService.askForGuess();
        // Assert
        Assert.assertNotEquals(testGuess, 0);

    }

    @Test
    public void calculateRoundResults(){
        // Arrange
        int roundResult;
        // Act
        roundResult = roundService.calculateRoundResults();
        // Assert
        Assert.assertNotEquals(roundResult, 0);


    }
}
