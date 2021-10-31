import usermanagement.inter.User;
import usermanagement.inter.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import javax.naming.InvalidNameException;

public class UserServiceImplTest {

    private UserService userService;

    @Before
    public void setUp() {
        this.userService = new UserServiceImpl();
    }

    /**
     * Dieser Test dient zur Prüfung der Nutzersuche nach UserID.
     * @throws InvalidNameException
     */
    @Test
    public void testGetUserByID() throws InvalidNameException {
        int userID = 4444;
        User newUser = userService.createUser(userID, "Max", "Mustermann", "MaxMustermann", "Passwort1234");

        User userIDTest = userService.getUserById(userID);

        Assert.assertNotNull(userIDTest);
        //userService.removeUser(4444);
    }


    /**
     * Dieser Test dient zur Prüfung auf Sonderzeichen bei der Erstellung eines Users.
     * @throws InvalidNameException
     */
    @Test(expected = InvalidNameException.class)
    public void testCreateUserWithSpecialCharacters () throws InvalidNameException {
        String testFirstName = "M%s";
        String testLastName = "Mu$termann";

        User userWithSpecialCharacterInFirstName = userService.createUser(1234, testFirstName, "Mustermann", "MaxMustermann", "Passwort1234");
        User userWithSpecialCharacterInLastName = userService.createUser(1234, "Max", testLastName, "MaxMustermann", "Passwort1234");

        //Exception expected
    }


    /**
     * Dieser Test dient zur Prüfung auf leere Werte bei der Erstellung eines Users.
     * @throws InvalidNameException
     */
    @Test(expected = InvalidNameException.class)
    public void testCreateUserWithoutValues () throws InvalidNameException {
        String testFirstName = "Max";
        String testLastName = "Mustermann";
        String testUserName = "MaxMustermann";
        String testPassword = "Passwort";

        User userWithoutFirstname = userService.createUser(1234, "", testLastName, testUserName, testPassword);
        User userWithoutLastName = userService.createUser(1234, testFirstName, "", testUserName, testPassword);
        User userWithoutUsername = userService.createUser(1234, testFirstName, testLastName, "", testPassword);
        User userWithoutPassword = userService.createUser(1234, testFirstName, testLastName, testUserName, "");

        //Exception expected
    }

    /**
     * Dieser Test dient zur Prüfung der Komplexität des Passworts.
     * @throws InvalidNameException
     */
    @Test(expected = InvalidNameException.class)
    public void testCreateUserWithTooSimplePassword () throws InvalidNameException {
        String testPassword = "Passwort";

        User user = userService.createUser(1234, "Max", "Mustermann", "MaxMustermann", testPassword);

        //Exception expected
    }

    /**
     * Dieser Test dient zur Prüfung der Länge des Passworts.
     * @throws InvalidNameException
     */
    @Test(expected = InvalidNameException.class)
    public void testCreateUserWithTooShortPassword () throws InvalidNameException {
        String testPassword = "Pass";

        User user = userService.createUser(1234, "Max", "Mustermann", "MaxMustermann", testPassword);

        //Exception expected
    }
}
