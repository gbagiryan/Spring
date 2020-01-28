<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 27.12.2019
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<%
    if (request.getAttribute("existingUser") != null) {
        response.getWriter().println(request.getAttribute("existingUser"));
    }
    if (request.getAttribute("nameEmpty") != null) {
        response.getWriter().println(request.getAttribute("nameEmpty"));
    }
    if (request.getAttribute("surnameEmpty") != null) {
        response.getWriter().println(request.getAttribute("surnameEmpty"));
    }
    if (request.getAttribute("usernameShort") != null) {
        response.getWriter().println(request.getAttribute("usernameShort"));
    }
    if (request.getAttribute("passwordShort") != null) {
        response.getWriter().println(request.getAttribute("passwordShort"));
    }
    if (request.getAttribute("ageEmpty") != null) {
        response.getWriter().println(request.getAttribute("ageEmpty"));
    }
%>
<form action="/register" method="post">

    <b>
        Name
    </b></br>
    <input type="text" name="name" size="40" >
    </br>
    <b>
        Surname
    </b></br>
    <input type="text" name="surname" size="40">
    </br>
    <b>
        Username
    </b></br>
    <input type="text" name="username" size="40" >
    </br>
    <b>
        Password
    </b></br>
    <input type="password" name="password" size="40" >
    </br>
    <b>
        Age
    </b></br>
    <input type="number" name="age" size="3" >
    </br>
    <input type="submit" value="Register"/>

</form>
<button onclick="window.location.href = '/';">Back to Login</button>
</body>
</html>
