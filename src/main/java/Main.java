
import pl.sda.infrastructure.EntityMenagerProvider;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
//        UserService userService = UserService.getUserService();
//
//        PostService postService = PostService.getPostService();
//        postService.findAll().stream().forEach(post -> System.out.println(post));
        EntityManager entityManager = EntityMenagerProvider.getEmntityMenager();

        entityManager.isOpen();
    }
}
