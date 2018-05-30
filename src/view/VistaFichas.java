package view;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

public class VistaFichas extends JFrame{

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
	public JTextField txtNombre;
	public JTextField txtEquipo;
	public JTextField txtApellido;
	public JTextField txtPosicion;
	public JTextField txtFecha;
	public JTextField txtDorsal;
	public JLabel lblFoto;
	public JTextField txtNombreBuscar;
	public JLabel lblBuscadorDeJugadores;
	public JTextField txtApellidoBuscar;
	public JLabel lblNombre;
	public JLabel lblApellido_1;
	public JTextArea txtObservaciones;
	public JLabel lblObservaciones;
	public JButton btnBuscar;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnBorrar;
	private JLabel lblEstadsticasDeJugador;
	private JLabel lblEstadsticas;
	private JLabel lblAsistencia;
	public JComboBox comboBoxSelecEquipo;

public VistaFichas() {
		
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
		setTitle("SportClubData - FICHAS");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/Repositorios/icon-soccer/026-strategy-1.png"));
		
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
		
		txtNombre = new JTextField();
		txtNombre.setBounds(410, 194, 126, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEquipo = new JTextField();
		txtEquipo.setColumns(10);
		txtEquipo.setBounds(410, 225, 126, 20);
		panel.add(txtEquipo);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(671, 194, 137, 20);
		panel.add(txtApellido);
		
		txtPosicion = new JTextField();
		txtPosicion.setColumns(10);
		txtPosicion.setBounds(671, 225, 137, 20);
		panel.add(txtPosicion);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(410, 256, 126, 20);
		panel.add(txtFecha);
		
		txtDorsal = new JTextField();
		txtDorsal.setColumns(10);
		txtDorsal.setBounds(671, 256, 137, 20);
		panel.add(txtDorsal);
		
		JLabel lblNombreFic = new JLabel("NOMBRE");
		lblNombreFic.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreFic.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblNombreFic.setBounds(270, 197, 130, 14);
		panel.add(lblNombreFic);
		
		JLabel lblApellidos = new JLabel("EQUIPO");
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidos.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblApellidos.setBounds(270, 228, 130, 14);
		panel.add(lblApellidos);
		
		JLabel lblFechaNacimiento = new JLabel("FECHA NACIMIENTO");
		lblFechaNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaNacimiento.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblFechaNacimiento.setBounds(270, 259, 130, 14);
		panel.add(lblFechaNacimiento);
		
		JLabel lblCaducidadFicha = new JLabel("DORSAL");
		lblCaducidadFicha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCaducidadFicha.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblCaducidadFicha.setBounds(546, 259, 115, 14);
		panel.add(lblCaducidadFicha);
		
		JLabel lblPosicin = new JLabel("POSICI\u00D3N");
		lblPosicin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPosicin.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblPosicin.setBounds(546, 228, 115, 14);
		panel.add(lblPosicin);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblApellido.setBounds(546, 197, 115, 14);
		panel.add(lblApellido);
		
		lblFoto = new JLabel("");
		lblFoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFoto.setBounds(81, 188, 126, 156);
		panel.add(lblFoto);

		//OBTENER FOTO JUGADOR
		ImageIcon imgJugador = new ImageIcon("src/Repositorios/sinImagen.png");
		Icon imagenJugador = new ImageIcon(imgJugador.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
		lblFoto.setIcon(imagenJugador);
		
		txtNombreBuscar = new JTextField();
		txtNombreBuscar.setBounds(121, 96, 164, 20);
		panel.add(txtNombreBuscar);
		txtNombreBuscar.setColumns(10);
		
		lblBuscadorDeJugadores = new JLabel("BUSCADOR DE JUGADORES");
		lblBuscadorDeJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscadorDeJugadores.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblBuscadorDeJugadores.setBounds(410, 51, 229, 14);
		panel.add(lblBuscadorDeJugadores);
		
		txtApellidoBuscar = new JTextField();
		txtApellidoBuscar.setColumns(10);
		txtApellidoBuscar.setBounds(445, 96, 164, 20);
		panel.add(txtApellidoBuscar);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(41, 99, 70, 14);
		panel.add(lblNombre);
		
		lblApellido_1 = new JLabel("APELLIDO");
		lblApellido_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblApellido_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido_1.setBounds(358, 99, 77, 14);
		panel.add(lblApellido_1);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		btnBuscar.setBounds(945, 95, 89, 23);
		panel.add(btnBuscar);
		
		JLabel lblFichaDeJugador = new JLabel("FICHA DE JUGADOR");
		lblFichaDeJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblFichaDeJugador.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblFichaDeJugador.setBounds(469, 151, 127, 14);
		panel.add(lblFichaDeJugador);
		
		comboBoxSelecEquipo = new JComboBox();
		comboBoxSelecEquipo.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		comboBoxSelecEquipo.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Seleccione Equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		comboBoxSelecEquipo.setBounds(667, 81, 248, 40);
		comboBoxSelecEquipo.setModel(new DefaultComboBoxModel(new String[] {"SENIOR", "JUVENIL A", "- JUVENIL B", "- CADETE A", "- CADETE B", "- INFANTIL A", "- INFANTIL B", "- ALEVIN A", "- ALEVIN B", "- BENJAMIN A", "- BENJAMIN B"}));
		panel.add(comboBoxSelecEquipo);
		
		txtObservaciones = new JTextArea();
		txtObservaciones.setBounds(410, 294, 398, 90);
		panel.add(txtObservaciones);
		
		lblObservaciones = new JLabel("OBSERVACIONES");
		lblObservaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObservaciones.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblObservaciones.setBounds(270, 299, 130, 14);
		panel.add(lblObservaciones);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		btnGuardar.setBounds(910, 224, 100, 23);
		panel.add(btnGuardar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		btnModificar.setBounds(910, 266, 100, 23);
		panel.add(btnModificar);
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		btnBorrar.setBounds(910, 309, 100, 23);
		panel.add(btnBorrar);
		
		lblEstadsticasDeJugador = new JLabel("ESTAD\u00CDSTICAS DE JUGADOR");
		lblEstadsticasDeJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadsticasDeJugador.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblEstadsticasDeJugador.setBounds(445, 451, 194, 14);
		panel.add(lblEstadsticasDeJugador);
		
		lblEstadsticas = new JLabel("ESTAD\u00CDSTICAS");
		lblEstadsticas.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblEstadsticas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadsticas.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEstadsticas.setBounds(81, 494, 907, 61);
		panel.add(lblEstadsticas);
		
		lblAsistencia = new JLabel("ASISTENCIA");
		lblAsistencia.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblAsistencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsistencia.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAsistencia.setBounds(81, 566, 907, 61);
		panel.add(lblAsistencia);
		
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
