<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Detalles de cancion</h1>
    <p><strong>Título:</strong> ${cancion.titulo}</p>
    <p><strong>Artista:</strong> ${cancion.artista.nombre} ${cancion.artista.apellido}</p>
    <p><strong>Album:</strong> ${cancion.album}</p>
    <p><strong>Género:</strong> ${cancion.genero}</p>
    <p><strong>Idioma:</strong> ${cancion.idioma}</p>
    
    <form action="/canciones/eliminar/${cancion.id}" method="POST">
    	<input type="hidden" name="_method" value="DELETE" />
    	<button> Eliminar </button>
    </form>

<a href="/canciones/formulario/editar/${cancion.id}">Editar Canción</a>
<a href="<c:url value='/canciones'/>">Volver a lista de canciones</a>
<a href="<c:url value='/artistas'/>">Volver a lista de artista</a>
</body>
</html>