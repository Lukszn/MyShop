<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="styles.jsp" %>
<title>Witaj</title>
</head>
<body style="background-image: url(<c:url value="/static/images/bgg.jpg"/>)">
<section>
<div class="jumbotron">
<div class="container">
<h1> ${greeting} </h1>
<p> ${tagline} </p>
</div>
</div>
<center><div>
		<a href="<c:url value="/products" />"
			class="btn btn-danger">Przejdź do strony
			produktów</a></div>
	</center>
</section>
</body>
</html>