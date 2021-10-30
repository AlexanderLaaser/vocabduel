package usermanagement.inter;

import javax.naming.InvalidNameException;

public interface UserService {

    User createUser(int userID, String firstName, String lastName, String userName, String password) throws InvalidNameException;
    User getUserById(int userID);
    void removeUser(int userID);
    void changePassword (int userID, String password);
    void increaseTotalGames(int userID);

}



