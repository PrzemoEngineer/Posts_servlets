package pl.sda.api;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/posts")
public class LoginCheckFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        Object login = req.getSession().getAttribute("login");

        if (login == null || String.valueOf(login).isBlank()) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/users/login.jsp");
            requestDispatcher.forward(req, res);
        } else {
            chain.doFilter(req, res);
        }
    }
}
