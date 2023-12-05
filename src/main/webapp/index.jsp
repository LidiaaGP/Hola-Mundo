<%@page import="com.ipartek.modelo.DAO_Constantes"%>
<%@page import="com.ipartek.modelo.dto.Producto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%
	List<Producto> lista=new ArrayList<Producto>();
	
	if(request.getAttribute(DAO_Constantes.ATR_LISTA_PRODUCTOS)!=null){
		lista=(List<Producto>)request.getAttribute(DAO_Constantes.ATR_LISTA_PRODUCTOS);
	}
	
	
	%>
	
	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Plantilla</title>
		<link rel="stylesheet" href="styles/styles.css"></link>
	</head>
	
	<body>
	
	<%@ include file="includes/cabecera.jsp" %>
	
	
	<main>
		<table border="1">
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Nombre</th>
		            <th>Precio</th>
		        </tr>
		    </thead>
		    
		    <tbody>
		    
		    <%
		    for(Producto elemento:lista){
		    %>
		    	 <tr>
		            <td><%=elemento.getId()%></td>
		            <td><%=elemento.getNombre()%></td>
		            <td><%=elemento.getPrecio()%></td>
		        </tr>
		        
		    <%   
		    }
		    %>
		       
		        
		        
		    </tbody>
		</table>
	</main>

	<%@ include file="includes/pie.jsp" %>


</body>
</html>