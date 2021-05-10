<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.coloum {
	width: 60%;
	height: 220px;
	margin-left: 20%;
	margin-top: 20px;
	margin-bottom: 10px;
	background-color: lightgrey;
}

.image {
	width: 180px;
	margin-top: 8px;
	margin-left: 8px;
}

.name {
	font-family: sans-serif;
	margin-left: 10px;
}

.colour {
	margin-left: 10px;
	font-family: sans-serif;
}

.productcode {
	margin-left: 10px;
	font-family: sans-serif;
}

.price {
	margin-left: 10px;
	font-family: sans-serif;
}

.remove {
	background-color: #ff3300;
	font-weight: bolder;
	padding: 10px 40px;
	font-size: 40px;
	color: white;
	text-decoration: none;
	margin-right: 80px;
}

.carttotal {
	background-color: grey;
	height: 150px;
}

.carttext {
	padding-left: 1100px;
	padding-top: 50px;
	font-family: sans-serif;
	font-weight: bold;
	font-size: large;
	color: white;
}

.cartprice {
	padding-top: 50px;
	font-family: sans-serif;
	font-weight: bold;
	font-size: large;
	color: white;
}

.checkout {
	margin-top: 50px;
	font-family: sans-serif;
	font-weight: bold;
	text-decoration: none;
	font-size: large;
	color: white;
	background-color: black;
	padding: 5px;
	border-radius: 2px;
}
.message{
height: 50px;
}
.message h1{
font-family: sans-serif;
margin-left: 550px;
}
</style>
</head>
<body>
<div class="message">
<h1>${message}</h1>
</div>
	<div>
		<c:forEach var="item" items="${items}">
			<div class="coloum">
				<table>
					<tr>
						<td><img class="image"
							src="data:image/jpg;base64,${item.base64Image}"></td>
						<td><h5 class="name">${item.name}</h5>
							<p class="colour">colour:black/white</p>
							<p class="productcode">product code:${item.productCode}</p>
							<p class="price">
								Price:<b>${item.price} </b>
							</p></td>
						<td><a
							href="${pageContext.request.contextPath}/remove/${item.productCode}"
							class="remove">&#10005;</a></td>

					</tr>

				</table>
			</div>
		</c:forEach>
	</div>
	<div class="carttotal">
		<table>
			<tr>
				<td class="carttext">CartTotal:</td>
				<td class="cartprice">${carttotal}</td>
			</tr>
			<tr>
				<td></td>
				<td><a href="${pageContext.request.contextPath}/checkout"
					class="checkout">Checkout &#10143;</a></td>
			</tr>
		</table>

	</div>

</body>
</html>