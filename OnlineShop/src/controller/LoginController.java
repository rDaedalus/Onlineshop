package controller;

import data.DataManager;
import view.HomeScreen;
import view.Login;

public class LoginController {


	public String login(String username, String password) {

		if (username.equals("Admin") && password.equals("admin")) {
			
			return "Login Successful";
		}
		return "Login Failed";
	}

	// public void disposeLogin() {

	// }
}
