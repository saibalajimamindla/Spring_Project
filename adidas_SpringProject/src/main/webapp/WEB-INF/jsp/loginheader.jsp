<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.header {
	overflow: hidden;
	background-color:BLACK;
	padding: 20px 10px;
}

.header a {
	float: left;
	color: white;
	text-align: center;
	padding: 25px;
	text-decoration: none;
	font-size: 18px;
	line-height: 25px;
	border-radius: 4px;
}

.header-left a {
	margin-top: 10px;
	font-size: large;
	font-weight: bolder;
	font-size: large;
}

.header-right a {
	float: right;
	 margin-top : 10px;
	font-size: large;
	font-weight: bolder;
	font-size: large;
	margin-top: 10px;
}

.header a:hover {
	color: #ffff00;
}

.header a.active {
	margin-left: 50px;
}
</style>
</head>

<body>
	<header>
		<div class="header">
			<a href="homepage" class="logo"><img
				src="https://www.searchpng.com/wp-content/uploads/2019/01/Adidas-Logo-White-PNG.png"
				alt="Italian Trulli" width="50"></a>
			<div class="header-left">
				<a class="active" href="men">MEN</a> <a href="women">WOMEN</a> 
				<a href="kids">KIDS</a> <a href="sports">SPORTS</a>
			</div>
			<div class="header-right">
				<a href="#">Cart</a> 
				<a href="#" >Welcome-${username}</a>
			</div>
		</div>
	</header>
</body>
</html>