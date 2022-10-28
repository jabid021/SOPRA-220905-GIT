<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${pageContext.request.contextPath}/">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form method="post" action="produit">
			<input type="hidden" name="query" value="save">
			<div class="form-group">
				<label for="id">id:</label> <input class="form-control" id="id"
					name="id" readonly="readonly" value="${produit.id}"
					placeholder="generer automatiquement">
			</div>
			<div class="form-group">
				<label for="libelle">libelle:</label> <input class="form-control"
					id="libelle" name="libelle" value="${produit.libelle}">
			</div>
			<div class="form-group">
				<label for="prix">prix:</label> <input type="number"
					class="form-control" id="prix" name="prix" value="${produit.prix}" step="0.1">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-primary">enregistrer</button>
				<a href="produit" class="btn btn-outline-warning">annuler</a>
			</div>
		</form>
	</div>
</body>
</html>