<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#box {
	float: left;
	width: 280px;
	height: 420px;
	background-color: lightgrey;
	margin-top: 50px;
	margin-left: 70px;
	box-shadow: 5px 5px 20px grey;
}

#box img {
	width: 250px;
	margin-left: 15px;
	margin-top: 15px;
}

#name {
	font-weight: bold;
	font-family: sans-serif;
	font-size: 20px;
	text-align: center;
}

#price {
	font-weight: bold;
	font-size: 20px;
	font-family: sans-serif;
	text-align: center;
	margin-left: 10px;
}

#button {
	text-align: center;
	padding-top: 15px;
}

#button a {
	text-decoration: none;
	background-color: black;
	color: white;
	padding: 10px;
	border-radius: 5px;
}
</style>
</head>
<body>
	<div style="background-color: black; height: 1000px">
		<c:forEach var="product" items="${listProducts}">
			<div id="box">
				<table>
					<tr>
						<td><a href="${pageContext.request.contextPath}/detailpage/${product.productCode}"><img src="data:image/jpg;base64,${product.base64Image}" /></a>
						</td>
					</tr>
					<tr>
						<td id="name">${product.name}</td>
					</tr>
					<tr>
						<td id="price">Price:${product.price}</td>

					</tr>
					<tr>
						<td id="button"><a href="${pageContext.request.contextPath}/addtocart/${product.productCode}/${product.category}">Add To Cart</a></td>
					</tr>

				</table>
			</div>

		</c:forEach>

	</div>
	
</body>
</html>