package pl.sda.api;

import pl.sda.domain.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;

@WebServlet(urlPatterns = {"/", "/login"})
public class LoginServlet extends HttpServlet {

    private UserService userService = UserService.getUserService();

    @Override // do wyświetlania formularza logowania
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object login = req.getSession().getAttribute("login");

        if (login == null || String.valueOf(login).isBlank()) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/users/login.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("/posts"); // przekierowanie do servletu zajmującego się postami
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserService.getUserService();
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (login == null || login.isBlank() || password == null || password.isBlank()) {
            sendRedirectToErrorPage(req, resp);
            return;
        }

        if(!userService.authenticate(login, password)) {
            sendRedirectToErrorPage(req, resp);
            return;
        }
        req.getSession().setAttribute("login", login);
        resp.addCookie(new Cookie("loginAt", Instant.now().toString()));
        resp.sendRedirect(req.getContextPath() + "/posts");
    }

    private void sendRedirectToErrorPage(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("message", "Niepoprawny login lub hasło");
        req.getRequestDispatcher("/errors/form-error.jsp");
    }
}
