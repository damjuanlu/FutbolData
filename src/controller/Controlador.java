package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.text.SimpleAttributeSet;

import database.ConexionBD;
import model.*;
import view.*;

public class Controlador implements ActionListener{
	
	private VistaLogin miVistaLogin;
	private VistaRegistro miVistaRegistro;
	private VistaPrincipal miVistaPrincipal;
	private VistaFichas miVistaFichas;
	private VistaEstadisticas miVistaEstadisticas;
	private VistaGestionEquipos miVistaGestionEquipos;
	private VistaAñadirEquipo miVistaAñadirEquipo;
	private VistaConvocatorias miVistaConvocatorias;
	private VistaMensajes miVistaMensajes;
	private VistaCuotas miVistaCuotas;
	private VistaSesiones miVistaSesion;
	private VistaPartidos miVistaPartidos;
	
	Equipos_TD equipos;
	Equipos_AD miEquipoAD=new Equipos_AD();
	Jugadores_TD jugadores;
	Jugadores_AD miJugadoresAD = new Jugadores_AD();
	Usuarios_TD usuario;
	Usuarios_AD miUsuariosAD = new Usuarios_AD();
	Mensajes_TD mensaje;
	Mensajes_AD miMensajesAD = new Mensajes_AD();
	Partidos_TD partidos;
	Partidos_AD miPartidosAD = new Partidos_AD();
	Clasificacion_TD clasificacion;
	Clasificacion_AD miClasificacionAD = new Clasificacion_AD();
	Sesiones_TD sesiones;
	Sesiones_AD miSesiones_AD = new Sesiones_AD();
	
	int cod_jugador=0;
	
	public Controlador(	VistaLogin miVistaLogin, VistaRegistro miVistaRegistro, VistaPrincipal miVistaPrincipal, 
						VistaFichas miVistaFichas,VistaEstadisticas miVistaEstadisticas,VistaGestionEquipos miVistaGestionEquipos, 
						VistaAñadirEquipo miVistaAñadirEquipo, VistaConvocatorias miVistaConvocatorias, 
						VistaCuotas miVistaCuotas, VistaSesiones miVistaSesion, VistaMensajes miVistaMensajes, VistaPartidos miVistaPartidos) {
		
		this.miVistaLogin=miVistaLogin;
		this.miVistaRegistro=miVistaRegistro;
		this.miVistaPrincipal=miVistaPrincipal;
		this.miVistaFichas=miVistaFichas;
		this.miVistaEstadisticas=miVistaEstadisticas;
		this.miVistaGestionEquipos=miVistaGestionEquipos;
		this.miVistaAñadirEquipo=miVistaAñadirEquipo;
		this.miVistaConvocatorias=miVistaConvocatorias;
		this.miVistaMensajes=miVistaMensajes;
		this.miVistaCuotas=miVistaCuotas;
		this.miVistaSesion=miVistaSesion;
		this.miVistaPartidos=miVistaPartidos;
		
		/******  COMBOBOX EQUIPOS  ******/
		
		ArrayList<String>listaEquipos = new ArrayList<>();
		listaEquipos=miJugadoresAD.rellenaComboEquipos();
		ArrayList<String>listaSesiones = new ArrayList<>();
		listaSesiones=miSesiones_AD.rellenaComboSesion(cod_jugador);
		
		
		miVistaFichas.comboBoxSelecEquipo.addActionListener(this);
		miVistaFichas.comboBoxSelecEquipo.removeAllItems();
		miVistaGestionEquipos.comboBoxSelecEquipo.removeAllItems();
		miVistaGestionEquipos.comboBoxSelecEquipo.addActionListener(this);
		miVistaEstadisticas.comboBoxSelecEquipo.addActionListener(this);
		miVistaEstadisticas.comboBoxSelecEquipo.removeAllItems();
		miVistaSesion.comboBoxSelecEquipo.removeAllItems();
		miVistaSesion.comboBoxSelecSesion.removeAllItems();
		for (int i=0; i<listaEquipos.size();i++) {
			miVistaFichas.comboBoxSelecEquipo.addItem(listaEquipos.get(i));
			miVistaEstadisticas.comboBoxSelecEquipo.addItem(listaEquipos.get(i));
			miVistaGestionEquipos.comboBoxSelecEquipo.addItem(listaEquipos.get(i));
			miVistaSesion.comboBoxSelecEquipo.addItem(listaEquipos.get(i));
			miVistaSesion.comboBoxSelecSesion.addItem(listaEquipos.get(i));
		}
		
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
		miVistaPrincipal.mntmEstadisticas.addActionListener(this);
		miVistaPrincipal.mntmGestionEquipos.addActionListener(this);
		miVistaPrincipal.mntmConvocatorias.addActionListener(this);
		miVistaPrincipal.mntmMensajes.addActionListener(this);
		miVistaPrincipal.mntmCuotasJugadores.addActionListener(this);
		miVistaPrincipal.mntmPartidos.addActionListener(this);

		
		miVistaFichas.btnCerrarSesion.addActionListener(this);
		miVistaFichas.mntmInicio.addActionListener(this);
		miVistaFichas.mntmEstadisticas.addActionListener(this);
		miVistaFichas.mntmGestionEquipos.addActionListener(this);
		miVistaFichas.mntmConvocatorias.addActionListener(this);
		miVistaFichas.mntmMensajes.addActionListener(this);
		miVistaFichas.mntmCuotasJugadores.addActionListener(this);
		miVistaFichas.btnBuscar.addActionListener(this);
		miVistaFichas.btnGuardar.addActionListener(this);
		miVistaFichas.btnModificar.addActionListener(this);
		miVistaFichas.btnInsert.addActionListener(this);
		miVistaFichas.btnBorrar.addActionListener(this);
		
		miVistaEstadisticas.btnCerrarSesion.addActionListener(this);
		miVistaEstadisticas.mntmInicio.addActionListener(this);
		miVistaEstadisticas.mntmFichas.addActionListener(this);
		miVistaEstadisticas.mntmEstadisticas.addActionListener(this);
		miVistaEstadisticas.mntmGestionEquipos.addActionListener(this);
		miVistaEstadisticas.mntmConvocatorias.addActionListener(this);
		miVistaEstadisticas.mntmMensajes.addActionListener(this);
		miVistaEstadisticas.mntmCuotasJugadores.addActionListener(this);
		miVistaEstadisticas.btnBuscar.addActionListener(this);
		miVistaEstadisticas.btnInformeAsistencia.addActionListener(this);
		
		miVistaGestionEquipos.btnCerrarSesion.addActionListener(this);
		miVistaGestionEquipos.mntmInicio.addActionListener(this);
		miVistaGestionEquipos.mntmFichas.addActionListener(this);
		miVistaGestionEquipos.mntmEstadisticas.addActionListener(this);
		miVistaGestionEquipos.mntmGestionEquipos.addActionListener(this);
		miVistaGestionEquipos.mntmConvocatorias.addActionListener(this);
		miVistaGestionEquipos.mntmMensajes.addActionListener(this);
		miVistaGestionEquipos.mntmCuotasJugadores.addActionListener(this);
		miVistaGestionEquipos.btnMostrarEquipo.addActionListener(this);
		miVistaGestionEquipos.btnAgregarEquipo.addActionListener(this);
		miVistaGestionEquipos.btnEliminarEquipo.addActionListener(this);
		miVistaGestionEquipos.btnInformeEquipo.addActionListener(this);
		
		miVistaAñadirEquipo.btnVolver.addActionListener(this);
		miVistaAñadirEquipo.btnGuardar.addActionListener(this);
		
		miVistaMensajes.btnCerrarSesion.addActionListener(this);
		miVistaMensajes.mntmInicio.addActionListener(this);
		miVistaMensajes.mntmFichas.addActionListener(this);
		miVistaMensajes.mntmEstadisticas.addActionListener(this);
		miVistaMensajes.mntmGestionEquipos.addActionListener(this);
		miVistaMensajes.mntmConvocatorias.addActionListener(this);
		miVistaMensajes.mntmPlanificacionSesiones.addActionListener(this);
		miVistaMensajes.mntmCuotasJugadores.addActionListener(this);
		miVistaMensajes.btnEnviar.addActionListener(this);

		miVistaCuotas.btnActualizar.addActionListener(this);
		miVistaCuotas.btnBuscarJug.addActionListener(this);
		miVistaCuotas.btnCerrarSesion.addActionListener(this);
		miVistaCuotas.btnCerrarSesion.addActionListener(this);
		miVistaCuotas.mntmInicio.addActionListener(this);
		miVistaCuotas.mntmFichas.addActionListener(this);
		miVistaCuotas.mntmEstadisticas.addActionListener(this);
		miVistaCuotas.mntmGestionEquipos.addActionListener(this);
		miVistaCuotas.mntmPlanificacionSesiones.addActionListener(this);
		miVistaCuotas.mntmConvocatorias.addActionListener(this);
		miVistaCuotas.mntmMensajes.addActionListener(this);
		
		miVistaConvocatorias.btnCerrarSesion.addActionListener(this);
		miVistaConvocatorias.btnBuscar.addActionListener(this);
		miVistaConvocatorias.btnNuevaConvocatoria.addActionListener(this);
		miVistaConvocatorias.mntmInicio.addActionListener(this);
		miVistaConvocatorias.mntmFichas.addActionListener(this);
		miVistaConvocatorias.mntmEstadisticas.addActionListener(this);
		miVistaConvocatorias.mntmGestionEquipos.addActionListener(this);
		miVistaConvocatorias.mntmPlanificacionSesiones.addActionListener(this);
		miVistaConvocatorias.mntmConvocatorias.addActionListener(this);
		miVistaConvocatorias.mntmMensajes.addActionListener(this);
		
		miVistaPartidos.btnCerrarSesion.addActionListener(this);
		miVistaPartidos.btnInsert.addActionListener(this);
		miVistaPartidos.mntmInicio.addActionListener(this);
		miVistaPartidos.mntmFichas.addActionListener(this);
		miVistaPartidos.mntmEstadisticas.addActionListener(this);
		miVistaPartidos.mntmGestionEquipos.addActionListener(this);
		miVistaPartidos.mntmPlanificacionSesiones.addActionListener(this);
		miVistaPartidos.mntmConvocatorias.addActionListener(this);
		miVistaPartidos.mntmMensajes.addActionListener(this);
		
		miVistaSesion.btnCerrarSesion.addActionListener(this);
		miVistaSesion.mntmInicio.addActionListener(this);
		miVistaSesion.mntmEstadisticas.addActionListener(this);
		miVistaSesion.mntmGestionEquipos.addActionListener(this);
		miVistaSesion.mntmConvocatorias.addActionListener(this);
		miVistaSesion.mntmMensajes.addActionListener(this);
		miVistaSesion.mntmCuotasJugadores.addActionListener(this);
		miVistaSesion.btnBuscarSesion.addActionListener(this);
		miVistaSesion.btnMuestraSesion.addActionListener(this);
		miVistaSesion.btnGuardar.addActionListener(this);
		miVistaSesion.btnModificarSesion.addActionListener(this);
		miVistaSesion.btnNuevaSesion.addActionListener(this);
		miVistaSesion.btnEliminarSesion.addActionListener(this);
		miVistaSesion.comboBoxSelecEquipo.addActionListener(this);
		miVistaSesion.comboBoxSelecSesion.addActionListener(this);


		
		
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
			miVistaLogin.txtUser.setText("");
			miVistaLogin.txtPassword.setText("");
		}
		
