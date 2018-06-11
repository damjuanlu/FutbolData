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
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;
import javax.swing.DropMode;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class VistaSesiones extends JFrame{

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
	public JMenuItem mntmPartidos;
	public JMenu mnEntrenamiento;
	public JMenuItem mntmPlanificacionSesiones;
	public JMenu mnAdministracion;
	public JMenuItem mntmCuotasJugadores;
	public JMenu mnAyuda;
	public JMenuItem mntmUsuario;
	public JMenuItem mntmContacto;
	public JMenuItem mntmAcercaDe;
	public JMenu mnMensajes;
	public JMenuItem mntmMensajes;
	public JButton btnCerrarSesion;
	public JLabel lblUser;
	public JCalendar calendar;
	public String stringFecha;
	public JComboBox comboBoxSelecEquipo;
	public JComboBox comboBoxSelecSesion;
	public String equipoSeleccionado;
	public String mesSeleccionado;
	public JButton btnBuscarSesion;
	public JButton btnMuestraSesion;
	public JButton btnInformeSesion;
	public JButton btnModificarSesion;
	public JButton btnEliminarSesion;
	public JButton btnGuardar;
	public JButton btnNuevaSesion;
	public JButton btnGuardarNueva;
	public JLabel lblInformativo;
	public JTextField txtNombreEquipo;
	private JLabel label;
	public JTextField txtDiaSesion;
	private JLabel lblMinutosDeLa;
	public JTextField txtMinutosSesion;
	private JLabel lblObjetivos;
	public JTextArea textAreaMaterial;
	private JLabel lblMaterial;
	private JLabel lblObservaciones;
	public JTextArea textAreaObservaciones;
	public JTextArea textAreaObjetivosSesion;
	private JScrollPane scrollBarMaterial;
	private JScrollPane scrollBarObservaciones;
	private JScrollPane scrollBarObjetivosSesion;
	private JLabel lblCalentamiento;
	public JTextArea textAreaCalentamiento;
	private JScrollPane scrollBarCalentamiento;
	private JLabel lblPartePrincipal;
	public JTextArea textAreaPartePrincipal;
	private JScrollPane scrollBarPartePrincipal;
	private JLabel lblVueltaCalma;
	public JTextArea textAreaVueltaCalma;
	private JScrollPane scrollBarVueltaCalma;

public VistaSesiones() {
		
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
		setTitle("SportClubData - SESIONES DE ENTRENAMIENTO");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/Repositorios/logoSCD_32x32.png"));
		
		super.setContentPane(panel);
		
		JLabel lblVersion = new JLabel("0.9.8");
		lblVersion.setBounds(10, 666, 24, 15);
		panel.add(lblVersion);
		lblVersion.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblVersion.setForeground(Color.BLACK);
		
		lblUser = new JLabel("");
		lblUser.setFont(new Font("Agency FB", Font.PLAIN, 15));
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setBounds(800, 0, 260, 21);
		panel.add(lblUser);
		
		menuPrincipal = new JMenuBar();
		menuPrincipal.setFont(new Font("Agency FB", Font.BOLD, 15));
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
		mntmEstadisticas.setFont(new Font("Agency FB", Font.BOLD, 12));
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
		
		mntmPartidos = new JMenuItem("PARTIDOS");
		mntmPartidos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmPartidos.setFont(new Font("Agency FB", Font.BOLD, 15));
		mnCompeticion.add(mntmPartidos);
		
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
		mntmMensajes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		
		comboBoxSelecEquipo = new JComboBox();
		comboBoxSelecEquipo.setFont(new Font("Agency FB", Font.BOLD, 15));
		comboBoxSelecEquipo.setModel(new DefaultComboBoxModel(new String[] {}));
		comboBoxSelecEquipo.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Seleccione Equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		comboBoxSelecEquipo.setBounds(35, 90, 248, 40);
		panel.add(comboBoxSelecEquipo);
		
		lblInformativo = new JLabel("SESIONES DE ENTRENAMIENTO");
		lblInformativo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblInformativo.setToolTipText("");
		lblInformativo.setOpaque(true);
		lblInformativo.setFocusable(false);
		lblInformativo.setForeground(Color.WHITE);
		lblInformativo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblInformativo.setBackground(new Color(144, 238, 144));
		lblInformativo.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblInformativo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformativo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblInformativo.setBounds(85, 40, 930, 30);
		panel.add(lblInformativo);
		
		ImageIcon imgCabecera = new ImageIcon(VistaEstadisticas.class.getResource("/Repositorios/lblInformativo.jpg"));
		Icon imagenCabecera = new ImageIcon(imgCabecera.getImage().getScaledInstance(lblInformativo.getWidth(), imgCabecera.getIconHeight(), Image.SCALE_DEFAULT));
		lblInformativo.setIcon(imagenCabecera);
		
		btnInformeSesion = new JButton("INFORME");
		btnInformeSesion.setEnabled(false);
		btnInformeSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInformeSesion.setFocusable(false);
		btnInformeSesion.setFocusPainted(false);
		btnInformeSesion.setDefaultCapable(false);
		btnInformeSesion.setBackground(SystemColor.activeCaption);
		btnInformeSesion.setVerticalAlignment(SwingConstants.TOP);
		btnInformeSesion.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnInformeSesion.setBounds(915, 95, 100, 25);
		panel.add(btnInformeSesion);
		
		btnBuscarSesion = new JButton("BUSCAR");
		btnBuscarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarSesion.setVerticalAlignment(SwingConstants.TOP);
		btnBuscarSesion.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnBuscarSesion.setFocusable(false);
		btnBuscarSesion.setFocusPainted(false);
		btnBuscarSesion.setDefaultCapable(false);
		btnBuscarSesion.setBackground(SystemColor.activeCaption);
		btnBuscarSesion.setBounds(310, 95, 100, 25);
		panel.add(btnBuscarSesion);
		
		comboBoxSelecSesion = new JComboBox();
		comboBoxSelecSesion.setFont(new Font("Agency FB", Font.BOLD, 15));
		comboBoxSelecSesion.setModel(new DefaultComboBoxModel(new String[] {}));
		comboBoxSelecSesion.setEnabled(false);
		comboBoxSelecSesion.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Seleccione Sesion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		comboBoxSelecSesion.setBounds(462, 90, 248, 40);
		panel.add(comboBoxSelecSesion);

		btnMuestraSesion = new JButton("MOSTRAR");
		btnMuestraSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMuestraSesion.setEnabled(false);
		btnMuestraSesion.setVerticalAlignment(SwingConstants.TOP);
		btnMuestraSesion.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnMuestraSesion.setFocusable(false);
		btnMuestraSesion.setFocusPainted(false);
		btnMuestraSesion.setDefaultCapable(false);
		btnMuestraSesion.setBackground(SystemColor.activeCaption);
		btnMuestraSesion.setBounds(737, 95, 100, 25);
		panel.add(btnMuestraSesion);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(85, 140, 930, 2);
		panel.add(separator);
		
		btnModificarSesion = new JButton("MODIFICAR SESION");
		btnModificarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificarSesion.setVerticalAlignment(SwingConstants.TOP);
		btnModificarSesion.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnModificarSesion.setFocusable(false);
		btnModificarSesion.setFocusPainted(false);
		btnModificarSesion.setEnabled(false);
		btnModificarSesion.setDefaultCapable(false);
		btnModificarSesion.setBackground(SystemColor.activeCaption);
		btnModificarSesion.setBounds(85, 150, 157, 25);
		panel.add(btnModificarSesion);
		
		btnEliminarSesion = new JButton("ELIMINAR SESION");
		btnEliminarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminarSesion.setVerticalAlignment(SwingConstants.TOP);
		btnEliminarSesion.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnEliminarSesion.setFocusable(false);
		btnEliminarSesion.setFocusPainted(false);
		btnEliminarSesion.setEnabled(false);
		btnEliminarSesion.setDefaultCapable(false);
		btnEliminarSesion.setBackground(SystemColor.activeCaption);
		btnEliminarSesion.setBounds(445, 150, 146, 25);
		panel.add(btnEliminarSesion);
		
		btnGuardar = new JButton("GUARDAR SESION");
		btnGuardar.setVerticalAlignment(SwingConstants.TOP);
		btnGuardar.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnGuardar.setFocusable(false);
		btnGuardar.setFocusPainted(false);
		btnGuardar.setEnabled(false);
		btnGuardar.setDefaultCapable(false);
		btnGuardar.setBackground(SystemColor.activeCaption);
		btnGuardar.setBounds(279, 150, 146, 25);
		panel.add(btnGuardar);
		
		btnNuevaSesion = new JButton("NUEVA SESION");
		btnNuevaSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevaSesion.setVerticalAlignment(SwingConstants.TOP);
		btnNuevaSesion.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnNuevaSesion.setFocusable(false);
		btnNuevaSesion.setFocusPainted(false);
		btnNuevaSesion.setEnabled(false);
		btnNuevaSesion.setDefaultCapable(false);
		btnNuevaSesion.setBackground(SystemColor.activeCaption);
		btnNuevaSesion.setBounds(712, 150, 130, 25);
		panel.add(btnNuevaSesion);
		
		btnGuardarNueva = new JButton("GUARDAR NUEVA");
		btnGuardarNueva.setVerticalAlignment(SwingConstants.TOP);
		btnGuardarNueva.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnGuardarNueva.setFocusable(false);
		btnGuardarNueva.setFocusPainted(false);
		btnGuardarNueva.setEnabled(false);
		btnGuardarNueva.setDefaultCapable(false);
		btnGuardarNueva.setBackground(SystemColor.activeCaption);
		btnGuardarNueva.setBounds(869, 150, 146, 25);
		panel.add(btnGuardarNueva);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(85, 180, 930, 2);
		panel.add(separator_1);
		
		JLabel lblDiaSesion = new JLabel("EQUIPO");
		lblDiaSesion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiaSesion.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblDiaSesion.setBounds(33, 189, 130, 14);
		panel.add(lblDiaSesion);
		
		txtNombreEquipo = new JTextField();
		txtNombreEquipo.setEditable(false);
		txtNombreEquipo.setFont(new Font("Agency FB", Font.PLAIN, 15));
		txtNombreEquipo.setEnabled(false);
		txtNombreEquipo.setColumns(10);
		txtNombreEquipo.setBounds(173, 186, 140, 20);
		panel.add(txtNombreEquipo);
		
		label = new JLabel("D\u00CDA (dd/mm/aaaa)");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Agency FB", Font.BOLD, 15));
		label.setBounds(390, 189, 130, 14);
		panel.add(label);
		
		txtDiaSesion = new JTextField();
		txtDiaSesion.setEnabled(false);
		txtDiaSesion.setFont(new Font("Agency FB", Font.PLAIN, 15));
		txtDiaSesion.setColumns(10);
		txtDiaSesion.setBounds(530, 186, 126, 20);
		panel.add(txtDiaSesion);
		
		lblMinutosDeLa = new JLabel("MINUTOS DE LA SESION");
		lblMinutosDeLa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMinutosDeLa.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblMinutosDeLa.setBounds(738, 189, 179, 14);
		panel.add(lblMinutosDeLa);
		
		txtMinutosSesion = new JTextField();
		txtMinutosSesion.setFont(new Font("Agency FB", Font.PLAIN, 15));
		txtMinutosSesion.setEnabled(false);
		txtMinutosSesion.setColumns(10);
		txtMinutosSesion.setBounds(928, 186, 80, 20);
		panel.add(txtMinutosSesion);
		
		lblObjetivos = new JLabel("OBJETIVO");
		lblObjetivos.setHorizontalAlignment(SwingConstants.CENTER);
		lblObjetivos.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblObjetivos.setBounds(33, 220, 320, 14);
		panel.add(lblObjetivos);

		textAreaObjetivosSesion = new JTextArea();
		textAreaObjetivosSesion.setFont(new Font("Agency FB", Font.PLAIN, 15));
		textAreaObjetivosSesion.setEnabled(false);
		textAreaObjetivosSesion.setBounds(0, 0, 320, 40);
		textAreaObjetivosSesion.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaObjetivosSesion.setLineWrap(true);
		
		scrollBarObjetivosSesion = new JScrollPane(textAreaObjetivosSesion);
		scrollBarObjetivosSesion.setBounds(33, 240, 320, 40);
		panel.add(scrollBarObjetivosSesion);
		
		lblMaterial = new JLabel("MATERIAL");
		lblMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaterial.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblMaterial.setBounds(378, 220, 320, 14);
		panel.add(lblMaterial);
		
		textAreaMaterial = new JTextArea();
		textAreaMaterial.setFont(new Font("Agency FB", Font.PLAIN, 15));
		textAreaMaterial.setEnabled(false);
		textAreaMaterial.setBounds(0, 0, 320, 40);
		textAreaMaterial.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaMaterial.setLineWrap(true);
		
		scrollBarMaterial = new JScrollPane(textAreaMaterial);
		scrollBarMaterial.setBounds(378, 240, 320, 40);
		panel.add(scrollBarMaterial);
		
		lblObservaciones = new JLabel("OBSERVACIONES");
		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservaciones.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblObservaciones.setBounds(723, 220, 320, 14);
		panel.add(lblObservaciones);
		
		textAreaObservaciones = new JTextArea();
		textAreaObservaciones.setFont(new Font("Agency FB", Font.PLAIN, 15));
		textAreaObservaciones.setEnabled(false);
		textAreaObservaciones.setBounds(0, 0, 320, 40);
		textAreaObservaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaObservaciones.setLineWrap(true);
		
		scrollBarObservaciones = new JScrollPane(textAreaObservaciones);
		scrollBarObservaciones.setBounds(723, 240, 320, 40);
		panel.add(scrollBarObservaciones);
		
		/*
		 * CALENTAMIENTO
		 */
		lblCalentamiento = new JLabel("CALENTAMIENTO");
		lblCalentamiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalentamiento.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblCalentamiento.setBounds(33, 285, 1010, 14);
		panel.add(lblCalentamiento);
		
		textAreaCalentamiento = new JTextArea();
		textAreaCalentamiento.setFont(new Font("Agency FB", Font.PLAIN, 15));
		textAreaCalentamiento.setEnabled(false);
		textAreaCalentamiento.setBounds(0, 0, 1010, 80);
		textAreaCalentamiento.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaCalentamiento.setLineWrap(true);
		
		scrollBarCalentamiento = new JScrollPane(textAreaCalentamiento);
		scrollBarCalentamiento.setBounds(33, 305, 1010, 80);
		panel.add(scrollBarCalentamiento);
		
		/*
		 * PARTE PRINCIPAL
		 */
		lblPartePrincipal = new JLabel("PARTE PRINCIPAL");
		lblPartePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartePrincipal.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblPartePrincipal.setBounds(33, 390, 1010, 14);
		panel.add(lblPartePrincipal);
		
		textAreaPartePrincipal = new JTextArea();
		textAreaPartePrincipal.setFont(new Font("Agency FB", Font.PLAIN, 15));
		textAreaPartePrincipal.setEnabled(false);
		textAreaPartePrincipal.setBounds(0, 0, 1010, 180);
		textAreaPartePrincipal.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaPartePrincipal.setLineWrap(true);
		
		scrollBarPartePrincipal = new JScrollPane(textAreaPartePrincipal);
		scrollBarPartePrincipal.setBounds(33, 410, 1010, 180);
		panel.add(scrollBarPartePrincipal);

		/*
		 * PARTE VUELTA A LA CALMA
		 */
		lblVueltaCalma = new JLabel("VUELTA A LA CALMA");
		lblVueltaCalma.setHorizontalAlignment(SwingConstants.CENTER);
		lblVueltaCalma.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblVueltaCalma.setBounds(33, 595, 1010, 14);
		panel.add(lblVueltaCalma);
		
		textAreaVueltaCalma = new JTextArea();
		textAreaVueltaCalma.setFont(new Font("Agency FB", Font.PLAIN, 15));
		textAreaVueltaCalma.setEnabled(false);
		textAreaVueltaCalma.setBounds(0, 0, 1010, 60);
		textAreaVueltaCalma.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaVueltaCalma.setLineWrap(true);
		
		scrollBarVueltaCalma = new JScrollPane(textAreaVueltaCalma);
		scrollBarVueltaCalma.setBounds(33, 615, 1010, 60);
		panel.add(scrollBarVueltaCalma);

		//IMAGEN DE FONDO
		JLabel lblImagenFondo = new JLabel("");
		lblImagenFondo.setFont(new Font("Agency FB", Font.BOLD, 15));
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
		
		mntmPartidos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mntmPlanificacionSesiones.addActionListener(new ActionListener(){
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
		

		btnBuscarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		btnMuestraSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		btnModificarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		btnNuevaSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnGuardarNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		btnEliminarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		btnInformeSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		comboBoxSelecEquipo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
                
            }
		});
		
		comboBoxSelecSesion.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
                
            }
		});
		
	}
}
