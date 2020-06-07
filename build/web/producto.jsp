
<%@page import="modelo.Promocion"%>
<%@page import="Dao.ProductoDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <style>
        .centrar
	{
		position: absolute;
		top:10%;
		left:25%;
		width:600px;
		height:450px;
		border:1px solid #808080;
		padding:50px;
	}
	</style>
    </head>
    <body>

        <div class="container m-4 centrar">
            <div class="alert alert-primary" role="alert">
                SISTEMA DE  PEDIDOS
            </div>
            <form action="ValidarCodigo">
                <div class="form-row" style="text-align: center;">
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">Nombre Producto :</label>
                        <input type="text" name="producto"  class="form-control" id="producto">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputZip">Cantidad :</label>
                        <input type="text" name="cantidad" class="form-control" id="cantidad">
                    </div>
                </div>
                <div class="form-row ">
                    <div class="form-group col-md-6" style="text-align: center;">
                        <label for="inputState">Código de Promoción :</label>
                        <select id="inputState" class="form-control" name="promocion">
                            <option value="-1">Selccione</option>
                            <option value="1">EXAMENPARCIAL</option>
                            <option value="2">TRENTINO</option>
                            <option value="3">PANDEMIA</option>
                            <% for(Promocion p : ProductoDao.comboPromociones()){%>
                              <option value="<%p.getIdPromocion();%>"><%p.getPromocion();%></option>
                            <%}%>
                            
                        </select>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Pagar</button>
            </form>
            
            <div class="alert alert-danger m-4" role="alert">
                ${mensaje}
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" ></script>
    </body>
</html>
