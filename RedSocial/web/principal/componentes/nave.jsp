<%-- 
    Document   : nave
    Created on : 9 nov. 2020, 2:29:55
    Author     : Aldana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri= "http://java.sun.com/jsp/jstl/core" %>


<c:choose>
            <c:when test="${ not empty usr}">
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" style="background-color: darkseagreen">
    <div class="container">
        <a class="navbar-brand" href="#">Centro vecinal de Villa Allende</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/RedSocial/ListadoRubros"> Inicio
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item dropdown" >
                    <a class="nav-link dropdown-toggle" href="" id="menu" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Reportes
                    </a>
                    <div class="dropdown-menu" aria-labelledby="menu">
                        <a class="dropdown-item" href="/RedSocial/Reporte1">Comercios ordenado por cantidad de comentarios</a>
                        <a class="dropdown-item" href="/RedSocial/Reporte2">Comentarios no respondidos</a>                
                        <a class="dropdown-item" href="/RedSocial/Reporte3">Valoraciones por cantidad de estrellas</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/RedSocial/Comercio">Comercios</a>
                </li> 
                <li class="nav-item">
                    <a class="nav-link" href="/RedSocial/ofertaMenu">Ofertas</a>
                </li> 
        
            </ul>
        </div>
    </div>
</nav>
      </c:when>
    <c:otherwise>
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" style="background-color: darkseagreen">
    <div class="container">
        <a class="navbar-brand" href="#">Centro vecinal de Villa Allende</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/RedSocial/ListadoRubros"> Inicio
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/RedSocial/Comercio">Comercios</a>
                </li> 
                <li class="nav-item">
                    <a class="nav-link" href="/RedSocial/ofertaMenu">Ofertas</a>
                </li> 
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Iniciar Sesion</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
        
        
        
        
    </c:otherwise>
</c:choose>