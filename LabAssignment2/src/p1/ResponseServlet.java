package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseServlet
 */
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Map<String,String> hs = new HashMap<String,String>();
		hs.put("mansi123", "mansi");
		hs.put("manish123", "manish");
		hs.put("neelam123", "neelam");
		hs.put("rajveer9917", "rajveer");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Set< Map.Entry< String,String> > st = hs.entrySet();
		
		for (Map.Entry< String,String>  me:st) 
	       { 
	           System.out.print(me.getKey()+":"); 
	           System.out.println(me.getValue()); 
	       	  //out.print( me.getValue());
	       } 
		
		if(hs.containsKey(username) && hs.containsValue(password))
		{
			//out.print("<a href='Success.html'>");
			request.getRequestDispatcher("Success.html").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("Failure.html").forward(request, response);
			//out.print("<a href="");
		}
	}

}
