<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.body table {
	width: 100%;
	height: 500px;
}

.image {
	
}

.image img {
	width: 400px;
	padding-left: 30px;
	padding-top: 30px;
}

.data {
	width: 60%;
}

.name {
	font-family: sans-serif;
	margin-bottom: 50px;
}

.price {
	font-family: sans-serif;
}

.stockunits {
	font-family: sans-serif;
}

.stockunits a {
	text-decoration: none;
	color: red;
}

.size a {
	text-decoration: none;
	color: black;
	background-color: lightgrey;
	margin-top: 30px;
	margin-right: 20px;
	padding: 10px;
	border-radius: 60px;
}

.size a:hover {
	background-color: grey;
}

.size a::selection {
	background-color: black;
	color: white;
}

.cartbutton {
	text-decoration: none;
	padding: 10px;
	background-image: linear-gradient(to right, #005266, #00ccff);
	color: white;
	font-family: sans-serif;
	font-weight: bold;
}

.description {
	width: 60%;
}

.description p {
	padding-left: 50px;
}

.description h3 {
	padding-left: 50px;
}
</style>
</head>
<body>

	<div class="body">
		<table>
			<tr>
				<td class="image"><img
					src="data:image/jpg;base64,${productDetails.base64Image}" /></td>
				<td class="data">
					<h1 class="name">${productDetails.name}</h1>
					<h1 class="price">&#x20B9;${productDetails.price}</h1>
					<p>(Inclusive of all taxes)</p>
					<p class="stockunits">
						No.of units left:<a>${productDetails.quantity}</a>
					</p> <br> <br> <br> <a class="cartbutton"
					href="${pageContext.request.contextPath}/addtocart/${productDetails.productCode}/${product.category}">ADD
						TO CART </a> <br>

				</td>
			</tr>
		</table>
	</div>

	<div class="description">
		<h3>Description:</h3>
		<p>${productDetails.description}</p>

	</div>

</body>
</html>