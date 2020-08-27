package pl.sda.domain.user;

import pl.sda.infrastructure.EntityMenagerProvider;

import javax.persistence.EntityManager;
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

//    private static List<User> users = new ArrayList<>();
//
//    static {
//        users.add(new User("admin", "admin"));
//        users.add(new User("admin2", "admin2"));
//        users.add(new User("admin3", "admin3"));
//    } jakby statycznie to mozna tak ale my hibernatujemy

    public Optional<User> findUserByUserName(String userName){
//        return users.stream()
//                .filter(user -> user.getUserName().equals(userName))
//                .findFirst();
        try{
            EntityManager em = EntityMenagerProvider.getEmntityMenager();
            em.getTransaction().begin();
            User user = em.find(User.class, userName);
            em.detach(user);
            em.getTransaction().commit();
            return Optional.of(user);
        }catch (Exception e) {
            return Optional.empty();
        }
    }

    public void addUser(String userName, String password) {
//        if (!findUserByUserName(userName).isEmpty()) {
//            return;
//        }
//        users.add(new User(userName,password));
        EntityManager em = null;
        try{
            em = EntityMenagerProvider.getEmntityMenager();
            em.getTransaction().begin();
            User user = new User(userName, password);
            em.persist(user);
            em.getTransaction().commit();
        }catch (Exception e) {
            throw new RuntimeException("Nie udfało się dodać użytkownika", e);
        }finally {
            em.close();
        }
    }

    public boolean authenticate(String userName, String password) {
        return findUserByUserName(userName)
                .filter(user -> user.getPassword().equals(password))
                .isPresent();
    }
}
