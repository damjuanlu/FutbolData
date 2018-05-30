package controller;

import view.*;
import model.*;
import java.awt.event.*;

public class ControladorFichaPartidos implements ActionListener {
	
	private VistaLogin miVistaLogin;
	private VistaPrincipal miVistaPrincipal;
	private VistaFichas miVistaFichas;
	private VistaAsistencias miVistaAsistencias;
	private VistaEstadisticas miVistaEstadisticas;
	private VistaGestionEquipos miVistaGestionEquipos;
	private VistaPartidosDisputados miVistaPartidosDisputados;
	private VistaFichaPartidos miVistaFichaPartidos;

	//CONSTRUCTOR DEL CONTROLADOR
	public ControladorFichaPartidos(	VistaLogin miVL, VistaPrincipal miVP, VistaFichas miVF, 
										VistaAsistencias miVA, VistaEstadisticas miVE, VistaGestionEquipos miVGE, 
										VistaPartidosDisputados miVPD, VistaFichaPartidos miVFP) {
		
		//INICIALIZAR ATRIBUTOS
		miVistaLogin = miVL;
		miVistaPrincipal = miVP;
		miVistaFichas = miVF;
		miVistaAsistencias = miVA;
		miVistaEstadisticas = miVE;
		miVistaGestionEquipos = miVGE;
		miVistaPartidosDisputados = miVPD;
		miVistaFichaPartidos = miVFP;
		
		//ASOCIAR EL COMPONENTE Swing AL LISTENER
		miVistaFichaPartidos.btnCerrarSesion.addActionListener(this);
		miVistaFichaPartidos.mntmInicio.addActionListener(this);
		miVistaFichaPartidos.mntmFichas.addActionListener(this);
		miVistaFichaPartidos.mntmAsistencia.addActionListener(this);
		miVistaFichaPartidos.mntmEstadisticas.addActionListener(this);
		miVistaFichaPartidos.mntmGestionEquipos.addActionListener(this);
		miVistaFichaPartidos.mntmPartidosDisputados.addActionListener(this);
		miVistaFichaPartidos.comboBoxSelecEquipo.addActionListener(this);
	}
	
	/*IMPLEMENTAR EL METODO ABSTRACTO QUE INDICA LAS ACCIONES A LLEVAR A CABO
	  CUANDO EL EVENTO SE PRODUCE Y ES ESCUCHADO.*/
	public void actionPerformed (ActionEvent e) {
		
		//SI EL EVENTO ESTÁ PAUSADO POR EL BOTON QUE ESTAMOS INTERESADOS, REALIZAR ACCIONES
		if (e.getSource()==miVistaFichaPartidos.btnCerrarSesion) {
			miVistaFichaPartidos.setVisible(false);
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
		
		if (e.getSource()==miVistaFichaPartidos.mntmInicio) {
			miVistaFichaPartidos.setVisible(false);
			miVistaPrincipal.setVisible(true);
		}
		
		if (e.getSource()==miVistaFichaPartidos.mntmFichas) {
			miVistaFichaPartidos.setVisible(false);
			miVistaFichas.setVisible(true);
		}
		
		if (e.getSource()==miVistaFichaPartidos.mntmAsistencia) {
			miVistaFichaPartidos.setVisible(false);
			miVistaAsistencias.setVisible(true);
		}
		
		if (e.getSource()==miVistaFichaPartidos.mntmEstadisticas) {
			miVistaFichaPartidos.setVisible(false);
			miVistaEstadisticas.setVisible(true);
		}
		
		if (e.getSource()==miVistaFichaPartidos.mntmGestionEquipos) {
			miVistaFichaPartidos.setVisible(false);
			miVistaGestionEquipos.setVisible(true);
		}
		
		if (e.getSource()==miVistaFichaPartidos.mntmPartidosDisputados) {
			miVistaFichaPartidos.setVisible(false);
			miVistaPartidosDisputados.setVisible(true);
		}
		
		if (e.getSource()==miVistaFichaPartidos.comboBoxSelecEquipo) {
			String seleccion =  (String) miVistaFichaPartidos.comboBoxSelecEquipo.getSelectedItem();
			miVistaFichaPartidos.equipoSeleccionado.equals(seleccion);
		}
	}
}
