package controller;

import view.*;
import model.*;
import java.awt.event.*;

public class ControladorAsistencias implements ActionListener {
	
	private VistaLogin miVistaLogin;
	private VistaPrincipal miVistaPrincipal;
	private VistaFichas miVistaFichas;
	private VistaAsistencias miVistaAsistencias;
	private VistaEstadisticas miVistaEstadisticas;
	private VistaGestionEquipos miVistaGestionEquipos;
	private VistaPartidosDisputados miVistaPartidosDisputados;

	//CONSTRUCTOR DEL CONTROLADOR
	public ControladorAsistencias(	VistaLogin miVL, VistaPrincipal miVP, VistaFichas miVF, 
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
		miVistaAsistencias.btnCerrarSesion.addActionListener(this);
		miVistaAsistencias.mntmInicio.addActionListener(this);
		miVistaAsistencias.mntmFichas.addActionListener(this);
		miVistaAsistencias.mntmEstadisticas.addActionListener(this);
		miVistaAsistencias.mntmGestionEquipos.addActionListener(this);
		miVistaAsistencias.mntmPartidosDisputados.addActionListener(this);
		miVistaAsistencias.calendar.addPropertyChangeListener(null);
		miVistaAsistencias.comboBoxSelecEquipo.addActionListener(this);
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
			miVistaAsistencias.setVisible(false);
			//miVistaFichas.setVisible(true);
		}
		
		if (e.getSource()==miVistaAsistencias.mntmEstadisticas) {
			miVistaAsistencias.setVisible(false);
			miVistaEstadisticas.setVisible(true);
		}
		
		if (e.getSource()==miVistaAsistencias.mntmGestionEquipos) {
			miVistaAsistencias.setVisible(false);
			miVistaGestionEquipos.setVisible(true);
		}
		
		if (e.getSource()==miVistaAsistencias.mntmPartidosDisputados) {
			miVistaAsistencias.setVisible(false);
			miVistaPartidosDisputados.setVisible(true);
		}
		
		if (e.getSource()==miVistaAsistencias.comboBoxSelecEquipo) {
			String seleccion =  (String) miVistaAsistencias.comboBoxSelecEquipo.getSelectedItem();
            miVistaAsistencias.equipoSeleccionado.equals(seleccion);
		}
	}
}
