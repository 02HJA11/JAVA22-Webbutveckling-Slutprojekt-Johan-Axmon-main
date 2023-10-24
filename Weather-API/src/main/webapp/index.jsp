<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/styles.css">
<title>OpenWeather</title>
</head>
<body>

	<div class="bg">

		<nav class="nav">

			<a class="nav-link" href="./index.jsp"> Hem </a>
		</nav>


		<div class="content">
			<h1>Check the weather</h1>

			<form class="form" action="OWservlet" method="get">
				<input type="text" name="city" placeholder="City" required/><br /> <input
					type="text" name="country" placeholder="Country" required/> <br /> <input
					class="button" type="submit" value="Check weather" />
			</form>
		</div>
		<%
		// Create instance of Cookie class and request(get) the cookies
Cookie[] cookies = request.getCookies();
		
		String acceptCookie = null;
		
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("acceptcookies")) {
				acceptCookie = cookies[i].getValue();
			}
		}
		
		if(acceptCookie == null || request.getAttribute("cookie") == null) { %>
		
		<jsp:include page="Cookie.jsp"></jsp:include>
		
		<%
		}
		%>		
		<footer>
			<p class="contact">
				<strong>E-mail:</strong>
			</p>
			<p class="contact">hansjohanaxmon@gmail.com</p>
		</footer>

	</div>
</body>
</html>