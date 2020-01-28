<%@ page import="am.basic.web.model.User" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 16.12.2019
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <title>${user.name} 's page</title>--%>
    <title>page</title>
</head>
<body>
<% User user = (User) session.getAttribute("user"); %>
<H1><%=user.getUsername()%></H1>
<H3><%=user.getName()%></H3>
<H4> <%   response.getWriter().println(user.getSurname()); %></H4>

<p><a href="/secure/logout">Logout</a></p>
</body>
</html>
