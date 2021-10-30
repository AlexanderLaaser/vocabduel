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
        String testPassword = "Passwort";
        //Act
        User user = userService.createUser(testUserID, testFirstName, testLastName, testUserName, testPassword);
        //Assert
        Assert.assertNotNull(user);
    }

    @Test
    public void testCreateUserWithSpecialCharacters() throws InvalidNameException {
        //Arrage
        int testUserID = 1234;
        String testFirstName = "M%&s";
        String testLastName = "Mustermann";
        String testUserName = "MaxMustermann";
        String testPassword = "Passwort";
        //Act
        User user = userService.createUser(testUserID, testFirstName, testLastName, testUserName, testPassword);
        //Assert
        Assert.assertNotNull(user);
    }

    @Test(expected = InvalidNameException.class)
    public void testCreateUserWithoutValues() throws InvalidNameException {
        //Arrage
        int testUserID = 1234;
        String testFirstName = "";
        String testLastName = "";
        String testUserName = "";
        String testPassword = "";
        //Act
        User user = userService.createUser(testUserID, testFirstName, testLastName, testUserName, testPassword);
        //Assert
        //Exception expected
    }

    @Test(expected = InvalidNameException.class)
    public void testCreateUserWithoutPassword() throws InvalidNameException {
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
    public void testCreateUserWithSimplePassword() throws InvalidNameException {
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
