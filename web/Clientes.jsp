<%-- 
    Document   : Clientes
    Created on : 05/09/2017, 11:43:30
    Author     : alexandretorres
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <title>Clientes</title>
    </head>
    <body>

        <jsp:include page="Header.jsp" />
        <div class="container">

            
       
                <table class="table">
                    <thead>
                        <tr>
                            <th>CPF</th>
                            <th>Nome</th>
                            <th colspan=2>Action</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${clientes}" var="cliente">
                            <tr>
                                <td><c:out value="${cliente.cpf}" /></td>
                                <td><c:out value="${cliente.nome}" /></td>
                                <td><a href="UserController?action=edit&userId=<c:out value="${cliente.id}"/>">Update</a></td>
                                <td><a href="UserController?action=delete&userId=<c:out value="${cliente.id}"/>">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <a href="controller?action=incluir">
                    <button class="btn btn-md btn-primary">Incluir</button> 
                </a>
        
    </body>
</html>
