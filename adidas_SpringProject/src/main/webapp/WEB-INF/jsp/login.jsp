<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
body{
background-color: black;
height:500px;
margin-bottom:20px;
}
.login{
width:400px;
margin-left:35%;
margin-bottom:30px;
margin-top: 30px;
}

.login .fields{
padding: 30px;
background-color: white;
border-radius: 20px;
box-shadow: 8px 8px 20px grey;

}

.login .fields .cells td{
padding: 15px;
font-weight: bold;
font-family:sans-serif;
}

.login .fields .submit input{
background-color: black;
  border: none;
  color: white;
  padding: 10px;
  text-align: center;
  font-size: 16px;
  font-weight:bold;
  border-radius: 10px;
  
}
</style>

</head>
<body>
	<div class="login" >
		<div class=" fields">
			<form:form method="post" action="login" modelAttribute="login">
				<table>
					<tr class="cells">
						<td>Username :</td>
						<td><form:input path="username" /></td>
					</tr>
					<tr class="cells">
						<td>Password :</td>
						<td><form:password  path="password" /></td>
					</tr>
				
					<tr class="submit">
						<td></td>
						<td><input type="submit" value="Login"/></td>
					</tr>
					<tr>
						<td style="font-style: italic; color: red; font-size: small; ">${message}</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>