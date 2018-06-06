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
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;

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
	public JButton btnGuardar;
	public JButton btnModificar;
	public JButton btnBorrar;
	public JButton btnInsert;
	public JLabel lblEstadsticasDeJugador;
	public JComboBox comboBoxSelecEquipo;
	public JTable tablaEst;
	public JLabel lblInformativo;

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
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(414, 285, 126, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEquipo = new JTextField();
		txtEquipo.setEnabled(false);
		txtEquipo.setColumns(10);
		txtEquipo.setBounds(414, 316, 126, 20);
		panel.add(txtEquipo);
		
		txtApellido = new JTextField();
		txtApellido.setEnabled(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(675, 285, 137, 20);
		panel.add(txtApellido);
		
		txtPosicion = new JTextField();
		txtPosicion.setEnabled(false);
		txtPosicion.setColumns(10);
		txtPosicion.setBounds(675, 316, 137, 20);
		panel.add(txtPosicion);
		
		txtFecha = new JTextField();
		txtFecha.setEnabled(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(414, 347, 126, 20);
		panel.add(txtFecha);
		
		txtDorsal = new JTextField();
		txtDorsal.setEnabled(false);
		txtDorsal.setColumns(10);
		txtDorsal.setBounds(675, 347, 137, 20);
		panel.add(txtDorsal);
		
		JLabel lblNombreFic = new JLabel("NOMBRE");
		lblNombreFic.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreFic.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblNombreFic.setBounds(274, 288, 130, 14);
		panel.add(lblNombreFic);
		
		JLabel lblApellidos = new JLabel("EQUIPO");
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidos.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblApellidos.setBounds(274, 319, 130, 14);
		panel.add(lblApellidos);
		
		JLabel lblFechaNacimiento = new JLabel("FECHA NACIMIENTO");
		lblFechaNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaNacimiento.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblFechaNacimiento.setBounds(274, 350, 130, 14);
		panel.add(lblFechaNacimiento);
		
		JLabel lblCaducidadFicha = new JLabel("DORSAL");
		lblCaducidadFicha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCaducidadFicha.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblCaducidadFicha.setBounds(550, 350, 115, 14);
		panel.add(lblCaducidadFicha);
		
		JLabel lblPosicin = new JLabel("POSICI\u00D3N");
		lblPosicin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPosicin.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblPosicin.setBounds(550, 319, 115, 14);
		panel.add(lblPosicin);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblApellido.setBounds(550, 288, 115, 14);
		panel.add(lblApellido);
		
		lblFoto = new JLabel("");
		lblFoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFoto.setBounds(85, 279, 126, 156);
		panel.add(lblFoto);

		//OBTENER FOTO JUGADOR
		ImageIcon imgJugador = new ImageIcon("src/Repositorios/sinImagen.png");
		Icon imagenJugador = new ImageIcon(imgJugador.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
		lblFoto.setIcon(imagenJugador);
		
		txtNombreBuscar = new JTextField();
		txtNombreBuscar.setBounds(125, 151, 164, 20);
		panel.add(txtNombreBuscar);
		txtNombreBuscar.setColumns(10);
		
		lblInformativo = new JLabel("FICHAS JUGADOR");
		lblInformativo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblInformativo.setToolTipText("");
		lblInformativo.setOpaque(true);
		lblInformativo.setFocusable(false);
		lblInformativo.setForeground(Color.WHITE);
		lblInformativo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblInformativo.setBackground(new Color(144, 238, 144));
		lblInformativo.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		lblInformativo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformativo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblInformativo.setBounds(85, 40, 930, 30);
		panel.add(lblInformativo);
		
		ImageIcon imgCabecera = new ImageIcon(VistaFichas.class.getResource("/Repositorios/lblInformativo.jpg"));
		Icon imagenCabecera = new ImageIcon(imgCabecera.getImage().getScaledInstance(lblInformativo.getWidth(), imgCabecera.getIconHeight(), Image.SCALE_DEFAULT));
		lblInformativo.setIcon(imagenCabecera);
		
		lblBuscadorDeJugadores = new JLabel("BUSCADOR DE JUGADORES");
		lblBuscadorDeJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscadorDeJugadores.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		lblBuscadorDeJugadores.setBounds(414, 106, 229, 14);
		panel.add(lblBuscadorDeJugadores);
		
		txtApellidoBuscar = new JTextField();
		txtApellidoBuscar.setColumns(10);
		txtApellidoBuscar.setBounds(449, 151, 164, 20);
		panel.add(txtApellidoBuscar);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(45, 154, 70, 14);
		panel.add(lblNombre);
		
		lblApellido_1 = new JLabel("APELLIDO");
		lblApellido_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblApellido_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido_1.setBounds(362, 154, 77, 14);
		panel.add(lblApellido_1);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		btnBuscar.setBounds(949, 150, 89, 23);
		panel.add(btnBuscar);
		
		JLabel lblFichaDeJugador = new JLabel("FICHA DE JUGADOR");
		lblFichaDeJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblFichaDeJugador.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		lblFichaDeJugador.setBounds(473, 242, 127, 14);
		panel.add(lblFichaDeJugador);
		
		comboBoxSelecEquipo = new JComboBox();
		comboBoxSelecEquipo.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		comboBoxSelecEquipo.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Seleccione Equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		comboBoxSelecEquipo.setBounds(671, 136, 248, 40);
		comboBoxSelecEquipo.setModel(new DefaultComboBoxModel(new String[] {"SENIOR", "JUVENIL A", "- JUVENIL B", "- CADETE A", "- CADETE B", "- INFANTIL A", "- INFANTIL B", "- ALEVIN A", "- ALEVIN B", "- BENJAMIN A", "- BENJAMIN B"}));
		panel.add(comboBoxSelecEquipo);
		
		txtObservaciones = new JTextArea();
		txtObservaciones.setEnabled(false);
		txtObservaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtObservaciones.setBounds(414, 385, 398, 90);
		panel.add(txtObservaciones);
		
		lblObservaciones = new JLabel("OBSERVACIONES");
		lblObservaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObservaciones.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblObservaciones.setBounds(274, 390, 130, 14);
		panel.add(lblObservaciones);
		
		btnInsert = new JButton("INSERTAR");
		btnInsert.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		btnInsert.setBounds(914, 279, 100, 23);
		panel.add(btnInsert);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		btnGuardar.setBounds(914, 315, 100, 23);
		panel.add(btnGuardar);
		
		btnModificar = new JButton("HABILITAR");
		btnModificar.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		btnModificar.setBounds(914, 357, 100, 23);
		panel.add(btnModificar);
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		btnBorrar.setBounds(914, 400, 100, 23);
		panel.add(btnBorrar);
		
		tablaEst = new JTable();
		tablaEst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaEst.setRowSelectionAllowed(false);
		tablaEst.setRowHeight(18);
		tablaEst.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		tablaEst.setFocusable(false);
		tablaEst.setBorder(new LineBorder(Color.BLACK));

		tablaEst.setModel(new DefaultTableModel(
			new Object[][] {
				{"PARTIDOS JUGADOS", "GOLES", "ASISTENCIAS", "TARJETAS AMARILLAS", "TARJETAS ROJAS"},
				{null, null, null, null, null},
			},
			new String[] {
				"PARTIDOS JUGADOS", "GOLES", "ASISTENCIAS", "TARJETAS AMARILLAS", "TARJETAS ROJAS"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablaEst.getColumnModel().getColumn(0).setResizable(false);
		tablaEst.setBorder(new LineBorder(new Color(1, 1, 1)));
		tablaEst.setBounds(85, 600, 929, 36);
		panel.add(tablaEst);
		
		lblEstadsticasDeJugador = new JLabel("ESTAD\u00CDSTICAS DE JUGADOR");
		lblEstadsticasDeJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadsticasDeJugador.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		lblEstadsticasDeJugador.setBounds(445, 567, 194, 14);
		panel.add(lblEstadsticasDeJugador);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(85, 208, 930, 2);
		panel.add(separator);
		
		JSeparator separator2 = new JSeparator();
		separator2.setBounds(85, 520, 930, 2);
		panel.add(separator2);
		
		JLabel lblImagenFondo = new JLabel("");
		lblImagenFondo.setAlignmentX(Component.CENTER_ALIGNMENT);
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
		
		btnBuscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
                
            }
		});
	}
}
