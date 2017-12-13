<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="styles.jsp" %>
<title>Dodaj produkt</title>
</head>
<body style="background-image: url(<c:url value="/static/images/bgg.jpg"/>)">
<%@include file="header.jsp" %>
<hr>
<section class="container">
<br>
<form:form class="form-inline" method="post" modelAttribute="order">
<div form-row align-items-center>
<div class="col-auto">
	<b>Klient:</b><form:select class="custom-select" path="client" items="${clients}" itemValue="id" itemLabel="lastName"/>
	<b>Produkt:</b> <form:select class="custom-select" path="product" items="${products}" itemValue="id" itemLabel="name"/>
	<b>Ilość:</b> <form:input class="form-control" path="amount"/>
	<input type="submit" class="btn btn-primary">
	</div>
	</div>
</form:form>
</section>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>