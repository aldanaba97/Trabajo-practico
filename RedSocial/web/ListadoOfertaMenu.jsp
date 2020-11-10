<%-- 
    Document   : ListadoOfertaMenu
    Created on : 5 nov. 2020, 2:06:13
    Author     : Aldana
--%>
<%@page import="gestor.Gestor"%>
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
        <title>Busqueda de ofertas</title>
    </head>
    <body>
        <h1>Listado de ofertas</h1>
 <form method="POST" action="ofertaMenu">

            <div class="input-group mb-3">
                <input type="text" class="form-control" name="txtbuscar" placeholder="Escriba el titulo de la oferta">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="submit">Buscar oferta</button>
                </div>

                <c:forEach items = "${lista}" var = "l">
                    <table class="table table-borderless">
                        <thead> 

                            <tr>

                                <th scope="col">Nombre de comercio</th>
                                <th scope="col">Oferta</th>
                                <th scope="col">Cantidad</th>
                                <th scope="col">Precio</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>

                                <td>${l.c.nombre}</td>
                                <td>${l.nombre}</td>
                                <td>${l.cantidad}</td>
                                <td>${l.precio}</td>
                                <td> <a href="/RedSocial/perfilComercio?id=${l.c.comercios_id}">Visitar su perfil</a></td>
                            </tr>

                        </tbody>
                    </table>
                </c:forEach>
       
            </div>
        </form>
        
        
            <table class="table table-borderless">
                <thead> 

                    <tr>

                        <th scope="col">Nombre de comercio</th>
                        <th scope="col">Oferta</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Precio</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items = "${oferta}" var = "l">
                    <tr>

                        <td>${l.c.nombre}</td>
                        <td>${l.nombre}</td>
                        <td>${l.cantidad}</td>
                        <td>${l.precio}</td>
                        <td> <a href="/RedSocial/perfilComercio?id=${l.c.comercios_id}">Visitar su perfil</a></td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
       






       
    
    <%--
        String parameter = request.getParameter("txtbuscar");
        if (parameter != null) {
            Gestor g = new Gestor();
            g.listaxbusqueda(parameter);

        }
    --%>

   <%@include file = "principal/componentes/nave.jsp" %>
    <%@include file = "principal/componentes/footer.html" %>
</body>
</html>
