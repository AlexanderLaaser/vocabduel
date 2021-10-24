package usermanagement.inter;

public interface UserService {

    User removeUser(User userID);
    User changePassword(User password);
}
