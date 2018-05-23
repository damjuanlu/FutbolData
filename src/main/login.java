package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class login {

	private JFrame frame;
	private JTextField txtPassword;
	private JTextField txtUser;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setBounds(184, 34, 46, 14);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setBounds(173, 101, 68, 14);
		frame.getContentPane().add(lblContrasea);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(165, 126, 86, 20);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(165, 59, 86, 20);
		frame.getContentPane().add(txtUser);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(165, 169, 89, 23);
		frame.getContentPane().add(btnLogin);
	}

}
