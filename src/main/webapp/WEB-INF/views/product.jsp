<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="styles.jsp" %>
<title>Produkt</title>
</head>
<body style="background-image: url(<c:url value="/static/images/bgg.jpg"/>)">
<%@include file="header.jsp" %>
	<section>
	<div class="jumbotron">
		<div class="container">
			<h1>Produkt</h1>
		</div>
	</div>
	</section>
	<section class="container">
	<div class="row">
		<div class="col-md-5">
			<h3>${product.name}</h3>
			
			<p>
				<strong>Kod produktu: </strong><span class="label label-warning">${product.id}</span>
			</p>
			<p>
				<strong>Producent:</strong> ${product.brand}
			</p>
			
			<p>
				<strong>Dostępna liczba sztuk :</strong>${product.unitsInStock}
			</p>
			
			<h4>${product.price}PLN</h4>
			<p><strong>Opis : </strong>${product.description}</p>
			<a href="<spring:url value="/products" />" class="btn btndefault">
				<span class="glyphicon-hand-left glyphicon"></span> Wstecz
			</a>
			
		</div>
	</div>
	</section>
</body>
</html>