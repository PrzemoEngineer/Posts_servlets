package pl.sda.domain.user.post;

import pl.sda.domain.user.User;
import pl.sda.domain.user.UserService;
import pl.sda.infrastructure.EntityMenagerProvider;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PostService {
    private final static PostService INSTANCE = new PostService();

    public static PostService getPostService() {
        return INSTANCE;
    }

    private PostService() {
    }
    private final UserService userService = UserService.getUserService();

//    static List<Post> posts = new ArrayList<>();
//
//    static {
//        posts.add(new Post("test",  new User("admin", "admin"), Instant.now()));
//        posts.add(new Post("test",  new User("admin2", "admin2"), Instant.now()));
//        posts.add(new Post("test",  new User("admin3", "admin3"), Instant.now()));
//    }

    public List<Post> findAll() {
        EntityManager em = EntityMenagerProvider.getEmntityMenager();

        return em.createQuery("FROM Post", Post.class).getResultList();
    }

    public void addPost(String userName, String content) {
//        User user = userService.findUserByUserName(userName).orElseThrow();
//        posts.add(new Post(content, user,Instant.now()));
        EntityManager em = EntityMenagerProvider.getEmntityMenager();
        em.getTransaction().begin();
        User user = em.find(User.class, userName);
        Post post = new Post(content, user, Instant.now());
        em.persist(post);

        em.getTransaction().commit();
    }
}
