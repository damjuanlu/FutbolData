package controller;

import view.*;
import model.*;
import java.awt.event.*;

public class ControladorPartidosDisputados implements ActionListener {
	
	private VistaLogin miVistaLogin;
	private VistaPrincipal miVistaPrincipal;
	private VistaFichas miVistaFichas;
	private VistaAsistencias miVistaAsistencias;
	private VistaEstadisticas miVistaEstadisticas;
	private VistaGestionEquipos miVistaGestionEquipos;
	private VistaPartidosDisputados miVistaPartidosDisputados;

	//CONSTRUCTOR DEL CONTROLADOR
	public ControladorPartidosDisputados(	VistaLogin miVL, VistaPrincipal miVP, VistaFichas miVF, 
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
		miVistaPartidosDisputados.btnCerrarSesion.addActionListener(this);
		miVistaPartidosDisputados.mntmInicio.addActionListener(this);
		miVistaPartidosDisputados.mntmFichas.addActionListener(this);
		miVistaPartidosDisputados.mntmAsistencia.addActionListener(this);
		miVistaPartidosDisputados.mntmEstadisticas.addActionListener(this);
		miVistaPartidosDisputados.mntmGestionEquipos.addActionListener(this);
		miVistaPartidosDisputados.mntmPartidosDisputados.addActionListener(this);
		miVistaPartidosDisputados.comboBoxSelecEquipo.addActionListener(this);
	}
	
	/*IMPLEMENTAR EL METODO ABSTRACTO QUE INDICA LAS ACCIONES A LLEVAR A CABO
	  CUANDO EL EVENTO SE PRODUCE Y ES ESCUCHADO.*/
	public void actionPerformed (ActionEvent e) {
		
		//SI EL EVENTO ESTÁ PAUSADO POR EL BOTON QUE ESTAMOS INTERESADOS, REALIZAR ACCIONES
		if (e.getSource()==miVistaPartidosDisputados.btnCerrarSesion) {
			miVistaPartidosDisputados.setVisible(false);
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
		
		if (e.getSource()==miVistaPartidosDisputados.mntmInicio) {
			miVistaPartidosDisputados.setVisible(false);
			miVistaPrincipal.setVisible(true);
		}
		
		if (e.getSource()==miVistaPartidosDisputados.mntmFichas) {
			miVistaPartidosDisputados.setVisible(false);
			miVistaFichas.setVisible(true);
		}
		
		if (e.getSource()==miVistaPartidosDisputados.mntmAsistencia) {
			miVistaPartidosDisputados.setVisible(false);
			miVistaAsistencias.setVisible(true);
		}
		
		if (e.getSource()==miVistaPartidosDisputados.mntmEstadisticas) {
			miVistaPartidosDisputados.setVisible(false);
			miVistaEstadisticas.setVisible(true);
		}
		
		if (e.getSource()==miVistaPartidosDisputados.mntmGestionEquipos) {
			miVistaPartidosDisputados.setVisible(false);
			miVistaGestionEquipos.setVisible(true);
		}
		
		if (e.getSource()==miVistaPartidosDisputados.comboBoxSelecEquipo) {
			String seleccion =  (String) miVistaPartidosDisputados.comboBoxSelecEquipo.getSelectedItem();
			miVistaPartidosDisputados.equipoSeleccionado.equals(seleccion);
		}
	}
}
