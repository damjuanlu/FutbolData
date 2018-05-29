package view;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class VistaRegistro extends JFrame{

	public JPanel panel;
	public JButton btnGuardaRegistro;
	public JTextField txtRegistroUser;
	public JPasswordField txtRegistroPassword;
	public JLabel lblError;
	public JLabel lblUsuario;
	public JLabel lblPassword;
	public JLabel lblRepitaPassword;
	public JPasswordField txtRepitaPassword;
	public JButton btnVolver;
	private JLabel label;

public VistaRegistro() {
		
		setResizable(false);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int centroAncho = (ancho / 2) - 200;
		int centroAlto = (alto / 2) - 110;

        super.setBounds(centroAncho, centroAlto, 400, 220);
		
		panel = new JPanel();
		//panel.setBackground(new Color(255, 255, 204));
		panel.setLayout(null);
		setTitle("SportClubData - REGISTRO");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/Repositorios/icon-soccer/026-strategy-1.png"));
		
		super.setContentPane(panel);
		
		lblUsuario = new JLabel("NOMBRE DE USUARIO");
		lblUsuario.setBounds(113, 46, 167, 15);
		panel.add(lblUsuario);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		
		lblPassword = new JLabel("CONTRASE\u00D1A");
		lblPassword.setBounds(70, 93, 83, 15);
		panel.add(lblPassword);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		
		txtRegistroUser = new JTextField();
		txtRegistroUser.setBounds(137, 61, 120, 21);
		panel.add(txtRegistroUser);
		txtRegistroUser.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		txtRegistroUser.setColumns(10);
		
		btnGuardaRegistro = new JButton("REGISTRAR");
		btnGuardaRegistro.setBounds(137, 157, 120, 23);
		panel.add(btnGuardaRegistro);
		btnGuardaRegistro.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		
		txtRegistroPassword = new JPasswordField();
		txtRegistroPassword.setBounds(51, 108, 120, 20);
		panel.add(txtRegistroPassword);
		
		JLabel lblVersion = new JLabel("0.9.4");
		lblVersion.setBounds(365, 176, 24, 15);
		panel.add(lblVersion);
		lblVersion.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblVersion.setForeground(Color.LIGHT_GRAY);
		
		lblError = new JLabel("Usuario o Contrase\u00F1a incorrectos.");
		lblError.setVisible(false);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 12));
		lblError.setBounds(99, 21, 195, 14);
		panel.add(lblError);
		
		lblRepitaPassword = new JLabel("REPITA CONTRASE\u00D1A");
		lblRepitaPassword.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		lblRepitaPassword.setBounds(215, 93, 134, 14);
		panel.add(lblRepitaPassword);
		
		txtRepitaPassword = new JPasswordField();
		txtRepitaPassword.setBounds(222, 108, 120, 20);
		panel.add(txtRepitaPassword);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setMargin(new Insets(2, 5, 2, 5));
		btnVolver.setFont(new Font("Palatino Linotype", Font.PLAIN, 9));
		btnVolver.setBounds(335, 0, 59, 23);
		panel.add(btnVolver);
		
		label = new JLabel("New label");
		label.setIcon(new ImageIcon(VistaRegistro.class.getResource("/Repositorios/fondo3.jpg")));
		label.setBounds(-74, -30, 511, 330);
		panel.add(label);
		
		btnGuardaRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

	}
}
