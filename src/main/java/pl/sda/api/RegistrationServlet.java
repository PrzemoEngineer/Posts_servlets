package pl.sda.api;

import pl.sda.domain.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    UserService userService = UserService.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/users/registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        if (userName == null || userName.isBlank() || password == null || password.isBlank()) {
            req.setAttribute("message", "Niepoprawny login lub hasło");
            req.getRequestDispatcher("/errors/form-error.jsp").forward(req,resp);
        }

        if (userService.findUserByUserName(userName).isPresent()) {
            req.setAttribute("message", "Nazwa użytkownika już istnieje");
            req.getRequestDispatcher("/errors/form-error.jsp").forward(req,resp);
        }

        userService.addUser(userName, password);

        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
