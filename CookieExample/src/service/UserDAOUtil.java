package service;

import java.util.HashMap;
import java.util.Map;

public class UserDAOUtil {

public static Map<String, String> oracleDB = new HashMap<String, String>();
	
	static
	{
		oracleDB.put("ramesh","ramesh");
		oracleDB.put("rakesh","rakesh");
		
	}
	
	public static Map<String, String> getDB()
	{
		return oracleDB;
	}
}
