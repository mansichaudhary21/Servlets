package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserDAOImpl;

/**
 * Servlet implementation class Servlet
 */
public class Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Cookie arr[] = request.getCookies();
		String cookieValue = null;
		if (arr != null) 
		{
			for (Cookie cookie : arr) {
				String cookieName = cookie.getName();
				if (cookieName.equals("cookieUsername")) {
					cookieValue = cookie.getValue();
					break;
				}
			}
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//HTML Form
		
		out.print("<HTML><BODY>");
		out.print("<form method='post' action='login'>");
		if (cookieValue == null)
			out.print("username <input type='text' name='name'><br/>");
		if (cookieValue != null)
			out.print("username <input type='text' name='name' value='" + cookieValue + "'><br/>");
		out.print("Password:<input type='password' name='password'><br>");
		out.print("<input type='checkbox' value='remember' name='remember'>Remember Me<br>");
		out.print("<input type='submit' value='Submit'");
		out.print("</form>");
		out.print("</HTML></BODY>");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String rememberme = request.getParameter("remember");
		System.out.println("Inside Servlet1-->Cookie Name:" + name);
		
		UserDAOImpl dao = UserDAOImpl.getUserDAOImplObject();
		boolean isValidUser = dao.validateUser(name, password);

		if (isValidUser) {
			System.out.println(" ---->>> User Validated ");
		//we check, if "RememberMe" parameter is not null,
		  //then set above "name" value accordingly
		  if(request.getParameter("remember") != null)
		  {  
			  Cookie c = new Cookie("cookieUserName", name);
			  System.out.println("Inside If-->Cookie Name:" + name);
			  c.setMaxAge(1000*60);
			  response.addCookie(c);
			// if valid move to Welcome page
			  request.setAttribute("name", name);
			  request.getRequestDispatcher("ViewServlet").forward(request, response);
		} 
		  else {
			  System.out.println("Login again");
				response.sendRedirect("login");
			}

			 
		  }
		}
		 
	}


