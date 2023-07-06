package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String cookiesAccepted = request.getParameter("acceptcookies");
		
		// Create instance of Cookie class and request(get) the cookies
		Cookie[] cookies = request.getCookies();

		// Create String variable
		// loop through the cookies array
		String temp= "";
		for (int i = 0; i < cookies.length; i++) {
			// if cookie[i] name equals name "acceptcookies" 
			if (cookies[i].getName().equals("acceptcookies")) {
				// put the value from cookies[i] in the variable temp
				temp = cookies[i].getValue();
			}
		}
		// put cookiesAccepted as value in temp
		temp = cookiesAccepted;
		// Create cookie
		Cookie ck = new Cookie("acceptcookies", temp);
		response.addCookie(ck);
		request.setAttribute("cookie", " ");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
