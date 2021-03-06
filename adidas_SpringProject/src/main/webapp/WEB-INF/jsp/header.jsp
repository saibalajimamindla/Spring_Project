<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	background-color: BLACK;
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

.header-right {
	float: right;
	margin-top: 10px;
	font-size: large;
	font-weight: bolder;
	font-size: large;
	margin-top: 10px;
}

.header a:hover {
	color: #ffff00;
}

.header a.active {
	margin-left: 20px;
}
</style>
</head>

<body>
	<header>
		<div class="header">
			<a href="${pageContext.request.contextPath}/homepage" class="logo"><img
				src="https://www.searchpng.com/wp-content/uploads/2019/01/Adidas-Logo-White-PNG.png"
				alt="Italian Trulli" width="50"></a>
			<div class="header-left">
		<c:forEach var="category" items="${categoryList}">
		<a class="active" href="${pageContext.request.contextPath}/requestplp/${category}">${category}</a>
		
		</c:forEach>
			
			</div>
			<div class="header-right">
				<a href="${pageContext.request.contextPath}/${button2adress}">${button2}</a>
				<a href="${pageContext.request.contextPath}/${button3adress}">${button3}</a>
				<form action="${button1adress}" method="post">
					<input type="submit" value="${button1}"
						style="background-color: Transparent; background-repeat: no-repeat; border: none; cursor: pointer; overflow: hidden; color:white; font-size: large; font-weight: bolder; font-size: large;margin-top: 25px;">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</div>
		</div>
	</header>
</body>
</html>