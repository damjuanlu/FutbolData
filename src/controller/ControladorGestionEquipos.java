package controller;

import view.*;
import model.*;
import java.awt.event.*;

public class ControladorGestionEquipos implements ActionListener {
	
	private VistaLogin miVistaLogin;
	private VistaPrincipal miVistaPrincipal;
	private VistaFichas miVistaFichas;
	private VistaAsistencias miVistaAsistencias;
	private VistaEstadisticas miVistaEstadisticas;
	private VistaGestionEquipos miVistaGestionEquipos;
	private VistaPartidosDisputados miVistaPartidosDisputados;

	//CONSTRUCTOR DEL CONTROLADOR
	public ControladorGestionEquipos(	VistaLogin miVL, VistaPrincipal miVP, VistaFichas miVF, 
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
		miVistaGestionEquipos.btnCerrarSesion.addActionListener(this);
		miVistaGestionEquipos.mntmInicio.addActionListener(this);
		miVistaGestionEquipos.mntmFichas.addActionListener(this);
		miVistaGestionEquipos.mntmAsistencia.addActionListener(this);
		miVistaGestionEquipos.mntmEstadisticas.addActionListener(this);
		miVistaGestionEquipos.mntmGestionEquipos.addActionListener(this);
		miVistaGestionEquipos.mntmPartidosDisputados.addActionListener(this);
		miVistaGestionEquipos.comboBoxSelecEquipo.addActionListener(this);
	}
	
	/*IMPLEMENTAR EL METODO ABSTRACTO QUE INDICA LAS ACCIONES A LLEVAR A CABO
	  CUANDO EL EVENTO SE PRODUCE Y ES ESCUCHADO.*/
	public void actionPerformed (ActionEvent e) {
		
		//SI EL EVENTO ESTÁ PAUSADO POR EL BOTON QUE ESTAMOS INTERESADOS, REALIZAR ACCIONES
		if (e.getSource()==miVistaGestionEquipos.btnCerrarSesion) {
			miVistaGestionEquipos.setVisible(false);
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
		
		if (e.getSource()==miVistaGestionEquipos.mntmInicio) {
			miVistaGestionEquipos.setVisible(false);
			miVistaPrincipal.setVisible(true);
		}
		
		if (e.getSource()==miVistaGestionEquipos.mntmFichas) {
			miVistaGestionEquipos.setVisible(false);
			miVistaFichas.setVisible(true);
		}
		
		if (e.getSource()==miVistaGestionEquipos.mntmAsistencia) {
			miVistaGestionEquipos.setVisible(false);
			miVistaAsistencias.setVisible(true);
		}
		
		if (e.getSource()==miVistaGestionEquipos.mntmEstadisticas) {
			miVistaGestionEquipos.setVisible(false);
			miVistaEstadisticas.setVisible(true);
		}
		
		if (e.getSource()==miVistaGestionEquipos.mntmPartidosDisputados) {
			miVistaGestionEquipos.setVisible(false);
			miVistaPartidosDisputados.setVisible(true);
		}
		
		if (e.getSource()==miVistaGestionEquipos.comboBoxSelecEquipo) {
			String seleccion =  (String) miVistaGestionEquipos.comboBoxSelecEquipo.getSelectedItem();
			miVistaGestionEquipos.equipoSeleccionado.equals(seleccion);
		}
	}
}
