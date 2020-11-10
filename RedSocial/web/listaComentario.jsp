<%-- 
    Document   : listaComentario
    Created on : 5 nov. 2020, 22:44:16
    Author     : Aldana
--%>
<%@taglib prefix = "c" uri= "http://java.sun.com/jsp/jstl/core" %>
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
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container" style ="margin-top: 5em;">
            <h2>Comentarios no respondidos</h2>
            <div class="container">
                <div class="row">
                    <c:forEach items = "${comentario}" var = "o">
                        <div class="col-lg-12 col-md-6 mb-4">
                            <div class="card w-75">
                                <div class="card-body">
                                    <h5 class="card-title">${o.nombreComercio}</h5>
                                    <h5 class="card-title">${o.nombre}</h5>
                                    <p class="card-text">${o.descripcion}</p>
                                    <p class="card-text" align="right">${o.fecha}</p>
                                     
                                    <div class="card-footer">
                                        <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734; ${o.valoracion}</small>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <%@include file = "principal/componentes/nave.jsp" %>
            <%@include file = "principal/componentes/footer.html" %>
    </body>
</html>
