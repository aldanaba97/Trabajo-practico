<%-- 
    Document   : eliminarRubro
    Created on : 9 nov. 2020, 12:01:47
    Author     : Aldana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
<link href="principal/pluggins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Eliminar rubro </h1>
        <div class="container">
            <div class="col-lg-12">
                <div class="form-horizontal">
                    <form method = "POST" action = "EliminarRubro" enctype="multipart/form-data">
                        <div class="form-group col-md-6" >
                            <input type="hidden" name="idRubro" value="${r.id}">
                            <label for="input">Nombre </label>
                            <input type="text" class="form-control" name="txtNombre" id="txtNombre"value="${r.nombre}"disabled>

                        </div>
                        <div class="form-group col-md-6">
                            <label for="input">Descripcion</label>
                            <input type="text" class="form-control" id="txtDesc" name= "txtDescripcion" value="${r.descripcion}" disabled>           
                        </div>

                        <div class="col-md-3 mb-3"> 
                            <label for="input">Seleccione una imagen</label>
                            <input type="file" id="upload1" name="txtupload1" disabled>                
                        </div>

                        <div class="form-group col-md-6">
                            <input type="submit" value="Eliminar" class="btn btn-danger">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@include file = "principal/componentes/nave.jsp" %>
    </body>
</html>
