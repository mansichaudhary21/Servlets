package service;

import java.util.Map;

public class UserDAOImpl implements UserDAO {

	public static UserDAOImpl getUserDAOImplObject()
	{
		return new UserDAOImpl();
	}
	
	
	
	public boolean validateUser(String username, String password) {
		Map<String, String> con = UserDAOUtil.getDB();
		
		String savedPassoword = con.get(username);
		
		if(savedPassoword == null) return false;
		else if(savedPassoword.equals(password)) return true;
		else return false;
		
	}
}
