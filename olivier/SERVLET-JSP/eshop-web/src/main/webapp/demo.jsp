<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%!//declarative pour declaration d'attribut et de methode
	private String texte = "hello";

	private String getTexte() {
		return this.texte;
	}%>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>hello de la jsp</h1>
		<hr>
		<%
		//scriptlet
		//ajouter du code dans la methode service exactement à cet endroit
		out.write("scriptlet");
		%>
		<hr>
		<%
		out.write("autre scriptlet");
		for (int i = 0; i < 5; i++) {
			out.write("i=" + i);
		%>
		<br>
		<%
		}
		%>
		<hr>
		<%
		List<String> prenoms = Arrays.asList("olivier", "jordan", "chloe");
		%>
		<table class="table">
			<%
			for (String s : prenoms) {
			%>
			<tr>
				<td>prenom:</td>
				<td><%out.write(s); %></td>
				<td>affichage avec une expression <%=s %></td>
			</tr>
			<%
			}
			%>
		</table>

	</div>
</body>
</html>