package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private VistaAsistencias miVistaAsistencias;
	private VistaEstadisticas miVistaEstadisticas;
	private VistaGestionEquipos miVistaGestionEquipos;
	private VistaAñadirEquipo miVistaAñadirEquipo;
	private VistaPartidosDisputados miVistaPartidosDisputados;
	private VistaFichaPartidos miVistaFichaPartidos;
	private VistaConvocatorias miVistaConvocatorias;
	private VistaMensajes miVistaMensajes;
	
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
	
	int cod_jugador=0;
	
	public Controlador(VistaLogin miVistaLogin, VistaRegistro miVistaRegistro, VistaPrincipal miVistaPrincipal, VistaFichas miVistaFichas,VistaAsistencias miVistaAsistencias,VistaEstadisticas miVistaEstadisticas,VistaGestionEquipos miVistaGestionEquipos, VistaAñadirEquipo miVistaAñadirEquipo, VistaPartidosDisputados miVistaPartidosDisputados, VistaConvocatorias miVistaConvocatorias, VistaFichaPartidos miVistaFichaPartidos, VistaMensajes miVistaMensajes) {
		
		this.miVistaLogin=miVistaLogin;
		this.miVistaRegistro=miVistaRegistro;
		this.miVistaPrincipal=miVistaPrincipal;
		this.miVistaFichas=miVistaFichas;
		this.miVistaAsistencias=miVistaAsistencias;
		this.miVistaEstadisticas=miVistaEstadisticas;
		this.miVistaGestionEquipos=miVistaGestionEquipos;
		this.miVistaAñadirEquipo=miVistaAñadirEquipo;
		this.miVistaPartidosDisputados=miVistaPartidosDisputados;
		this.miVistaFichaPartidos=miVistaFichaPartidos;
		this.miVistaConvocatorias=miVistaConvocatorias;
		this.miVistaMensajes=miVistaMensajes;
		
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
		
		miVistaFichas.btnCerrarSesion.addActionListener(this);
		miVistaFichas.mntmInicio.addActionListener(this);
		miVistaFichas.mntmEstadisticas.addActionListener(this);
		miVistaFichas.mntmAsistencia.addActionListener(this);
		miVistaFichas.mntmGestionEquipos.addActionListener(this);
		miVistaFichas.mntmPartidosDisputados.addActionListener(this);
		miVistaFichas.mntmConvocatorias.addActionListener(this);
		miVistaFichas.comboBoxSelecEquipo.addActionListener(this);
		miVistaFichas.btnBuscar.addActionListener(this);
		miVistaFichas.btnGuardar.addActionListener(this);
		miVistaFichas.btnModificar.addActionListener(this);
		miVistaFichas.btnInsert.addActionListener(this);
		miVistaFichas.btnBorrar.addActionListener(this);
		
		miVistaGestionEquipos.btnCerrarSesion.addActionListener(this);
		miVistaGestionEquipos.mntmInicio.addActionListener(this);
		miVistaGestionEquipos.mntmFichas.addActionListener(this);
		miVistaGestionEquipos.mntmAsistencia.addActionListener(this);
		miVistaGestionEquipos.mntmEstadisticas.addActionListener(this);
		miVistaGestionEquipos.mntmGestionEquipos.addActionListener(this);
		miVistaGestionEquipos.mntmPartidosDisputados.addActionListener(this);
		miVistaGestionEquipos.mntmConvocatorias.addActionListener(this);
		miVistaGestionEquipos.comboBoxSelecEquipo.addActionListener(this);
		miVistaGestionEquipos.btnMostrarEquipo.addActionListener(this);
		miVistaGestionEquipos.btnAgregarEquipo.addActionListener(this);
		
		miVistaAñadirEquipo.btnVolver.addActionListener(this);
		miVistaAñadirEquipo.btnGuardar.addActionListener(this);
		
		miVistaMensajes.btnEnviar.addActionListener(this);
		
		miVistaEstadisticas.btnBuscar.addActionListener(this);
		
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
				ArrayListPartidos=miPartidosAD.BuscaPartidosEquipo("SENIOR");
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
			boolean accion=jugadorAD.ModificaJugador(cod_jugador, nombre, apellido, equipo, posicion, dorsal);
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
			if (nombre_nuevo!="" && apellido_nuevo!="" && equipo_nuevo!="" && equipo_nuevo!="" && dorsal_comprobacion!=null) {
				jugadorAD.InsertaJugador(nombre_nuevo, apellido_nuevo, equipo_nuevo, posicion_nuevo, dorsal);
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
			
			miVistaGestionEquipos.textAreaPartidosEquipo.setText("");
			miVistaGestionEquipos.textAreaDatosEquipo.setText("");
			miVistaGestionEquipos.textAreaJugadores.setText("");
			
			String seleccion =  (String) miVistaGestionEquipos.comboBoxSelecEquipo.getSelectedItem();
			
			miVistaGestionEquipos.lblInformativo.setText("MOSTRANDO INFORMACIÓN DE EQUIPO "+seleccion);

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
		if (e.getSource()==miVistaEstadisticas.btnBuscar) {
			
			Estadisticas_AD estadisticas = new Estadisticas_AD();
			ArrayList <Estadisticas_TD> miArrayListEstad=new ArrayList <Estadisticas_TD> ();
			miArrayListEstad=estadisticas.MuestraALLEStad();
			Iterator listIteratorEst = miArrayListEstad.listIterator();	
			int acumEst=1;
			while(listIteratorEst.hasNext() || acumEst<=24) {
				Estadisticas_TD estadistica;
				estadistica=miArrayListEstad.get(acumEst);
				int codigo=estadistica.getCod_jugador();
				int partidos=estadistica.getPartidos_jug();
				int goles=estadistica.getGoles();
				int asistencias=estadistica.getAsistencias();
				int amarillas=estadistica.getTarjetas_amarillas();
				int rojas=estadistica.getTarjetas_rojas();
				miVistaEstadisticas.tableEstadisticas.getModel().setValueAt(codigo, acumEst, 0);
				miVistaEstadisticas.tableEstadisticas.getModel().setValueAt(partidos, acumEst, 1);
				miVistaEstadisticas.tableEstadisticas.getModel().setValueAt(goles, acumEst, 2);
				miVistaEstadisticas.tableEstadisticas.getModel().setValueAt(asistencias, acumEst, 3);
				miVistaEstadisticas.tableEstadisticas.getModel().setValueAt(amarillas, acumEst, 4);
				miVistaEstadisticas.tableEstadisticas.getModel().setValueAt(rojas, acumEst, 5);
				listIteratorEst.next();
				acumEst++;
			}
		}
		
	}

	
}
