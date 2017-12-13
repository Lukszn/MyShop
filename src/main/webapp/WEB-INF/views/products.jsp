<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="styles.jsp" %>
<style>
.flex-container {
	display: flex;
	flex-wrap: wrap;
	background-color: DodgerBlue;
}

.flex-container>div {
	background-color: #f1f1f1;
	width: 300px;
	height: 300px;
	margin: 10px;
}
</style>
<title>Produkty</title>
</head>
<body style="background-image: url(<c:url value="/static/images/bgg.jpg"/>)">
<%@include file="header.jsp" %>
	<section>
	<div class="jumbotron">
		<div class="container">
			<h1>Produkty</h1>
			<p>Wszystkie produkty dostępne w naszym sklepie</p>
		</div>
	</div>
	</section>
	<section class="flex-container">
	 <c:forEach
		items="${products}" var="product">

		<div class="thumbnail">
			<div class="caption">

				<h3>${product.name}</h3>
				
				<p>${product.brand}</p>
				<p>${product.price}PLN</p>
				<p>Liczba sztuk w magazynie: ${product.unitsInStock}</p>
				<a href="<spring:url value="/products/product?id=${product.id}"/>"
				class="btn btn-primary"> <span
				class="glyphicon-info-sign glyphicon" /></span>Szczegóły
			</a>
				<br><br>
				<div class="col-1">
					<a href="/MyShop/products/delete/${product.id }"><button
							class="btn btn-danger">Delete</button></a>&nbsp
					<a href="/MyShop/products/edit/${product.id }"><button
							class="btn btn-success">Edit</button></a>
				</div>
				
			</div>
			
			
		</div>


	</c:forEach> </section>
	<%@include file="footer.jsp" %>
</body>
</html>