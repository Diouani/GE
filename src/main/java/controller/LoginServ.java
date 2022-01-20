package controller;

import entity.Users;
import service.implementation.UsersServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServ", value = "/login")
public class LoginServ extends HttpServlet {
    private UsersServiceImpl auth;

    public void init() {
        auth = new UsersServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(auth.login(username, password));
        if (auth.login(username, password) == 1) {
            long userId = new UsersServiceImpl().findByEmail(username).getUserId();
            HttpSession session = request.getSession();
            session.setAttribute("UserId" , userId );

            response.sendRedirect("home");
        } else {
            RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
            rd.include(request,response);
            response.sendRedirect("/");
        }
    }
}
