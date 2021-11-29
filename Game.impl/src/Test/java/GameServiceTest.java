import game.inter.GameService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import usermanagement.inter.User;
import usermanagement.inter.UserService;
import vocabmanagement.inter.VocabList;
import vocabmanagement.inter.VocabListService;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    private VocabList testVocabList;

    @Spy
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

    @Test
    public void testCreateGameSameUser()  {

        //Arrange
        User user1 = new User(1, "Max", "Test", "maxtest", "1234",5,1,4);
        User user2 = new User(1, "Nax", "Test", "maxtest", "1234",5,1,4);

        //Act
        VocabList vocablist = vocabservice.receiveVocabList(1);
        gameService.createGame(user1, user2, vocablist);

        //Assert
        Mockito.verify(userService, Mockito.times(1)).getUserByID(1);
        Assert.assertNotNull(user1);
        Assert.assertNotNull(user2);
        Assert.assertNotEquals(user1, user2);

    }
    @Test
    public void testCreateGameUserNullFail()  {

        int testUserID = 3;
        //Arrange
        User user1 = new User(1, "Max", "Test", "maxtest", "1234",5,1,4);
        User user3 = userService.getUserByID(testUserID);

        //Hier muss thenReturn(Game instanz zurückgegeben werden)
        Mockito.when(userService.getUserByID(1)).thenReturn(user3);

        //Act
        VocabList vocablist = vocabservice.receiveVocabList(1);
        gameService.createGame(user1, user3, vocablist);

        //Assert
        Mockito.verify(userService, Mockito.times(1)).getUserByID(testUserID);
        Assert.assertNotNull(user1);
        Assert.assertNotNull(user3);
        Assert.assertNotNull(vocablist);
        Assert.assertNotEquals(user1.getUserID(), user3.getUserID());

    }

    @Test
    public void testCreateGameTrue()  {

        int testUserID = 3;
        //Arrange
        User user1 = new User(1, "Max", "Test", "maxtest", "1234",5,1,4);
        User user2 = new User(2, "Max", "Test", "maxtest", "1234",5,1,4);

        //Hier muss thenReturn(Game instanz zurückgegeben werden)
        //Mockito.when(userService.getUserByID(1)).thenReturn(user1);

        //Act
        VocabList vocablist = vocabservice.receiveVocabList(1);
        gameService.createGame(user1, user2, vocablist);

        //Assert
        Mockito.verify(userService, Mockito.times(1)).getUserByID(testUserID);
        Assert.assertNotNull(user1);
        Assert.assertNotNull(user2);
        Assert.assertNotEquals(user1, user2);

    }

    @Test
    public void testmatchUser(){

        //Arrange
        //Act
        List<User> testUserList = gameService.matchUser();

        //Assert
        Assert.assertNotNull(testUserList);
    }



    @Test
    public void testGenerateCustomVocabSet() {

        //Arrange
        vocabservice.createVocabList();
        VocabList choosedList = vocabservice.receiveVocabList(1);
        //Act

        gameService.generateCustomVocabSet(choosedList);
        //Assert
        Assert.assertNotNull(choosedList);

    }

    @Test
    public void testInitRoundWrongRoundNumber() {

        //Arrange
        List<User> userList = gameService.matchUser();

        //Act
        gameService.InitRound(userList, 1, 4);


        //Assert

    }

    @Test
    public void testCalcualteTotalWinner() {

        //Arrange
        int winningUserRound1 = 2;
        int winningUserRound2 = 2;
        int winningUserRound3 = 2;
        int winningUser;
        //Act
        winningUser = gameService.calcualteTotalWinner(winningUserRound1, winningUserRound2, winningUserRound3);

        //Assert

    }

}
