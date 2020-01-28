package am.basic.web.controller;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepositoryImplHibernate;
import am.basic.web.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


public class Login extends HttpServlet {

    UserRepository userRepository = new UserRepositoryImplHibernate();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Boolean remember = Boolean.valueOf(request.getParameter("remember"));

        PrintWriter printWriter = response.getWriter();
        HttpSession session = request.getSession();


        try {
            User dbUser = userRepository.getByName(username);
            if (dbUser.getPassword().equals(password)) {

                session.setAttribute("user", dbUser);

                if (remember == true) {
                    Cookie cookie = new Cookie("username", dbUser.getUsername());
                    cookie.setMaxAge(30 * 24 * 60);
                    response.addCookie(cookie);
                }

                response.sendRedirect("/secure/home.jsp");
            } else {
                request.setAttribute("wrongLogin", "wrong password");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException n) {
            request.setAttribute("wrongLogin", "username doesn't exist");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }


}
