import game.inter.GameService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import usermanagement.inter.User;
import usermanagement.inter.UserService;
import vocabmanagement.inter.VocabList;
import vocabmanagement.inter.VocabListService;

import java.util.List;


public class GameServiceTest {

    @InjectMocks
    private GameService gameService = new GameServiceImpl();

    @Mock
    private VocabListService vocabservice;

    @Mock
    private UserService userService;

    @Before
    public void setUp(){
        //this.gameService = new GameServiceImpl();
       // this.vocabservice = new VocabListServiceImpl();
        //mockuser = mock(User.class);

    }


    @Test(expected = NullPointerException.class)
    public void testmatchUser() throws NullPointerException{

        //Arrange
        //Act
        List<User> testUserList = gameService.matchUser();

        //Assert
        Assert.assertNotNull(testUserList);
    }

    @Test
    public void testCreateGame()  {

        //Arrange
        User user1 = new User(1, "Max", "Test", "maxtest", "1234",5,1,4);
        User user2 = new User(1, "Nax", "Test", "maxtest", "1234",5,1,4);

        //Hier muss thenReturn(Game instanz zurückgegeben werden)
        //Mockito.when(userService.getUserByID(1)).thenReturn(user1);

        //Act
        VocabList vocablist = vocabservice.receiveVocabList(1);
        gameService.createGame(user1, user2, vocablist);

        //Assert
        Mockito.verify(userService, Mockito.times(1)).getUserByID(1);
        Assert.assertNotNull(user1.getUserID());
        Assert.assertNotNull(user2);
        Assert.assertNotNull(vocablist);
        Assert.assertNotEquals(user1.getUserID(), user2.getUserID());

    }

    // testing receive VocabList

}