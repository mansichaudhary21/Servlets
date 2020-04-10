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
 * Servlet implementation class ShowTrainingServlet
 */
public class ShowTrainingServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		List<TrainingModel> list;
		DatabaseOperationsDAOImpl operation;
		try {
			operation = new DatabaseOperationsDAOImpl();
			list=operation.getInstructors();
			out.print("<table>");
			out.print("<tr>");
			out.print("<th> Training Id </th>"); 
			out.print("<th> Training Name </th>"); 
			out.print("<th> Avalaible Seats </th>"); 
			out.print("</tr>");
			for (TrainingModel t : list) {
				out.print("<tr>");
				out.print("<td>"+t.getId()+"</td>");
				out.print("<td>"+t.getName()+"</td>");
				out.print("<td>"+t.getSeats()+"</td>");
				System.out.println("view");
				out.print("<td><a href='ResponseServlet?id="+t.getId()+"&seats="+t.getSeats()+"'>Enroll</a></td>");
				out.print("</tr>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

	}

	
}
