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
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;

public class VistaAñadirEquipo extends JFrame {
	
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
	public JLabel lblUser;
	public JButton btnGuardar;
	public JButton btnVolver;
	public JLabel lblImagenFondo;
	public JLabel lblInformativo;
	public JTextField txtNombre;
	public JTextField txtCampo;
	public JTextField txtHorario;
	public JTextField txtEntrenamiento;
	
	public VistaAñadirEquipo(){
		
setResizable(false);
		
		int CentrarAncho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int CentrarAlto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		int ancho=700;
		int alto=400;
	
		super.setBounds(((CentrarAncho / 2) - 540), ((CentrarAlto / 2) - 360), ancho, alto);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setLayout(null);
		setTitle("SportClubData - GESTION DE EQUIPOS");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/Repositorios/logoSCD_32x32.png"));
		
		super.setContentPane(panel);
		
		lblUser = new JLabel("");
		lblUser.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setBounds(800, 0, 260, 21);
		panel.add(lblUser);

		btnVolver = new JButton("VOLVER");
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.setFocusable(false);
		btnVolver.setDefaultCapable(false);
		btnVolver.setFocusPainted(false);
		btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnVolver.setBounds(600, 350, 100, 23);
		btnVolver.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		panel.add(btnVolver);
		
		lblInformativo = new JLabel("NUEVO EQUIPO");
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
		lblInformativo.setBounds(40, 40, 588, 30);
		panel.add(lblInformativo);
		
		JLabel lblVersion = new JLabel("0.9.8");
		lblVersion.setBounds(10, 346, 24, 15);
		panel.add(lblVersion);
		lblVersion.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblVersion.setForeground(Color.BLACK);
		
		ImageIcon imgCabecera = new ImageIcon(VistaAñadirEquipo.class.getResource("/Repositorios/lblInformativo.jpg"));
		Icon imagenCabecera = new ImageIcon(imgCabecera.getImage().getScaledInstance(lblInformativo.getWidth(), imgCabecera.getIconHeight(), Image.SCALE_DEFAULT));
		lblInformativo.setIcon(imagenCabecera);
		
		JLabel lblNombreEquipo = new JLabel("NOMBRE EQUIPO");
		lblNombreEquipo.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNombreEquipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreEquipo.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblNombreEquipo.setBounds(40, 125, 130, 14);
		panel.add(lblNombreEquipo);
		
		JLabel lblCampo = new JLabel("CAMPO");
		lblCampo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCampo.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblCampo.setBounds(40, 155, 130, 14);
		panel.add(lblCampo);
		
		JLabel lblEntrenamiento = new JLabel("ENTRENAMIENTO");
		lblEntrenamiento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntrenamiento.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblEntrenamiento.setBounds(40, 185, 130, 14);
		panel.add(lblEntrenamiento);
		
		JLabel lblHorario = new JLabel("HORARIO");
		lblHorario.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblHorario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorario.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblHorario.setBounds(40, 215, 130, 14);
		panel.add(lblHorario);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(180, 125, 400, 20);
		panel.add(txtNombre);
		
		txtCampo = new JTextField();
		txtCampo.setColumns(10);
		txtCampo.setBounds(180, 155, 400, 20);
		panel.add(txtCampo);
		
		txtHorario = new JTextField();
		txtHorario.setColumns(10);
		txtHorario.setBounds(180, 215, 400, 20);
		panel.add(txtHorario);
		
		txtEntrenamiento = new JTextField();
		txtEntrenamiento.setColumns(10);
		txtEntrenamiento.setBounds(180, 185, 400, 20);
		panel.add(txtEntrenamiento);

		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		btnGuardar.setBounds(297, 280, 100, 23);
		panel.add(btnGuardar);
		
		lblImagenFondo = new JLabel("");
		lblImagenFondo.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/Repositorios/background1080x720grey.png")));
		lblImagenFondo.setBounds(0, 0, 694, 374);
		panel.add(lblImagenFondo);
		
		//ACTION LISTENER
		
		
		btnGuardar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnVolver.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
