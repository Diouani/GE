package controller;

import entity.Users;
import service.implementation.UsersServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Home", value = "/home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("UserId") != null){
            UsersServiceImpl UsersService = new UsersServiceImpl();
            ArrayList<Users> users = (ArrayList<Users>) UsersService.getAll();
            request.setAttribute("users", users);
            this.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
        }else{
            response.sendRedirect("/");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
