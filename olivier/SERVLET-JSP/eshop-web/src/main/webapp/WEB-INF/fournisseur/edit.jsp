<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<form method="post" action="fournisseur">
			<input type="hidden" name="q" value="save">
			<div class="form-group">
				<label for="id">id:</label> <input class="form-control" id="id"
					name="id" readonly="readonly" value="${fournisseur.id}"
					placeholder="generer automatiquement">
			</div>
			<div class="form-group">
				<label for="prenom">prenom:</label> <input class="form-control"
					id="prenom" name="prenom" value="${fournisseur.prenom}">
			</div>
			<div class="form-group">
				<label for="nom">nom:</label> <input class="form-control" id="nom"
					name="nom" value="${fournisseur.nom}">
			</div>
			<div class="form-group">
				<label for="societe">societe:</label> <input class="form-control"
					id="societe" name="societe" value="${fournisseur.societe}">
			</div>
			<div class="form-group">
				<label for="numero">numero:</label> <input class="form-control"
					id="numero" name="numero" value="${fournisseur.adresse.numero}">
			</div>
			<div class="form-group">
				<label for="voie">voie:</label> <input class="form-control"
					id="voie" name="voie" value="${fournisseur.adresse.voie}">
			</div>
			<div class="form-group">
				<label for="ville">ville:</label> <input class="form-control"
					id="ville" name="ville" value="${fournisseur.adresse.ville}">
			</div>
			<div class="form-group">
				<label for="cp">code postal:</label> <input class="form-control"
					id="cp" name="cp" value="${fournisseur.adresse.cp}">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-primary">enregistrer</button>
				<a href="fournisseur" class="btn btn-outline-warning">annuler</a>
			</div>
		</form>
	</div>
</body>
</html>