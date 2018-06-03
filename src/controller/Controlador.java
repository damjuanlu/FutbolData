package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import database.ConexionBD;
import model.*;
import view.*;

public class Controlador implements ActionListener{
	
	private VistaLogin miVistaLogin;
	private VistaRegistro miVistaRegistro;
	private VistaPrincipal miVistaPrincipal;
	private VistaFichas miVistaFichas;
	private VistaAsistencias miVistaAsistencias;
	private VistaEstadisticas miVistaEstadisticas;
	private VistaGestionEquipos miVistaGestionEquipos;
	private VistaPartidosDisputados miVistaPartidosDisputados;
	private VistaFichaPartidos miVistaFichaPartidos;
	private VistaConvocatorias miVistaConvocatorias;
	
	Equipos_TD equipos;
	Equipos_AD miEquipoAD=new Equipos_AD();
	Jugadores_TD jugadores;
	Jugadores_AD miJugadoresAD = new Jugadores_AD();
	Usuarios_TD usuario;
	Usuarios_AD miUsuariosAD = new Usuarios_AD();
	Mensajes_TD mensaje;
	Mensajes_AD miMensajesAD = new Mensajes_AD();
	
	public Controlador(VistaLogin miVistaLogin, VistaRegistro miVistaRegistro, VistaPrincipal miVistaPrincipal, VistaFichas miVistaFichas,VistaAsistencias miVistaAsistencias,VistaEstadisticas miVistaEstadisticas,VistaGestionEquipos miVistaGestionEquipos, VistaPartidosDisputados miVistaPartidosDisputados, VistaConvocatorias miVistaConvocatorias, VistaFichaPartidos miVistaFichaPartidos) {
		
		this.miVistaLogin=miVistaLogin;
		this.miVistaRegistro=miVistaRegistro;
		this.miVistaPrincipal=miVistaPrincipal;
		this.miVistaFichas=miVistaFichas;
		this.miVistaAsistencias=miVistaAsistencias;
		this.miVistaEstadisticas=miVistaEstadisticas;
		this.miVistaGestionEquipos=miVistaGestionEquipos;
		this.miVistaPartidosDisputados=miVistaPartidosDisputados;
		this.miVistaFichaPartidos=miVistaFichaPartidos;
		this.miVistaConvocatorias=miVistaConvocatorias;
		
		//Asociar el componente Swing al listener
		miVistaLogin.btnIniciarSesion.addActionListener(this);
		miVistaLogin.btnLogin.addActionListener(this);
		miVistaLogin.btnRegistrarse.addActionListener(this);
		miVistaLogin.btnVolver.addActionListener(this);
		
		miVistaLogin.btnLogin.addActionListener(this);
		miVistaLogin.btnRegistrarse.addActionListener(this);
		miVistaLogin.btnVolver.addActionListener(this);
		miVistaRegistro.btnGuardaRegistro.addActionListener(this);
		miVistaRegistro.btnVolver.addActionListener(this);
		miVistaLogin.btnIniciarSesion.addActionListener(this);
		miVistaPrincipal.btnCerrarSesion.addActionListener(this);
		miVistaPrincipal.mntmFichas.addActionListener(this);
		miVistaPrincipal.mntmAsistencia.addActionListener(this);
		miVistaPrincipal.mntmEstadisticas.addActionListener(this);
		miVistaPrincipal.mntmGestionEquipos.addActionListener(this);
		miVistaPrincipal.mntmPartidosDisputados.addActionListener(this);
		miVistaPrincipal.mntmConvocatorias.addActionListener(this);
		
		miVistaFichas.btnCerrarSesion.addActionListener(this);
		miVistaFichas.mntmInicio.addActionListener(this);
		miVistaFichas.mntmEstadisticas.addActionListener(this);
		miVistaFichas.mntmAsistencia.addActionListener(this);
		miVistaFichas.mntmGestionEquipos.addActionListener(this);
		miVistaFichas.mntmPartidosDisputados.addActionListener(this);
		miVistaFichas.mntmConvocatorias.addActionListener(this);
		miVistaFichas.comboBoxSelecEquipo.addActionListener(this);
		miVistaFichas.btnBuscar.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		/*
		 * 
		 * 
		 * LISTENER VISTA LOGIN Y VISTA REGISTRO
		 * 
		 * 
		 */
		
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
				ArrayList<Mensajes_TD> arrayListMensaje= new ArrayList <Mensajes_TD> ();
				arrayListMensaje=miMensajesAD.BuscarMensajes();
				Iterator listIterator = arrayListMensaje.listIterator();
				int acum=0;
				while(listIterator.hasNext()) {
					Mensajes_TD miMens;
					miMens=arrayListMensaje.get(acum);
					String mensaje=miMens.getMensaje();
					String user=miMens.getUsu_mensaje();
					miVistaPrincipal.txtAreaMensajes.append(""+mensaje+", escrito por: "+user+"\n");
					miVistaPrincipal.txtAreaMensajes.append("\n");
					listIterator.next();
					acum++;
				}
				
			}
		}
		if (e.getSource()==miVistaLogin.btnRegistrarse) {
			miVistaLogin.setVisible(false);
			miVistaRegistro.setVisible(true);
		}
		
		if (e.getSource()==miVistaRegistro.btnGuardaRegistro) {
			//COMPROBAR SI YA EXITE USUARIO Y GUARDAR DATOS DE USUARIO EN LA BASE DE DATOS
			Usuarios_AD miUsuario = new Usuarios_AD();
			String usuario = miVistaRegistro.txtRegistroUser.getText();
			String pass = miVistaRegistro.txtRegistroPassword.getText();
			
			if (pass.equals(miVistaRegistro.txtRepitaPassword.getText())) {
				try {
					miUsuario.CreaUsuario(usuario, pass);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				miVistaRegistro.setVisible(false);
				miVistaLogin.setVisible(true);
			}else
				JOptionPane.showMessageDialog(null, "Error, Introduzca las contraseñas correctamente");
		}
		
		if (e.getSource()==miVistaRegistro.btnVolver) {
			miVistaRegistro.setVisible(false);
			miVistaLogin.setVisible(true);
			miVistaLogin.btnVolver.setVisible(false);
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
		
		/*
		 * 
		 * 
		 * LISTENER VISTA PRINCIPAL
		 * 
		 * 
		 */
		
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
		
		if (e.getSource()==miVistaPrincipal.mntmAsistencia) {
			miVistaPrincipal.setVisible(false);
			miVistaAsistencias.setVisible(true);
		}
		
		if (e.getSource()==miVistaPrincipal.mntmEstadisticas) {
			miVistaPrincipal.setVisible(false);
			miVistaEstadisticas.setVisible(true);
		}
		
		if (e.getSource()==miVistaPrincipal.mntmGestionEquipos) {
			miVistaPrincipal.setVisible(false);
			miVistaGestionEquipos.setVisible(true);
		}
		
		if (e.getSource()==miVistaPrincipal.mntmPartidosDisputados) {
			miVistaPrincipal.setVisible(false);
			miVistaPartidosDisputados.setVisible(true);
		}
		
		if (e.getSource()==miVistaPrincipal.mntmConvocatorias) {
			miVistaPrincipal.setVisible(false);
			miVistaConvocatorias.setVisible(true);
		}

		if (e.getSource()==miVistaPrincipal.btnSelectorEscudo) {
				
		}
		
		/*
		 * 
		 * 
		 * LISTENER VISTA FICHAS
		 * 
		 * 
		 */
		
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
			
			Jugadores_AD jugadorAD=new Jugadores_AD();
			Jugadores_TD jugador;
			
			if (nombreBusc.equals("") || apellidoBusc.equals("") || equipoBusc.equals(""))
				JOptionPane.showMessageDialog(null, "Faltan campos por introducir");
			else {
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
