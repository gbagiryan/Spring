package am.basic.web.controller;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepositoryImplHibernate;
import am.basic.web.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Register")
public class Register extends HttpServlet {

    UserRepository userRepository = new UserRepositoryImplHibernate();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = null;
        String surname = null;
        String username = null;
        String password = null;
        int age = 0;

        if (request.getParameter("name") == null || request.getParameter("name").equals("")) {
            request.setAttribute("nameEmpty", "Name can't be empty");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } else {
            name = request.getParameter("name");
        }
        if (request.getParameter("surname") == null || request.getParameter("surname").equals("")) {
            request.setAttribute("surnameEmpty", "Surname can't be empty");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } else {
            surname = request.getParameter("surname");
        }
        if (request.getParameter("username").length() < 4) {
            request.setAttribute("usernameShort", "Username must have at least 4 symbols");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } else {
            username = request.getParameter("username");
        }
        if (request.getParameter("password").length() < 5) {
            request.setAttribute("passwordShort", "Password must have at least 5 symbols");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } else {
            password = request.getParameter("password");
        }
        if (request.getParameter("age") == null || Integer.parseInt(request.getParameter("age"))<=0) {
            request.setAttribute("ageEmpty", "Age must be a positive number");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } else {
            age = Integer.parseInt(request.getParameter("age"));
        }

        if (name != null && surname != null && username != null && password != null && age != 0) {


            User user1 = new User();

            user1.setName(name);
            user1.setSurname(surname);
            user1.setUsername(username);
            user1.setPassword(password);
            user1.setAge(age);

            User user = null;
            try {
                user = userRepository.getByName(username);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (user == null) {

                try {
                    userRepository.addUser(user1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("regSuccess", "Registration complete. You may now log in.");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                request.setAttribute("existingUser", "username already exists");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }

        }
    }
}