		if (e.getSource()==miVistaLogin.btnLogin) {
			String User = miVistaLogin.txtUser.getText();
			String Pass = new String(miVistaLogin.txtPassword.getPassword());
			
			ConexionBD conexion = new ConexionBD (User, Pass);
			if (conexion.conexion(User, Pass) == true) {
				miVistaLogin.setVisible(false);
				miVistaPrincipal.setVisible(true);
				miVistaPrincipal.lblUser.setText("Bienvenido " + User);
				
				//Carga Clasificación
				ArrayList<Clasificacion_TD> arrayListClasif= new ArrayList <Clasificacion_TD> ();
				arrayListClasif=miClasificacionAD.CargaClasificacion();
				Iterator listIteratorClasif = arrayListClasif.listIterator();
				int sizeArrayClasif=arrayListClasif.size();
				int acumClas=1;
				sizeArrayClasif--;
				while(listIteratorClasif.hasNext()) {
					Clasificacion_TD miClasif;
					miClasif=arrayListClasif.get(sizeArrayClasif);
					miVistaPrincipal.tableClasif.getModel().setValueAt(miClasif.getNombre_eq(), acumClas, 1);
					miVistaPrincipal.tableClasif.getModel().setValueAt(miClasif.getPuntos(), acumClas, 2);
					miVistaPrincipal.tableClasif.getModel().setValueAt(miClasif.getPartidos_jug(), acumClas, 3);
					miVistaPrincipal.tableClasif.getModel().setValueAt(miClasif.getGol_favor(), acumClas, 4);
					miVistaPrincipal.tableClasif.getModel().setValueAt(miClasif.getGol_contra(), acumClas, 5);
					acumClas++;
					sizeArrayClasif--;
					listIteratorClasif.next();
				}
				
				//Carga Mensajes
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
				
				// Carga Ultimos Partidos
				ArrayList<Partidos_TD> ArrayListPartidos= new ArrayList <Partidos_TD> ();
				ArrayListPartidos=miPartidosAD.buscaTodosPartidos();
				Iterator listIteratorEquipos = arrayListMensaje.listIterator();
				int acumeq=0;
				int sizeArray=ArrayListPartidos.size();
				sizeArray--;
				while(listIteratorEquipos.hasNext() && acumeq<=4) {
					partidos=ArrayListPartidos.get(sizeArray);
					miVistaPrincipal.tableUltimos.getModel().setValueAt(partidos.getEq_local(), acumeq, 0);
					miVistaPrincipal.tableUltimos.getModel().setValueAt(partidos.getGol_local()+"-"+partidos.getGol_visit(), acumeq, 1);
					miVistaPrincipal.tableUltimos.getModel().setValueAt(partidos.getEq_visit(), acumeq, 2);
					acumeq++;
					sizeArray--;
					listIteratorEquipos.next();
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
			String pass2=miVistaRegistro.txtRepitaPassword.getText();
			
			if (pass.equals(pass2)) {
				miUsuario.CreaUsuario(usuario, pass);
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
		
		if (e.getSource()==miVistaPrincipal.mntmMensajes) {
			miVistaPrincipal.setVisible(false);
			miVistaMensajes.setVisible(true);
		}
		if (e.getSource()==miVistaPrincipal.mntmCuotasJugadores) {
			miVistaPrincipal.setVisible(false);
			miVistaCuotas.setVisible(true);
		}
		if (e.getSource()==miVistaPrincipal.mntmPlanificacionSesiones) {
			miVistaPrincipal.setVisible(false);
			miVistaSesion.setVisible(true);
		}
		if (e.getSource()==miVistaPrincipal.mntmPartidos) {
			miVistaPrincipal.setVisible(false);
			miVistaPartidos.setVisible(true);
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

		if (e.getSource()==miVistaFichas.mntmGestionEquipos) {
			miVistaFichas.setVisible(false);
			miVistaGestionEquipos.setVisible(true);
		}
		
		if (e.getSource()==miVistaFichas.mntmConvocatorias) {
			miVistaFichas.setVisible(false);
			miVistaConvocatorias.setVisible(true);
		} 
		
		if (e.getSource()==miVistaFichas.mntmCuotasJugadores) {
			miVistaFichas.setVisible(false);
			miVistaCuotas.setVisible(true);
		}
		
		if (e.getSource()==miVistaFichas.mntmPlanificacionSesiones) {
			miVistaFichas.setVisible(false);
			miVistaSesion.setVisible(true);
		}
		
		if (e.getSource()==miVistaFichas.btnBuscar) {
						
			String nombreBusc=miVistaFichas.txtNombreBuscar.getText();
			String apellidoBusc=miVistaFichas.txtApellidoBuscar.getText();
			String equipoBusc=(String)miVistaFichas.comboBoxSelecEquipo.getSelectedItem();
			
			Jugadores_AD jugadorAD=new Jugadores_AD();
			Jugadores_TD jugador;
			Estadisticas_AD estadisticasAD=new Estadisticas_AD();
			Estadisticas_TD estadisticas;
			
			if (nombreBusc.equals("") || apellidoBusc.equals("") || equipoBusc.equals(""))
				JOptionPane.showMessageDialog(null, "Faltan campos por introducir");
			else {
				//Busca jugador
				jugador=jugadorAD.BuscarJugador(nombreBusc, apellidoBusc, equipoBusc);
				int codigojugador=jugador.getCod_jugador();
				miVistaFichas.txtNombre.setText(jugador.getNombre());
				miVistaFichas.txtApellido.setText(jugador.getApellido());
				miVistaFichas.txtEquipo.setText(jugador.getEquipo());
				//miVistaFichas.txtFecha.setText((String)jugador.getFecha_nac());
				miVistaFichas.txtPosicion.setText(jugador.getPosicion());
				miVistaFichas.txtDorsal.setText(Integer.toString(jugador.getDorsal()));
				miVistaFichas.txtObservaciones.setText(jugador.getObservaciones());
				
				//Busca estadistica
				estadisticas=estadisticasAD.BuscaEstadisticas(codigojugador);
				miVistaFichas.tablaEst.getModel().setValueAt(estadisticas.getPartidos_jug(), 1, 0);
				miVistaFichas.tablaEst.getModel().setValueAt(estadisticas.getGoles(), 1, 1);
				miVistaFichas.tablaEst.getModel().setValueAt(estadisticas.getAsistencias(), 1, 2);
				miVistaFichas.tablaEst.getModel().setValueAt(estadisticas.getTarjetas_amarillas(), 1, 3);
				miVistaFichas.tablaEst.getModel().setValueAt(estadisticas.getTarjetas_rojas(), 1, 4);
			}
		}
		
		if (e.getSource()==miVistaFichas.btnModificar) {
			
			String nombreBusc=miVistaFichas.txtNombreBuscar.getText();
			String apellidoBusc=miVistaFichas.txtApellidoBuscar.getText();
			String equipoBusc=(String)miVistaFichas.comboBoxSelecEquipo.getSelectedItem();
			
			Jugadores_AD jugadorAD=new Jugadores_AD();
			Jugadores_TD jugador;
			
			jugador=jugadorAD.BuscarJugador(nombreBusc, apellidoBusc, equipoBusc);
			cod_jugador=jugador.getCod_jugador();
			
			miVistaFichas.btnGuardar.setEnabled(true);
			miVistaFichas.txtNombre.setEnabled(true);
			miVistaFichas.txtApellido.setEnabled(true);
			miVistaFichas.txtEquipo.setEnabled(true);
			//miVistaFichas.txtFecha.setEnabled(true);
			miVistaFichas.txtPosicion.setEnabled(true);
			miVistaFichas.txtDorsal.setEnabled(true);
			miVistaFichas.txtObservaciones.setEnabled(true);
			
//			miVistaFichas.txtNombre.setEditable(true);
//			miVistaFichas.txtApellido.setEditable(true);
//			miVistaFichas.txtEquipo.setEditable(true);
//			miVistaFichas.txtPosicion.setEditable(true);
//			miVistaFichas.txtDorsal.setEditable(true);
			
		}
		
		if (e.getSource()==miVistaFichas.btnGuardar) {
			
			String nombreBusc=miVistaFichas.txtNombreBuscar.getText();
			String apellidoBusc=miVistaFichas.txtApellidoBuscar.getText();
			String equipoBusc=(String)miVistaFichas.comboBoxSelecEquipo.getSelectedItem();
			
			Jugadores_AD jugadorAD=new Jugadores_AD();
			Jugadores_TD jugador;
			
			String nombre=miVistaFichas.txtNombre.getText();
			String apellido=miVistaFichas.txtApellido.getText();
			String equipo=miVistaFichas.txtEquipo.getText();
			String posicion=miVistaFichas.txtPosicion.getText();
			int dorsal=Integer.parseInt(miVistaFichas.txtDorsal.getText());
			String observaciones=miVistaFichas.txtObservaciones.getText();
			boolean accion=jugadorAD.ModificaJugador(cod_jugador, nombre, apellido, equipo, posicion, dorsal,observaciones);
			if (accion==true)
				JOptionPane.showMessageDialog(null, "Modificación realizada correctamente");
			else
				JOptionPane.showMessageDialog(null, "ERROR! Modificación realizada incorrectamente");
			
			
		}
		
		if (e.getSource()==miVistaFichas.btnInsert) {
			Jugadores_AD jugadorAD=new Jugadores_AD();
			String nombre_nuevo=miVistaFichas.txtNombre.getText();
			String apellido_nuevo=miVistaFichas.txtApellido.getText();
			String equipo_nuevo=miVistaFichas.txtEquipo.getText();
			String posicion_nuevo=miVistaFichas.txtPosicion.getText();
			String dorsal_comprobacion=miVistaFichas.txtDorsal.getText();
			int dorsal=Integer.parseInt(miVistaFichas.txtDorsal.getText());
			String observaciones=miVistaFichas.txtObservaciones.getText();
			if (nombre_nuevo!="" && apellido_nuevo!="" && equipo_nuevo!="" && posicion_nuevo!="" && dorsal_comprobacion!=null) {
				jugadorAD.InsertaJugador(nombre_nuevo, apellido_nuevo, equipo_nuevo, posicion_nuevo, dorsal, observaciones);
				JOptionPane.showMessageDialog(null, "Nuevo jugador insertado");
			} else
				JOptionPane.showMessageDialog(null, "Introduzca todos los parámetros");
		}
		
		if (e.getSource()==miVistaFichas.btnBorrar) {
			Jugadores_AD jugadorAD=new Jugadores_AD();
			boolean comprobar=jugadorAD.EliminaJugador(miVistaFichas.txtNombre.getText(), miVistaFichas.txtApellido.getText(), miVistaFichas.txtEquipo.getText());
			if (comprobar==true) {
				JOptionPane.showMessageDialog(null, "Jugador Eliminado");
			} else
				JOptionPane.showMessageDialog(null, "Error al eliminar, revise parámetros");
		}
		/*
		 * 
		 * 
		 * LISTENER VISTA GESTION EQUIPOS
		 * 
		 * 
		 */
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
		
		
		if (e.getSource()==miVistaGestionEquipos.mntmEstadisticas) {
			miVistaGestionEquipos.setVisible(false);
			miVistaEstadisticas.setVisible(true);
		}
		
		if (e.getSource()==miVistaGestionEquipos.mntmMensajes) {
			miVistaGestionEquipos.setVisible(false);
			miVistaMensajes.setVisible(true);
		}
		
		if (e.getSource()==miVistaGestionEquipos.mntmPlanificacionSesiones) {
			miVistaGestionEquipos.setVisible(false);
			miVistaSesion.setVisible(true);
		}
		
		if (e.getSource()==miVistaGestionEquipos.mntmConvocatorias) {
			miVistaGestionEquipos.setVisible(false);
			miVistaConvocatorias.setVisible(true);
		}
		
		if (e.getSource()==miVistaGestionEquipos.comboBoxSelecEquipo) {
			String seleccion =  (String) miVistaGestionEquipos.comboBoxSelecEquipo.getSelectedItem();
			//miVistaGestionEquipos.equipoSeleccionado.equals(seleccion);
		}
		
		if (e.getSource()==miVistaGestionEquipos.btnAgregarEquipo) {
			miVistaGestionEquipos.setVisible(false);
			miVistaAñadirEquipo.setVisible(true);
		}
		
		if (e.getSource()==miVistaGestionEquipos.btnMostrarEquipo) {
			
			miVistaGestionEquipos.btnInformeEquipo.setEnabled(true);
			
			miVistaGestionEquipos.textAreaPartidosEquipo.setText("");
			miVistaGestionEquipos.textAreaDatosEquipo.setText("");
			miVistaGestionEquipos.textAreaJugadores.setText("");
			
			String seleccion =  (String) miVistaGestionEquipos.comboBoxSelecEquipo.getSelectedItem();
			
			miVistaGestionEquipos.lblInformativo.setText("MOSTRANDO INFORMACIÓN DE EQUIPO "+seleccion);

			miVistaGestionEquipos.btnEliminarEquipo.setEnabled(true);
			
			//Lista jugadores
			Jugadores_AD jugadores = new Jugadores_AD();
			ArrayList <Jugadores_TD> miArrayList=new ArrayList <Jugadores_TD> ();
			miArrayList=jugadores.BuscaJugadoresEquipo(seleccion);
			Iterator listIterator = miArrayList.listIterator();	
			int acum=0;
			while(listIterator.hasNext()) {
				Jugadores_TD jugador;
				jugador=miArrayList.get(acum);
				String nombre=jugador.getNombre();
				String apellido=jugador.getApellido();
				String posicion=jugador.getPosicion();
				miVistaGestionEquipos.textAreaJugadores.append(""+nombre+" "+apellido+" , "+posicion+"\n");
				listIterator.next();
				acum++;
			}

			//Lista Partidos
			Partidos_AD partidos = new Partidos_AD();
			ArrayList <Partidos_TD> miArrayListPart=new ArrayList <Partidos_TD> ();
			miArrayListPart=partidos.BuscaPartidosEquipo(seleccion);
			Iterator listIteratorPart = miArrayListPart.listIterator();	
			int acumPart=0;
			while(listIteratorPart.hasNext() || acumPart<=5) {
				Partidos_TD partido;
				partido=miArrayListPart.get(acumPart);
				String eq_local=partido.getEq_local();
				int gol_local=partido.getGol_local();
				String eq_visit=partido.getEq_visit();
				int gol_visit=partido.getGol_visit();
				miVistaGestionEquipos.textAreaPartidosEquipo.append(""+eq_local+"  "+gol_local+" - "+gol_visit+"  "+eq_visit+"\n");
				listIteratorPart.next();
				acumPart++;
			}

			//Lista datos equipo
			Equipos_AD datos_equipo = new Equipos_AD();
			Equipos_TD miEquipo=null;
			miEquipo=datos_equipo.BuscaEquiposGestion(seleccion);

				String nombre=miEquipo.getNombre();
				String campo=miEquipo.getCampo();
				String entrenamiento=miEquipo.getEntrenamiento();
				String horario=miEquipo.getHorario();
				miVistaGestionEquipos.textAreaDatosEquipo.append(" EQUIPO: "+nombre+"\n\r CAMPO: "+campo+"\n\r DIAS DE ENTRENAMIENTO: "+entrenamiento+"\n\r HORARIO: "+horario);
			
		}
		
		
		if (e.getSource()==miVistaGestionEquipos.btnEliminarEquipo) {
			Equipos_AD equipoAD=new Equipos_AD();
			String seleccion =  (String) miVistaGestionEquipos.comboBoxSelecEquipo.getSelectedItem();
//			JOptionPane.showConfirmDialog(null, "Realmente desea eliminar el equipo "+seleccion+"?", "Confirmar eliminar equipo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			int opcionJPane = JOptionPane.showConfirmDialog(null, "Realmente desea eliminar el equipo "+seleccion+"?", "Confirmar eliminar equipo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			switch(opcionJPane) {
			   case 0 :
					   equipoAD.EliminaEquipo(seleccion);
						JOptionPane.showMessageDialog(null, "Equipo "+seleccion+" ELIMINADO");
						miVistaGestionEquipos.btnEliminarEquipo.setEnabled(false);
			      break; // optional
			   
			   case 1 :
			   case -1:
					JOptionPane.showMessageDialog(null, "Eliminar "+seleccion+" CANCELADO");
					miVistaGestionEquipos.btnEliminarEquipo.setEnabled(true);
			      break; // optional
			
//			if (comprobar==true && JOptionPane.showConfirmDialog(null, "Realmente desea eliminar el equipo "+seleccion+"?", "Confirmar eliminar equipo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
//				JOptionPane.showMessageDialog(null, "Equipo Eliminado");
//				miVistaGestionEquipos.btnEliminarEquipo.setEnabled(false);
//			} 
//			
//			else if (JOptionPane.showConfirmDialog(null, "Realmente desea eliminar el equipo "+seleccion+"?", "Confirmar eliminar equipo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
//				JOptionPane.showMessageDialog(null, "Eliminar cancelado");
//			}
//			
//			else
//				JOptionPane.showMessageDialog(null, "Error al eliminar, revise parámetros");
			      
			}
		}
		
		if (e.getSource()==miVistaGestionEquipos.btnInformeEquipo) {
			
			String JugadoresEquipo=miVistaGestionEquipos.textAreaJugadores.getText();
			String PartidosEquipo=miVistaGestionEquipos.textAreaPartidosEquipo.getText();
			String DatosEquipo=miVistaGestionEquipos.textAreaDatosEquipo.getText();
			
			FileWriter fileWritter;
			
			try {
				fileWritter = new FileWriter("InformeEquipo.txt");
				BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
				try {
					
					bufferWritter.write("INFORME DE EQUIPO");
			        bufferWritter.newLine();
			        bufferWritter.newLine();
			        
					bufferWritter.write("JUGADORES");
			        bufferWritter.newLine();
			        bufferWritter.newLine();
			        
					bufferWritter.write(JugadoresEquipo);
			        bufferWritter.newLine();
			        bufferWritter.newLine();
			        
					bufferWritter.write("PARTIDOS");
			        bufferWritter.newLine();
			        bufferWritter.newLine();
			        
					bufferWritter.write(PartidosEquipo);
			        bufferWritter.newLine();
			        bufferWritter.newLine();
			        
					bufferWritter.write("DATOS DE EQUIPO");
			        bufferWritter.newLine();
			        bufferWritter.newLine();
			        
					bufferWritter.write(DatosEquipo);
			        bufferWritter.newLine();
			        bufferWritter.newLine();

			        bufferWritter.close();
			} catch (IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
		}
		
		
		/*
		 * 
		 * 
		 * LISTENER VISTA AÑADIR EQUIPO
		 * 
		 * 
		 */
		if (e.getSource()==miVistaAñadirEquipo.btnVolver) {
			miVistaAñadirEquipo.setVisible(false);
			miVistaGestionEquipos.setVisible(true);
		}
		
		if (e.getSource()==miVistaAñadirEquipo.btnGuardar) {
			
			Equipos_AD Equipos_AD=new Equipos_AD();
			
			String nombre_nuevo=miVistaAñadirEquipo.txtNombre.getText();
			String campo_nuevo=miVistaAñadirEquipo.txtCampo.getText();
			String entrenamiento_nuevo=miVistaAñadirEquipo.txtEntrenamiento.getText();
			String horario_nuevo=miVistaAñadirEquipo.txtHorario.getText();
						
			if (nombre_nuevo!="" && campo_nuevo!="" && entrenamiento_nuevo!="" && horario_nuevo!="") {
				Equipos_AD.InsertaJugador(nombre_nuevo, campo_nuevo, entrenamiento_nuevo, horario_nuevo);
				JOptionPane.showMessageDialog(null, "Nuevo equipo insertado");
				
				miVistaAñadirEquipo.txtNombre.setText("");
				miVistaAñadirEquipo.txtCampo.setText("");
				miVistaAñadirEquipo.txtEntrenamiento.setText("");
				miVistaAñadirEquipo.txtHorario.setText("");
				
			} else
				JOptionPane.showMessageDialog(null, "Introduzca todos los parámetros");
		}
		
		
		/*
		 * 
		 * 
		 * LISTENER VISTA MENSAJES
		 * 
		 * 
		 */
		if (e.getSource()==miVistaMensajes.btnCerrarSesion) {
			miVistaMensajes.setVisible(false);
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
		
		if (e.getSource()==miVistaMensajes.mntmInicio) {
			miVistaMensajes.setVisible(false);
			miVistaPrincipal.setVisible(true);
		}
		
		if (e.getSource()==miVistaMensajes.mntmEstadisticas) {
			miVistaMensajes.setVisible(false);
			miVistaEstadisticas.setVisible(true);
		}

		if (e.getSource()==miVistaMensajes.mntmGestionEquipos) {
			miVistaMensajes.setVisible(false);
			miVistaGestionEquipos.setVisible(true);
		}
		
		if (e.getSource()==miVistaMensajes.mntmConvocatorias) {
			miVistaMensajes.setVisible(false);
			miVistaConvocatorias.setVisible(true);
		} 
		
		if (e.getSource()==miVistaMensajes.mntmCuotasJugadores) {
			miVistaMensajes.setVisible(false);
			miVistaCuotas.setVisible(true);
		}
		
		if (e.getSource()==miVistaMensajes.mntmPlanificacionSesiones) {
			miVistaMensajes.setVisible(false);
			miVistaSesion.setVisible(true);
		}
		
		if (e.getSource()==miVistaMensajes.btnEnviar){
			
			String mensaje=miVistaMensajes.txtAreaMensaje.getText();
			
			miMensajesAD.InsertaMensaje(mensaje);
			JOptionPane.showMessageDialog(null, "Mensaje enviado");
			
		}
		
		/*
		 * 
		 * 
		 * LISTENER VISTA ESTADISTICAS
		 * 
		 * 
		 */
		
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
			miVistaFichas.setVisible(true);
		}

		if (e.getSource()==miVistaEstadisticas.mntmGestionEquipos) {
			miVistaEstadisticas.setVisible(false);
			miVistaGestionEquipos.setVisible(true);
		}
		
		if (e.getSource()==miVistaEstadisticas.mntmConvocatorias) {
			miVistaEstadisticas.setVisible(false);
			miVistaConvocatorias.setVisible(true);
		} 
		
		if (e.getSource()==miVistaEstadisticas.mntmCuotasJugadores) {
			miVistaEstadisticas.setVisible(false);
			miVistaCuotas.setVisible(true);
		}
		
		if (e.getSource()==miVistaEstadisticas.mntmPlanificacionSesiones) {
			miVistaEstadisticas.setVisible(false);
			miVistaSesion.setVisible(true);
		}
		
		if (e.getSource()==miVistaEstadisticas.btnBuscar) {
			
			miVistaEstadisticas.btnInformeAsistencia.setEnabled(true);
			
			for (int i=1; i<=27; i++) {
				miVistaEstadisticas.tableEstadisticas.getModel().setValueAt("", i, 0);
				miVistaEstadisticas.tableEstadisticas.getModel().setValueAt("", i, 1);
				miVistaEstadisticas.tableEstadisticas.getModel().setValueAt("", i, 2);
				miVistaEstadisticas.tableEstadisticas.getModel().setValueAt("", i, 3);
				miVistaEstadisticas.tableEstadisticas.getModel().setValueAt("", i, 4);
				miVistaEstadisticas.tableEstadisticas.getModel().setValueAt("", i, 5);
			}
			
			Estadisticas_AD estadisticas = new Estadisticas_AD();
			ArrayList <Estadisticas_TD> miArrayListEstad=new ArrayList <Estadisticas_TD> ();
			miArrayListEstad=estadisticas.MuestraALLEStad();
			Iterator listIteratorEst = miArrayListEstad.listIterator();
			int cuenta = miArrayListEstad.size();
			int acumEst=0;
			while(listIteratorEst.hasNext() || acumEst<=cuenta-1) {
				Estadisticas_TD estadistica;
				estadistica=miArrayListEstad.get(acumEst);
				int codigo=estadistica.getCod_jugador();
				String nombre=estadistica.getNombre_jugador();
				int partidos=estadistica.getPartidos_jug();
				int goles=estadistica.getGoles();
				int asistencias=estadistica.getAsistencias();
				int amarillas=estadistica.getTarjetas_amarillas();
				int rojas=estadistica.getTarjetas_rojas();
				miVistaEstadisticas.tableEstadisticas.getModel().setValueAt(nombre, acumEst+1, 0);
				miVistaEstadisticas.tableEstadisticas.getModel().setValueAt(partidos, acumEst+1, 1);
				miVistaEstadisticas.tableEstadisticas.getModel().setValueAt(goles, acumEst+1, 2);
				miVistaEstadisticas.tableEstadisticas.getModel().setValueAt(asistencias, acumEst+1, 3);
				miVistaEstadisticas.tableEstadisticas.getModel().setValueAt(amarillas, acumEst+1, 4);
				miVistaEstadisticas.tableEstadisticas.getModel().setValueAt(rojas, acumEst+1, 5);
				listIteratorEst.next();
				acumEst++;
			}
		}
		
		if (e.getSource()==miVistaEstadisticas.btnInformeAsistencia) {
			
			FileWriter fileWritter;
			try {
				fileWritter = new FileWriter("InformeEstadisticas.txt");
				BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
				try {
					
					bufferWritter.write("INFORME DE ESTADÍSTICAS");
			        bufferWritter.newLine();
			        bufferWritter.newLine();
			        
					for (int i = 1; i <=27; i++) {
						String var1=miVistaEstadisticas.tableEstadisticas.getModel().getValueAt(i, 0).toString();
						String var2=miVistaEstadisticas.tableEstadisticas.getModel().getValueAt(i, 1).toString();
						String var3=miVistaEstadisticas.tableEstadisticas.getModel().getValueAt(i, 2).toString();
						String var4=miVistaEstadisticas.tableEstadisticas.getModel().getValueAt(i, 3).toString();
						String var5=miVistaEstadisticas.tableEstadisticas.getModel().getValueAt(i, 4).toString();
						String var6=miVistaEstadisticas.tableEstadisticas.getModel().getValueAt(i, 5).toString();

						bufferWritter.write("Nombre: "+var1+", PJ: "+var2+", GOL: "+var3+", ASIST: "+var4+", AMARILLAS: "+var5+", ROJAS: "+var6);
				        bufferWritter.newLine();
					}

			        bufferWritter.close();	        
			        JOptionPane.showMessageDialog(null, "Informe obtenido");
			        
			} catch (IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Informe no obtenido");
			}
			
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Informe no obtenido");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Informe no obtenido");
			}
		}
		
		
		/*
		 * 
		 * 
		 * LISTENER VISTA CUOTAS
		 * 
		 * 
		 */
		if (e.getSource()==miVistaCuotas.btnCerrarSesion) {
			miVistaCuotas.setVisible(false);
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
		
		if (e.getSource()==miVistaCuotas.mntmInicio) {
			miVistaCuotas.setVisible(false);
			miVistaPrincipal.setVisible(true);
		}
		
		if (e.getSource()==miVistaCuotas.mntmEstadisticas) {
			miVistaCuotas.setVisible(false);
			miVistaEstadisticas.setVisible(true);
		}

		if (e.getSource()==miVistaCuotas.mntmGestionEquipos) {
			miVistaCuotas.setVisible(false);
			miVistaGestionEquipos.setVisible(true);
		}
		
		if (e.getSource()==miVistaCuotas.mntmConvocatorias) {
			miVistaCuotas.setVisible(false);
			miVistaConvocatorias.setVisible(true);
		} 
		
		if (e.getSource()==miVistaCuotas.mntmCuotasJugadores) {
			miVistaCuotas.setVisible(false);
			miVistaCuotas.setVisible(true);
		}
		
		if (e.getSource()==miVistaCuotas.mntmPlanificacionSesiones) {
			miVistaCuotas.setVisible(false);
			miVistaSesion.setVisible(true);
		}
		
		if (e.getSource()==miVistaCuotas.btnBuscarJug) {
			Cuotas_AD cuotasAD= new Cuotas_AD();
			Cuotas_TD cuota=null;
			
			String nomcuo=miVistaCuotas.txtNombre.getText();
			String apecuo=miVistaCuotas.txtApellido.getText();
			String equipocuo=miVistaCuotas.comboEquipo.getSelectedItem().toString();
			
			if (miVistaCuotas.txtNombre.getText()!="" && miVistaCuotas.txtApellido.getText()!="" && miVistaCuotas.comboEquipo.getSelectedItem().toString()!="") {
				cuota=cuotasAD.muestraCuotas(nomcuo, apecuo, equipocuo);
				int cant_cuota=cuota.getCantidad();
				boolean bool_cuota=cuota.isPagado();
				String cantidad_cuota=String.valueOf(cant_cuota);
				miVistaCuotas.txtCuota.setText(cantidad_cuota);
				miVistaCuotas.checkCuota.setSelected(bool_cuota);
			}else {
				JOptionPane.showMessageDialog(null, "Error, introduzca todos los parámetros");
			}
	
			
		}
		
		if (e.getSource()==miVistaCuotas.btnActualizar) {
			Cuotas_AD cuotasAD= new Cuotas_AD();
			Cuotas_TD cuota=null;
			String nomcuo=miVistaCuotas.txtNombre.getText();
			String apecuo=miVistaCuotas.txtApellido.getText();
			String equipocuo=miVistaCuotas.comboEquipo.getSelectedItem().toString();
			
			int cuotanueva=Integer.parseInt(miVistaCuotas.txtCuota.getText());
			boolean pagadonuevo=(boolean)miVistaCuotas.checkCuota.isSelected();
			
			boolean comprobacion=cuotasAD.actualizaCuotas(nomcuo, apecuo, equipocuo, cuotanueva, pagadonuevo);
			
			if (comprobacion==true)
				JOptionPane.showMessageDialog(null, "Actualizado!");
			else
				JOptionPane.showMessageDialog(null, "Error al actualizar!");
		}
		
		/*
		 * 
		 * 
		 * LISTENER VISTA CONVOCATORIAS
		 * 
		 * 
		 */
		
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
		
		if (e.getSource()==miVistaConvocatorias.mntmEstadisticas) {
			miVistaConvocatorias.setVisible(false);
			miVistaEstadisticas.setVisible(true);
		}

		if (e.getSource()==miVistaConvocatorias.mntmGestionEquipos) {
			miVistaConvocatorias.setVisible(false);
			miVistaGestionEquipos.setVisible(true);
		}
		
		if (e.getSource()==miVistaConvocatorias.mntmConvocatorias) {
			miVistaConvocatorias.setVisible(false);
			miVistaConvocatorias.setVisible(true);
		} 
		
		if (e.getSource()==miVistaConvocatorias.mntmCuotasJugadores) {
			miVistaConvocatorias.setVisible(false);
			miVistaCuotas.setVisible(true);
		}
		
		if (e.getSource()==miVistaConvocatorias.mntmPlanificacionSesiones) {
			miVistaConvocatorias.setVisible(false);
			miVistaSesion.setVisible(true);
		}
		
		if (e.getSource()==miVistaConvocatorias.btnBuscar){
			
			miVistaConvocatorias.btnNuevaConvocatoria.setEnabled(true);
			
			String seleccion=miVistaConvocatorias.comboBoxSelecEquipo.getSelectedItem().toString();
			Jugadores_AD jugadores_AD= new Jugadores_AD();
			ArrayList <Jugadores_TD> ArrList= new ArrayList();
			ArrList=jugadores_AD.BuscaJugadoresEquipo(seleccion);
			Iterator listIteratorEst = ArrList.listIterator();
			int cuenta = ArrList.size();
			int acumEst=0;
			while(listIteratorEst.hasNext() || acumEst<=cuenta-1) {
				Jugadores_TD jugador;
				jugador=ArrList.get(acumEst);
				String nombre=jugador.getNombre();
				String apellidos=jugador.getApellido();
				String posicion=jugador.getPosicion();
				miVistaConvocatorias.tablaConvocar.getModel().setValueAt(nombre+" "+apellidos, acumEst+1, 0);
				miVistaConvocatorias.tablaConvocar.getModel().setValueAt(posicion, acumEst+1, 1);
				listIteratorEst.next();
				acumEst++;
			}
		}
		
		if (e.getSource()==miVistaConvocatorias.btnNuevaConvocatoria) {
			
			//JOptionPane.showMessageDialog(null, "La convocatoria será de 15 jugadores");
			
//			int convocados=0;
//			String convocado="false";
//			
//			for (int i = 1; i <=27; i++) {
//				convocado=miVistaConvocatorias.tablaConvocar.getModel().getValueAt(i, 2).toString();
//				if (convocado=="true")
//					convocados++;
//			}
			
//			if (convocados==15) {	
				FileWriter fileWritter;
				try {
					fileWritter = new FileWriter("Convocatoria.txt");
					BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
					
					try {
						
						bufferWritter.write("CONVOCATORIA DE PARTIDO");
				        bufferWritter.newLine();
				        bufferWritter.newLine();
				        
				        String rival=miVistaConvocatorias.txtRival.getText();
				        String equipo=miVistaConvocatorias.comboBoxSelecEquipo.getSelectedItem().toString();
				        
						bufferWritter.write(equipo+" CONTRA "+rival);
				        bufferWritter.newLine();
				        bufferWritter.newLine();
				        int i=1;

						String convocado="";
			        	String var1="";
						String var2="";
						String var3="";
				        
				        while (i<=27) {
				        	var1=miVistaConvocatorias.tablaConvocar.getModel().getValueAt(i, 0).toString();
							var2=miVistaConvocatorias.tablaConvocar.getModel().getValueAt(i, 1).toString();
							var3=miVistaConvocatorias.tablaConvocar.getModel().getValueAt(i, 2).toString();
							
							if (var3=="true")
								convocado="SI";
							else
								convocado="NO";
	
							bufferWritter.write("Nombre: "+var1+", Posición: "+var2+", Convocado: "+convocado);
					        bufferWritter.newLine();
					        
					        i++;
				        }
				        
	
				        bufferWritter.close();	        
				        JOptionPane.showMessageDialog(null, "Convocatoria Realizada");
				        
					} catch (IOException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
				        JOptionPane.showMessageDialog(null, "Informe no obtenido");
					}
			
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Informe no obtenido");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Informe no obtenido");
			}
//			} else
//				JOptionPane.showMessageDialog(null, "ERROR. Seleccione 15 jugadores");
		}
		
		
		/*
		 * 
		 * 
		 * LISTENER VISTA PARTIDOS
		 * 
		 * 
		 */
		if (e.getSource()==miVistaPartidos.btnCerrarSesion) {
			miVistaPartidos.setVisible(false);
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
		
		/*
		 * 
		 * 
		 * LISTENER VISTA SESIONES
		 * 
		 * 
		 */
		
		if (e.getSource()==miVistaSesion.btnCerrarSesion) {
			miVistaSesion.setVisible(false);
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
		
		if (e.getSource()==miVistaSesion.mntmInicio) {
			miVistaSesion.setVisible(false);
			miVistaPrincipal.setVisible(true);
		}
		
		if (e.getSource()==miVistaSesion.mntmEstadisticas) {
			miVistaSesion.setVisible(false);
			miVistaEstadisticas.setVisible(true);
		}

		if (e.getSource()==miVistaSesion.mntmGestionEquipos) {
			miVistaSesion.setVisible(false);
			miVistaGestionEquipos.setVisible(true);
		}
		
		if (e.getSource()==miVistaSesion.mntmConvocatorias) {
			miVistaSesion.setVisible(false);
			miVistaConvocatorias.setVisible(true);
		} 
		
		if (e.getSource()==miVistaSesion.mntmCuotasJugadores) {
			miVistaSesion.setVisible(false);
			miVistaCuotas.setVisible(true);
		}
		
		if (e.getSource()==miVistaSesion.mntmFichas) {
			miVistaSesion.setVisible(false);
			miVistaFichas.setVisible(true);
		}
		
		if (e.getSource()==miVistaSesion.btnBuscarSesion) {
						
			int cod_equipoBusc=(int)miVistaSesion.comboBoxSelecEquipo.getSelectedItem();
			
			Sesiones_AD sesionAD=new Sesiones_AD();
			Sesiones_TD sesion;

				//Busca sesion
				sesion=sesionAD.rellenaComboSesion(cod_equipo);
				int codigojugador=jugador.getCod_jugador();
				
				miVistaSesion.comboBoxSelecSesion.setEnabled(true);
				miVistaSesion.btnMuestraSesion.setEnabled(true);
				miVistaSesion.btnModificarSesion.setEnabled(true);
		}
		
		if (e.getSource()==miVistaFichas.btnModificar) {
			
			String nombreBusc=miVistaFichas.txtNombreBuscar.getText();
			String apellidoBusc=miVistaFichas.txtApellidoBuscar.getText();
			String equipoBusc=(String)miVistaFichas.comboBoxSelecEquipo.getSelectedItem();
			
			Jugadores_AD jugadorAD=new Jugadores_AD();
			Jugadores_TD jugador;
			
			jugador=jugadorAD.BuscarJugador(nombreBusc, apellidoBusc, equipoBusc);
			cod_jugador=jugador.getCod_jugador();
			
			miVistaFichas.btnGuardar.setEnabled(true);
			miVistaFichas.txtNombre.setEnabled(true);
			miVistaFichas.txtApellido.setEnabled(true);
			miVistaFichas.txtEquipo.setEnabled(true);
			//miVistaFichas.txtFecha.setEnabled(true);
			miVistaFichas.txtPosicion.setEnabled(true);
			miVistaFichas.txtDorsal.setEnabled(true);
			miVistaFichas.txtObservaciones.setEnabled(true);
			
//			miVistaFichas.txtNombre.setEditable(true);
//			miVistaFichas.txtApellido.setEditable(true);
//			miVistaFichas.txtEquipo.setEditable(true);
//			miVistaFichas.txtPosicion.setEditable(true);
//			miVistaFichas.txtDorsal.setEditable(true);
			
		}
		
		if (e.getSource()==miVistaFichas.btnGuardar) {
			
			String nombreBusc=miVistaFichas.txtNombreBuscar.getText();
			String apellidoBusc=miVistaFichas.txtApellidoBuscar.getText();
			String equipoBusc=(String)miVistaFichas.comboBoxSelecEquipo.getSelectedItem();
			
			Jugadores_AD jugadorAD=new Jugadores_AD();
			Jugadores_TD jugador;
			
			String nombre=miVistaFichas.txtNombre.getText();
			String apellido=miVistaFichas.txtApellido.getText();
			String equipo=miVistaFichas.txtEquipo.getText();
			String posicion=miVistaFichas.txtPosicion.getText();
			int dorsal=Integer.parseInt(miVistaFichas.txtDorsal.getText());
			String observaciones=miVistaFichas.txtObservaciones.getText();
			boolean accion=jugadorAD.ModificaJugador(cod_jugador, nombre, apellido, equipo, posicion, dorsal,observaciones);
			if (accion==true)
				JOptionPane.showMessageDialog(null, "Modificación realizada correctamente");
			else
				JOptionPane.showMessageDialog(null, "ERROR! Modificación realizada incorrectamente");
			
			
		}
		
		if (e.getSource()==miVistaFichas.btnInsert) {
			Jugadores_AD jugadorAD=new Jugadores_AD();
			String nombre_nuevo=miVistaFichas.txtNombre.getText();
			String apellido_nuevo=miVistaFichas.txtApellido.getText();
			String equipo_nuevo=miVistaFichas.txtEquipo.getText();
			String posicion_nuevo=miVistaFichas.txtPosicion.getText();
			String dorsal_comprobacion=miVistaFichas.txtDorsal.getText();
			int dorsal=Integer.parseInt(miVistaFichas.txtDorsal.getText());
			String observaciones=miVistaFichas.txtObservaciones.getText();
			if (nombre_nuevo!="" && apellido_nuevo!="" && equipo_nuevo!="" && posicion_nuevo!="" && dorsal_comprobacion!=null) {
				jugadorAD.InsertaJugador(nombre_nuevo, apellido_nuevo, equipo_nuevo, posicion_nuevo, dorsal, observaciones);
				JOptionPane.showMessageDialog(null, "Nuevo jugador insertado");
			} else
				JOptionPane.showMessageDialog(null, "Introduzca todos los parámetros");
		}
		
		if (e.getSource()==miVistaFichas.btnBorrar) {
			Jugadores_AD jugadorAD=new Jugadores_AD();
			boolean comprobar=jugadorAD.EliminaJugador(miVistaFichas.txtNombre.getText(), miVistaFichas.txtApellido.getText(), miVistaFichas.txtEquipo.getText());
			if (comprobar==true) {
				JOptionPane.showMessageDialog(null, "Jugador Eliminado");
			} else
				JOptionPane.showMessageDialog(null, "Error al eliminar, revise parámetros");
		}
		
		
		
		if (e.getSource()==miVistaPartidos.mntmFichas) {
			miVistaPartidos.setVisible(false);
			miVistaFichas.setVisible(true);
		}
		
		if (e.getSource()==miVistaPartidos.mntmEstadisticas) {
			miVistaPartidos.setVisible(false);
			miVistaEstadisticas.setVisible(true);
		}
		
		if (e.getSource()==miVistaPartidos.mntmGestionEquipos) {
			miVistaPartidos.setVisible(false);
			miVistaGestionEquipos.setVisible(true);
		}
		
		if (e.getSource()==miVistaPartidos.mntmConvocatorias) {
			miVistaPartidos.setVisible(false);
			miVistaConvocatorias.setVisible(true);
		}
		
		if (e.getSource()==miVistaPartidos.mntmMensajes) {
			miVistaPartidos.setVisible(false);
			miVistaMensajes.setVisible(true);
		}
		if (e.getSource()==miVistaPartidos.mntmCuotasJugadores) {
			miVistaPartidos.setVisible(false);
			miVistaCuotas.setVisible(true);
		}
		if (e.getSource()==miVistaPartidos.mntmPlanificacionSesiones) {
			miVistaPartidos.setVisible(false);
			miVistaSesion.setVisible(true);
		}
		if (e.getSource()==miVistaPartidos.mntmPartidos) {
			miVistaPartidos.setVisible(false);
			miVistaPartidos.setVisible(true);
		}
		if (e.getSource()==miVistaPartidos.btnInsert) {
			Partidos_AD partidosAD = new Partidos_AD();
			Partidos_TD partido=null;
			Clasificacion_AD clasificacion = new Clasificacion_AD();
			
			String eq_local=miVistaPartidos.txtLocal.getText();
			String eq_visit=miVistaPartidos.txtVisit.getText();
			int gol_local=miVistaPartidos.sliderLocal.getValue();
			int gol_visit=miVistaPartidos.sliderVisit.getValue();
			String liga=miVistaPartidos.txtLiga.getText();
			
			clasificacion.ActualizaClasificacion(eq_local, eq_visit, gol_local, gol_visit);
			
			if (eq_local!="" && eq_visit!="" && liga!="") {
				boolean comprobar=partidosAD.InsertaPartido(eq_local, eq_visit, gol_local, gol_visit, liga);
				if (comprobar==true) {
					JOptionPane.showMessageDialog(null, "PARTIDO INSERTADO");
				}else
					JOptionPane.showMessageDialog(null, "PARTIDO NO INSERTADO");
			}else
				JOptionPane.showMessageDialog(null, "RELLENE TODOS LOS CAMPOS");

			
		}
		
	}

	
}
