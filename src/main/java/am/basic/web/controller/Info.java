package am.basic.web.controller;

import am.basic.web.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Info")
public class Info extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        PrintWriter printWriter = response.getWriter();

        printWriter.println("ID " + user.getId());
        printWriter.println("Name " + user.getName());
        printWriter.println("Surname " + user.getSurname());
        printWriter.println("Username " + user.getUsername());
        printWriter.println("Password " + user.getPassword());
        printWriter.println("Age " + user.getAge());
        printWriter.println("Code " + user.getCode());
    }
}
