<%-- 
    Document   : index
    Created on : 17/05/2020, 11:19:11 AM
    Author     : USUARIO
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="modelo.Producto" %>

<%
    Double respuesta = (Double) request.getAttribute("respuesta");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>

        <div class="container m-4">
            <form action="DescargaExcel" >
                <input type="hidden" name="producto" value="${producto.producto}">
                <input type="hidden" name="promocion" value="${codigo}">
                <input type="hidden" name="montoTotal" value="<%=respuesta%>">
                
                <div class="card">
                    <div class="card-body">
                        <div class="alert alert-primary" role="alert">
                            Producto Adquirido:
                        </div>
                        <h2 class="card-subtitle mb-2 text-muted">${producto.producto}</h2>
                        <p class="card-text">Promcion: <strong>${codigo}</strong></p>
                        <p>Precio: <small><%=respuesta%></small></p>
                        <!--<a href="/Pedidos/DescargaExcel" class="btn btn-primary">Descargar</a>-->
                        <button type="submit" class="btn btn-primary">Descargar</button>
                    </div>
                </div>
            </form>

        </div>


        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

    </body>
</html>
