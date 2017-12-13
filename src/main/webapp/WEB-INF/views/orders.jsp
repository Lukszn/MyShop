<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@include file="styles.jsp" %>
<title>Koszyk</title>
</head>
<body style="background-image: url(<c:url value="/static/images/bgg.jpg"/>)">
<%@include file="header.jsp" %>
<div class="container">
<h2>Lista produktów w koszyku:</h2>
<a href="/MyShop/orders/addOrder"><button class="btn btn-primary">  Dodaj  </button></a>



<hr>
<c:forEach items="${orders}" var="order">
<div>Ilość: <b>${order.amount}</b> <b>${order.product.name} <b>${order.client.lastName}</b></b>
<a href="/MyShop/orders/delete/${order.id }"><button class="btn btn-dark" >  Usuń  </button></a>
<a href="/MyShop/products/edit/${product.id }"><button class="btn btn-info">  Edytuj  </button></a></div>
</c:forEach>

</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>