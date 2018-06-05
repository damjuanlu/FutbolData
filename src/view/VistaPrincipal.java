package view;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class VistaPrincipal extends JFrame{

	private JPanel panel;
	private JMenuBar menuPrincipal;
	private JMenuItem mntmInicio;
	private JMenu mnJugadores;
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
	public JMenu mnMensajes;
	public JMenuItem mntmMensajes;
	public JButton btnCerrarSesion;
	public JLabel lblUser;
	private JLabel lblEscudo;
	public JButton btnSelectorEscudo;
	public JTable tableClasif;
	public JTable tableProximos;
	public JTable tableUltimos;
	private JLabel lblMensajes_1;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JLabel label;
	public JTextArea textArea_2;
	public JTextArea txtAreaMensajes;
	private JLabel lblEntrenamientos;
	private JLabel lblCumpleaosDa;

public VistaPrincipal() {
		
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
		setTitle("SportClubData");
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
		
		mnMensajes = new JMenu("MENSAJES");
		mnMensajes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMensajes.setHorizontalAlignment(SwingConstants.CENTER);
		mnMensajes.setMargin(new Insets(2, 10, 0, 10));
		mnMensajes.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		menuPrincipal.add(mnMensajes);
		
		mntmMensajes = new JMenuItem("MENSAJES");
		mntmMensajes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmMensajes.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnMensajes.add(mntmMensajes);
		
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
		btnSelectorEscudo.setFocusable(false);
		btnSelectorEscudo.setDefaultCapable(false);
		btnSelectorEscudo.setFocusPainted(false);
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
		
		//TABLA CLASIFICACION
		//FALTA CABECERA DE COLUMNAS
		tableClasif = new JTable();
		tableClasif.setRowHeight(18);
		tableClasif.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableClasif.setFocusable(false);
		tableClasif.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tableClasif.setRowSelectionAllowed(false);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tableClasif.setDefaultRenderer(String.class, centerRenderer);
		tableClasif.setModel(new DefaultTableModel(
			new Object[][] {
				{"POS","EQUIPO", "PUNTOS", "PJ", "GF", "GC"},
				{1,null, null, null, null, null},
				{2,null, null, null, null, null},
				{3,null, null, null, null, null},
				{4,null, null, null, null, null},
				{5,null, null, null, null, null},
				{6,null, null, null, null, null},
				{7,null, null, null, null, null},
				{8, null, null, null, null, null},
				{9, null, null, null, null, null},
				{10, null, null, null, null, null},
				{11, null, null, null, null, null},
				{12, null, null, null, null, null},
				{13, null, null, null, null, null},
				{14, null, null, null, null, null},
				{15, null, null, null, null, null},
				{16, null, null, null, null, null},
				{17, null, null, null, null, null},
				{18, null, null, null, null, null},
				{19, null, null, null, null, null},
				{20, null, null, null, null, null},
			},
			new String[] {
					"POS","EQUIPO", "PUNTOS", "PJ", "GF", "GC"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableClasif.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableClasif.getColumnModel().getColumn(0).setMinWidth(30);
		tableClasif.getColumnModel().getColumn(1).setPreferredWidth(330);
		tableClasif.getColumnModel().getColumn(1).setMinWidth(330);
		tableClasif.getColumnModel().getColumn(2).setPreferredWidth(50);
		tableClasif.getColumnModel().getColumn(2).setMinWidth(50);
		tableClasif.getColumnModel().getColumn(3).setPreferredWidth(30);
		tableClasif.getColumnModel().getColumn(3).setMinWidth(30);
		tableClasif.getColumnModel().getColumn(4).setPreferredWidth(30);
		tableClasif.getColumnModel().getColumn(4).setMinWidth(30);
		tableClasif.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		tableClasif.setBorder(new LineBorder(Color.BLACK));
		tableClasif.setBounds(312, 119, 539, 378);
		panel.add(tableClasif);
		
		tableProximos = new JTable();
		tableProximos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"LOCAL", "CONTRA", "VISITANTE"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableProximos.getColumnModel().getColumn(0).setResizable(false);
		tableProximos.getColumnModel().getColumn(1).setPreferredWidth(30);
		tableProximos.getColumnModel().getColumn(1).setMinWidth(30);
		tableProximos.getColumnModel().getColumn(1).setMaxWidth(30);
		tableProximos.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableProximos.setBounds(35, 162, 248, 96);
		panel.add(tableProximos);
		
		tableUltimos = new JTable();
		tableUltimos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"LOCAL", "CONTRA", "VISITANTE"
			}
		));
		tableUltimos.getColumnModel().getColumn(0).setPreferredWidth(70);
		tableUltimos.getColumnModel().getColumn(1).setPreferredWidth(40);
		tableUltimos.getColumnModel().getColumn(1).setMinWidth(25);
		tableUltimos.getColumnModel().getColumn(1).setMaxWidth(40);
		tableUltimos.getColumnModel().getColumn(2).setPreferredWidth(70);
		tableUltimos.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableUltimos.setBounds(35, 339, 248, 96);
		panel.add(tableUltimos);
		
		JLabel lblltimosPartidos = new JLabel("\u00DALTIMOS PARTIDOS");
		lblltimosPartidos.setBounds(35, 309, 248, 14);
		panel.add(lblltimosPartidos);
		
		JLabel lblPrximosPartidos = new JLabel("PR\u00D3XIMOS PARTIDOS");
		lblPrximosPartidos.setBounds(35, 141, 248, 14);
		panel.add(lblPrximosPartidos);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(35, 288, 248, 2);
		panel.add(separator);
		
		lblMensajes_1 = new JLabel("MENSAJES");
		lblMensajes_1.setBounds(35, 483, 248, 14);
		panel.add(lblMensajes_1);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(35, 465, 248, 2);
		panel.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(861, 215, 203, 2);
		panel.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(857, 446, 203, 2);
		panel.add(separator_3);
		
		label = new JLabel("New label");
		label.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/Repositorios/1_Primary_logo_on_transparent_201x71.png")));
		label.setBounds(35, 40, 180, 72);
		panel.add(label);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea_1.setBackground(Color.WHITE);
		textArea_1.setBounds(880, 257, 165, 165);
		panel.add(textArea_1);
		
		textArea_2 = new JTextArea();
		textArea_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea_2.setBackground(Color.WHITE);
		textArea_2.setBounds(880, 483, 165, 177);
		panel.add(textArea_2);
		
		txtAreaMensajes = new JTextArea();
		txtAreaMensajes.setEditable(false);
		txtAreaMensajes.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAreaMensajes.setBackground(Color.WHITE);
		txtAreaMensajes.setBounds(35, 525, 816, 140);
		panel.add(txtAreaMensajes);
		
		panel.add(txtAreaMensajes);
		
		lblCumpleaosDa = new JLabel("CUMPLEA\u00D1OS D\u00CDA");
		lblCumpleaosDa.setBounds(880, 232, 160, 14);
		panel.add(lblCumpleaosDa);
		
		lblEntrenamientos = new JLabel("ENTRENAMIENTOS D\u00CDA");
		lblEntrenamientos.setBounds(880, 465, 160, 14);
		panel.add(lblEntrenamientos);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/Repositorios/background1080x720grey.png")));
		lblNewLabel.setBounds(0, 15, 1080, 680);
		panel.add(lblNewLabel);
		
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
		
		mntmMensajes.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
