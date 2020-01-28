package am.basic.web.controller;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepositoryImplHibernate;
import am.basic.web.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Start")
public class Start extends HttpServlet {

    UserRepository userRepository = new UserRepositoryImplHibernate();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = null;

        if (request.getCookies() == null) {
            response.sendRedirect("/index.jsp");
            return;
        }

        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("username")) {
                username = cookie.getValue();
            }

        }
        if (username == null) {
            response.sendRedirect("/index.jsp");
        } else {
            User user = null;
            try {
                user = userRepository.getByName(username);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("/secure/home.jsp");

        }
    }
}
