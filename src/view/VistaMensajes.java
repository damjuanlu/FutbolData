package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class VistaMensajes extends JFrame {
	
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
	private JMenu mnEntrenamiento;
	public JMenuItem mntmPlanificacionSesiones;
	private JMenu mnAdministracion;
	public JMenuItem mntmCuotasJugadores;
	private JMenu mnMensajes;
	private JMenuItem mntmMensajes;
	public JButton btnCerrarSesion;
	public JLabel lblUser;
	public JLabel lblNewLabel;
	public JButton btnEnviar;
	public JTextArea txtAreaMensaje;
	public JLabel lblInformativo;
	
	public VistaMensajes(){
		
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
		
		lblInformativo = new JLabel("ENVIAR MENSAJES");
		lblInformativo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblInformativo.setToolTipText("");
		lblInformativo.setOpaque(true);
		lblInformativo.setFocusable(false);
		lblInformativo.setForeground(Color.WHITE);
		lblInformativo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblInformativo.setBackground(new Color(144, 238, 144));
		lblInformativo.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblInformativo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformativo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblInformativo.setBounds(84, 86, 930, 30);
		panel.add(lblInformativo);
		
		ImageIcon imgCabecera = new ImageIcon(VistaMensajes.class.getResource("/Repositorios/lblInformativo.jpg"));
		Icon imagenCabecera = new ImageIcon(imgCabecera.getImage().getScaledInstance(lblInformativo.getWidth(), imgCabecera.getIconHeight(), Image.SCALE_DEFAULT));
		lblInformativo.setIcon(imagenCabecera);
		
		txtAreaMensaje = new JTextArea();
		txtAreaMensaje.setFont(new Font("Agency FB", Font.PLAIN, 15));
		txtAreaMensaje.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAreaMensaje.setBounds(274, 263, 525, 164);
		panel.add(txtAreaMensaje);
		
		btnEnviar = new JButton("ENVIAR");
		btnEnviar.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnEnviar.setBounds(491, 468, 91, 23);
		panel.add(btnEnviar);
		
		JLabel lblNewLabel_1 = new JLabel("MENSAJE");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNewLabel_1.setBounds(274, 235, 102, 14);
		panel.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("New label");
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
