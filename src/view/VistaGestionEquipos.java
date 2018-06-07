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
import javax.swing.JSeparator;

public class VistaGestionEquipos extends JFrame{

	public JPanel panel;
	public JMenuBar menuPrincipal;
	public JMenuItem mntmInicio;
	public JMenu mnJugadores;
	public JMenuItem mntmFichas;
	public JMenuItem mntmEstadisticas;
	public JMenu mnCompeticion;
	public JMenuItem mntmGestionEquipos;
	public JMenuItem mntmConvocatorias;
	public JMenu mnEntrenamiento;
	public JMenuItem mntmPlanificacionSesiones;
	public JMenuItem mntmBaseDeDatos;
	public JMenu mnAdministracion;
	public JMenuItem mntmCuotasJugadores;
	public JMenu mnMensajes;
	public JMenuItem mntmMensajes;
	public JButton btnCerrarSesion;
	public JButton btnMostrarEquipo;
	public JButton btnAgregarEquipo;
	public JButton btnEliminarEquipo;
	public JLabel lblUser;
	public JLabel lblFotoPlantilla;
	public JCalendar calendar;
	public JTextArea textAreaJugadores;
	public JTextArea textAreaPartidosEquipo;
	public JLabel lblInformativo;
	public String stringFecha;
	public JComboBox comboBoxSelecEquipo;
	public JComboBox comboBoxSelecMes;
	public String equipoSeleccionado;
	public String mesSeleccionado;
	public JTextArea textAreaDatosEquipo;
	private JSeparator separator;
	public JButton btnInformeEquipo;

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
		mntmInicio.setFont(new Font("Agency FB", Font.BOLD, 15));
		mntmInicio.setHorizontalAlignment(SwingConstants.CENTER);
		menuPrincipal.add(mntmInicio);
		
		mnJugadores = new JMenu("JUGADORES");
		mnJugadores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		mnJugadores.setMargin(new Insets(2, 10, 0, 10));
		mnJugadores.setFont(new Font("Agency FB", Font.BOLD, 15));
		menuPrincipal.add(mnJugadores);
		
		mntmFichas = new JMenuItem("FICHAS");
		mntmFichas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmFichas.setFont(new Font("Agency FB", Font.BOLD, 15));
		mnJugadores.add(mntmFichas);
		
		mntmEstadisticas = new JMenuItem("ESTAD\u00CDSTICAS");
		mntmEstadisticas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmEstadisticas.setFont(new Font("Agency FB", Font.BOLD, 15));
		mnJugadores.add(mntmEstadisticas);
		
		mnCompeticion = new JMenu("COMPETICI\u00D3N");
		mnCompeticion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnCompeticion.setHorizontalAlignment(SwingConstants.CENTER);
		mnCompeticion.setMargin(new Insets(2, 10, 0, 10));
		mnCompeticion.setFont(new Font("Agency FB", Font.BOLD, 15));
		menuPrincipal.add(mnCompeticion);
		
		mntmGestionEquipos = new JMenuItem("GESTI\u00D3N EQUIPOS");
		mntmGestionEquipos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmGestionEquipos.setFont(new Font("Agency FB", Font.BOLD, 15));
		mnCompeticion.add(mntmGestionEquipos);
		
		mntmConvocatorias = new JMenuItem("CONVOCATORIAS");
		mntmConvocatorias.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmConvocatorias.setFont(new Font("Agency FB", Font.BOLD, 15));
		mnCompeticion.add(mntmConvocatorias);
		
		mnEntrenamiento = new JMenu("ENTRENAMIENTO");
		mnEntrenamiento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnEntrenamiento.setHorizontalAlignment(SwingConstants.CENTER);
		mnEntrenamiento.setMargin(new Insets(2, 10, 0, 10));
		mnEntrenamiento.setFont(new Font("Agency FB", Font.BOLD, 15));
		menuPrincipal.add(mnEntrenamiento);
		
		mntmPlanificacionSesiones = new JMenuItem("PLANIFICACI\u00D3N SESIONES");
		mntmPlanificacionSesiones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmPlanificacionSesiones.setFont(new Font("Agency FB", Font.BOLD, 15));
		mnEntrenamiento.add(mntmPlanificacionSesiones);
		
