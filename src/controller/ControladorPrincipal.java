package controller;

import view.*;

import javax.swing.UIManager;
import javax.swing.UIManager.*;

public class ControladorPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		}catch(Exception ex){
			System.out.println("Apariencia Look & Feel no cargada");
		}

		VistaLogin miVistaLogin = new VistaLogin();
		VistaRegistro miVistaRegistro = new VistaRegistro();
		VistaPrincipal miVistaPrincipal = new VistaPrincipal();
		
		Controlador miControlador = new Controlador(miVistaLogin, miVistaRegistro, miVistaPrincipal);
		
		miVistaLogin.setVisible(true);
	}

}
