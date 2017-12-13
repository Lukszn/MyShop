<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<br>
<center>
<div>
<a href="/MyShop/products"><button class="btn btn-primary">Strona główna</button></a> 
<a href="/MyShop/products/addProduct"><button class="btn btn-primary">Dodaj produkt</button></a> 
<a href="<c:url value="/brands"/>"><button class="btn btn-success"> Producenci</button></a> 
<a href="<c:url value="/clients"/>"><button class="btn btn-danger">Zarządzaj klientami</button></a> 
<a href="<c:url value="/orders" />" class="btn btn-default"><span class="glyphicon-hand-right glyphicon"></span> Koszyk</a><br><br>
</div>
</center>