<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Artista:</title>
</head>
<body>
<h1>Ingresa los datos del Artista:</h1>
	<form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="artista">
		<form:label path="nombre">Nombre Artista:</form:label>
		<form:input path="nombre" type="text"/>
		<form:errors path="nombre"/>
		
		<form:label path="apellido">Apellido:</form:label>
		<form:input path="apellido" type="text"/>
		<form:errors path="apellido"/>
		
		<form:label path="biografia">BiografÃ­a:</form:label>
		<form:input path="biografia" type="text"/>
		<form:errors path="biografia"/>
		
		<input type="submit" value="Agregar Artista">
	
	</form:form>
	<a href="/artistas">Volver a Lista de Artistas</a>

</body>
</html>