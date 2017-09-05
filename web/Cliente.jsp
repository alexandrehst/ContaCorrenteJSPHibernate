<%-- 
    Document   : Cliente
    Created on : 05/09/2017, 13:28:40
    Author     : alexandretorres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <title>Cadastrar Cliente</title>
    </head>
    <body>
         <jsp:include page="Header.jsp" />
         
        <div class="container">
            <div class="row">
                <div class="col"></div>
                <div class="col-6">
                    <c:if test="${sucesso != null}">
                        <div class="alert alert-success" role="alert">
                            Cliente incluído com sucesso.
                        </div>
                    </c:if>
                    <form action="controller" method="post" style="display:block;">
                        <div class="form-group">
                            <label>CPF:</label>
                            <input type="text" name="cfp" placeholder="Digite o CPF" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nome:</label>
                            <input type="text" name="nome" placeholder="Digite o nome" class="form-control">
                        </div>
                        <input type="submit" name="action" value="incluir" class="btn btn-primary">  
                    </form>
                </div>
                <div class="col"></div>
            </div>
        </div>
    </body>
</html>
