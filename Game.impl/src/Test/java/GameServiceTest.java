import game.inter.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import usermanagement.inter.User;

import java.util.List;


public class GameServiceTest {

    private GameService gameService;
    @Before
    public void setUp(){
        this.gameService = new GameServiceImpl();
    }

    @Test(expected = NullPointerException.class)
    public void testCreateGame() throws NullPointerException{

        //Arrange
        User testUser1 = new User();
        User testUser2 = new User();
        //VocabList testVocablist = new VocabList();

        //Act
         List<User> testUserList = gameService.matchUser();

        //Assert
        Assert.assertNotNull(testUserList);
    }
}