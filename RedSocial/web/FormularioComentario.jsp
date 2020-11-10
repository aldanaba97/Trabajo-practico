<%-- 
    Document   : ComentarioComercio
    Created on : 30 oct. 2020, 0:31:08
    Author     : Aldana
--%>

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

    </head>
    <body>
        
        <form method = "POST" action = "Comentario">
             <div class="form-group col-md-6">
                <input type="hidden" class="form-control" name="idComercio" value="${comercio.comercios_id}">
            </div>
            <div class="form-group col-md-6" >
                <label for="input">Nombre de usuario: </label>
                <input type="text" class="form-control" name="txtNombre" placeholder="Escriba su nombre">
            </div>
            <div class="form-group col-md-6">
                <label for="input">Descripcion: </label>
                <input type="text" class="form-control" name="txtDescripcion" placeholder="Escriba su comentario">
            </div>
            <div class="form-group col-md-6">
                <label for="input">Valoracion: </label>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="rbtValoracion" id="1" value="1">
                    <label class="form-check-label" for="inlineRadio1">1</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="rbtValoracion" id="2" value=2>
                    <label class="form-check-label" for="inlineRadio2">2</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="rbtValoracion" id="3" value=3>
                    <label class="form-check-label" for="inlineRadio3">3</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="rbtValoracion" id="4" value=4>
                    <label class="form-check-label" for="inlineRadio3">4</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="rbtValoracion" id="5" value=5>
                    <label class="form-check-label" for="inlineRadio3">5</label>
                </div>
                
            </div>
            <button type="submit" class=" btn btn-success">Registrar</button>
  <%@include file = "principal/componentes/nave.jsp" %>
        </form> 
    </body>
</html>
