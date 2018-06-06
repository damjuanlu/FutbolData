package controller;

import view.*;
import model.*;
import java.awt.event.*;

import database.ConexionBD;
import model.Jugadores_AD;
import model.Jugadores_TD;
import view.*;

public class ControladorConvocatorias implements ActionListener {
	
	private VistaLogin miVistaLogin;
	private VistaPrincipal miVistaPrincipal;
	private VistaFichas miVistaFichas;
	private VistaAsistencias miVistaAsistencias;
	private VistaEstadisticas miVistaEstadisticas;
	private VistaGestionEquipos miVistaGestionEquipos;
	private VistaPartidosDisputados miVistaPartidosDisputados;
	private VistaConvocatorias miVistaConvocatorias;
	
	Jugadores_AD jugadorAD = new Jugadores_AD();
	Jugadores_TD jugador;

	//CONSTRUCTOR DEL CONTROLADOR
	public ControladorConvocatorias(	VistaLogin miVL, VistaPrincipal miVP, VistaFichas miVF, 
										VistaAsistencias miVA, VistaEstadisticas miVE, VistaGestionEquipos miVGE, 
										VistaPartidosDisputados miVPD, VistaConvocatorias miVCO) {
		
		//INICIALIZAR ATRIBUTOS
		miVistaLogin = miVL;
		miVistaPrincipal = miVP;
		miVistaFichas = miVF;
		miVistaAsistencias = miVA;
		miVistaEstadisticas = miVE;
		miVistaGestionEquipos = miVGE;
		miVistaPartidosDisputados = miVPD;
		miVistaConvocatorias = miVCO;
		
		//ASOCIAR EL COMPONENTE Swing AL LISTENER
		miVistaConvocatorias.btnCerrarSesion.addActionListener(this);
		miVistaConvocatorias.mntmInicio.addActionListener(this);
		miVistaConvocatorias.mntmFichas.addActionListener(this);
		miVistaConvocatorias.mntmAsistencia.addActionListener(this);
		miVistaConvocatorias.mntmEstadisticas.addActionListener(this);
		miVistaConvocatorias.mntmGestionEquipos.addActionListener(this);
		miVistaConvocatorias.mntmPartidosDisputados.addActionListener(this);
		miVistaConvocatorias.comboBoxSelecEquipo.addActionListener(this);
		miVistaConvocatorias.btnBuscar.addActionListener(this);
	}
	
	/*IMPLEMENTAR EL METODO ABSTRACTO QUE INDICA LAS ACCIONES A LLEVAR A CABO
	  CUANDO EL EVENTO SE PRODUCE Y ES ESCUCHADO.*/
	public void actionPerformed (ActionEvent e) {
		
		//SI EL EVENTO ESTÁ PAUSADO POR EL BOTON QUE ESTAMOS INTERESADOS, REALIZAR ACCIONES
		if (e.getSource()==miVistaConvocatorias.btnCerrarSesion) {
			miVistaConvocatorias.setVisible(false);
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
		
		if (e.getSource()==miVistaConvocatorias.mntmInicio) {
			miVistaConvocatorias.setVisible(false);
			miVistaPrincipal.setVisible(true);
		}
		
		if (e.getSource()==miVistaConvocatorias.mntmFichas) {
			miVistaConvocatorias.setVisible(false);
			miVistaFichas.setVisible(true);
		}

		if (e.getSource()==miVistaConvocatorias.mntmAsistencia) {
			miVistaConvocatorias.setVisible(false);
			miVistaAsistencias.setVisible(true);
		}
		
		if (e.getSource()==miVistaConvocatorias.mntmEstadisticas) {
			miVistaConvocatorias.setVisible(false);
			miVistaEstadisticas.setVisible(true);
		}
		
		if (e.getSource()==miVistaConvocatorias.mntmGestionEquipos) {
			miVistaConvocatorias.setVisible(false);
			miVistaGestionEquipos.setVisible(true);
		}
		
		if (e.getSource()==miVistaConvocatorias.mntmPartidosDisputados) {
			miVistaConvocatorias.setVisible(false);
			miVistaPartidosDisputados.setVisible(true);
		}
		
		if (e.getSource()==miVistaConvocatorias.btnBuscar) {
			
			String equipoBusc=(String)miVistaConvocatorias.comboBoxSelecEquipo.getSelectedItem();
			miVistaConvocatorias.lblInformativo.setText("Mostrando convocatoria de "+equipoBusc);
			
//			if (nombreBusc!=null && apellidoBusc!=null && equipoBusc!=null){
//				jugador=jugadorAD.BuscarJugador(nombreBusc, apellidoBusc, equipoBusc);
//				miVistaFichas.txtNombre.setText(jugador.getNombre());
//				miVistaFichas.txtApellido.setText(jugador.getApellido());
//				miVistaFichas.txtEquipo.setText(jugador.getEquipo());
//				//miVistaFichas.txtFecha.setText((String)jugador.getFecha_nac());
//				miVistaFichas.txtPosicion.setText(jugador.getPosicion());
//				miVistaFichas.txtDorsal.setText(Integer.toString(jugador.getDorsal()));
//				
//			}
		}
	}
}
