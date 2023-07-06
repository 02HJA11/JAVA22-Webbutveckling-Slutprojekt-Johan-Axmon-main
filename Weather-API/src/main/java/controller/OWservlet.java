package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GettheWeather;
import model.weatherBean;

@WebServlet("/OWservlet")
public class OWservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cityStr = request.getParameter("city");
		String countryStr = request.getParameter("country");

		weatherBean wBean = new weatherBean(cityStr, countryStr);

		GettheWeather.getWeather(wBean);

		request.setAttribute("wBean", wBean);

		// Create instance of Cookie class and request(get) the cookies
		Cookie[] cookies = request.getCookies();
		
		String acceptCookie= "";
		
		for (int i = 0; i < cookies.length; i++) {
			//
			if (cookies[i].getName().equals("acceptcookies")) {
				acceptCookie = cookies[i].getValue();
			};
	
		}

if(acceptCookie.equals("Accept")) {
		// Create String variable
		String cookieValue= "";
		
		
		// loop through the cookies array
		for (int i = 0; i < cookies.length; i++) {
			// if the name of cookie[i] equals "city"
			if (cookies[i].getName().equals("city")) {
				// put the value from cookies[i] in the variable cookieValue
				cookieValue = cookies[i].getValue();
			};
		}
		
		// Set cookies with value cookieValue
		wBean.setCookieStr(cookieValue);
		
		// cookieValue new value = old value and then add new value
		cookieValue = cookieValue + ":" + cityStr +  "_"  + countryStr;

		// Create cookie with parameters name "city" and value cookieValue
		Cookie ck = new Cookie("city", cookieValue);
		ck.setMaxAge(60);
		response.addCookie(ck);
	
}
else {
	wBean.setCookieStr(" ");
}
	// Send forward to showWeather page
			RequestDispatcher rd = request.getRequestDispatcher("showWeather.jsp");
			rd.forward(request, response);
	}
}