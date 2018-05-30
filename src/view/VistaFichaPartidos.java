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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Box;

public class VistaFichaPartidos extends JFrame{

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
	public JCalendar calendar;
	public String stringFecha;
	public JComboBox comboBoxSelecEquipo;
	public JComboBox comboBoxSelecMes;
	public String equipoSeleccionado;
	public String mesSeleccionado;
	public JButton btnVolver;
	public JButton btnEliminaPartido;
	public JButton btnGuardar;
	public JTable tableResultado;
	public JTextField txtFecha;
	public JTextField txtContrario2;
	public JTextField txtContrario;
	public JTextField textHora;
	public JTextField txtLugar;
	public JTextField txtJornada;
	public JTextField txtResulLocal;
	public JTextField txtResulVisitante;

public VistaFichaPartidos() {
		
		setResizable(false);
		
		int CentrarAncho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int CentrarAlto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		int alto=720;
		int ancho=1080;
	
		super.setBounds(((CentrarAncho / 2) - 540), ((CentrarAlto / 2) - 360), ancho, alto);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		setTitle("SportClubData - GESTION DE EQUIPOS");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/Repositorios/icon-soccer/047-stopwatch.png"));
		
		super.setContentPane(panel);
		
		lblUser = new JLabel("");
		lblUser.setBounds(800, 0, 260, 21);
		lblUser.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		
		menuPrincipal = new JMenuBar();
		menuPrincipal.setBounds(0, 0, 1080, 21);
		menuPrincipal.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		
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
		
		//OBTENER IMAGEN DE PLANTILLA
		ImageIcon imgPlantilla = new ImageIcon("src/Repositorios/fotoPlantillaATM.jpg");
		
		comboBoxSelecEquipo = new JComboBox();
		comboBoxSelecEquipo.setBounds(35, 150, 248, 40);
		comboBoxSelecEquipo.setFocusable(false);
		comboBoxSelecEquipo.setFocusTraversalKeysEnabled(false);
		comboBoxSelecEquipo.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Seleccione Equipo", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		comboBoxSelecEquipo.setModel(new DefaultComboBoxModel(new String[] {"- SENIOR", "- JUVENIL A", "- JUVENIL B", "- CADETE A", "- CADETE B", "- INFANTIL A", "- INFANTIL B", "- ALEVIN A", "- ALEVIN B", "- BENJAMIN A", "- BENJAMIN B"}));
		
		JLabel lblTituloventana = new JLabel("FICHA DE PARTIDO");
		lblTituloventana.setBounds(35, 40, 248, 20);
		lblTituloventana.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		lblTituloventana.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(945, 40, 100, 25);
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		btnVolver.setFocusable(false);
		btnVolver.setFocusPainted(false);
		btnVolver.setDefaultCapable(false);
		btnVolver.setBackground(SystemColor.activeCaption);
		btnVolver.setVerticalAlignment(SwingConstants.TOP);
		btnVolver.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		
		btnEliminaPartido = new JButton("ELIMINAR PARTIDO");
		btnEliminaPartido.setBounds(770, 40, 160, 25);
		btnEliminaPartido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminaPartido.setFocusable(false);
		btnEliminaPartido.setFocusPainted(false);
		btnEliminaPartido.setDefaultCapable(false);
		btnEliminaPartido.setBackground(SystemColor.activeCaption);
		btnEliminaPartido.setVerticalAlignment(SwingConstants.TOP);
		btnEliminaPartido.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(650, 40, 100, 25);
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setFocusable(false);
		btnGuardar.setFocusPainted(false);
		btnGuardar.setDefaultCapable(false);
		btnGuardar.setBackground(SystemColor.activeCaption);
		btnGuardar.setVerticalAlignment(SwingConstants.TOP);
		btnGuardar.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		
		tableResultado = new JTable();
		tableResultado.setBounds(35, 95, 1010, 30);
		tableResultado.setEnabled(false);
		tableResultado.setRowHeight(30);
		tableResultado.setOpaque(false);
		tableResultado.setRequestFocusEnabled(false);
		tableResultado.setFocusable(false);
		tableResultado.setFocusTraversalKeysEnabled(false);
		tableResultado.setRowSelectionAllowed(false);
		tableResultado.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		tableResultado.setModel(new DefaultTableModel(
			new Object[][] {
				{"-", "-", "-", "-"},
			},
			new String[] {
				"EquipoLocal", "GolesLocal", "GolesVisitante", "EquipoVisitante"
			}
		));
		tableResultado.setBackground(new Color(152, 251, 152));
		tableResultado.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		txtFecha.setBounds(312, 150, 90, 40);
		txtFecha.setOpaque(false);
		txtFecha.setFocusTraversalKeysEnabled(false);
		txtFecha.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Fecha", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		txtFecha.setHorizontalAlignment(SwingConstants.CENTER);
		txtFecha.setText("dd/mm/aaaa");
		txtFecha.setToolTipText("");
		txtFecha.setColumns(10);

		panel.setLayout(null);
		panel.add(lblUser);
		panel.add(menuPrincipal);
		panel.add(comboBoxSelecEquipo);
		panel.add(lblTituloventana);
		panel.add(btnVolver);
		panel.add(btnEliminaPartido);
		panel.add(btnGuardar);
		panel.add(tableResultado);
		panel.add(txtFecha);
		
		txtContrario = new JTextField();
		txtContrario.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		txtContrario.setBounds(442, 152, 250, 40);
		txtContrario.setOpaque(false);
		txtContrario.setFocusTraversalKeysEnabled(false);
		txtContrario.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "EquipoRival", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		txtContrario.setHorizontalAlignment(SwingConstants.LEADING);
		txtContrario.setText("Contrario");
		txtContrario.setToolTipText("");
		txtContrario.setColumns(10);
		panel.add(txtContrario);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		horizontalBox.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Jugando Como", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		horizontalBox.setBounds(710, 150, 150, 40);
		panel.add(horizontalBox);
		
		JRadioButton rdbtnLocal = new JRadioButton("Local");
		rdbtnLocal.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		rdbtnLocal.setRequestFocusEnabled(false);
		rdbtnLocal.setOpaque(false);
		rdbtnLocal.setFocusable(false);
		rdbtnLocal.setFocusPainted(false);
		horizontalBox.add(rdbtnLocal);
		
		JRadioButton rdbtnVisitante = new JRadioButton("Visitante");
		rdbtnVisitante.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		rdbtnVisitante.setMargin(new Insets(2, 10, 2, 2));
		rdbtnVisitante.setFocusPainted(false);
		rdbtnVisitante.setFocusable(false);
		rdbtnVisitante.setOpaque(false);
		rdbtnVisitante.setRequestFocusEnabled(false);
		horizontalBox.add(rdbtnVisitante);
		
		textHora = new JTextField();
		textHora.setOpaque(false);
		textHora.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Hora", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		textHora.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		textHora.setText("hh:mm");
		textHora.setBounds(35, 220, 86, 40);
		panel.add(textHora);
		textHora.setColumns(10);
		
		txtLugar = new JTextField();
		txtLugar.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		txtLugar.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Lugar", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		txtLugar.setFocusTraversalKeysEnabled(false);
		txtLugar.setOpaque(false);
		txtLugar.setText("Lugar");
		txtLugar.setBounds(150, 220, 200, 40);
		panel.add(txtLugar);
		txtLugar.setColumns(10);
		
		txtJornada = new JTextField();
		txtJornada.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		txtJornada.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Jornada", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		txtJornada.setFocusTraversalKeysEnabled(false);
		txtJornada.setOpaque(false);
		txtJornada.setText("Jornada");
		txtJornada.setBounds(380, 220, 200, 40);
		panel.add(txtJornada);
		txtJornada.setColumns(10);
		
		txtResulLocal = new JTextField();
		txtResulLocal.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		txtResulLocal.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Resultado Local", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		txtResulLocal.setFocusTraversalKeysEnabled(false);
		txtResulLocal.setOpaque(false);
		txtResulLocal.setText("Resultado Local");
		txtResulLocal.setBounds(610, 220, 150, 40);
		panel.add(txtResulLocal);
		txtResulLocal.setColumns(10);
		
		txtResulVisitante = new JTextField();
		txtResulVisitante.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		txtResulVisitante.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Resultado Visitante", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		txtResulVisitante.setFocusTraversalKeysEnabled(false);
		txtResulVisitante.setOpaque(false);
		txtResulVisitante.setText("Resultado Visitante");
		txtResulVisitante.setBounds(790, 220, 150, 40);
		panel.add(txtResulVisitante);
		txtResulVisitante.setColumns(10);
		
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
	}
}