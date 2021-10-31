import game.inter.Game;
import game.inter.GameService;
import game.inter.Round;
import game.inter.RoundService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import usermanagement.inter.InvalidUserException;
import usermanagement.inter.User;
import usermanagement.inter.UserService;
import vocabmanagement.inter.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    @Spy
    @InjectMocks
    private GameService gameService = new GameServiceImpl();
    @InjectMocks
    private RoundService roundService = new RoundServiceImpl();

    @Mock
    private UserService userService;
    @Mock
    private VocabListService vocabservice;
    @Mock
    private Category mockcategory;
    @Mock
    private Language mocklanguage;
    @Mock
    private VocabList mocklist;
    @Mock
    private Game mockGame;

    @Before
    public void setUp(){
    }

    /**
     * Test bekommt 2x die gleiche UserID und wirft daher eine InvalidUserException
     * @throws InvalidUserException
     */
    @Test(expected = InvalidUserException.class)
    public void testValidateUserMatchFail() throws InvalidUserException {
        int  userId = 1;
        User mockuser = new User(userId,"Peter", "Test","Supertester123", "qwer");

        Mockito.when(userService.getUserById(userId)).thenReturn(mockuser);

        gameService.validateUserMatch(userId,userId);
    }

    /**
     * Test bekommt 2 unterschiedliche UserIds daher sind die User valide
     * @throws InvalidUserException
     */
    @Test
    public void testValidateUserMatch() throws InvalidUserException {
        int  userId1 = 1;
        int  userId2 = 2;

        User mockuser1 = new User(userId1,"Peter", "Test","Supertester123", "qwer");
        User mockuser2 = new User(userId2,"Peter", "Test","Supertester123", "qwer");

        Mockito.when(userService.getUserById(userId1)).thenReturn(mockuser1);
        Mockito.when(userService.getUserById(userId2)).thenReturn(mockuser2);

        gameService.validateUserMatch(userId1,userId2);

        Mockito.verify(userService, Mockito.times(1)).getUserById(userId1);
        Mockito.verify(userService, Mockito.times(1)).getUserById(userId2);
        Assert.assertNotEquals(mockuser1.getUserID(),mockuser2.getUserID());
    }

    /**
     * Test erstellt ein Game mit künstlichen Daten aus User und VocabList
     * @throws InvalidUserException
     */
    @Test
    public void testCreateGame() throws InvalidUserException {
        int userId1 = 1;
        int userId2 = 2;
        int listId = 2;

        List listLeftLan = new ArrayList();
        listLeftLan.add("Hallo");
        List listRightLan = new ArrayList();
        listRightLan.add("Hello");
        List<VocabItem> vocabItems = new ArrayList<VocabItem>();
        VocabItem mockitem = new VocabItem(1L,listLeftLan, listRightLan);
        vocabItems.add(mockitem);

        User mockuser1 = new User(userId1,"Peter", "Test","Supertester123", "qwer");
        User mockuser2 = new User(userId2,"Peter", "Test","Supertester123", "qwer");

        VocabList mocklist = new VocabList(listId,mocklanguage, mocklanguage, mockcategory, vocabItems);

        Mockito.when(userService.getUserById(userId1)).thenReturn(mockuser1);
        Mockito.when(userService.getUserById(userId2)).thenReturn(mockuser2);
        Mockito.when(vocabservice.getVocabListByID(listId)).thenReturn(mocklist);

        Game gametestObj = gameService.createGame(userId1, userId2, listId);

        Assert.assertEquals(mockuser1.getUserID(), userId1);
        Assert.assertNotNull(mockuser2);
        Assert.assertNotNull(gametestObj);
        Assert.assertNotNull(gametestObj.getGameOwner());
    }

    /**
     * test initialisiert Runden
     */
    @Test
    public void testInitRounds(){
        int anzahlRunden = 2;
        LinkedHashMap<String, List<String>>  TestList;

        LinkedHashMap<String, List<String>>  CustomVocabListmock = new LinkedHashMap<String, List<String>> ();
        List<String> fakeAnswerList = new ArrayList<String>();
        fakeAnswerList.add("Fake1");
        fakeAnswerList.add("Fake2");
        fakeAnswerList.add("Fake3");
        CustomVocabListmock.put("Hallo",fakeAnswerList);
        CustomVocabListmock.put("Tschüss",fakeAnswerList);

        Mockito.when(vocabservice.generateCustomVocabSet(anzahlRunden)).thenReturn(CustomVocabListmock);
        Round roundTestObj = gameService.InitRounds(1,anzahlRunden,mockGame);

        Mockito.verify(vocabservice, Mockito.times(1)).generateCustomVocabSet(anzahlRunden);
        Assert.assertNotNull(roundTestObj);
        Assert.assertTrue(roundTestObj.getVocabSet().containsKey("Hallo"));
    }

    /**
     * Test aktualisiert User Daten
     */
    @Test
    public void testUpdateUserDataAfterGame(){
        int UserId = 1;
        User mockuser1 = new User(UserId,"Peter", "Test","Supertester123", "qwer");

        gameService.UpdateUserDataAfterGame(1);

        Mockito.verify(userService, Mockito.times(1)).increaseTotalGames(UserId);
    }

    /**
     * Testet Algorithmus zum Feststellen des Gewinners
     */
    @Test
    public void testCalcualteTotalWinner() {

        int winningUserRound1 = 2;
        int winningUserRound2 = 2;
        int winningUserRound3 = 2;
        int winningUser;

        winningUser = gameService.calculateTotalWinner(winningUserRound1, winningUserRound2, winningUserRound3);
        Assert.assertEquals(1,winningUser);

    }


}