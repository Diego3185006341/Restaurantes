<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

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
<br>

<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">tipo restaurante</th>
      <th scope="col">menu restaurante</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>10 a 20</td>
      <td>Restaurante de carnes</td>
 	  <td><a class="btn btn-primary" href="menu_carnes.jsp" role="button">ver menu</a></td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>21 a 30</td>
      <td>restaurante vegetariano</td>
      <td><a class="btn btn-primary" href="menu_vegetariano.jsp" role="button">ver menu</a></td>
    </tr>
    <tr>
      <th scope="row">3</th>
       <td >31 a 40</td>
      <td > pescado mariscos</td>
      <td><a class="btn btn-primary" href="menu_pescados.jsp" role="button">ver menu</a></td>
      
    </tr>
      <tr>
      <th scope="row">4</th>
       <td >41 a 50</td>
      <td >Restaurante vegano</td>
      <td><a class="btn btn-primary" href="menu_vegano.jsp" role="button">ver menu</a></td>
      
    </tr>
  </tbody>
</table>






<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>