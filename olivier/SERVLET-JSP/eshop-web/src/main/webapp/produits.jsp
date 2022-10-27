<%@page import="java.util.Arrays"%>
<%@page import="ajc.sopra.eshop.exercie.Produit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th>id:</th>
				<th>nom:</th>
				<th>prix</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Produit> produits = Arrays.asList(new Produit(1, "velo", 100), new Produit(2, "tasse", 1));
			for (Produit produit : produits) {
			%>
			<tr>
				<td><%=produit.getId()%></td>
				<td><%=produit.getNom()%></td>
				<td><%=produit.getPrix()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>