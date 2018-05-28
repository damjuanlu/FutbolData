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

public class VistaAsistencias extends JFrame{

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
	public JLabel lblUser;
	public JLabel lblEscudo;
	public JButton btnSelectorEscudo;
	public JLabel lblCumpleaños;
	public JLabel lblEntrenamientos;
	public JLabel lblClasificacion;
	public JLabel lblMensajes;
	public JCalendar calendar;
	public JLabel lblFechaAsistencia;
	public String stringFecha;
	public JComboBox comboBoxSelecEquipo;

public VistaAsistencias() {
		
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
		setTitle("SportClubData - ASISTENCIA");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/Repositorios/icon-soccer/047-stopwatch.png"));
		
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
		
		btnSelectorEscudo = new JButton("...");
		btnSelectorEscudo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSelectorEscudo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSelectorEscudo.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSelectorEscudo.setMargin(new Insets(0, 14, 0, 14));
		btnSelectorEscudo.setToolTipText("Cambia Escudo");
		btnSelectorEscudo.setBounds(1014, 192, 30, 12);
		panel.add(btnSelectorEscudo);
		
		btnSelectorEscudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		lblEscudo = new JLabel("");
		lblEscudo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEscudo.setBounds(880, 40, 165, 165);
		panel.add(lblEscudo);
		
		//OBTENER ESCUDO DEL CLUB
		ImageIcon Escudo = new ImageIcon("src/Repositorios/sinEscudo.png");
		Icon imagenEscudo = new ImageIcon(Escudo.getImage().getScaledInstance(lblEscudo.getWidth(), lblEscudo.getHeight(), Image.SCALE_DEFAULT));
		lblEscudo.setIcon(imagenEscudo);
		
		lblCumpleaños = new JLabel("CUMPLEA\u00D1OS");
		lblCumpleaños.setHorizontalAlignment(SwingConstants.CENTER);
		lblCumpleaños.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCumpleaños.setBounds(880, 235, 165, 200);
		panel.add(lblCumpleaños);
		
		lblEntrenamientos = new JLabel("ENTRENAMIENTOS");
		lblEntrenamientos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrenamientos.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEntrenamientos.setBounds(880, 465, 165, 200);
		panel.add(lblEntrenamientos);
		
		lblClasificacion = new JLabel("CLASIFICACION");
		lblClasificacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasificacion.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblClasificacion.setBounds(312, 60, 539, 395);
		panel.add(lblClasificacion);
		
		// Instanciar Componente
		calendar = new JCalendar();
		calendar.setBorder(new LineBorder(new Color(0, 0, 0)));
		calendar.getMonthChooser().getSpinner().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendar.getYearChooser().getSpinner().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendar.getMonthChooser().getComboBox().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendar.getDayChooser().getDayPanel().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendar.setWeekOfYearVisible(false);
		calendar.setBounds(35, 40, 248, 180);
		panel.add(calendar);
		Date fecha = calendar.getDate();
		stringFecha = DateFormat.getDateInstance().format(fecha);
		
		lblMensajes = new JLabel("MENSAJES");
		lblMensajes.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMensajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajes.setBounds(35, 465, 816, 200);
		panel.add(lblMensajes);
		
		comboBoxSelecEquipo = new JComboBox();
		comboBoxSelecEquipo.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Seleccione equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		comboBoxSelecEquipo.setModel(new DefaultComboBoxModel(new String[] {"SENIOR", "JUVENIL A", "JUVENIL B", "CADETE A", "CADETE B", "INFANTIL A", "INFANTIL B", "ALEVIN A", "ALEVIN B", "BENJAMIN A", "BENJAMIN B"}));
		comboBoxSelecEquipo.setBounds(35, 255, 248, 40);
		panel.add(comboBoxSelecEquipo);
		
		lblFechaAsistencia = new JLabel("Asistencia correspondiente a lunes, "+stringFecha);
		lblFechaAsistencia.setBackground(Color.WHITE);
		lblFechaAsistencia.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		lblFechaAsistencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaAsistencia.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblFechaAsistencia.setBounds(312, 40, 539, 20);
		panel.add(lblFechaAsistencia);
		
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
		
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
			}
		});
	}
}
