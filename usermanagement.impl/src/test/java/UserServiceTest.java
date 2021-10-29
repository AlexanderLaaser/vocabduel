import usermanagement.inter.User;
import usermanagement.inter.UserService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp() { this.userService = new UserServicImpl(); }

    @Test
    public void testGetUserByID() {
        //Arrage
        int testUserID = 1234;
        //Act
        User user = userService.getUserByID(testUserID);
        //Assert
        Assert.assertNotNull(user);
    }

    @Test
    public void testRemoveUser() {
        //Arrange
        User testUser = new User();
        //Act
        User user = userService.removeUser(testUser);
        //Assert
        Assert.assertNotNull(user);
    }

    @Test
    public void testChangePassword() {
        //Arrange
        User testUser = new User();
        //Act
        User user = userService.changePassword(testUser);
        //Assert
        Assert.assertNotNull(user);
    }
}
