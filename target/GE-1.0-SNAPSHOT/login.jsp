<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <meta charset="ISO-8859-1">
    <title>Login</title>
</head>
<body>
<div align="center">
    <h1>Employee Login Form</h1>
    <form action="<%=request.getContextPath()%>/login" method="post">
        <table style="with: 100%">
            <tr>
                <td>Email</td>
                <td><input class="form-control" type="text" name="username" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input class="form-control" type="password" name="password" /></td>
            </tr>

        </table>
        <input type="submit" class="btn btn-primary" value="Submit" />
    </form>
</div>
</body>
</html>