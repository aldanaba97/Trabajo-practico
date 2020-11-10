<%-- 
    Document   : ListadoComercioMenu
    Created on : 5 nov. 2020, 1:05:01
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
        <title>Listado comercio</title>
    </head>
    <body>
        <h1>Conozca todos los comercios del Centro vecinal</h1>
       
        <c:choose>
            <c:when test="${ not empty usr}">
                
                <div class="container" style="margin-top: 3em;">
                <h1>Comercios</h1>
                </div>
                <div class="container ">
                    <a href="/RedSocial/NuevoComercio">Crear nuevo comercio</a>
                    <!-- /.col-lg-3 -->
                    <div class="container" style="margin-top: 1em; margin-bottom: 1em;">
                        <div class="col-lg-12">


                            <div class="row" >
                                <c:forEach items = "${comercio}" var = "c">
                                    <c:if test="${c.estado == true }">
                                        <div class="col-lg-6 col-md-6 mb-4">

                                            <div class="card h-100">
                                                <a href="#"><img class="card-img-top" src="archivos/${c.ruta}" alt=""width="700" height="400"></a>
                                                <div class="card-body"> 
                                                    <h5>${c.nombre}</h5>
                                                    <p class="card-text">Direccion : ${c.direccion}</p>
                                                    <p class="card-text">Telefono : ${c.numero}</p>
                                                    
                                                    <p class="card-title">
                                                        <a href="/RedSocial/perfilComercio?id=${c.comercios_id}" class="btn btn-success"> &raquo;Visitar</a> 
                                                        <a href="ListadoComercio?modo=editar&id=${c.getComercios_id()}" class="btn btn-success"> &raquo;Editar</a>
                                                        <a href="ListadoComercio?modo=eliminar&id=${c.getComercios_id()}"class="btn btn-success">&raquo;Eliminar</a>
                                                    </p>
                                                </div>                            
                                            </div>                                               
                                        </div>
                                    </c:if>
                                </c:forEach>          
                                  <a href="/RedSocial/ListadoRubros" class="btn btn-success"> &raquo;Volver</a> 
                            </div>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
             <div class="container" style="margin-top: 3em;">
                <h1>Comercios</h1>
                </div>   
                <div class="container ">

                    <!-- /.col-lg-3 -->
                    <div class="container" style="margin-top: 1em;">
                        <div class="col-lg-12">


                            <div class="row" >
                                <c:forEach items = "${comercio}" var = "c">
                                    <c:if test="${c.estado == true }">
                                        <div class="col-lg-6 col-md-6 mb-4">

                                            <div class="card h-100" align = "center">
                                                <a href="#"><img class="card-img-top" src="archivos/${c.ruta}" alt=""width="700" height="400"></a>
                                                <div class="card-body"> 
                                                    <h5>${c.nombre}</h5>
                                                    <p class="card-text">Direccion: ${c.direccion}</p>
                                                    <p class="card-text">Telefono: ${c.numero}</p>
                                                    <p class="card-text">${c.nombre}</p>
                                                    <p class="card-title">
                                                        <a href="/RedSocial/perfilComercio?id=${c.comercios_id}" class="btn btn-success"> &raquo;Visitar su perfil</a>                                       
                                                    </p>
                                                </div>
                                                
                                            </div>
                                        </div>

                                    </c:if>
                                </c:forEach>          

                            </div>
                        </div>
                    </div>
                </div>
                </c:otherwise>
            </c:choose>
        
           <%@include file = "principal/componentes/nave.jsp" %>
    <%@include file = "principal/componentes/footer.html" %>
    </body>
</html>
