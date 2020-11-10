<%-- 
    Document   : eliminarComentario
    Created on : 9 nov. 2020, 16:28:29
    Author     : Aldana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form method = "POST" action = "EliminarComentario">
             <div class="form-group col-md-6">
                <input type="hidden" class="form-control" name="idComercio" value="${comercio.comercios_id}">
            </div>
             <div class="form-group col-md-6">
                <input type="hidden" class="form-control" name="idComentario" value="${listaComercio.come.id_comentarios}">
            </div>
            <div class="form-group col-md-6" >
                <label for="input">Nombre de usuario: </label>
                <input type="text" class="form-control" name="txtNombre" value = "${listaComercio.come.nombreUsuario}" disabled>
            </div>
            <div class="form-group col-md-6">
                <label for="input">Descripcion: </label>
                <input type="text" class="form-control" name="txtDescripcion" value = "${listaComercio.come.descripcion}">
            </div>
            
                
            </div>
            <button type="submit" class=" btn btn-danger">Eliminar</button>
  <%@include file = "principal/componentes/nave.jsp" %>
        </form> 
    </body>
</html>
