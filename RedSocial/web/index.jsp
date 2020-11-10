<%-- 
    Document   : login
    Created on : 29 oct. 2020, 16:53:31
    Author     : Aldana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP</title>
    </head>


    <body>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>


        <div class="row">
            <div class="col-lg-12">
                <div>
                    <h1>Iniciar Sesion</h1>
                </div>
            </div>
        </div>

        <%@include file = "principal/componentes/head.html"%>
        <% if (request.getAttribute("mensajeError") != null && !request.getAttribute("mensajeError").equals("")) { %>
        <h2>${ mensajeError }</h2>
        <% }%>
        <div class="col-lg-12">
            <div class="card w-50">
                <div class="card-body">
                    <form method = "POST" action = "Login">
                        <div class="form-group col-sm-12 " >
                            <label for="input">Nombre de usuario: </label>
                            <input type="text" class="form-control" name="txtUsuario" placeholder="Nombre del usuario">
                        </div>
                        <div class="form-group col-sm-12">
                            <label for="input">Contraseña</label>
                            <input type="password" class="form-control" name="txtDescripcion" placeholder="Escriba su contraseña">
                        </div>
                        <div class="form-group col-md-6">
                            <button type="submit" class=" btn btn-success">Entrar</button> 
                        </div>
                    </form> 
                </div>
            </div>
        </div>    
  
    </body>
    <%@include file = "principal/componentes/nave.jsp" %>
    <%@include file = "principal/componentes/footer.html" %>
</html>
