<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>eshop</title>
<base href="${pageContext.request.contextPath}/">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<a href="achat/save" class="btn btn-link">identifiez vous</a>
			</div>
			<div class="col">
				nouveau client:<a href="client/inscription" class="btn btn-link">inscrivez
					vous</a>
			</div>
		</div>
	</div>
</body>
</html>