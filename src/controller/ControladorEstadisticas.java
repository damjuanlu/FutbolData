package controller;

import view.*;
import model.*;
import java.awt.event.*;

public class ControladorEstadisticas implements ActionListener {
	
	private VistaLogin miVistaLogin;
	private VistaPrincipal miVistaPrincipal;
	private VistaFichas miVistaFichas;
	private VistaAsistencias miVistaAsistencias;
	private VistaEstadisticas miVistaEstadisticas;
	private VistaGestionEquipos miVistaGestionEquipos;
	private VistaPartidosDisputados miVistaPartidosDisputados;

	//CONSTRUCTOR DEL CONTROLADOR
	public ControladorEstadisticas(	VistaLogin miVL, VistaPrincipal miVP, VistaFichas miVF, 
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
		miVistaEstadisticas.btnCerrarSesion.addActionListener(this);
		miVistaEstadisticas.mntmInicio.addActionListener(this);
		miVistaEstadisticas.mntmFichas.addActionListener(this);
		miVistaEstadisticas.mntmAsistencia.addActionListener(this);
		miVistaEstadisticas.mntmGestionEquipos.addActionListener(this);
		miVistaEstadisticas.mntmPartidosDisputados.addActionListener(this);
		miVistaEstadisticas.comboBoxSelecEquipo.addActionListener(this);
		miVistaEstadisticas.comboBoxSelecMes.addActionListener(this);
	}
	
	/*IMPLEMENTAR EL METODO ABSTRACTO QUE INDICA LAS ACCIONES A LLEVAR A CABO
	  CUANDO EL EVENTO SE PRODUCE Y ES ESCUCHADO.*/
	public void actionPerformed (ActionEvent e) {
		
		//SI EL EVENTO EST� PAUSADO POR EL BOTON QUE ESTAMOS INTERESADOS, REALIZAR ACCIONES
		if (e.getSource()==miVistaEstadisticas.btnCerrarSesion) {
			miVistaEstadisticas.setVisible(false);
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
		
		if (e.getSource()==miVistaEstadisticas.mntmInicio) {
			miVistaEstadisticas.setVisible(false);
			miVistaPrincipal.setVisible(true);
		}
		
		if (e.getSource()==miVistaEstadisticas.mntmFichas) {
			miVistaEstadisticas.setVisible(false);
			//miVistaFichas.setVisible(true);
		}
		
		if (e.getSource()==miVistaEstadisticas.mntmAsistencia) {
			miVistaEstadisticas.setVisible(false);
			miVistaAsistencias.setVisible(true);
		}
		
		if (e.getSource()==miVistaEstadisticas.mntmGestionEquipos) {
			miVistaEstadisticas.setVisible(false);
			miVistaGestionEquipos.setVisible(true);
		}
		
		if (e.getSource()==miVistaEstadisticas.mntmPartidosDisputados) {
			miVistaEstadisticas.setVisible(false);
			miVistaPartidosDisputados.setVisible(true);
		}
		
		if (e.getSource()==miVistaEstadisticas.comboBoxSelecEquipo) {
			String seleccion =  (String) miVistaEstadisticas.comboBoxSelecEquipo.getSelectedItem();
			miVistaEstadisticas.equipoSeleccionado.equals(seleccion);
		}
		
		if (e.getSource()==miVistaEstadisticas.comboBoxSelecMes) {
			String mesSeleccionado =  (String) miVistaEstadisticas.comboBoxSelecMes.getSelectedItem();
			miVistaEstadisticas.mesSeleccionado.equals(mesSeleccionado);
		}
	}
}