package pl.sda.domain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private static final UserService INSTANCE = new UserService();

    public static UserService getUserService() {
        return INSTANCE;
    }

    private UserService() {
    }

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("admin", "admin"));
        users.add(new User("admin2", "admin2"));
        users.add(new User("admin3", "admin3"));
    }

    public Optional<User> findUserByUserName(String userName){
        return users.stream()
                .filter(user -> user.getUserName().equals(userName))
                .findFirst();
    }

    public void addUser(String userName, String password) {
        if (!findUserByUserName(userName).isEmpty()) {
            return;
        }
        users.add(new User(userName,password));
    }

    public boolean authenticate(String userName, String password) {
//        for (User user: users) {
//            if (user.getUserName().equals(userName)) {
//                return user.getPassword().equals(password);
//            }
//        }
//        return false;

//        Optional<User> user = findUserByUserName(userName);
//        return user.isPresent() && user.get().getPassword().equals(password);
        return findUserByUserName(userName)
                .filter(user -> user.getPassword().equals(password))
                .isPresent();
    }
}
