package controller;

import view.*;

public class ControladorPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VistaLogin miVistaLogin = new VistaLogin();
		VistaPrincipal miVistaPrincipal = new VistaPrincipal();
		
		Controlador miControlador = new Controlador(miVistaLogin,miVistaPrincipal);
		
		miVistaLogin.setVisible(true);
	}

}
