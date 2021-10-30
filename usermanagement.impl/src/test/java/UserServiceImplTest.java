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


    @Test
    public void testCreateUser() throws InvalidNameException {
        //Arrage
        int testUserID = 1234;
        String testFirstName = "Max";
        String testLastName = "Mustermann";
        String testUserName = "MaxMustermann";
        String testPassword = "Passwort1234";
        //Act
        User user = userService.createUser(testUserID, testFirstName, testLastName, testUserName, testPassword);
        //Assert
        Assert.assertNotNull(user);
    }


    @Test(expected = InvalidNameException.class)
    public void testCreateUserWithSpecialCharacters() throws InvalidNameException {
        //Arrage
        int testUserID = 1234;
        String testFirstName = "M%s";
        String testLastName = "Mu$termann";
        String testUserName = "M%xMu$termann";
        String testPassword = "Passwort";
        //Act
        User userWithSpecialCharacterInFirstName = userService.createUser(testUserID, testFirstName, "Mustermann", "MaxMustermann", testPassword);
        User userWithSpecialCharacterInLastName = userService.createUser(testUserID, "Max", testLastName, "MaxMustermann", testPassword);
        User userWithSpecialCharacterInUserName = userService.createUser(testUserID, "Max", "Mustermann", testUserName, testPassword);
        //Assert
        //Exception expected
    }


    @Test(expected = InvalidNameException.class)
    public void testCreateUserWithoutValues() throws InvalidNameException {
        //Arrage
        int testUserID = 1234;
        String testFirstName = "Max";
        String testLastName = "Mustermann";
        String testUserName = "MaxMustermann";
        String testPassword = "Passwort";
        //Act
        User userWithoutFirstname = userService.createUser(testUserID, "", testLastName, testUserName, testPassword);
        User userWithoutLastName = userService.createUser(testUserID, testFirstName, "", testUserName, testPassword);
        User userWithoutUsername = userService.createUser(testUserID, testFirstName, testLastName, "", testPassword);
        User userWithoutPassword = userService.createUser(testUserID, testFirstName, testLastName, testUserName, "");
        //Assert
        //Exception expected
    }


    @Test(expected = InvalidNameException.class)
    public void testCreateUserWithTooSimplePassword() throws InvalidNameException {
        //Arrage
        int testUserID = 1234;
        String testFirstName = "Max";
        String testLastName = "Mustermann";
        String testUserName = "MaxMustermann";
        String testPassword = "Passwort";
        //Act
        User user = userService.createUser(testUserID, testFirstName, testLastName, testUserName, testPassword);
        //Assert
        //Exception expected
    }


    @Test(expected = InvalidNameException.class)
    public void testCreateUserWithTooShortPassword() throws InvalidNameException {
        //Arrage
        int testUserID = 1234;
        String testFirstName = "Max";
        String testLastName = "Mustermann";
        String testUserName = "MaxMustermann";
        String testPassword = "Pass";
        //Act
        User user = userService.createUser(testUserID, testFirstName, testLastName, testUserName, testPassword);
        //Assert
        //Exception expected
    }


    @Test
    public void testGetUserByID() {
    }


    @Test
    public void testRemoveUser() {
    }


    @Test
    public void testChangePassword() {
    }


    @Test
    public void testIncreaseTotalGames() {
    }


}
