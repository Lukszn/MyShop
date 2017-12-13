<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="styles.jsp" %>
<title>Lista Klientów</title>
</head>
<body style="background-image: url(<c:url value="/static/images/bgg.jpg"/>)">
<%@include file="header.jsp" %>
<div class="container">
 <div class="row">

    <div class="col-4">
<h2>Lista Klientów</h2> 
<a href="<c:url value="/clients/addClient"/>"><button class="btn btn-primary">  Dodaj  </button></a>


<hr>
<c:forEach items="${allClients}" var="client">
<div><b>${client.firstName} ${client.lastName} </b>
<a href="/MyShop/clients/delete/${client.id }"><button class="btn btn-dark">  Usuń  </button></a>
<a href="/MyShop/clients/edit/${client.id }"><button class="btn btn-info">  Edytuj  </button></a></d>
</div>

<c:forEach items="${client.orders}" var="order">
<ul class="list-group">
<li class="list-group-item">${order.product.name}</li>
</ul>
</c:forEach>
</c:forEach>

</div>
</div>
<div class="col-4">
 </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<hr>



</body>
</html>