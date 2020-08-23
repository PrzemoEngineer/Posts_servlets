package pl.sda.domain.user.post;

import pl.sda.domain.user.User;
import pl.sda.domain.user.UserService;

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

    static List<Post> posts = new ArrayList<>();

    static {
        posts.add(new Post("test",  new User("admin", "admin"), Instant.now()));
        posts.add(new Post("test",  new User("admin2", "admin2"), Instant.now()));
        posts.add(new Post("test",  new User("admin3", "admin3"), Instant.now()));
    }

    public List<Post> findAll() {
        return posts;
    }

    public void addPost(String userName, String content) {
        User user = userService.findUserByUserName(userName).orElseThrow();
        posts.add(new Post(content, user,Instant.now()));
    }
}
