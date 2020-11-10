<%-- 
    Document   : listaValoracion
    Created on : 5 nov. 2020, 23:16:54
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
        <title>Valoracion</title>
    </head>
    <body>
        <h1>Cantidad de valoracion</h1>
         
            <table class="table table-borderless">
                <thead> 

                    <tr>

                        <th scope="col">Valoracion por estrella</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items = "${valor}" var = "o">
                    <tr>
                        <td>${o.valoracion} estrellas</td>
                        <td>${o.cantidad}</td>
                       
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
      
           <%@include file = "principal/componentes/nave.jsp" %>
    <%@include file = "principal/componentes/footer.html" %>
    </body>
</html>
