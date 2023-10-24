<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.weatherBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/styles.css">
<title>the weather</title>
</head>
<body>
		<nav class="nav">
			<a class="nav-link" href="./index.jsp"> Hem </a>
		</nav>
		<div class="content">
			<%
			weatherBean wBean = (weatherBean) request.getAttribute("wBean");
			out.print(" <h1> The weather in "  + wBean.getCityStr()+ "</h1>");
			out.print("<p> Clouds: " + wBean.getCloudsStr() + "</p>");
			out.print("<p>  Wind: " + wBean.getWindStr().toLowerCase() + "</p>");		
			out.print("<p> Sunrise: " + wBean.getSunRiseStr()+ "</p>");
			out.print("<p> Sunset: "+ wBean.getSunSetStr() + "</p>");
			%>
			<br>
			<br>
		</div>

		<footer>
			<p class="contact">E-mail:</p>
			<p class="contact">hansjohanaxmon@gmail.com</p>
		</footer>


</body>
</html>