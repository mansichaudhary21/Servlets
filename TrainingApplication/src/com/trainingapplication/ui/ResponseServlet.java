package com.trainingapplication.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainingapplication.dao.DatabaseOperationsDAOImpl;
import com.trainingapplication.model.TrainingModel;

/**
 * Servlet implementation class ResponseServlet
 */
public class ResponseServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id =Integer.parseInt(request.getParameter("id"));
		int seats =Integer.parseInt(request.getParameter("seats"));
		PrintWriter out = response.getWriter();
		if(seats==0) {
			out.print("<b>No Seats Are Available.</b>");
			out.print("</br></br><a href='index.html'>Enroll Again</a>");
		}
		else
		{
			try {
				DatabaseOperationsDAOImpl operation = new DatabaseOperationsDAOImpl();
				System.out.println("responseservlet");
				if(operation.enrollUpdate(id, seats)) {
					out.print("<b>Hi you have successfully enrolled for Spring Training.</b>");
					out.print("</br></br><a href='Index.html'>Enroll Again</a>");
				}
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	}


}
