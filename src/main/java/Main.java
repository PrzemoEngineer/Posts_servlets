import pl.sda.domain.user.UserService;
import pl.sda.domain.user.post.PostService;

public class Main {
    public static void main(String[] args) {
        UserService userService = UserService.getUserService();




        PostService postService = PostService.getPostService();
        postService.findAll().stream().forEach(post -> System.out.println(post));
    }
}