		mntmBaseDeDatos = new JMenuItem("BASE DE DATOS EJERCICIOS");
		mntmBaseDeDatos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmBaseDeDatos.setFont(new Font("Agency FB", Font.BOLD, 15));
		mnEntrenamiento.add(mntmBaseDeDatos);
		
		mnAdministracion = new JMenu("ADMINISTRACI\u00D3N");
		mnAdministracion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnAdministracion.setHorizontalAlignment(SwingConstants.CENTER);
		mnAdministracion.setMargin(new Insets(2, 10, 0, 10));
		mnAdministracion.setFont(new Font("Agency FB", Font.BOLD, 15));
		menuPrincipal.add(mnAdministracion);
		
		mntmCuotasJugadores = new JMenuItem("CUOTAS JUGADORES");
		mntmCuotasJugadores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmCuotasJugadores.setFont(new Font("Agency FB", Font.BOLD, 15));
		mnAdministracion.add(mntmCuotasJugadores);
		
		mnMensajes = new JMenu("MENSAJES");
		mnMensajes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMensajes.setHorizontalAlignment(SwingConstants.CENTER);
		mnMensajes.setMargin(new Insets(2, 10, 0, 10));
		mnMensajes.setFont(new Font("Agency FB", Font.BOLD, 15));
		menuPrincipal.add(mnMensajes);
		
		mntmMensajes = new JMenuItem("MENSAJES");
		mntmMensajes.setFont(new Font("Agency FB", Font.BOLD, 15));
		mnMensajes.add(mntmMensajes);
		
		btnCerrarSesion = new JButton("CERRAR SESI\u00D3N");
		btnCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrarSesion.setFocusable(false);
		btnCerrarSesion.setDefaultCapable(false);
		btnCerrarSesion.setFocusPainted(false);
		btnCerrarSesion.setAlignmentX(Component.CENTER_ALIGNMENT);
		menuPrincipal.add(btnCerrarSesion);
		btnCerrarSesion.setFont(new Font("Agency FB", Font.BOLD, 15));
		
		lblFotoPlantilla = new JLabel("");
		lblFotoPlantilla.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFotoPlantilla.setBounds(640, 211, 405, 255);
		panel.add(lblFotoPlantilla);
		
		//OBTENER IMAGEN DE PLANTILLA
		ImageIcon imgPlantilla = new ImageIcon("src/Repositorios/fotoPlantillaATM.jpg");
		Icon imagenPlantilla = new ImageIcon(imgPlantilla.getImage().getScaledInstance(lblFotoPlantilla.getWidth(), lblFotoPlantilla.getHeight(), Image.SCALE_DEFAULT));
		lblFotoPlantilla.setIcon(imagenPlantilla);
		
		comboBoxSelecEquipo = new JComboBox();
		comboBoxSelecEquipo.setFont(new Font("Agency FB", Font.BOLD, 15));
		comboBoxSelecEquipo.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Seleccione Equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		comboBoxSelecEquipo.setModel(new DefaultComboBoxModel(new String[] {"SENIOR", "JUVENIL", "CADETE", "INFANTIL", "ALEVIN", "BENJAMIN"}));
		comboBoxSelecEquipo.setBounds(35, 101, 248, 40);
		panel.add(comboBoxSelecEquipo);
		
		lblInformativo = new JLabel("SELECCIONA EQUIPO A MOSTRAR");
		lblInformativo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblInformativo.setToolTipText("");
		lblInformativo.setOpaque(true);
		lblInformativo.setFocusable(false);
		lblInformativo.setForeground(Color.WHITE);
		//lblInformativo.setIcon(new ImageIcon(VistaFichas.class.getResource("/Repositorios/lblInformativo.jpg")));
		lblInformativo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblInformativo.setBackground(new Color(144, 238, 144));
		lblInformativo.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblInformativo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformativo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblInformativo.setBounds(85, 40, 930, 30);
		panel.add(lblInformativo);
		
		ImageIcon imgCabecera = new ImageIcon(VistaFichas.class.getResource("/Repositorios/lblInformativo.jpg"));
		Icon imagenCabecera = new ImageIcon(imgCabecera.getImage().getScaledInstance(lblInformativo.getWidth(), imgCabecera.getIconHeight(), Image.SCALE_DEFAULT));
		lblInformativo.setIcon(imagenCabecera);
		
