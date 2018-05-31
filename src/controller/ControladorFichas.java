package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import database.ConexionBD;
import model.Jugadores_AD;
import model.Jugadores_TD;
import view.*;

public class ControladorFichas implements ActionListener {
	
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
	public ControladorFichas(	VistaLogin miVL, VistaPrincipal miVP, VistaFichas miVF, 
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
		miVistaFichas.btnCerrarSesion.addActionListener(this);
		miVistaFichas.mntmInicio.addActionListener(this);
		miVistaFichas.mntmEstadisticas.addActionListener(this);
		miVistaFichas.mntmAsistencia.addActionListener(this);
		miVistaFichas.mntmGestionEquipos.addActionListener(this);
		miVistaFichas.mntmPartidosDisputados.addActionListener(this);
		miVistaFichas.mntmConvocatorias.addActionListener(this);
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
		
		if (e.getSource()==miVistaFichas.mntmEstadisticas) {
			miVistaFichas.setVisible(false);
			miVistaEstadisticas.setVisible(true);
		}

		if (e.getSource()==miVistaFichas.mntmAsistencia) {
			miVistaFichas.setVisible(false);
			miVistaAsistencias.setVisible(true);
		}

		if (e.getSource()==miVistaFichas.mntmGestionEquipos) {
			miVistaFichas.setVisible(false);
			miVistaGestionEquipos.setVisible(true);
		}
		
		if (e.getSource()==miVistaFichas.mntmPartidosDisputados) {
			miVistaFichas.setVisible(false);
			miVistaPartidosDisputados.setVisible(true);
		}
		
		if (e.getSource()==miVistaFichas.mntmConvocatorias) {
			miVistaFichas.setVisible(false);
			miVistaConvocatorias.setVisible(true);
		}
		
		if (e.getSource()==miVistaFichas.btnBuscar) {
						
			String nombreBusc=miVistaFichas.txtNombreBuscar.getText();
			String apellidoBusc=miVistaFichas.txtApellidoBuscar.getText();
			String equipoBusc=(String)miVistaFichas.comboBoxSelecEquipo.getSelectedItem();
			
			if (nombreBusc!=null && apellidoBusc!=null && equipoBusc!=null){
				jugador=jugadorAD.BuscarJugador(nombreBusc, apellidoBusc, equipoBusc);
				miVistaFichas.txtNombre.setText(jugador.getNombre());
				miVistaFichas.txtApellido.setText(jugador.getApellido());
				miVistaFichas.txtEquipo.setText(jugador.getEquipo());
				//miVistaFichas.txtFecha.setText((String)jugador.getFecha_nac());
				miVistaFichas.txtPosicion.setText(jugador.getPosicion());
				miVistaFichas.txtDorsal.setText(Integer.toString(jugador.getDorsal()));
				
			}
			
		}
	}
}
