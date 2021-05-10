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
.signup{
width:400px;
margin-left:35%;
margin-bottom:30px;
margin-top: 30px;
}

.signup .fields{
padding: 30px;
background-color: white;
border-radius: 20px;
box-shadow: 8px 8px 20px grey;

}

.signup .fields .cells td{
padding: 15px;
font-weight: bold;
font-family:sans-serif;
}

.signup .fields .submit input{
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
<script type="text/javascript">

function validateEmail(email){
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

    if (reg.test(email.value) == false) 
    {
        alert('Invalid Email Address');
        return false;
    }

    return true;

}


function validatePhoneNumber(phno){
    var reg = /^\d{10}$/;

    if (reg.test(phno.value) == false) 
    {
        alert('Invalid Phone Number it should be only 10 digits');
        return false;
    }

    return true;

}


function validatePassword(password){
    var reg = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).*$/;

    if (reg.test(password.value) == false) 
    {
        alert('Invalid Password');
        return false;
    }

    return true;

}

</script>
</head>
<body>
	<div class="signup" >
		<div class=" fields">
			<form:form method="post" action="signup" modelAttribute="user">
				<table>
					<tr class="cells">
						<td>Username :</td>
						<td><form:input path="username" /></td>
					</tr>
					<tr class="cells">
						<td>Password :</td>
						<td><form:password  path="password" onblur="validatePassword(this);" /></td>
					</tr>
					<tr class="cells">
						<td>Email :</td>
						<td><form:input path="email" onblur="validateEmail(this);"/></td>
					</tr>
					<tr class="cells">
						<td>PhoneNo :</td>
						<td><form:input path="phone" onblur="validatePhoneNumber(this);" /></td>
					</tr>
					<tr class="submit">
						<td></td>
						<td><input type="submit" value="Sign-Up"/></td>
					</tr>
					<tr>
					<td style="font-style: italic; color: red; font-size: small;">${message}</td>
					 </tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>