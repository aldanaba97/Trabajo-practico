<%-- 
    Document   : editarComercio
    Created on : 4 nov. 2020, 3:03:23
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
        <title>Editar Comercio</title>
    </head>
    <body>
        <div class="container" style=" margin-top: 5em">
        <h2>Modificar los datos del comercio</h2>
        <form method = "POST" action = "ListadoComercio" enctype="multipart/form-data">
            <input type="hidden" name="idComercio" value="${comercio.comercios_id}">
            <div class="form-group col-md-6" >
                <label for="input">Nombre: </label>
                <input type="text" class="form-control" name="txtNombre" placeholder="Nombre del comercio" value="${comercio.nombre}">
            </div>
            <div class="form-group col-md-6">
                <label for="input">Direccion</label>
                <input type="text" class="form-control" name="txtDireccion" placeholder="Direccion del comercio"value="${comercio.direccion}">
            </div>
            <div class="form-group col-md-6">
                <label for="input">Telefono</label>
                <input type="text" class="form-control" name="txtTelefono" placeholder="Telefono del comercio"value="${comercio.numero}">
            </div>
            <div class="form-group col-md-6">
                <label for="input">Informacion</label>
                <textarea class="form-control" name="txtInformacion" rows="3" value="${comercio.informacion}"></textarea>
            </div>
            <div class="form-group col-md-6">
                <label for="input">Red social</label>
                <input type="text" class="form-control" name="txtRed" placeholder="Facebook, Instagram, Twitter del comercio" value="${comercio.redSocial}">
            </div>
            <div class="form-group col-md-6">
                <label for="input">Rubro</label>
                <select name = "cboRubro" placeholder="Seleccione un rubro" class="form-control">
                    <c:forEach items = "${rubro}" var = "item">
                        <c:if test= "${item.estado == true}">
                            <option value="${item.id}" <c:if test="${ item.id == comercio.r.getId()}">selected</c:if>>${item.nombre}</option>   
                        </c:if>
                    </c:forEach>
                </select>
            </div>

            <div class="col-md-3 mb-3"> 
                <label for="input">Seleccione una imagen</label>
                <input type="file" id="upload1" name="txtupload1">                
            </div>

            <div class="form-group col-md-6">
                <p align="right"><button type="submit" class=" btn btn-success">Cargar los datos</button> </p>
            </div>
        </form>
    </body>
    <%@include file = "principal/componentes/nave.jsp" %>
    <%@include file = "principal/componentes/footer.html" %>
</html>
