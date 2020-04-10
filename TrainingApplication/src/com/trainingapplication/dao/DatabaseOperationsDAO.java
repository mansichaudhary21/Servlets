package com.trainingapplication.dao;

import java.util.List;

import com.trainingapplication.model.TrainingModel;

public interface DatabaseOperationsDAO {
	
	public boolean enrollUpdate(int id,int seats) throws Exception;
	public List<TrainingModel> getInstructors() throws Exception;

}
