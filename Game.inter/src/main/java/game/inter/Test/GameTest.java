package game.inter.Test;

import game.inter.Game;
import org.junit.Assert;
import org.junit.Test;
import usermanagement.inter.User;
import vocabmanagement.inter.VocabList;

import java.util.List;

//@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    //   @InjectMocks
//    private User userService = new User();
//    @Mock
//    private VocabList vocabListService = new VocabList();

 //   @Before
 //   public void setUp() {
//		this.userService = Mockito.mock(User.class);
//    }

    @Test
            //(expected = NullPointerException.class)
    public void testCreateGame() throws NullPointerException{

        //Arrange
        Game tester = new Game();
        User testUser1 = new User();
        User testUser2 = new User();
        VocabList testVocablist = new VocabList();

        //Act
        List<User> testUserList = tester.matchUser();

        //Assert
        Assert.assertNotNull(testUserList);
    }
}