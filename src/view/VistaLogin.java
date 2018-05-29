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
import javax.swing.*;
import javax.swing.UIManager.*;

public class VistaLogin extends JFrame{

	public JPanel panel;
	public JButton btnRegistrarse;
	public JButton btnIniciarSesion;
	public JButton btnLogin;
	public JTextField txtUser;
	public JPasswordField txtPassword;
	public JLabel lblError;
	public JLabel lblUsuario;
	public JLabel lblPassword;
	public JButton btnVolver;
	private final JLabel lblNewLabel = new JLabel("New label");

public VistaLogin() {
		
		setResizable(false);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int centroAncho = (ancho / 2) - 200;
		int centroAlto = (alto / 2) - 110;

        super.setBounds(centroAncho, centroAlto, 400, 220);
		
		panel = new JPanel();
		panel.setLayout(null);
		setTitle("SportClubData");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/Repositorios/icon-soccer/026-strategy-1.png"));
		
		super.setContentPane(panel);

		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		btnRegistrarse.setBounds(124, 59, 145, 23);
		panel.add(btnRegistrarse);
		
		btnIniciarSesion = new JButton("INICIAR SESI\u00D3N");
		btnIniciarSesion.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		btnIniciarSesion.setBounds(124, 105, 145, 23);
		panel.add(btnIniciarSesion);
		
		lblUsuario = new JLabel("USUARIO");
		lblUsuario.setVisible(false);
		lblUsuario.setBounds(170, 46, 53, 15);
		panel.add(lblUsuario);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		
		lblPassword = new JLabel("CONTRASE\u00D1A");
		lblPassword.setVisible(false);
		lblPassword.setBounds(155, 91, 83, 15);
		panel.add(lblPassword);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		
		txtUser = new JTextField();
		txtUser.setVisible(false);
		txtUser.setBounds(137, 61, 120, 21);
		panel.add(txtUser);
		txtUser.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		txtUser.setColumns(10);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setVisible(false);
		btnLogin.setBounds(137, 157, 120, 23);
		panel.add(btnLogin);
		btnLogin.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		
		txtPassword = new JPasswordField();
		txtPassword.setVisible(false);
		txtPassword.setBounds(137, 106, 120, 20);
		panel.add(txtPassword);
		
		JLabel lblVersion = new JLabel("0.9.4");
		lblVersion.setBounds(10, 176, 24, 15);
		panel.add(lblVersion);
		lblVersion.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblVersion.setForeground(Color.BLACK);
		
		lblError = new JLabel("Usuario o Contrase\u00F1a incorrectos.");
		lblError.setVisible(false);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 12));
		lblError.setBounds(99, 21, 195, 14);
		panel.add(lblError);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setVisible(false);
		btnVolver.setMargin(new Insets(2, 5, 2, 5));
		btnVolver.setFont(new Font("Palatino Linotype", Font.PLAIN, 9));
		btnVolver.setBounds(335, 0, 59, 23);
		panel.add(btnVolver);
		lblNewLabel.setIcon(new ImageIcon(VistaLogin.class.getResource("/Repositorios/fondo3.jpg")));
		lblNewLabel.setBounds(-78, -27, 511, 330);
		panel.add(lblNewLabel);
		
		//ACTION LISTENER
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

	}
}
