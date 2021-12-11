import de.htwberlin.usermanagement.inter.InvalidUserException;
import de.htwberlin.usermanagement.inter.User;
import de.htwberlin.usermanagement.inter.UserService;
import org.junit.Before;
import org.junit.Test;

import javax.naming.InvalidNameException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserServiceImplTest {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAKBA");
    private EntityManager em = emf.createEntityManager();

    private UserService userService;

    @Before
    public void setUp() {
//        this.userService = new UserServiceImpl();
    }


    @Test
    public void testGetUserByIdExist() throws InvalidNameException {
        User testUser = userService.getUserById(25L);
    }

    @Test
    public void testGetUserByIdNotExistant() throws InvalidNameException {
        User testUser = userService.getUserById(100L);
    }


    @Test
    public void testIncreaseTotalGames() throws  InvalidNameException {
        userService.increaseTotalGames(30L);

    }

}
