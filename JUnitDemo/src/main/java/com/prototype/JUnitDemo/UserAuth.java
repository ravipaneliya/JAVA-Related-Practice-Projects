package com.prototype.JUnitDemo;

public class UserAuth {
	
	public boolean authUser(String username, String password) {
		try {
			if(validateUser(username)) {
				if(validatePassword(password)) {
					return true;
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean validateUser(String username) {
		if(username != null && username.equalsIgnoreCase("test")) {
			return true;
		}
		return false;
	}
	
	public boolean validatePassword(String password) {
		if(password != null && password.equalsIgnoreCase("pwd")) {
			return true;
		}
		return false;
	}
}
