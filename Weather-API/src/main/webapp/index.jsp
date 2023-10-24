<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/styles.css">
<title>Check the weather</title>
</head>
<body>
			<form class="form" action="OWservlet" method="get">
				<input type="text" name="city" placeholder="City" required/><br /> <input type="text" name="country" placeholder="Country" required/> <br /> <input
					class="button" type="submit" value="Check weather" />
			</form>
		
</body>
</html>