		JLabel lblTituloventana = new JLabel("EQUIPOS");
		lblTituloventana.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		lblTituloventana.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloventana.setBounds(35, 40, 248, 20);
		panel.add(lblTituloventana);
		
		btnInformeEquipo = new JButton("INFORME");
		btnInformeEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInformeEquipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInformeEquipo.setFocusable(false);
		btnInformeEquipo.setFocusPainted(false);
		btnInformeEquipo.setDefaultCapable(false);
		btnInformeEquipo.setBackground(SystemColor.activeCaption);
		btnInformeEquipo.setVerticalAlignment(SwingConstants.TOP);
		btnInformeEquipo.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnInformeEquipo.setBounds(945, 116, 100, 25);
		panel.add(btnInformeEquipo);
		
		btnAgregarEquipo = new JButton("AGREGAR EQUIPO");
		btnAgregarEquipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarEquipo.setFocusable(false);
		btnAgregarEquipo.setFocusPainted(false);
		btnAgregarEquipo.setDefaultCapable(false);
		btnAgregarEquipo.setBackground(SystemColor.activeCaption);
		btnAgregarEquipo.setVerticalAlignment(SwingConstants.TOP);
		btnAgregarEquipo.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnAgregarEquipo.setBounds(605, 116, 160, 25);
		panel.add(btnAgregarEquipo);
		
		btnEliminarEquipo = new JButton("ELIMINAR EQUIPO");
		btnEliminarEquipo.setEnabled(false);
		btnEliminarEquipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminarEquipo.setFocusable(false);
		btnEliminarEquipo.setFocusPainted(false);
		btnEliminarEquipo.setDefaultCapable(false);
		btnEliminarEquipo.setBackground(new Color(255, 0, 0));
		btnEliminarEquipo.setVerticalAlignment(SwingConstants.TOP);
		btnEliminarEquipo.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnEliminarEquipo.setBounds(775, 116, 160, 25);
		panel.add(btnEliminarEquipo);
		
		btnMostrarEquipo = new JButton("MOSTRAR EQUIPO");
		btnMostrarEquipo.setVerticalAlignment(SwingConstants.TOP);
		btnMostrarEquipo.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnMostrarEquipo.setFocusable(false);
		btnMostrarEquipo.setFocusPainted(false);
		btnMostrarEquipo.setDefaultCapable(false);
		btnMostrarEquipo.setBackground(SystemColor.activeCaption);
		btnMostrarEquipo.setBounds(336, 115, 160, 25);
		panel.add(btnMostrarEquipo);
		
		textAreaJugadores = new JTextArea();
		textAreaJugadores.setFont(new Font("Agency FB", Font.PLAIN, 15));
		textAreaJugadores.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textAreaJugadores.setFocusable(false);
		textAreaJugadores.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaJugadores.setBounds(35, 211, 260, 434);
		panel.add(textAreaJugadores);
		
		textAreaPartidosEquipo = new JTextArea();
		textAreaPartidosEquipo.setFont(new Font("Agency FB", Font.PLAIN, 15));
		textAreaPartidosEquipo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textAreaPartidosEquipo.setFocusable(false);
		textAreaPartidosEquipo.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaPartidosEquipo.setBounds(336, 211, 260, 434);
		panel.add(textAreaPartidosEquipo);
		
		textAreaDatosEquipo = new JTextArea();
		textAreaDatosEquipo.setFont(new Font("Agency FB", Font.PLAIN, 15));
		textAreaDatosEquipo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textAreaDatosEquipo.setFocusable(false);
		textAreaDatosEquipo.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaDatosEquipo.setBounds(640, 497, 405, 148);
		panel.add(textAreaDatosEquipo);
		
		separator = new JSeparator();
		separator.setBounds(85, 170, 930, 2);
		panel.add(separator);
		
		JLabel lblImagenFondo = new JLabel("");
		lblImagenFondo.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
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
		
		mntmEstadisticas.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mntmGestionEquipos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mntmConvocatorias.addActionListener(new ActionListener(){
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
		
		mntmMensajes.addActionListener(new ActionListener(){
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
		
		btnAgregarEquipo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
                
            }
		});
		
		btnEliminarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
			}
		});
	}
}
