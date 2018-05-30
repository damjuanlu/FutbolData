package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.*;

public class ControladorFichas implements ActionListener {
	
	private VistaLogin miVistaLogin;
	private VistaPrincipal miVistaPrincipal;
	private VistaFichas miVistaFichas;
	private VistaAsistencias miVistaAsistencias;
	private VistaEstadisticas miVistaEstadisticas;
	private VistaGestionEquipos miVistaGestionEquipos;
	private VistaPartidosDisputados miVistaPartidosDisputados;

	//CONSTRUCTOR DEL CONTROLADOR
	public ControladorFichas(	VistaLogin miVL, VistaPrincipal miVP, VistaFichas miVF, 
								VistaAsistencias miVA, VistaEstadisticas miVE, VistaGestionEquipos miVGE, 
								VistaPartidosDisputados miVPD) {
		
		//INICIALIZAR ATRIBUTOS
		miVistaLogin = miVL;
		miVistaPrincipal = miVP;
		miVistaFichas = miVF;
		miVistaAsistencias = miVA;
		miVistaEstadisticas = miVE;
		miVistaGestionEquipos = miVGE;
		miVistaPartidosDisputados = miVPD;
		
		//ASOCIAR EL COMPONENTE Swing AL LISTENER
		miVistaFichas.btnCerrarSesion.addActionListener(this);
		miVistaFichas.mntmInicio.addActionListener(this);
		miVistaFichas.mntmFichas.addActionListener(this);
		miVistaFichas.mntmAsistencia.addActionListener(this);
		miVistaFichas.mntmEstadisticas.addActionListener(this);
		miVistaFichas.mntmGestionEquipos.addActionListener(this);
		miVistaFichas.mntmPartidosDisputados.addActionListener(this);
		miVistaFichas.comboBoxSelecEquipo.addActionListener(this);
	}
	
	/*IMPLEMENTAR EL METODO ABSTRACTO QUE INDICA LAS ACCIONES A LLEVAR A CABO
	  CUANDO EL EVENTO SE PRODUCE Y ES ESCUCHADO.*/
	public void actionPerformed (ActionEvent e) {
		
		//SI EL EVENTO ESTÁ PAUSADO POR EL BOTON QUE ESTAMOS INTERESADOS, REALIZAR ACCIONES
		if (e.getSource()==miVistaFichas.btnCerrarSesion) {
			miVistaFichas.setVisible(false);
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
		
		if (e.getSource()==miVistaFichas.mntmInicio) {
			miVistaFichas.setVisible(false);
			miVistaPrincipal.setVisible(true);
		}
		
		if (e.getSource()==miVistaFichas.mntmAsistencia) {
			miVistaFichas.setVisible(false);
			miVistaAsistencias.setVisible(true);
		}
		
		if (e.getSource()==miVistaFichas.mntmEstadisticas) {
			miVistaFichas.setVisible(false);
			miVistaEstadisticas.setVisible(true);
		}
		
		if (e.getSource()==miVistaFichas.mntmGestionEquipos) {
			miVistaFichas.setVisible(false);
			miVistaGestionEquipos.setVisible(true);
		}
		
		if (e.getSource()==miVistaFichas.mntmPartidosDisputados) {
			miVistaFichas.setVisible(false);
			miVistaPartidosDisputados.setVisible(true);
		}
	}
}
