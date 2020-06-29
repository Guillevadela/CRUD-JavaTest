<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert de datos</title>
</head>
<body>

<h2>Insertar datos desde este formulario</h2>
 
 <form action="series" method="post">
<c:set var="serie" value="${serie}"> </c:set>
	<input type="hidden" name="opcion" value="editar">
	<input type="hidden" name="id" value="${serie.id}">
		<table border="1">
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" size="50" value="${serie.nombre}"></td>
			</tr>

			<tr>
				<td>Precio:</td>
				<td><input type="text" name="precio" size="50" value="${serie.precio}"></td>
			</tr>			
		</table>
		<input type="submit" value="Guardar">
	</form>


</body>
</html>