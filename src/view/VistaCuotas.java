package view;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class VistaCuotas extends JFrame{
	
	private JPanel panel;
	private JMenuBar menuPrincipal;
	public JMenuItem mntmInicio;
	private JMenu mnJugadores;
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
	private JLabel label;
	private JLabel label_1;
	public JTextField txtApellido;
	private JLabel label_2;
	private JLabel label_3;
	public JButton btnBuscarJug;
	public JComboBox comboEquipo;
	private JSeparator separator;
	private JLabel lblInformativo;
	public JTextField txtCuota;
	public JButton btnActualizar;
	public JCheckBox checkCuota;
	
	public VistaCuotas() {
		
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
		panel.setFont(new Font("Agency FB",Font.PLAIN, 15));
		
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
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Agency FB", Font.PLAIN, 15));
		txtNombre.setColumns(10);
		txtNombre.setBounds(123, 185, 164, 20);
		panel.add(txtNombre);
		
		lblInformativo = new JLabel("CUOTAS JUGADOR");
		lblInformativo.setIcon(new ImageIcon(VistaCuotas.class.getResource("/Repositorios/lblInformativo.jpg")));
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
		lblInformativo.setBounds(114, 54, 834, 30);
		panel.add(lblInformativo);
		
		label_1 = new JLabel("BUSCADOR DE JUGADORES");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Agency FB", Font.BOLD, 15));
		label_1.setBounds(411, 115, 229, 14);
		panel.add(label_1);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Agency FB", Font.PLAIN, 15));
		txtApellido.setColumns(10);
		txtApellido.setBounds(447, 185, 164, 20);
		panel.add(txtApellido);
		
		label_2 = new JLabel("NOMBRE");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Agency FB", Font.BOLD, 15));
		label_2.setBounds(42, 188, 70, 14);
		panel.add(label_2);
		
		label_3 = new JLabel("APELLIDO");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Agency FB", Font.BOLD, 15));
		label_3.setBounds(360, 188, 77, 14);
		panel.add(label_3);
		
		btnBuscarJug = new JButton("BUSCAR");
		btnBuscarJug.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnBuscarJug.setBounds(947, 184, 89, 23);
		panel.add(btnBuscarJug);
		
		comboEquipo = new JComboBox();
		comboEquipo.setModel(new DefaultComboBoxModel(new String[] {}));
		comboEquipo.setFont(new Font("Agency FB", Font.PLAIN, 15));
		comboEquipo.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Seleccione Equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		comboEquipo.setBounds(669, 170, 248, 40);
		panel.add(comboEquipo);
		
		separator = new JSeparator();
		separator.setBounds(84, 262, 930, 2);
		panel.add(separator);
		
		JLabel lblCuotasDeJugadores = new JLabel("CUOTAS DE JUGADORES");
		lblCuotasDeJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuotasDeJugadores.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblCuotasDeJugadores.setBounds(411, 295, 229, 14);
		panel.add(lblCuotasDeJugadores);
		
		JLabel lblCuotasalario = new JLabel("CUOTA/SALARIO");
		lblCuotasalario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCuotasalario.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblCuotasalario.setBounds(229, 362, 115, 14);
		panel.add(lblCuotasalario);
		
		txtCuota = new JTextField();
		txtCuota.setFont(new Font("Agency FB", Font.PLAIN, 15));
		txtCuota.setColumns(10);
		txtCuota.setBounds(354, 359, 164, 20);
		panel.add(txtCuota);
		
		checkCuota = new JCheckBox("CUOTA/SALARIO PAGADO");
		checkCuota.setFont(new Font("Agency FB", Font.BOLD, 15));
		checkCuota.setBounds(576, 360, 190, 23);
		panel.add(checkCuota);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnActualizar.setBounds(411, 419, 229, 23);
		panel.add(btnActualizar);
		
		
		
		
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
		
	}
}
