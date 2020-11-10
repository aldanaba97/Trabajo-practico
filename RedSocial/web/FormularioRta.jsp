<%-- 
    Document   : FormularioRta
    Created on : 4 nov. 2020, 22:01:28
    Author     : Aldana
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
<link href="principal/pluggins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario</title>
    </head>
    <body>
        <h1>Crear nueva respuesta</h1>
          <%@include file = "principal/componentes/head.html" %>
            <%@include file = "principal/componentes/nave.jsp" %>
        <form method = "POST" action = "Respuesta">
            <div class="form-group col-md-6">
                <input type="text" class="form-control" name="idComentario" value="${respuesta.come.id_comentarios}">
            </div>
       
            <div class="form-group col-md-6">
                <label for="input">Descripcion: </label>
                <input type="text" class="form-control" name="txtDescripcion" placeholder="Escriba su respuesta">
            </div>
           
            <button type="submit" class=" btn btn-success">Registrar</button>

        </form> 
    </body>
</html>
