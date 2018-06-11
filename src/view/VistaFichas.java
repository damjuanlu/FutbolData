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
	public JMenuItem mntmEstadisticas;
	public JMenu mnCompeticion;
	public JMenuItem mntmGestionEquipos;
	public JMenuItem mntmConvocatorias;
	public JMenuItem mntmPartidos;
	public JMenu mnEntrenamiento;
	public JMenuItem mntmPlanificacionSesiones;
	public JMenu mnAdministracion;
	public JMenuItem mntmCuotasJugadores;
	public JMenu mnMensajes;
	public JMenuItem mntmMensajes;
	public JButton btnCerrarSesion;
	public JLabel lblUser;
	public JTextField txtNombre;
	public JTextField txtEquipo;
	public JTextField txtApellido;
	public JTextField txtPosicion;
	public JTextField txtDorsal;
	public JLabel lblFoto;
	public JTextField txtNombreBuscar;
	public JLabel lblBuscadorDeJugadores;
	public JTextField txtApellidoBuscar;
	public JLabel lblNombre;
	public JLabel lblApellido_1;
	public JTextArea txtObservaciones;
	public JLabel lblObservaciones;
	public JButton btnSelectorFoto;
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
		
		btnSelectorFoto = new JButton("...");
		btnSelectorFoto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSelectorFoto.setFocusable(false);
		btnSelectorFoto.setDefaultCapable(false);
		btnSelectorFoto.setFocusPainted(false);
		btnSelectorFoto.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSelectorFoto.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSelectorFoto.setMargin(new Insets(0, 14, 0, 14));
		btnSelectorFoto.setToolTipText("Cambia Escudo");
		btnSelectorFoto.setBounds(180, 422, 30, 12);
		panel.add(btnSelectorFoto);
		
		btnSelectorFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Agency FB", Font.PLAIN, 15));
		txtNombre.setEnabled(false);
		txtNombre.setBounds(414, 285, 126, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEquipo = new JTextField();
		txtEquipo.setFont(new Font("Agency FB", Font.PLAIN, 15));
		txtEquipo.setEnabled(false);
		txtEquipo.setColumns(10);
		txtEquipo.setBounds(414, 316, 126, 20);
		panel.add(txtEquipo);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Agency FB", Font.PLAIN, 15));
		txtApellido.setEnabled(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(675, 285, 137, 20);
		panel.add(txtApellido);
		
		txtPosicion = new JTextField();
		txtPosicion.setFont(new Font("Agency FB", Font.PLAIN, 15));
		txtPosicion.setEnabled(false);
		txtPosicion.setColumns(10);
		txtPosicion.setBounds(675, 316, 137, 20);
		panel.add(txtPosicion);
		
		txtDorsal = new JTextField();
		txtDorsal.setFont(new Font("Agency FB", Font.PLAIN, 15));
		txtDorsal.setEnabled(false);
		txtDorsal.setColumns(10);
		txtDorsal.setBounds(675, 347, 137, 20);
		panel.add(txtDorsal);
		
		JLabel lblNombreFic = new JLabel("NOMBRE");
		lblNombreFic.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreFic.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNombreFic.setBounds(274, 288, 130, 14);
		panel.add(lblNombreFic);
		
		JLabel lblApellidos = new JLabel("EQUIPO");
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidos.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblApellidos.setBounds(274, 319, 130, 14);
		panel.add(lblApellidos);
		
		JLabel lblCaducidadFicha = new JLabel("DORSAL");
		lblCaducidadFicha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCaducidadFicha.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblCaducidadFicha.setBounds(550, 350, 115, 14);
		panel.add(lblCaducidadFicha);
		
		JLabel lblPosicin = new JLabel("POSICI\u00D3N");
		lblPosicin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPosicin.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblPosicin.setBounds(550, 319, 115, 14);
		panel.add(lblPosicin);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("Agency FB", Font.BOLD, 15));
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
		lblInformativo.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblInformativo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformativo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblInformativo.setBounds(85, 40, 930, 30);
		panel.add(lblInformativo);
		
		ImageIcon imgCabecera = new ImageIcon(VistaFichas.class.getResource("/Repositorios/lblInformativo.jpg"));
		Icon imagenCabecera = new ImageIcon(imgCabecera.getImage().getScaledInstance(lblInformativo.getWidth(), imgCabecera.getIconHeight(), Image.SCALE_DEFAULT));
		lblInformativo.setIcon(imagenCabecera);
		
		lblBuscadorDeJugadores = new JLabel("BUSCADOR DE JUGADORES");
		lblBuscadorDeJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscadorDeJugadores.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblBuscadorDeJugadores.setBounds(414, 106, 229, 14);
		panel.add(lblBuscadorDeJugadores);
		
		txtApellidoBuscar = new JTextField();
		txtApellidoBuscar.setColumns(10);
		txtApellidoBuscar.setBounds(449, 151, 164, 20);
		panel.add(txtApellidoBuscar);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(45, 154, 70, 14);
		panel.add(lblNombre);
		
		lblApellido_1 = new JLabel("APELLIDO");
		lblApellido_1.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblApellido_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido_1.setBounds(362, 154, 77, 14);
		panel.add(lblApellido_1);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnBuscar.setBounds(949, 150, 89, 23);
		panel.add(btnBuscar);
		
		JLabel lblFichaDeJugador = new JLabel("FICHA DE JUGADOR");
		lblFichaDeJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblFichaDeJugador.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblFichaDeJugador.setBounds(473, 242, 127, 14);
		panel.add(lblFichaDeJugador);
		
		comboBoxSelecEquipo = new JComboBox();
		comboBoxSelecEquipo.setFont(new Font("Agency FB", Font.PLAIN, 15));
		comboBoxSelecEquipo.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Seleccione Equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		comboBoxSelecEquipo.setBounds(671, 136, 248, 40);
		comboBoxSelecEquipo.setModel(new DefaultComboBoxModel(new String[] {/*"SENIOR", "JUVENIL A", "- JUVENIL B", "- CADETE A", "- CADETE B", "- INFANTIL A", "- INFANTIL B", "- ALEVIN A", "- ALEVIN B", "- BENJAMIN A", "- BENJAMIN B"*/}));
		panel.add(comboBoxSelecEquipo);
		
		txtObservaciones = new JTextArea();
		txtObservaciones.setEnabled(false);
		txtObservaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtObservaciones.setBounds(414, 385, 398, 90);
		panel.add(txtObservaciones);
		
		lblObservaciones = new JLabel("OBSERVACIONES");
		lblObservaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObservaciones.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblObservaciones.setBounds(274, 390, 130, 14);
		panel.add(lblObservaciones);
		
		btnInsert = new JButton("INSERTAR");
		btnInsert.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnInsert.setBounds(914, 284, 100, 23);
		panel.add(btnInsert);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setEnabled(false);
		btnGuardar.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnGuardar.setBounds(914, 315, 100, 23);
		panel.add(btnGuardar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnModificar.setBounds(914, 346, 100, 23);
		panel.add(btnModificar);
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnBorrar.setBounds(914, 400, 100, 23);
		panel.add(btnBorrar);
		
		tablaEst = new JTable();
		tablaEst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaEst.setRowSelectionAllowed(false);
		tablaEst.setRowHeight(18);
		tablaEst.setFont(new Font("Agency FB", Font.PLAIN, 15));
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
		lblEstadsticasDeJugador.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblEstadsticasDeJugador.setBounds(445, 567, 194, 14);
		panel.add(lblEstadsticasDeJugador);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(85, 208, 930, 2);
		panel.add(separator);
		
		JSeparator separator2 = new JSeparator();
		separator2.setBounds(85, 520, 930, 2);
		panel.add(separator2);
		
		JLabel lblImagenFondo = new JLabel("");
		lblImagenFondo.setFont(new Font("Agency FB", Font.BOLD, 15));
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
