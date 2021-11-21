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
int tipo_menu=0,calorias=0;
String nombre_menu="",lista_ingredientes="",tm_nombre="";
double precio=0;
if(request.getParameter("do")!=null){
tipo_menu=Integer.parseInt(request.getParameter("do"));
tm_nombre=request.getParameter("nm");
nombre_menu=request.getParameter("rs");
lista_ingredientes=request.getParameter("nc");
calorias=Integer.parseInt(request.getParameter("cy"));
precio=Double.parseDouble(request.getParameter("hra"));

}
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
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
<form action="servletmenuc" method="post">

<table width="55%" align="center" class="table">
  <thead>
    <tr>
      <th colspan="5" scope="col"><center>
        <h5>Formulario Restaurante</h5></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th colspan="5" scope="row"><input type="submit" name="btnins" value="Registrar" class="btn btn-primary" />
        <input type="submit" name="btncon" value="Consultar" class="btn btn-secondary" />
        <input type="submit" name="btnact" value="Actualizar" class="btn btn-success" />
        <input type="submit" name="btneli" value="Eliminar" class="btn btn-danger" onclick="return confirm('¿Seguro quiere borrar?, esta acción no se puede deshacer.')"/></th>
    </tr>
    <tr>
      <th scope="row">tipo menu</th>
      <td>tm nombre</td>
      <td>nombre menu</td>
     
      
      <td width="11%" colspan="2" rowspan="5">&nbsp;</td>
      </tr>
    <tr>
      <th scope="row"><input type="number" name="tipo_menu"  value="<%=tipo_menu%>" placeholder = " # tipo menu" required/></th>
      <td><input type="text" name="tm_nombre"  value="<%=tm_nombre%>"placeholder = "tm nombre" /></td>
      <td><input type="text" name="nombre_menu"  value="<%=nombre_menu%>"placeholder = "nombre menu" /></td>
      
    
      </tr>
    <tr>
      <th width="36%" scope="row">lista ingredientes</th>
      <td width="28%">calorias</td>
      <td width="28%">Precio</td>
        <td>&nbsp;</td>
       
      </tr>
    <tr>
    	<td><input type="text" name="lista_ingredientes"  value="<%=lista_ingredientes%>"placeholder = "lista ingredientes" /></td>	
      <th scope="row"><input type="number" name="calorias"  value="<%=calorias%>" placeholder = " Calorias" /></th>
      <td><input type="number" name="precio"  value="<%=precio%>"placeholder = "Precio" /></td>
    
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


<h3>Menu Restaurante Carnes y aves</h3></th>
  

  
<%
List<MenucDTO> lista=MenucDAO.consultar();
request.setAttribute("lista",lista);
%>


<table  class="table" >
<thead class="table" style="background-color: #C0C0C0;:"><th>Tipo menu</th><th>tm nombre</th><th>Nombre menu</th><th>Lista ingredientes</th><th>Calorias</th><th>Precio</th></thead>
<c:forEach items="${lista}" var="medto">
<tr><td>${medto.getTipo_menu()}</td><td>${medto.getTm_nombre()}</td><td>${medto.getNombre_menu()}</td><td>${medto.getLista_ingredientes()}</td>
<td>${medto.getCalorias()}</td><td>${medto.getPrecio()}</td>

</tr>
</c:forEach>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>