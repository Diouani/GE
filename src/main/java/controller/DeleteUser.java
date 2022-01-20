package controller;

import dao.implementation.UsersDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeleteUser", value = "/delete")
public class DeleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("UserId") != null) {
            Long userId = Long.parseLong((String) request.getParameter("id"));
            new UsersDaoImpl().delete(userId);
            response.sendRedirect("/home");
        } else {
            response.sendRedirect("/");
        }
    }

}
