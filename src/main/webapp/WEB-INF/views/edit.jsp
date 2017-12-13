<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="styles.jsp" %>
<title>Educja produktu</title>
</head>
<body style="background-image: url(<c:url value="/static/images/bgg.jpg"/>)">
<%@include file="header.jsp" %>
	<section>
	<div class="jumbotron">
		<div class="container">
			<h1>Produkty</h1>
			<p>Dodaj produkty</p>
		</div>
	</div>
	</section>
	<form action='../edit'>
		<input type='hidden' name='id' value='${product_id}'>
		<p>Nazwa produktu:</p>
		<input type='text' name='name'>
		<p>Cena produktu:</p>
		<input type='number' name='price' value=0>
		<p>Producent:</p>
		<input type='number' name='brand_id'> <input type='submit'>
	</form>

</body>
</html>