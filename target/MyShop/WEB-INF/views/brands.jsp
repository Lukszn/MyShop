<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="styles.jsp" %>
<title>Producenci</title>
</head>
<body style="background-image: url(<c:url value="/static/images/bgg.jpg"/>)"aaaa>
<%@include file="header.jsp" %>

<div class="container">

<h2>Lista producentów</h2>
<a href="/MyShop/brands/addBrand"><button class="btn btn-primary">  Dodaj  </button></a>

<hr>
<c:forEach items="${brandss}" var="brand">
<div class="row">
    <div class="col-2">
<div class="form-group row"><b>${brand.name}</b><a href="/MyShop/brands/delete/${brand.id }">&nbsp<button class="btn btn-danger">  Usuń  </button></div></div>
 </a></div>
<c:forEach items="${brand.products}" var="product">
<ul>
<li>${product.name}</li>
</ul>
</c:forEach>

</c:forEach>

</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>