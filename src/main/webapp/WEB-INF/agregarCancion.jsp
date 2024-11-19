<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Canción</title>
</head>
<body>
    <h2>Agregar Nueva Canción</h2>

    <form:form modelAttribute="canciones" action="/canciones/procesa/agregar" method="post">
        <div>
            <form:label path="titulo">Título:</form:label>
            <form:input path="titulo" />
            <form:errors path="titulo" cssClass="error" />
        </div>
        
        <div>
            <form:label path="artista">Artista:</form:label>
            <form:select path="artista">
            <c:forEach var="artista" items="${listaArtistas}">
            <option value="${artista.id}">${artista.nombre} ${artista.apellido}</option>
            </c:forEach>
            </form:select>
            <form:errors path="artista" cssClass="error" />
        </div>

        <div>
            <form:label path="album">Álbum:</form:label>
            <form:input path="album" />
            <form:errors path="album" cssClass="error" />
        </div>

        <div>
            <form:label path="genero">Género:</form:label>
            <form:input path="genero" />
            <form:errors path="genero" cssClass="error" />
        </div>

        <div>
            <form:label path="idioma">Idioma:</form:label>
            <form:input path="idioma" />
            <form:errors path="idioma" cssClass="error" />
        </div>

        <div>
            <input type="submit" value="Agregar Canción" />
        </div>
    </form:form>

    <div>
        <a href="/canciones">Volver a lista de canciones</a>
    </div>
</body>
</html>