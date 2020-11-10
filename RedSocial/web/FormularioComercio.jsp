<%--
    Document   : FormularioComercio
    Created on : 30 oct. 2020, 0:15:22
    Author     : Aldana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="principal/pluggins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de comercio</title>
    </head>
    <body>
       <%@include file = "principal/componentes/nave.jsp" %>
         <%@include file = "principal/componentes/head.html" %>
        <div style="margin-top: 5em;">
            <div class="container">
                <h4 align="left">Registre todos los datos de su comercio</h4>
                <form method = "POST" action = "NuevoComercio" enctype="multipart/form-data">
                    <div class="form-group col-md-6" >
                        <label for="input">Nombre: </label>
                        <input type="text" class="form-control" name="txtNombre" placeholder="Nombre del comercio" id="nombre" required>
                        <div style="color: red " id="messageN" hidden>
                            Debes completar este campo.
                        </div>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="input">Direccion</label>
                        <input type="text" class="form-control" name="txtDireccion" placeholder="Direccion del comercio" id="direccion">
                        <div style="color: red " id="messageD" hidden>
                            No debes superar los 50 caracteres
                        </div>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="input">Telefono</label>
                        <input type="text" class="form-control" name="txtTelefono" placeholder="Telefono del comercio" id="telefono" required>
                        <div style="color: red " id="messageT" hidden>
                            Debes completar este campo
                        </div>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="input">Informacion</label>
                        <textarea class="form-control" name="txtInformacion" rows="3" id="informacion"></textarea>
                        <div style="color: red " id="messageI" hidden>
                            No debes superar los 100 caracteres
                        </div>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="input">Red social</label>
                        <input type="text" class="form-control" name="txtRed" placeholder="Facebook, Instagram, Twitter del comercio" id="redsocial">
                        <div style="color: red " id="messageI" hidden>
                            No debes superar los 100 caracteres
                        </div>    
                        <div class="form-group col-md-6">
                            <label for="input">Rubro</label>
                            <select name = "cboRubro" placeholder="Seleccione un rubro" class="form-control" id ="rubro">
                                <c:forEach items = "${rubro}" var = "item">
                                    <c:if test= "${item.estado == true}">
                                        <option value="${item.id}">${item.nombre}</option>   
                                    </c:if>                
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-3 mb-3"> 
                            <label for="input">Seleccione una imagen</label>
                            <input type="file" id="upload1" name="txtupload1">                
                        </div>

                        <div class="form-group col-md-6">
                            <p align="right">
                                <input type="submit" value="Registrar" class="btn btn-success" onclick="return validarComercio();">
                            </p>
                        </div>
                </form>
            </div>
        </div>
    </body> 
</html>
<script>
    function validarComercio() {
        let nombre = document.getElementById("nombre");
        let direccion = document.getElementById("direccion");
        let telefono = document.getElementById("telefono");
        let informacion = document.getElementById("informacion");
        let red = document.getElementById("redsocial");


        const mensajen = document.getElementById("messageN");
        const mensajeD = document.getElementById("messageD");
        const mensajet = document.getElementById("messageT");
        const mensajei = document.getElementById("messageI");
        const mensajer = document.getElementById("messageR");

        if (nombre.value === "") {
            alert("Corrija los campos");
            nombre.style.borderColor = 'red';
            mensajen.hidden = false;
            return false;
        } else if (direccion.value.length > 50) {
            alert("Corrija los campos");
            direccion.style.borderColor = 'red';
            direccion.value = '';
            mensajeD.hidden = false;
            return false;
        } else if (telefono.value === "") {
            alert("Corrija los campos");
            telefono.style.borderColor = 'red';
            telefono.value = '';
            mensajet.hidden = false;
            return false;
        } else if (informacion.value.length > 100) {
            alert("Corrija los campos");
            informacion.style.borderColor = 'red';
            informacion.value = '';
            mensajei.hidden = false;
            return false;
        } else if (red.value.length > 30) {
            alert("Corrija los campos");
            red.style.borderColor = 'red';
            red.value = '';
            mensajer.hidden = false;
            return false;
        }
        return alert("Comercio cargado correctamente");

    }
</script> 