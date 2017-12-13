<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of products</title>
</head>
<body>
<div class="container">

<h2>List of products</h2>

<a href="/MyShop/products/addProduct"><button class="btn btn-primary">  Add  </button></a>
<a href="<c:url value="/brands"/>"><button class="btn btn-success">  Brands  </button></a>
<a href="<c:url value="/clients"/>"><button class="btn btn-danger">  Clients  </button></a>
<a href="<c:url value="/orders"/>"><button class="btn btn-warning">  Orders  </button></a>
<hr>
<c:forEach items="${products}" var="product">

 <div class="row">
    <div class="col-3">
<b>${product.name}</b> <fmt:formatNumber value = "${product.price}"  type = "currency"/> dolarów
</div>

<div class="col-1" >
<a href="/MyShop/products/delete/${product.id }"><button class="btn btn-dark">  Delete  </button></a></div>
<div class="col-6" >
<a href="/MyShop/products/edit/${product.id }"><button class="btn btn-info">  Edit  </button></a></div>
</div>
</c:forEach>

<hr>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>