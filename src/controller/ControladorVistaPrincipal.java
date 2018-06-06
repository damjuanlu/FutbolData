package controller;

import view.*;
import model.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

import database.ConexionBD;

public class ControladorVistaPrincipal implements ActionListener {
	
	private VistaLogin miVistaLogin;
	private VistaRegistro miVistaRegistro;
	private VistaPrincipal miVistaPrincipal;
	private VistaFichas miVistaFichas;
	private VistaAsistencias miVistaAsistencias;
	private VistaEstadisticas miVistaEstadisticas;
	private VistaGestionEquipos miVistaGestionEquipos;
	private VistaPartidosDisputados miVistaPartidosDisputados;
	private VistaConvocatorias miVistaConvocatorias;
	
	Mensajes_AD mensajeAD = new Mensajes_AD();

	//CONSTRUCTOR DEL CONTROLADOR
	public ControladorVistaPrincipal(	VistaLogin miVL, VistaRegistro miVR, VistaPrincipal miVP, 
										VistaFichas miVF, VistaAsistencias miVA, VistaEstadisticas miVE, 
										VistaGestionEquipos miVGE, VistaPartidosDisputados miVPD, VistaConvocatorias miVCO) {
		
		//INICIALIZAR ATRIBUTOS
		miVistaLogin = miVL;
		miVistaRegistro = miVR;
		miVistaPrincipal = miVP;
		miVistaFichas = miVF;
		miVistaAsistencias = miVA;
		miVistaEstadisticas = miVE;
		miVistaGestionEquipos = miVGE;
		miVistaPartidosDisputados = miVPD;
		miVistaConvocatorias = miVCO;
		
		//ASOCIAR EL COMPONENTE Swing AL LISTENER
		miVistaLogin.btnLogin.addActionListener(this);
		miVistaLogin.btnRegistrarse.addActionListener(this);
		miVistaLogin.btnVolver.addActionListener(this);
		miVistaRegistro.btnGuardaRegistro.addActionListener(this);
		miVistaRegistro.btnVolver.addActionListener(this);
		miVistaLogin.btnIniciarSesion.addActionListener(this);
		miVistaPrincipal.btnCerrarSesion.addActionListener(this);
		miVistaPrincipal.mntmFichas.addActionListener(this);
		miVistaPrincipal.mntmEstadisticas.addActionListener(this);
		miVistaPrincipal.mntmGestionEquipos.addActionListener(this);
		miVistaPrincipal.mntmConvocatorias.addActionListener(this);
	}
	
	/*IMPLEMENTAR EL METODO ABSTRACTO QUE INDICA LAS ACCIONES A LLEVAR A CABO
	  CUANDO EL EVENTO SE PRODUCE Y ES ESCUCHADO.*/
	
	public void actionPerformed (ActionEvent e) {
		
		//SI EL EVENTO ESTÁ PAUSADO POR EL BOTON QUE ESTAMOS INTERESADOS, REALIZAR ACCIONES
		if (e.getSource()==miVistaLogin.btnRegistrarse) {
			miVistaLogin.setVisible(false);
			miVistaRegistro.setVisible(true);
		}
		
		if (e.getSource()==miVistaRegistro.btnGuardaRegistro) {
			//COMPROBAR SI YA EXITE USUARIO Y GUARDAR DATOS DE USUARIO EN LA BASE DE DATOS
			miVistaRegistro.setVisible(false);
			miVistaLogin.setVisible(true);
		}
		
		if (e.getSource()==miVistaRegistro.btnVolver) {
			miVistaRegistro.setVisible(false);
			miVistaLogin.setVisible(true);
			miVistaLogin.btnVolver.setVisible(false);
		}
		
		if (e.getSource()==miVistaLogin.btnIniciarSesion) {
			miVistaLogin.btnIniciarSesion.setVisible(false);
			miVistaLogin.btnRegistrarse.setVisible(false);
			miVistaLogin.lblUsuario.setVisible(true);
			miVistaLogin.lblPassword.setVisible(true);
			miVistaLogin.txtUser.setVisible(true);
			miVistaLogin.txtPassword.setVisible(true);
			miVistaLogin.btnLogin.setVisible(true);
			miVistaLogin.setTitle("SportClubData - INICIAR SESI\u00D3N");
			miVistaLogin.btnVolver.setVisible(true);
		}
		
		if (e.getSource()==miVistaLogin.btnLogin) {
			String User = miVistaLogin.txtUser.getText();
			String Pass = new String(miVistaLogin.txtPassword.getPassword());
			
			ConexionBD conexion = new ConexionBD (User, Pass);
			if (conexion.conexion(User, Pass) == true) {
				miVistaLogin.setVisible(false);
				miVistaPrincipal.setVisible(true);
				miVistaPrincipal.lblUser.setText("Bienvenido " + User);
			}
		}
		
		if (e.getSource()==miVistaLogin.btnVolver) {
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
		
		if (e.getSource()==miVistaPrincipal.btnCerrarSesion) {
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
		
		if (e.getSource()==miVistaPrincipal.mntmFichas) {
			miVistaPrincipal.setVisible(false);
			miVistaFichas.setVisible(true);
		}
		
		if (e.getSource()==miVistaPrincipal.mntmEstadisticas) {
			miVistaPrincipal.setVisible(false);
			miVistaEstadisticas.setVisible(true);
		}
		
		if (e.getSource()==miVistaPrincipal.mntmGestionEquipos) {
			miVistaPrincipal.setVisible(false);
			miVistaGestionEquipos.setVisible(true);
		}
		
		if (e.getSource()==miVistaPrincipal.mntmConvocatorias) {
			miVistaPrincipal.setVisible(false);
			miVistaConvocatorias.setVisible(true);
		}

		if (e.getSource()==miVistaPrincipal.btnSelectorEscudo) {
				
		}
	}
}
