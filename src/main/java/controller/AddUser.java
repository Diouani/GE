package controller;

import dao.implementation.RoleDaoImpl;
import entity.Address;
import entity.Role;
import entity.Users;
import service.implementation.AddressServiceImpl;
import service.implementation.RoleServiceImpl;
import service.implementation.UsersServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddUser",  urlPatterns={"/add", "/update"})
public class AddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if(session.getAttribute("UserId") != null) {
            String path = request.getServletPath();

            ArrayList<Role> roles = new RoleDaoImpl().getAll();
            System.out.println(roles);
            request.setAttribute("roles", roles);

            switch (path) {
                case ("/add"):
                    this.getServletContext().getRequestDispatcher("/Users/addUser.jsp").forward(request, response);
                    break;
                case ("/update"):

                    Users user = new UsersServiceImpl().find(Long.parseLong(request.getParameter("id")));


                    request.setAttribute("user", user);
                    ;


                    this.getServletContext().getRequestDispatcher("/Users/updateUser.jsp").forward(request, response);
                    break;
            }

        }else{
            response.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String password = request.getParameter("password");
        String country = request.getParameter("country");
        Long role = Long.parseLong(request.getParameter("role"));
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        Users user = new Users();
        Address address = new Address();



        Role roleObject = new Role();
        roleObject.setId_role(role);
        user.setEmail(email);
        user.setFirst_name(firstName);
        user.setLast_name(lastName);
        user.setPassword(password);
        address.setCity(city);
        address.setStreet(street);
        address.setCountry(country);
        user.setRole(roleObject);
        System.out.println(address);
        System.out.println(roleObject);
     if(request.getServletPath().equals("/update") )  {
         Long idUser = Long.parseLong(request.getParameter("idUser"));
         user.setUserId(idUser);
         Long idAddress = Long.parseLong(request.getParameter("idAddress"));
         address.setIdAddress(idAddress);
      Address address1 = new AddressServiceImpl().update(address);
         System.out.println(address1);
       user.setAddress(address1);
         System.out.println(user);
         new UsersServiceImpl().update(user) ;
         System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
     }else{
         System.out.println("????????????????????????????????? ");
         user.setAddress(address);
         new UsersServiceImpl().add(user);
     }

        response.sendRedirect("/home");



    }
}
