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
	public JMenu mnInicio;
	public JMenu mnJugadores;
	public JMenuItem mntmFichas;
	public JMenuItem mntmAsistencia;
	public JMenuItem mntmEstadisticas;
	public JMenu mnCompeticion;
	public JMenuItem mntmMantenimientoEquipos;
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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblFoto;
	private JTextField txtNombreBuscar;
	private JLabel lblBuscadorDeJugadores;
	private JTextField txtApellidoBuscar;
	private JLabel lblNombre;
	private JLabel lblApellido_1;
	private JTextArea textArea;
	private JLabel lblObservaciones;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnBorrar;
	private JLabel lblEstadsticasDeJugador;
	private JLabel lblEstadsticas;
	private JLabel lblAsistencia;

public VistaFichas() {
		
		setResizable(false);
		//int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		//int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		int alto=720;
		int ancho=1080;

		super.setBounds(0, 0, ancho, alto);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setLayout(null);
		setTitle("SportClubData - FICHAS");
		setIconImage(Toolkit.getDefaultToolkit().getImage("\\FutbolData\\Repositorios\\icon-soccer\\026-strategy-1.png"));
		
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
		
		mnInicio = new JMenu("INICIO");
		mnInicio.setHorizontalAlignment(SwingConstants.CENTER);
		mnInicio.setMargin(new Insets(2, 10, 0, 10));
		mnInicio.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		menuPrincipal.add(mnInicio);
		
		mnJugadores = new JMenu("JUGADORES");
		mnJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		mnJugadores.setMargin(new Insets(2, 10, 0, 10));
		mnJugadores.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		menuPrincipal.add(mnJugadores);
		
		mntmFichas = new JMenuItem("FICHAS");
		mntmFichas.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnJugadores.add(mntmFichas);
		
		mntmAsistencia = new JMenuItem("ASISTENCIA");
		mntmAsistencia.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnJugadores.add(mntmAsistencia);
		
		mntmEstadisticas = new JMenuItem("ESTAD\u00CDSTICAS");
		mntmEstadisticas.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnJugadores.add(mntmEstadisticas);
		
		mnCompeticion = new JMenu("COMPETICI\u00D3N");
		mnCompeticion.setHorizontalAlignment(SwingConstants.CENTER);
		mnCompeticion.setMargin(new Insets(2, 10, 0, 10));
		mnCompeticion.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		menuPrincipal.add(mnCompeticion);
		
		mntmMantenimientoEquipos = new JMenuItem("MANTENIMIENTO EQUIPOS");
		mntmMantenimientoEquipos.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnCompeticion.add(mntmMantenimientoEquipos);
		
		mntmPartidosDisputados = new JMenuItem("PARTIDOS DISPUTADOS");
		mntmPartidosDisputados.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnCompeticion.add(mntmPartidosDisputados);
		
		mntmConvocatorias = new JMenuItem("CONVOCATORIAS");
		mntmConvocatorias.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnCompeticion.add(mntmConvocatorias);
		
		mntmCalendariosYResultados = new JMenuItem("CALENDARIOS Y RESULTADOS");
		mntmCalendariosYResultados.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnCompeticion.add(mntmCalendariosYResultados);
		
		mnEntrenamiento = new JMenu("ENTRENAMIENTO");
		mnEntrenamiento.setHorizontalAlignment(SwingConstants.CENTER);
		mnEntrenamiento.setMargin(new Insets(2, 10, 0, 10));
		mnEntrenamiento.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		menuPrincipal.add(mnEntrenamiento);
		
		mntmPlanificacionSesiones = new JMenuItem("PLANIFICACI\u00D3N SESIONES");
		mntmPlanificacionSesiones.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnEntrenamiento.add(mntmPlanificacionSesiones);
		
		mntmBaseDeDatos = new JMenuItem("BASE DE DATOS EJERCICIOS");
		mntmBaseDeDatos.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnEntrenamiento.add(mntmBaseDeDatos);
		
		mnAdministracion = new JMenu("ADMINISTRACI\u00D3N");
		mnAdministracion.setHorizontalAlignment(SwingConstants.CENTER);
		mnAdministracion.setMargin(new Insets(2, 10, 0, 10));
		mnAdministracion.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		menuPrincipal.add(mnAdministracion);
		
		mntmCuotasJugadores = new JMenuItem("CUOTAS JUGADORES");
		mntmCuotasJugadores.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnAdministracion.add(mntmCuotasJugadores);
		
		mnAyuda = new JMenu("AYUDA");
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
		menuPrincipal.add(btnCerrarSesion);
		btnCerrarSesion.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		
		textField = new JTextField();
		textField.setBounds(410, 194, 126, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(410, 225, 126, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(671, 194, 137, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(671, 225, 137, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(410, 256, 126, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(671, 256, 137, 20);
		panel.add(textField_5);
		
		JLabel lblNombreFic = new JLabel("NOMBRE");
		lblNombreFic.setBounds(354, 197, 46, 14);
		panel.add(lblNombreFic);
		
		JLabel lblApellidos = new JLabel("EQUIPO");
		lblApellidos.setBounds(354, 228, 46, 14);
		panel.add(lblApellidos);
		
		JLabel lblFechaNacimiento = new JLabel("FECHA NACIMIENTO");
		lblFechaNacimiento.setBounds(300, 259, 100, 14);
		panel.add(lblFechaNacimiento);
		
		JLabel lblCaducidadFicha = new JLabel("CADUCIDAD FICHA");
		lblCaducidadFicha.setBounds(561, 259, 100, 14);
		panel.add(lblCaducidadFicha);
		
		JLabel lblPosicin = new JLabel("POSICI\u00D3N");
		lblPosicin.setBounds(604, 228, 57, 14);
		panel.add(lblPosicin);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(604, 197, 57, 14);
		panel.add(lblApellido);
		
		lblFoto = new JLabel("FOTO JUGADOR");
		lblFoto.setIcon(new ImageIcon(VistaFichas.class.getResource("/Repositorios/sinImagen.png")));
		lblFoto.setBounds(81, 188, 126, 156);
		panel.add(lblFoto);
		
		txtNombreBuscar = new JTextField();
		txtNombreBuscar.setBounds(121, 96, 164, 20);
		panel.add(txtNombreBuscar);
		txtNombreBuscar.setColumns(10);
		
		lblBuscadorDeJugadores = new JLabel("BUSCADOR DE JUGADORES");
		lblBuscadorDeJugadores.setBounds(459, 51, 137, 14);
		panel.add(lblBuscadorDeJugadores);
		
		txtApellidoBuscar = new JTextField();
		txtApellidoBuscar.setColumns(10);
		txtApellidoBuscar.setBounds(445, 96, 164, 20);
		panel.add(txtApellidoBuscar);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(54, 99, 57, 14);
		panel.add(lblNombre);
		
		lblApellido_1 = new JLabel("APELLIDO");
		lblApellido_1.setBounds(358, 99, 57, 14);
		panel.add(lblApellido_1);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(945, 95, 89, 23);
		panel.add(btnBuscar);
		
		JLabel lblFichaDeJugador = new JLabel("FICHA DE JUGADOR");
		lblFichaDeJugador.setBounds(469, 151, 100, 14);
		panel.add(lblFichaDeJugador);
		
		JComboBox comboBoxEquipo = new JComboBox();
		comboBoxEquipo.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Seleccione Equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		comboBoxEquipo.setBounds(667, 81, 248, 40);
		comboBoxEquipo.setModel(new DefaultComboBoxModel(new String[] {"- SENIOR", "- JUVENIL A", "- JUVENIL B", "- CADETE A", "- CADETE B", "- INFANTIL A", "- INFANTIL B", "- ALEVIN A", "- ALEVIN B", "- BENJAMIN A", "- BENJAMIN B"}));
		panel.add(comboBoxEquipo);
		
		textArea = new JTextArea();
		textArea.setBounds(410, 294, 398, 90);
		panel.add(textArea);
		
		lblObservaciones = new JLabel("OBSERVACIONES");
		lblObservaciones.setBounds(300, 299, 100, 14);
		panel.add(lblObservaciones);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(910, 224, 100, 23);
		panel.add(btnGuardar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(910, 266, 100, 23);
		panel.add(btnModificar);
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.setBounds(910, 309, 100, 23);
		panel.add(btnBorrar);
		
		lblEstadsticasDeJugador = new JLabel("ESTAD\u00CDSTICAS DE JUGADOR");
		lblEstadsticasDeJugador.setBounds(459, 451, 150, 14);
		panel.add(lblEstadsticasDeJugador);
		
		lblEstadsticas = new JLabel("ESTAD\u00CDSTICAS");
		lblEstadsticas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadsticas.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEstadsticas.setBounds(81, 494, 907, 61);
		panel.add(lblEstadsticas);
		
		lblAsistencia = new JLabel("ASISTENCIA");
		lblAsistencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsistencia.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAsistencia.setBounds(81, 566, 907, 61);
		panel.add(lblAsistencia);
		
		//ACTION LISTENER
		
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		comboBoxEquipo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
                
            }
		});
	}
}
