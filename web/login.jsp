<%-- 
    Document   : login
    Created on : 23/08/2017, 18:56:16
    Author     : alexandretorres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <title>Login</title>
        <link href="./styles/signin.css" rel="stylesheet">
    </head>
    <body>
        
        <div class="container">

            <form class="form-signin" action="controller" method="post">
                <h2 class="form-signin-heading">Faça o login</h2>
                <label for="inputEmail" class="sr-only">Usuário</label>
                <input type="text" name="userId" id="inputEmail" class="form-control" placeholder="usuário" required autofocus>
                <label for="inputPassword"  class="sr-only">Senha</label>
                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Senha" required>

                <button name="action" value="login" class="btn btn-lg btn-primary btn-block" type="submit">Logar</button>
            </form>
            <c:if test="${erro != null}">
                <div class="alert alert-danger" role="alert">
                    Usuário ou senha inválido.
                </div>
            </c:if>

        </div>

        

            
    </body>
</html>