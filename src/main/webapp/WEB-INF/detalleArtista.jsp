<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
      <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle Artista</title>
</head>
<body>
<h1>Detalle Del Artista</h1>
<p>Nombre: ${artista.nombre}</p>
<p>Apellido:${artista.apellido}</p>
<p>Biografia: ${artista.biografia}</p>
<p>fecha_creacion: ${artista.fecha_creacion}</p>
<p>fecha_actualizacion: ${artista.fecha_actualizacion}</p>
<h3>Canciones:</h3>
<ul>
   <c:forEach var="cancion" items="${artista.listaCanciones}">
	 <li>${cancion.titulo} ${cancion.album}, ${cancion.genero} </li>
	</c:forEach>
	
</ul>
<a href="/artistas"> Volver a Lista de Artista</a>
</body>
</html>