<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Series</title>
</head>
<body>
	<h1>Listar Series</h1>

	<table border="1">
		<tr>
			<td>Id</td>
			<td>Nombre</td>
			<td>Cantidad</td>
			<td>Precio</td>
			<td>Fecha Creacion</td>
			<td>Fecha Actualizacion</td>
			<td>Accion</td>
		</tr>
		<c:forEach var="serie" items="${lista}">
			<tr>
				<td> <a href="series?opcion=meditar&id=<c:out value="${ serie.id}"></c:out>"> <c:out value="${ serie.id}"></c:out>  </a> </td>
				<td> <c:out value="${ serie.nombre}"></c:out> </td>
				<td> <c:out value="${ serie.cantidad}"></c:out></td>
				<td> <c:out value="${ serie.precio}"></c:out> </td>
				<td><c:out value="${ serie.fechaCrear}"></c:out> </td>
				<td><c:out value="${ serie.fechaActualizar}"></c:out> </td>
				<td> <a href="series?opcion=eliminar&id=<c:out value="${ serie.id}"></c:out>"> Eliminar  </a> </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>