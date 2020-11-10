<%-- 
    Document   : editarRubro
    Created on : 30 oct. 2020, 0:32:19
    Author     : Aldana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    <link href="principal/pluggins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file = "principal/componentes/navegacion.html"%>
    </head>
    <body>
        <div class="container" style="margin-top: 5em;">
        <h1>${ accion } de Rubro</h1>
      
        <div class="container">
            <div class="col-lg-12">
                <div class="form-horizontal">
                    <form method = "POST" action = "ListadoRubros" enctype="multipart/form-data">
                        <div class="form-group col-md-6" >
                            <input type="hidden" name="idRubro" value="${r.id}">
                            <label for="input">Nombre </label>
                            <input type="text" class="form-control" name="txtNombre" id="txtNombre"value="${r.nombre}" required>
                            <div style="color: red " id="messageN" hidden>
                                Campo incompleto.
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="input">Descripcion</label>
                            <input type="text" class="form-control" id="txtDesc" name= "txtDescripcion" value="${r.descripcion}"></textarea>
                            <div style="color: red " id="message" hidden>
                                La descripcion supero los 60 caracteres.
                            </div>
                        </div>

                        <div class="col-md-3 mb-3"> 
                            <label for="input">Seleccione una imagen</label>
                            <input type="file" id="upload1" name="txtupload1" ">                
                        </div>

                        <div class="form-group col-md-6">
                            <input type="submit" value="Registrar" class="btn btn-success" onclick="return validar();">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
    <%@include file = "principal/componentes/footer.html" %>
    <%@include file = "principal/componentes/nave.jsp" %>
</html>
<script>
    function validar() {
        let nombre = document.getElementById("txtNombre");
        let descripcion = document.getElementById("txtDesc");
        const maximo = 60;
        const mensaje = document.getElementById("message");
        const mensajeN = document.getElementById("messageN");

        if (nombre.value === "") {
            alert("Ingrese un nombre");
            nombre.style.borderColor = 'red';
            mensajeN.hidden = false;
            return false;
        } else if (descripcion.value.length > maximo) {
            alert("Ingrese hasta 60 caracteres en la descripcion");
            descripcion.style.borderColor = 'red';
            descripcion.value = '';
            mensaje.hidden = false;
            return false;
        }
        return alert("Rubro cargado");
        mensaje.hidden = true;
    }
</script>