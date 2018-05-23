package main;

import view.*;
import controller.*;

public class main {
	
	
	public static void main  (String args[]) {
		
		login login = new login();
		loginController logincontroller= new loginController (login);
		login.setVisible(true);
	}

}