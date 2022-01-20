package controller;

import dao.implementation.UsersDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteUser", value = "/delete")
public class DeleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("UserId") != null) {
            Long userId = Long.parseLong((String) request.getParameter("id"));
            new UsersDaoImpl().delete(userId);
            response.sendRedirect("/home");
        }else{
            response.sendRedirect("/");
        }
    }

}
