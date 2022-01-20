
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Users" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% if(session!=null){  %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Gestion d'employés</title>

</head>
<h1 class="mb-3" >Users List
</h1>
<buttton style="float:right" class="btn btn-danger mb-5"><a href="${pageContext.servletContext.contextPath}/Logout">Logout</a></buttton>



    <table class="table table-hover">
        <thead>
        <tr>
            <th>#</th>
            <th>Email</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Country</th>
            <th>Address</th>
            <th>Role</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
            <%ArrayList<Users> usersList = (ArrayList<Users>) request.getAttribute("users");
                for(Users users : usersList) {%>
        <tr>
            <td><%=  users.getUserId() %></td>
            <td><%= users.getEmail() %></td>
            <td><%=users.getFirst_name()%></td>
            <td><%=users.getLast_name()%></td>
            <td><%=users.getAddress().getCountry()%></td>
            <td><%=users.getAddress().getCity()%>, <%=users.getAddress().getStreet()%></td>
            <td><%= users.getRole().getName()%></td>

            <td>
                <a href="${pageContext.servletContext.contextPath}/update?id=<%=users.getUserId()%>" class="btn btn-primary">Update</a>
                <a href="${pageContext.servletContext.contextPath}/delete?id=<%=users.getUserId()%>" class="btn btn-danger">Delete</a>
            </td>
        </tr>
            <%}%>
        <tbody>
    </table>


<a class=" btn btn-primary mt-3" style="float: right" href="${pageContext.servletContext.contextPath}/add">Add User</a>
</body>
</html>
<% }else {
    request.getRequestDispatcher("login.jsp");
}  %>
