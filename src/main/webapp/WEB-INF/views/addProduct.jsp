<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="styles.jsp" %>
<title>Produkty</title>
</head>
<body style="background-image: url(<c:url value="/static/images/bgg.jpg"/>)">
<%@include file="header.jsp" %>
	<section>
	<div class="jumbotron">
		<div class="container">
			<a href="<c:url value="/j_spring_security_logout" />"
				class="btn btn-danger btn-mini pull-right">Wyloguj się</a>
			<h1>Produkty</h1>
			<p>Dodaj produkty</p>
		</div>
	</div>
	</section>
	<section class="container"> <form:form
		modelAttribute="product" class="form-horizontal">
		<fieldset>
			<legend>Dodaj nowy produkt</legend>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="name">Nazwa
					produktu:</label>
				<div class="col-lg-10">
					<form:input id="name" path="name" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="price">Cena:</label>
				<div class="col-lg-10">
					<form:input id="price" path="price" type="text"
						class="form:input-large" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="brand">Producent:</label><br>
				<form:select class="custom-select" path="brand">

					<form:options items="${brands}" itemValue="id" itemLabel="name" />
				</form:select>
			</div>
			
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="unitsInStock">Ilość
					dostępnych sztuk:</label>
				<div class="col-lg-10">
					<form:input id="unitsInStock" path="unitsInStock" type="text"
						class="form:input-large" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2" for="description">Opis:</label>
				<div class="col-lg-10">
					<form:textarea id="description" path="description" rows="2" />
				</div>
			</div>

			
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="Dodaj" />
				</div>
			</div>
		</fieldset>
	</form:form> </section>
</body>
</html>