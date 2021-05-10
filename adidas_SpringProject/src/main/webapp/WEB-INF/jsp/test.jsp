<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.body table{
width: 100%;
}
.image{
}
.image img{
width:400px;
padding-left: 30px;
padding-top: 30px;
}

.data{
width: 60%;
}
.name{
font-family:sans-serif;
margin-bottom: 50px;
}
.price{
font-family: sans-serif;
}
.stockunits{
font-family:sans-serif;
}
.stockunits a{
text-decoration: none;
color: red;
}
.size a{
text-decoration: none;
color:black;
background-color:lightgrey;
margin-top:30px;
margin-right:20px;
padding: 10px;
border-radius: 60px;
}
.size a:hover {
background-color:grey;
}
.size a::selection{
background-color:black;
color:white;
}
.cartbutton{
text-decoration:none;
padding: 10px;
background-image: linear-gradient(to right, #005266 , #00ccff);
color: white;
font-family: sans-serif;
font-weight: bold;
}
</style>
</head>
<body>

	<div class="body">
	<table>
	<tr> 
	<td class="image"><img alt="" src="https://fearlessrevolution.com/download/file.php?avatar=24979_1544619789.png"> </td>
	<td class="data">
	<h1 class="name">Addidas nem shoe 2021 collection</h1>
	<h1 class="price">&#x20B9;10000 </h1>
	<p>(Inclusive of all taxes) </p>
	<p class="stockunits">No.of units left:<a>25</a> </p>
	<br>
	<h3>Select Size</h3>
	<p class="size"> <a>40</a><a>42</a><a>44</a><a>45</a></p>
	<br><br>
	<a class="cartbutton">ADD TO CART </a>

	</td>
	</tr>
	</table>
	

	</div>

</body>
</html>