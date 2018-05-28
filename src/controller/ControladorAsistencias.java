package controller;

import view.*;
import model.*;
import java.awt.event.*;

public class ControladorAsistencias implements ActionListener {
	
	private VistaLogin miVistaLogin;
	private VistaPrincipal miVistaPrincipal;
	private VistaFichas miVistaFichas;
	private VistaAsistencias miVistaAsistencias;

	//CONSTRUCTOR DEL CONTROLADOR
	public ControladorAsistencias(VistaLogin miVL, VistaRegistro miVR, VistaPrincipal miVP, VistaFichas miVF, VistaAsistencias miVA) {
		
		//INICIALIZAR ATRIBUTOS
		miVistaLogin = miVL;
		miVistaPrincipal = miVP;
		miVistaFichas = miVF;
		miVistaAsistencias = miVA;
		
		//ASOCIAR EL COMPONENTE Swing AL LISTENER
		miVistaAsistencias.btnCerrarSesion.addActionListener(this);
		miVistaAsistencias.mntmInicio.addActionListener(this);
		miVistaAsistencias.mntmFichas.addActionListener(this);
		miVistaAsistencias.calendar.addPropertyChangeListener(null);
	}
	
	/*IMPLEMENTAR EL METODO ABSTRACTO QUE INDICA LAS ACCIONES A LLEVAR A CABO
	  CUANDO EL EVENTO SE PRODUCE Y ES ESCUCHADO.*/
	public void actionPerformed (ActionEvent e) {
		
		//SI EL EVENTO ESTÁ PAUSADO POR EL BOTON QUE ESTAMOS INTERESADOS, REALIZAR ACCIONES
		if (e.getSource()==miVistaAsistencias.btnCerrarSesion) {
			miVistaAsistencias.setVisible(false);
			miVistaLogin.setVisible(true);
			miVistaLogin.lblError.setVisible(false);
			miVistaLogin.btnIniciarSesion.setVisible(true);
			miVistaLogin.btnRegistrarse.setVisible(true);
			miVistaLogin.lblUsuario.setVisible(false);
			miVistaLogin.lblPassword.setVisible(false);
			miVistaLogin.txtUser.setVisible(false);
			miVistaLogin.txtPassword.setVisible(false);
			miVistaLogin.btnLogin.setVisible(false);
			miVistaLogin.btnVolver.setVisible(false);
			miVistaLogin.setTitle("SportClubData");
		}
		
		if (e.getSource()==miVistaAsistencias.mntmInicio) {
			miVistaAsistencias.setVisible(false);
			miVistaPrincipal.setVisible(true);
		}
		
		if (e.getSource()==miVistaAsistencias.mntmFichas) {
			miVistaPrincipal.setVisible(false);
			miVistaLogin.setVisible(true);
			miVistaLogin.lblError.setVisible(false);
			miVistaLogin.btnIniciarSesion.setVisible(true);
			miVistaLogin.btnRegistrarse.setVisible(true);
			miVistaLogin.lblUsuario.setVisible(false);
			miVistaLogin.lblPassword.setVisible(false);
			miVistaLogin.txtUser.setVisible(false);
			miVistaLogin.txtPassword.setVisible(false);
			miVistaLogin.btnLogin.setVisible(false);
			miVistaLogin.btnVolver.setVisible(false);
			miVistaLogin.setTitle("SportClubData");
		}
	}
}
