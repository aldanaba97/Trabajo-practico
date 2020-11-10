<%-- 
    Document   : PerfilComercio
    Created on : 30 oct. 2020, 0:17:01
    Author     : Aldana
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Perfil</title>
    </head>
    <body>

        <c:choose>
            <c:when test="${ not empty usr}">
                <input type="hidden" name="idComercio" value="${comercio.comercios_id}">
                <div style="margin-top: 2em">    
                    <div class="card bg-dark text-white">
                        <img src="archivos/${comercio.ruta}" class="card-img" alt="" width="700" height="400">
                        <div class="card-img-overlay">
                            <h1 class="card-title">${comercio.nombre}</h1>
                            <h3 class="card-text">${comercio.informacion}</h3>
                            <h3 class="card-text">Direccion: ${comercio.direccion} </h3>
                            <h3 class="card-text"> Telefono: ${comercio.numero}</h3>
                            <h3 class="card-text"> Red Social: ${comercio.redSocial}</h3>
                        </div>
                    </div>

                    <p align = left" style="margin: 1em;"><a href="ListadoComercio?id=${comercio.r.id}" class="btn btn-success"> &raquo; Volver</a></p>
                    <h1 align = "center">Nuestras ofertas</h1>
                    <p align = "right"><a href="Oferta?modo=alta&idc=${comercio.comercios_id}" class=" btn btn-success">&raquo; Crear nueva oferta</a></p>
                    <div class="container">
                        <div class="row" >
                            <c:forEach items = "${lista}" var = "oferta">
                                <c:if test="${oferta.estado == true }">
                                    <div class="col-lg-6 col-md-6 mb-4">

                                        <div class="card h-100" align = "center">
                                            <a href="#"><img class="card-img-top" src="archivos/${oferta.ruta}" alt=""width="700" height="400"></a>
                                            <div class="card-body"> 
                                                <h5>${oferta.nombre}</h5>
                                                <p class="card-text">Cantidad: ${oferta.cantidad}</p>
                                                <p class="card-text"> Precio: ${oferta.precio}</p>
                                                <p class="card-text"> Descripcion: ${oferta.descripcion}</p>
                                                <p class="card-text">Fecha: ${oferta.fecha} </p>
                                                <p class="card-title">
                                                    <a href="Oferta?modo=editar&id=${oferta.id_oferta}" class="btn btn-success">&raquo; Editar</a> 
                                                <td> <a href="Oferta?modo=eliminar&id=${oferta.id_oferta}" class="btn btn-danger"> &raquo; Eliminar</a>                                  
                                                    </p>
                                            </div>

                                        </div>
                                    </div>

                                </c:if>
                            </c:forEach>          
                        </div>
                    </div>
                    <h2>Comentarios </h2>

                    <div class="container">    
                        <p align = "right"><a href="Comentario?modo=alta&idc=${comercio.comercios_id}" class="btn btn-success">Crear comentario</a></p>
                        <div class="row">
                            <c:forEach items = "${listaComercio}" var = "dto">
                                <div class="col-lg-12 col-md-6 mb-4">
                                    <div class="card w-75">
                                        <div class="card-body">
                                            <h5 class="card-title">${dto.come.nombreUsuario}</h5>
                                            <p class="card-text">${dto.come.descripcion}</p>
                                            <p class="card-text" align="right">${dto.come.fecha}</p>
                                            <div class="card-footer">
                                                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734; ${dto.come.valoracion}</small>
                                            </div>
                                            
                                            <a href="Comentario?modo=eliminar&idc=${dto.come.id_comentarios}" class="btn btn-warning">Eliminar</a>
                                        </div>
                                    </div>
                                    <div class="card w-50">
                                        <div class="card-body">
                                            <h5 class="card-title">${dto.rta.come.c.nombre}</h5>
                                            <p class="card-text"> ${dto.rta.descripcion}</p>
                                            <p class="card-text" align="right"> ${dto.rta.fecha}</p>
                                            
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <%@include file="FormularioComentario.jsp"%>
                    </div>

                </div>
            </c:when>
            <c:otherwise>
                <input type="hidden" name="idComercio" value="${comercio.comercios_id}">
                <div style="margin-top: 2em">    
                    <div class="card bg-dark text-white">
                        <img src="archivos/${comercio.ruta}" class="card-img" alt="" width="700" height="400">
                        <div class="card-img-overlay">
                            <h1 class="card-title">${comercio.nombre}</h1>
                            <h3 class="card-text">${comercio.informacion}</h3>
                            <h3 class="card-text">Direccion: ${comercio.direccion} </h3>
                            <h3 class="card-text"> Telefono: ${comercio.numero}</h3>
                            <h3 class="card-text"> Red Social: ${comercio.redSocial}</h3>
                        </div>
                    </div>

                    <p align = left" style="margin: 1em;"><a href="ListadoComercio?id=${comercio.r.id}" class="btn btn-success"> &raquo; Volver</a></p>
                    <h1 align = "center">Nuestras ofertas</h1>
                    
                    <div class="container">
                        <div class="row" >
                            <c:forEach items = "${lista}" var = "oferta">
                                <c:if test="${oferta.estado == true }">
                                    <div class="col-lg-6 col-md-6 mb-4">

                                        <div class="card h-100" align = "center">
                                            <a href="#"><img class="card-img-top" src="archivos/${oferta.ruta}" alt=""width="700" height="400"></a>
                                            <div class="card-body"> 
                                                <h5>${oferta.nombre}</h5>
                                                <p class="card-text">Cantidad: ${oferta.cantidad}</p>
                                                <p class="card-text"> Precio: ${oferta.precio}</p>
                                                <p class="card-text"> Descripcion: ${oferta.descripcion}</p>
                                                <p class="card-text">Fecha: ${oferta.fecha} </p>
                                                <p class="card-title">
                                                                               
                                                    </p>
                                            </div>

                                        </div>
                                    </div>

                                </c:if>
                            </c:forEach>          
                        </div>
                    </div>
                    <h2>Comentarios </h2>

                    <div class="container">    
                        <p align = "right"><a href="Comentario?modo=alta&idc=${comercio.comercios_id}" class="btn btn-success">Crear comentario</a></p>
                        <div class="row">
                            <c:forEach items = "${listaComercio}" var = "dto">
                                <div class="col-lg-12 col-md-6 mb-4">
                                    <div class="card w-75">
                                        <div class="card-body">
                                            <h5 class="card-title">${dto.come.nombreUsuario}</h5>
                                            <p class="card-text">${dto.come.descripcion}</p>
                                            <p class="card-text" align="right">${dto.come.fecha}</p>
                                            <div class="card-footer">
                                                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734; ${dto.come.valoracion}</small>
                                            </div>
                                            <a href="Respuesta?modo=alta&id=${dto.come.c.comercios_id}" class="btn btn-success">Responder</a>
                                            
                                        </div>
                                    </div>
                                    <div class="card w-50">
                                        <div class="card-body">
                                            <h5 class="card-title">${dto.rta.come.c.nombre}</h5>
                                            <p class="card-text"> ${dto.rta.descripcion}</p>
                                            <p class="card-text" align="right"> ${dto.rta.fecha}</p>
                                            
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <%@include file="FormularioComentario.jsp"%>
                    </div>

                </div>
            </c:otherwise>
        </c:choose>
        <%@include file = "principal/componentes/nave.jsp" %>
        <%@include file = "principal/componentes/footer.html" %>
    </body>
</html>
