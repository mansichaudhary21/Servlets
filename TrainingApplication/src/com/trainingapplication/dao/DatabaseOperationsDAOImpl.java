package com.trainingapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import java.sql.SQLException;

import com.trainingapplication.model.TrainingModel;

public class DatabaseOperationsDAOImpl implements DatabaseOperationsDAO {

	Connection con;
	PreparedStatement ps;
	
	public DatabaseOperationsDAOImpl() throws ClassNotFoundException, SQLException{
		
		con = DatabaseConnectionFactory.getConnection();
	}
	
	
	
	
	public boolean enrollUpdate(int id, int seats) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("update Training set AvailableSeats=AvailableSeats-1 where trainingId="+id);
		con.close();
		return true;
	}

	public List<TrainingModel> getInstructors() throws Exception {
		// TODO Auto-generated method stub
		
		List<TrainingModel> list = new ArrayList<TrainingModel>();
		String query = "Select * from TRAINING";
		ps = con.prepareStatement(query);
		
		ResultSet rs =ps.executeQuery();
		
		while(rs.next())
		{
			int id = rs.getInt(1);
			String name = rs.getString(2);
			int seats = rs.getInt(3);
			TrainingModel t=new TrainingModel();
			t.setId(id);
			t.setName(name);
			t.setSeats(seats);
			
			list.add(t);
		}
		con.close();
		
		return list;
	}

	
	
}
