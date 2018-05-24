package main;

import view.*;
import controller.*;

public class main {
	
	
	public static void main  (String args[]) {
		
		VistaLogin login = new VistaLogin();
		loginController logincontroller= new loginController (login);
		login.setVisible(true);
	}

}