<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="inicio" />
  <jsp:param name="title" value="Inicio" /> 
</jsp:include>


<h1>Pagina principal</h1>
<h2>Todas las Series</h2>
	

	<p>${mensaje}</p>
	<a href="producto">Ir a formulario para Crear Nueva Serie</a>

	<%
		// Podemos usar el ${}  EL - Expresion Lenguage en los JSPs
		// suele ser mas comodo que tener que usar < % % >, a estos porcentajes se les llama SCRIPLETS
		// ademas se pueden combinar con JSTL - Java Servlet Tag Libraries
	%>	

	
	
	<table class="tabla table table-striped">
		<thead>
			<tr>
				<td>Id</td>
				<td>Nombre</td>
				<td>Cantidad</td>
				<td>Precio</td>
				<td>fecha_crear</td>
				<td>fecha_actualizar</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${series}" var="p">
				<tr>
					<td>${p.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${p.nombre}</td>
					<td>${p.precio} &euro;</td>
					<td><img src="${p.imagen}"  class="img-thumbnail" alt="imagen..."></td>
					<td>
						<a href="serie?id=${p.id}" class="mr-4"> <i class="far fa-edit fa-2x" title="Editar Serie"></i></a>
						<a href="serie-eliminar?id=${p.id}"><i class="fas fa-trash fa-2x" title="Eliminar Serie"></i></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


${series}
<%@include file="includes/pie.jsp" %>

