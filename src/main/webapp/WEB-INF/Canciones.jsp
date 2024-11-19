<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Canciones</title>
</head>
<body>
<h1>Estas son las Canciones</h1>
<ul>
<c:forEach var="cancion" items="${canciones}">
	<li>Titulo: ${cancion.titulo}</li> 
	<li>Artista:${cancion.artista.nombre} ${cancion.artista.apellido}</li>
	
	<a href="/canciones/detalle/${cancion.id}">detalle</a>
</c:forEach>
</ul>

<a href="<c:url value='/canciones/formulario/agregar'/>">Agregar Canción</a>
<a href="<c:url value='/artistas'/>">Ir a Artistas</a>
</body>
</html>