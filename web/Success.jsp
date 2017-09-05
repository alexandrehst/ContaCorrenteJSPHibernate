<%-- 
    Document   : Success
    Created on : 23/08/2017, 19:08:37
    Author     : alexandretorres
--%>

<%@page import="models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Loggado!</h1>
        <% 
            User user = (User)request.getAttribute("usuario");
        %>
        <h3> <%= user.getUserName() %> </h3>
    </body>
</html>
