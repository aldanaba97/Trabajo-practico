<%-- 
    Document   : ListadoRubros
    Created on : 28 oct. 2020, 12:18:01
    Author     : Aldana
--%>

<%@page import="Models.comercio"%>
<%@page import="gestor.Gestor"%>
<%@taglib prefix = "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file = "principal/componentes/head.html"%>
<html>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    <link href="principal/pluggins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado</title>
    </head>
    <body >

        <c:choose>
            <c:when test="${ not empty usr}">

               <div class="col-lg-12">
                <h1 align = "center">Descubri los rubros y los comercios asociados </h1>
                <p align = "right"> 
                    <a href="ListadoRubros?modo=alta" type="button" class="btn btn-success" style= " margin-right: 1em">Crear un rubro</a>
                </p>
               </div>

                <%@include file = "principal/componentes/head.html"%>
                <div class="container ">

                    <!-- /.col-lg-3 -->
                    <div class="row" style="margin-top: 2em">
                        <div class="col-lg-12">
                            <div class="row">   
                                <c:forEach items = "${lista}" var = "rubro">
                                    <c:if test="${rubro.estado == true }"> 

                                        <div class="col-lg-6 col-md-6 mb-4"> 

                                            <div class="card h-100">

                                                <a href="#"><img class="card-img-top" src="archivos/${rubro.ruta}"alt="" width="700" height="400"></a>
                                                <div class="card-body">

                                                    <h5>${rubro.getNombre()}</h5>
                                                    <p class="card-text">${rubro.getDescripcion()}</p>
                                                    <p class="card-title">
                                                        <a href="/RedSocial/ListadoComercio?id=${rubro.getId()}" class="btn btn-success ">Conocer los comercios &raquo;</a>
                                                        <a href="ListadoRubros?modo=editar&id=${rubro.getId()}" ><input type="button"  class="btn btn-success "value="Editar"></a>
                                                        <a href="ListadoRubros?modo=eliminar&id=${rubro.getId()}" ><input type="button" class="btn btn-success "value="Eliminar"></a>
                                                    </p>
                                                </div>                                         
                                            </div>
                                        </div>
                                    </c:if>

                                </c:forEach> 

                            </div>
                            <!-- /.row -->

                        </div>
                        <!-- /.col-lg-9 -->

                    </div>
                    <!-- /.row -->

                </div>
                <!-- /.container -->
            </c:when>
            <c:otherwise>
               <div class="col-lg-12">
                <h1 align = "center">Descubri los rubros y los comercios asociados </h1>
                <p align = "right"> 
                    <a href=ErrorLogin.jsp type="button" class="btn btn-success" style= " margin-right: 1em">Crear un rubro</a>
                </p>
               </div>

                <%@include file = "principal/componentes/head.html"%>
                <div class="container ">

                    <!-- /.col-lg-3 -->
                    <div class="row" style="margin-top: 2em">
                        <div class="col-lg-12">
                            <div class="row">   
                                <c:forEach items = "${lista}" var = "rubro">
                                    <c:if test="${rubro.estado == true }"> 

                                        <div class="col-lg-6 col-md-6 mb-4"> 

                                            <div class="card h-100">

                                                <a href="#"><img class="card-img-top" src="archivos/${rubro.ruta}"alt="" width="700" height="400"></a>
                                                <div class="card-body">

                                                    <h5>${rubro.getNombre()}</h5>
                                                    <p class="card-text">${rubro.getDescripcion()}</p>
                                                    <p class="card-title">
                                                        <a href="/RedSocial/ListadoComercio?id=${rubro.getId()}" class="btn btn-success"> &raquo; Conocer los comercios</a>                                                        
                                                    </p>
                                                </div>
                                            </div>

                                        </div>
                                    </c:if>

                                </c:forEach> 

                            </div>
                            <!-- /.row -->

                        </div>
                        <!-- /.col-lg-9 -->

                    </div>
                    <!-- /.row -->

                </div>
            </c:otherwise>
        </c:choose>
    </body>
    <%@include file = "principal/componentes/footer.html" %>
    <%@include file = "principal/componentes/nave.jsp" %>

</html>

