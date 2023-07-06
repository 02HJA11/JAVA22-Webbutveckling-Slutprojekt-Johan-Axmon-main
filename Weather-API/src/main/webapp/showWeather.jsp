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

	<div class="bg">

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


			<%
			out.print("<h3> Your recent searches: </h3>");
			// loop through the size of the arraylist and print out index
			for (int i = 0; i < wBean.cookieSplit().size(); i++) {
				out.print("<p> " + wBean.cookieSplit().get(i) + "</p> <br>");
			}
		
			
			%>
		</div>

		<footer>
			<p class="contact">
				<strong>E-mail:</strong>
			</p>
			<p class="contact">hansjohanaxmon@gmail.com</p>
		</footer>



	</div>


</body>
</html>