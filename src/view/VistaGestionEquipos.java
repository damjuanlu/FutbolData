package view;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JCalendar;

import java.util.Date;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;

public class VistaGestionEquipos extends JFrame{

	public JPanel panel;
	public JMenuBar menuPrincipal;
	public JMenuItem mntmInicio;
	public JMenu mnJugadores;
	public JMenuItem mntmFichas;
	public JMenuItem mntmAsistencia;
	public JMenuItem mntmEstadisticas;
	public JMenu mnCompeticion;
	public JMenuItem mntmGestionEquipos;
	public JMenuItem mntmPartidosDisputados;
	public JMenuItem mntmConvocatorias;
	public JMenuItem mntmCalendariosYResultados;
	public JMenu mnEntrenamiento;
	public JMenuItem mntmPlanificacionSesiones;
	public JMenuItem mntmBaseDeDatos;
	public JMenu mnAdministracion;
	public JMenuItem mntmCuotasJugadores;
	public JMenu mnAyuda;
	public JMenuItem mntmUsuario;
	public JMenuItem mntmContacto;
	public JMenuItem mntmAcercaDe;
	public JButton btnCerrarSesion;
	public JButton btnMostrarEquipo;
	public JLabel lblUser;
	public JLabel lblFotoPlantilla;
	public JCalendar calendar;
	public JTextArea textAreaJugadores;
	public JTextArea textAreaDatosEquipo;
	public JLabel lblFechaAsistencia;
	public String stringFecha;
	public JComboBox comboBoxSelecEquipo;
	public JComboBox comboBoxSelecMes;
	public String equipoSeleccionado;
	public String mesSeleccionado;
	private JLabel lblDatosPartidos;

public VistaGestionEquipos() {
		
		setResizable(false);
		
		int CentrarAncho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int CentrarAlto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		int alto=720;
		int ancho=1080;
	
		super.setBounds(((CentrarAncho / 2) - 540), ((CentrarAlto / 2) - 360), ancho, alto);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setLayout(null);
		setTitle("SportClubData - GESTION DE EQUIPOS");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/Repositorios/logoSCD_32x32.png"));
		
		super.setContentPane(panel);
		
		lblUser = new JLabel("");
		lblUser.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setBounds(800, 0, 260, 21);
		panel.add(lblUser);
		
		menuPrincipal = new JMenuBar();
		menuPrincipal.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		menuPrincipal.setBounds(0, 0, ancho, 21);
		panel.add(menuPrincipal);
		
		mntmInicio = new JMenuItem("INICIO");
		mntmInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmInicio.setMaximumSize(new Dimension(60, 32767));
		mntmInicio.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mntmInicio.setHorizontalAlignment(SwingConstants.CENTER);
		menuPrincipal.add(mntmInicio);
		
		mnJugadores = new JMenu("JUGADORES");
		mnJugadores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		mnJugadores.setMargin(new Insets(2, 10, 0, 10));
		mnJugadores.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		menuPrincipal.add(mnJugadores);
		
		mntmFichas = new JMenuItem("FICHAS");
		mntmFichas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmFichas.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnJugadores.add(mntmFichas);
		
		mntmAsistencia = new JMenuItem("ASISTENCIA");
		mntmAsistencia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmAsistencia.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnJugadores.add(mntmAsistencia);
		
		mntmEstadisticas = new JMenuItem("ESTAD\u00CDSTICAS");
		mntmEstadisticas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmEstadisticas.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnJugadores.add(mntmEstadisticas);
		
		mnCompeticion = new JMenu("COMPETICI\u00D3N");
		mnCompeticion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnCompeticion.setHorizontalAlignment(SwingConstants.CENTER);
		mnCompeticion.setMargin(new Insets(2, 10, 0, 10));
		mnCompeticion.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		menuPrincipal.add(mnCompeticion);
		
		mntmGestionEquipos = new JMenuItem("GESTI\u00D3N EQUIPOS");
		mntmGestionEquipos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmGestionEquipos.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnCompeticion.add(mntmGestionEquipos);
		
		mntmPartidosDisputados = new JMenuItem("PARTIDOS DISPUTADOS");
		mntmPartidosDisputados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmPartidosDisputados.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnCompeticion.add(mntmPartidosDisputados);
		
		mntmConvocatorias = new JMenuItem("CONVOCATORIAS");
		mntmConvocatorias.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmConvocatorias.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnCompeticion.add(mntmConvocatorias);
		
		mntmCalendariosYResultados = new JMenuItem("CALENDARIOS Y RESULTADOS");
		mntmCalendariosYResultados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmCalendariosYResultados.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnCompeticion.add(mntmCalendariosYResultados);
		
		mnEntrenamiento = new JMenu("ENTRENAMIENTO");
		mnEntrenamiento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnEntrenamiento.setHorizontalAlignment(SwingConstants.CENTER);
		mnEntrenamiento.setMargin(new Insets(2, 10, 0, 10));
		mnEntrenamiento.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		menuPrincipal.add(mnEntrenamiento);
		
		mntmPlanificacionSesiones = new JMenuItem("PLANIFICACI\u00D3N SESIONES");
		mntmPlanificacionSesiones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmPlanificacionSesiones.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnEntrenamiento.add(mntmPlanificacionSesiones);
		
		mntmBaseDeDatos = new JMenuItem("BASE DE DATOS EJERCICIOS");
		mntmBaseDeDatos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmBaseDeDatos.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnEntrenamiento.add(mntmBaseDeDatos);
		
		mnAdministracion = new JMenu("ADMINISTRACI\u00D3N");
		mnAdministracion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnAdministracion.setHorizontalAlignment(SwingConstants.CENTER);
		mnAdministracion.setMargin(new Insets(2, 10, 0, 10));
		mnAdministracion.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		menuPrincipal.add(mnAdministracion);
		
		mntmCuotasJugadores = new JMenuItem("CUOTAS JUGADORES");
		mntmCuotasJugadores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmCuotasJugadores.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnAdministracion.add(mntmCuotasJugadores);
		
		mnAyuda = new JMenu("AYUDA");
		mnAyuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnAyuda.setHorizontalAlignment(SwingConstants.CENTER);
		mnAyuda.setMargin(new Insets(2, 10, 0, 10));
		mnAyuda.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		menuPrincipal.add(mnAyuda);
		
		mntmUsuario = new JMenuItem("USUARIO");
		mntmUsuario.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnAyuda.add(mntmUsuario);
		
		mntmContacto = new JMenuItem("CONTACTO");
		mntmContacto.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnAyuda.add(mntmContacto);
		
		mntmAcercaDe = new JMenuItem("ACERCA DE ...");
		mntmAcercaDe.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnAyuda.add(mntmAcercaDe);
		
		btnCerrarSesion = new JButton("CERRAR SESI\u00D3N");
		btnCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrarSesion.setFocusable(false);
		btnCerrarSesion.setDefaultCapable(false);
		btnCerrarSesion.setFocusPainted(false);
		btnCerrarSesion.setAlignmentX(Component.CENTER_ALIGNMENT);
		menuPrincipal.add(btnCerrarSesion);
		btnCerrarSesion.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		
		lblFotoPlantilla = new JLabel("");
		lblFotoPlantilla.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFotoPlantilla.setBounds(640, 150, 405, 255);
		panel.add(lblFotoPlantilla);
		
		//OBTENER IMAGEN DE PLANTILLA
		ImageIcon imgPlantilla = new ImageIcon("src/Repositorios/fotoPlantillaATM.jpg");
		Icon imagenPlantilla = new ImageIcon(imgPlantilla.getImage().getScaledInstance(lblFotoPlantilla.getWidth(), lblFotoPlantilla.getHeight(), Image.SCALE_DEFAULT));
		lblFotoPlantilla.setIcon(imagenPlantilla);
		
		comboBoxSelecEquipo = new JComboBox();
		comboBoxSelecEquipo.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Seleccione Equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		comboBoxSelecEquipo.setModel(new DefaultComboBoxModel(new String[] {"SENIOR", "JUVENIL", "CADETE", "INFANTIL", "ALEVIN", "BENJAMIN"}));
		comboBoxSelecEquipo.setBounds(35, 85, 248, 40);
		panel.add(comboBoxSelecEquipo);
		
		lblFechaAsistencia = new JLabel(equipoSeleccionado);
		lblFechaAsistencia.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFechaAsistencia.setOpaque(true);
		lblFechaAsistencia.setBackground(new Color(144, 238, 144));
		lblFechaAsistencia.setFont(new Font("Palatino Linotype", Font.PLAIN, 14));
		lblFechaAsistencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaAsistencia.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblFechaAsistencia.setBounds(312, 95, 733, 30);
		panel.add(lblFechaAsistencia);
		
		JLabel lblTituloventana = new JLabel("EQUIPOS");
		lblTituloventana.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		lblTituloventana.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloventana.setBounds(35, 40, 248, 20);
		panel.add(lblTituloventana);
		
		JButton btnInformeEquipo = new JButton("INFORME");
		btnInformeEquipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInformeEquipo.setFocusable(false);
		btnInformeEquipo.setFocusPainted(false);
		btnInformeEquipo.setDefaultCapable(false);
		btnInformeEquipo.setBackground(SystemColor.activeCaption);
		btnInformeEquipo.setVerticalAlignment(SwingConstants.TOP);
		btnInformeEquipo.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		btnInformeEquipo.setBounds(945, 40, 100, 25);
		panel.add(btnInformeEquipo);
		
		JButton btnModificarEquipo = new JButton("MODIFICAR DATOS");
		btnModificarEquipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificarEquipo.setFocusable(false);
		btnModificarEquipo.setFocusPainted(false);
		btnModificarEquipo.setDefaultCapable(false);
		btnModificarEquipo.setBackground(SystemColor.activeCaption);
		btnModificarEquipo.setVerticalAlignment(SwingConstants.TOP);
		btnModificarEquipo.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		btnModificarEquipo.setBounds(770, 40, 160, 25);
		panel.add(btnModificarEquipo);
		
		JButton btnAgregarEquipo = new JButton("AGREGAR EQUIPO");
		btnAgregarEquipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarEquipo.setFocusable(false);
		btnAgregarEquipo.setFocusPainted(false);
		btnAgregarEquipo.setDefaultCapable(false);
		btnAgregarEquipo.setBackground(SystemColor.activeCaption);
		btnAgregarEquipo.setVerticalAlignment(SwingConstants.TOP);
		btnAgregarEquipo.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		btnAgregarEquipo.setBounds(590, 40, 160, 25);
		panel.add(btnAgregarEquipo);
		
		JButton btnEliminarEquipo = new JButton("ELIMINAR EQUIPO");
		btnEliminarEquipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminarEquipo.setFocusable(false);
		btnEliminarEquipo.setFocusPainted(false);
		btnEliminarEquipo.setDefaultCapable(false);
		btnEliminarEquipo.setBackground(new Color(255, 0, 0));
		btnEliminarEquipo.setVerticalAlignment(SwingConstants.TOP);
		btnEliminarEquipo.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		btnEliminarEquipo.setBounds(885, 655, 160, 25);
		panel.add(btnEliminarEquipo);
		
		lblDatosPartidos = new JLabel("\u00BF\u00BF\u00BF DATOS DE PARTIDOS ???");
		lblDatosPartidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosPartidos.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDatosPartidos.setBounds(640, 434, 405, 211);
		panel.add(lblDatosPartidos);
		
		btnMostrarEquipo = new JButton("MOSTRAR EQUIPO");
		btnMostrarEquipo.setVerticalAlignment(SwingConstants.TOP);
		btnMostrarEquipo.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		btnMostrarEquipo.setFocusable(false);
		btnMostrarEquipo.setFocusPainted(false);
		btnMostrarEquipo.setDefaultCapable(false);
		btnMostrarEquipo.setBackground(SystemColor.activeCaption);
		btnMostrarEquipo.setBounds(75, 150, 160, 25);
		panel.add(btnMostrarEquipo);
		
		textAreaJugadores = new JTextArea();
		textAreaJugadores.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaJugadores.setBounds(35, 211, 260, 434);
		panel.add(textAreaJugadores);
		
		JTextArea textAreaDatosEquipo = new JTextArea();
		textAreaDatosEquipo.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaDatosEquipo.setBounds(336, 211, 260, 434);
		panel.add(textAreaDatosEquipo);
		
		JLabel lblImagenFondo = new JLabel("");
		lblImagenFondo.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/Repositorios/background1080x720grey.png")));
		lblImagenFondo.setBounds(0, 15, 1080, 680);
		panel.add(lblImagenFondo);
		
		//ACTION LISTENER
		
		mntmInicio.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mntmFichas.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mntmAsistencia.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mntmEstadisticas.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mntmGestionEquipos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mntmPartidosDisputados.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mntmConvocatorias.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mntmCalendariosYResultados.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mntmPlanificacionSesiones.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mntmBaseDeDatos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mntmCuotasJugadores.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mntmUsuario.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mntmContacto.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mntmAcercaDe.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		comboBoxSelecEquipo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
                
            }
		});
		
		btnMostrarEquipo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
                
            }
		});
	}
}
