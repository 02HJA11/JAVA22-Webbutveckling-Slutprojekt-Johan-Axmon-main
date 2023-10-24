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
			<%
			weatherBean wBean = (weatherBean) request.getAttribute("wBean");
			out.print(" <h1> The weather in "  + wBean.getCityStr()+ "</h1>"); out.print("<p>  Wind: " + wBean.getWindStr().toLowerCase() + "</p>"); 
			%>
</body>
</html>