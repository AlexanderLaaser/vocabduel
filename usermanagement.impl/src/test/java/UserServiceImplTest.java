import usermanagement.inter.User;
import usermanagement.inter.UserService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.InvalidNameException;
import java.util.LinkedList;


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
        //Arrange
        int userID = 4444;
        User newUser = userService.createUser(userID, "Max", "Mustermann", "MaxMustermann", "Passwort1234", 1, 1, 1);
        //Act
        User userIDTest = userService.getUserById(userID);
        //Assert
        Assert.assertNotNull(userIDTest);
        //userService.removeUser(4444);
    }


    /**
     * Dieser Test dient zur Prüfung auf Sonderzeichen bei der Erstellung eines Users.
     * @throws InvalidNameException
     */
    @Test(expected = InvalidNameException.class)
    public void testCreateUserWithSpecialCharacters () throws InvalidNameException {
        //Arrange
        String testFirstName = "M%s";
        String testLastName = "Mu$termann";
        //Act
        User userWithSpecialCharacterInFirstName = userService.createUser(1234, testFirstName, "Mustermann", "MaxMustermann", "Passwort1234", 1, 1, 1);
        User userWithSpecialCharacterInLastName = userService.createUser(1234, "Max", testLastName, "MaxMustermann", "Passwort1234", 1, 1, 1);
        //Assert
        //Exception expected
    }


    /**
     * Dieser Test dient zur Prüfung auf leere Werte bei der Erstellung eines Users.
     * @throws InvalidNameException
     */
    @Test(expected = InvalidNameException.class)
    public void testCreateUserWithoutValues () throws InvalidNameException {
        //Arrange
        String testFirstName = "Max";
        String testLastName = "Mustermann";
        String testUserName = "MaxMustermann";
        String testPassword = "Passwort";
        //Act
        User userWithoutFirstname = userService.createUser(1234, "", testLastName, testUserName, testPassword, 1, 1, 1);
        User userWithoutLastName = userService.createUser(1234, testFirstName, "", testUserName, testPassword, 1, 1, 1);
        User userWithoutUsername = userService.createUser(1234, testFirstName, testLastName, "", testPassword, 1, 1, 1);
        User userWithoutPassword = userService.createUser(1234, testFirstName, testLastName, testUserName, "", 1, 1, 1);
        //Assert
        //Exception expected
    }

    /**
     * Dieser Test dient zur Prüfung der Komplexität des Passworts.
     * @throws InvalidNameException
     */
    @Test(expected = InvalidNameException.class)
    public void testCreateUserWithTooSimplePassword () throws InvalidNameException {
        //Arrange
        String testPassword = "Passwort";
        //Act
        User user = userService.createUser(1234, "Max", "Mustermann", "MaxMustermann", testPassword, 1, 1, 1);
        //Assert
        //Exception expected
    }

    /**
     * Dieser Test dient zur Prüfung der Länge des Passworts.
     * @throws InvalidNameException
     */
    @Test(expected = InvalidNameException.class)
    public void testCreateUserWithTooShortPassword () throws InvalidNameException {
        //Arrange
        String testPassword = "Pass";
        //Act
        User user = userService.createUser(1234, "Max", "Mustermann", "MaxMustermann", testPassword, 1, 1, 1);
        //Assert
        //Exception expected
    }
}
