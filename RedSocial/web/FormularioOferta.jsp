<%-- 
    Document   : FormularioOferta
    Created on : 30 oct. 2020, 0:19:07
    Author     : Aldana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
        <link href="principal/pluggins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Oferta</title>
    </head>
    <body>
        <%@include file = "principal/componentes/head.html" %>
          <%@include file = "principal/componentes/nave.jsp" %>

        <div style = "margin-top: 5em">
            <h4>Ingrese los datos de la oferta</h4>
            <form method = "POST" action = "NuevaOferta" enctype="multipart/form-data">
                <div class="form-group col-md-6" >
                    <label for="input">Nombre: </label>
                    <input type="text" class="form-control" name="txtNombre" placeholder="Titulo de la oferta" id="nombre" required>
                    <div style="color: red " id="messageN" hidden>
                        Complete este campo
                    </div>
                </div>
                <div class="form-group col-md-6">
                    <label for="input">Cantidad</label>
                    <input type="number" class="form-control" step="0.01" name="txtCantidad" placeholder="Cantidad de productos para las ofertas" id="cantidad" required>
                    <div style="color: red " id="messageC" hidden>
                        Complete este campo correctamente (solo numeros)
                    </div>
                </div>
                <div class="form-group col-md-6">
                    <label for="input">Precio </label>
                    <input type="number" class="form-control" name="txtPrecio" placeholder="Precio de la oferta" id= "precio" required>
                    <div style="color: red " id="messageP" hidden>
                        Complete este campo correctamente (solo numeros)
                    </div>
                </div>
                <div class="form-group col-md-6">
                    <input type="hidden" class="form-control" name="idComercio" value="${comercio.comercios_id}">
                </div>
                <div class="form-group col-md-6">
                    <label for="input">Descripcion</label>
                    <textarea class="form-control" name="txtDescripcion" rows="3" id="descripcion" required maxlength="100"></textarea>
                    <div style="color: red " id="messageD" hidden>
                        Complete este campo
                    </div>
                </div>
                <div class="col-md-3 mb-3"> 
                    <label for="input">Seleccione una imagen</label>
                    <input type="file" id="upload1" name="txtupload1">                
                </div>

                <div class="form-group col-md-6">
                    <p align="right">
                        <input type="submit" value="Registrar" class="btn btn-success" onclick="return validaroferta();">
                    </p>
                </div>
            </form>
        </div>
    </body>
</html>

<script>

     function validaroferta() {
        let nombre = document.getElementById("nombre");
        let cantidad = document.getElementById("cantidad");
        let precio = document.getElementById("precio");
        let descripcion = document.getElementById("descripcion");
        const mensajen = document.getElementById("messageN");
        const mensajec = document.getElementById("messageC");
        const mensajep = document.getElementById("messageP");
        const mensajed = document.getElementById("messageD");


        if (nombre.value === "") {
            alert("Corrija los campos");
            nombre.style.borderColor = 'red';
            mensajen.hidden = false;
            return false;

        } else if (cantidad.value === "") {
            alert("Corrija los campos");
            cantidad.style.borderColor = 'red';
            mensajec.hidden = false;
            return false;
        } else if (precio.value === "") {
            alert("Corrija los campos");
            precio.style.borderColor = 'red';
            mensajep.hidden = false;
            return false;
        } else if (descripcion.value.length > 100) {
            alert("Corrija los campos");
            descripcion.style.borderColor = 'red';
            descripcion.value = '';
            mensajed.hidden = false;
            return false;
        }

        return alert("Oferta cargada correctamente");

    }

    
</script>
    
   
