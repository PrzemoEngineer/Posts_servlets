package pl.sda.api;


import pl.sda.domain.user.post.Post;
import pl.sda.domain.user.post.PostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/posts")
public class PostServlet extends HttpServlet {

    PostService postService = PostService.getPostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            List<Post> posts = postService.findAll();
            req.setAttribute("posts", posts);
            redirectToPosts(req, resp); // niejawne przekierowanie
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String author = String.valueOf(req.getSession().getAttribute("login"));
        String content = req.getParameter("content");

        postService.addPost(author,content); // najpierw dodajemy do listy bazowej
        List<Post> posts = postService.findAll(); // potem tworzymy listę i przypisujemy jako atrybut -
                                                    // potem lista jest odczytana na stronie .jsp
        req.setAttribute("posts", posts);

        redirectToPosts(req, resp); // niejawne przekierowanie
    }

    private void redirectToPosts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/posts/posts.jsp"); // na widok zawsze przekirowanie niejawne !!!
        requestDispatcher.forward(req,resp);
    }
}
