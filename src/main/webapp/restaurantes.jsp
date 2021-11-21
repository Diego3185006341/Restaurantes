<%@page import="controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="modelo.RestaurantesDAO,modelo.*,java.util.*"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>

<body>
<%
	
//Conexion con=new Conexion();
//con.conexiondb();
int tipo_restaurante=0;
String razon_social="",nombre_comercial="",ciudad="",hora_apertura="",hora_cierre="",lista_menu="";

if(request.getParameter("do")!=null){
tipo_restaurante=Integer.parseInt(request.getParameter("do"));
razon_social=request.getParameter("rs");
nombre_comercial=request.getParameter("nc");
ciudad=request.getParameter("cy");
hora_apertura=request.getParameter("hra");
hora_cierre=request.getParameter("hrc");
lista_menu=request.getParameter("lm");
}
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light style="background-color: #C0C0C0;">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Bienvenidos Restaurantes Jungle</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link active" aria-current="page" href="index.jsp">Inicio</a>
        
      </div>
    </div>
  </div>
</nav>
<div class= "usuario">
<form action="servletrestaurantes" method="post">

<table width="55%" align="center" class="table">
  <thead>
    <tr>
      <th colspan="5" scope="col"><center>
        <h5>Formulario Restaurantes</h5></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th colspan="5" scope="row"><input type="submit" name="btnins" value="Registrar" class="btn btn-primary" />
        <input type="submit" name="btncon" value="Consultar" class="btn btn-secondary" />
        <input type="submit" name="btnact" value="Actualizar" class="btn btn-success" />
       	<input type="submit" name="btneli" value="Eliminar" class="btn btn-danger" onclick="return confirm('¿Seguro quiere borrar?, esta acción no se puede deshacer.')"/></th>
   		<td><a class="btn btn-primary" href="menu.jsp" role="button" align="">ver menu</a></td>	 
    
     </tr>
    <tr>
      <th scope="row">tipo restaurante</th>
      <td>razon_social</td>
      <td>nombre comercial</td>
       <td>ciudad</td>
      
      <td width="11%" colspan="2" rowspan="5">&nbsp;</td>
      </tr>
    <tr>
      <th scope="row"><input type="number" name="tipo_restaurante"  value="<%=tipo_restaurante%>" placeholder = " # razon_social" required/></th>
      <td><input type="text" name="razon_social"  value="<%=razon_social%>"placeholder = "nombre comercial" /></td>
      <td><input type="text" name="nombre_comercial"  value="<%=nombre_comercial%>"placeholder = "tipo restaurante" /></td>
      <td><input type="text" name="ciudad"  value="<%=ciudad%>"placeholder = "ciudad" /></td>
      </tr>
    <tr>
      <th width="36%" scope="row">hora apertura</th>
      <td width="28%">hora cierre</td>
      <td width="25%">lista menu</td>
       
      </tr>
    <tr>
      <th scope="row"><input type="text" name="hora_apertura"  value="<%=hora_apertura%>" placeholder = " # hora apertura" /></th>
      <td><input type="text" name="hora_cierre"  value="<%=hora_cierre%>"placeholder = "hora cierre" /></td>
      <td><input type="text" name="lista_menu"  value="<%=lista_menu%>"placeholder = "lista menu" /></td>
      <td>&nbsp;</td>
      </tr>
    <tr>
      <th scope="row">&nbsp;</th>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      </tr>
  </tbody>
</table>


</form>
</div>
<div class="row">

	<c:set var="mensaje_error" value="${requestScope.mensaje_error}" />
	<c:if test="${not empty mensaje_error}">
		<div class="alert alert-danger alert-dismissible">
			<p>${mensaje_error}</p>
		</div>
	</c:if>

</div>

<div class="row">

	<c:set var="mensaje_success" value="${requestScope.mensaje_success}" />
	<c:if test="${not empty mensaje_success}">
		<div class="alert alert-success alert-dismissible">
			<p>${mensaje_success}</p>
		</div>
	</c:if>

</div>

<div class="row">

	<c:set var="mensaje_warning" value="${requestScope.mensaje_warning}" />
	<c:if test="${not empty mensaje_warning}">
		<div class="alert alert-warning alert-dismissible">
			<p>${mensaje_warning}</p>
		</div>
	</c:if>

</div>


<h3>Lista de Restaurantes</h3></th>
  

  
<%
List<RestaurantesDTO> lista=RestaurantesDAO.consultar();
request.setAttribute("lista",lista);
%>


<table  class="table" >
<thead class="table" style="background-color: #C0C0C0;:"><th>tipo restaurante</th><th>razon social</th><th>nombre comercial</th><th>ciudad</th><th>hora apertura</th><th>hora cierre</th><th>lista menu</th></thead>
<c:forEach items="${lista}" var="rdto">
<tr><td>${rdto.getTipoRestaurante()}</td><td>${rdto.getRazonSocial()}</td><td>${rdto.getNombreComercial()}</td>
<td>${rdto.getCiudad()}</td><td>${rdto.getHora_Apertura()}</td><td>${rdto.getHora_Cierre()}</td><td>${rdto.getLista_Menu()}</td>

</tr>
</c:forEach>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>