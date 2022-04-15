package controller;

public class LoginController {


	public String login(String username, String password) {

		if (username.equals("Admin") && password.equals("admin")) {
			
			return "Login Successful";
		}
		return "Login Failed";
	}

	
}
