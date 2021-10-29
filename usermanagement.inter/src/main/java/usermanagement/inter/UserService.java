package usermanagement.inter;

public interface UserService {

    User getUserByID(int userID);
    User removeUser(User userID);
    User changePassword(User password);
}
