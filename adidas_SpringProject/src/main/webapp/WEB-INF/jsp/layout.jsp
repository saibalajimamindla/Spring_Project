<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><tiles:insertAttribute name="tilte" ignore="true"></tiles:insertAttribute></title>
 <link rel = "icon" href = 
"https://upload.wikimedia.org/wikipedia/commons/2/20/Adidas_Logo.svg" 
        type = "image/x-icon">
</head>
<body>
<div><tiles:insertAttribute name="header" ignore="true"></tiles:insertAttribute></div>
<div><tiles:insertAttribute name="body" ignore="true"></tiles:insertAttribute></div>
<div><tiles:insertAttribute name="footer" ignore="true"></tiles:insertAttribute></div>
</body>
</html>