package view;

import java.awt.*;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class VistaLogin extends JFrame{

	public JFrame frmSportClubData;
	public JTextField txtUser;
	public JButton btnLogin;
	public JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaLogin window = new VistaLogin();
					window.frmSportClubData.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSportClubData = new JFrame();
		frmSportClubData.setResizable(false);
		frmSportClubData.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rballesterosa\\git\\FutbolData\\Repositorios\\icon-soccer\\026-strategy-1.png"));
		frmSportClubData.setTitle("SportClubData");
		frmSportClubData.getContentPane().setBackground(new Color(255, 255, 204));
		frmSportClubData.setBounds(100, 100, 400, 250);
		frmSportClubData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSportClubData.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		lblUsuario.setBounds(127, 35, 140, 14);
		frmSportClubData.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		lblContrasea.setBounds(127, 95, 140, 14);
		frmSportClubData.getContentPane().add(lblContrasea);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		txtUser.setColumns(10);
		txtUser.setBounds(127, 55, 140, 20);
		frmSportClubData.getContentPane().add(txtUser);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		btnLogin.setBounds(127, 169, 140, 23);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		frmSportClubData.getContentPane().add(btnLogin);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(127, 115, 140, 20);
		frmSportClubData.getContentPane().add(txtPassword);
		
		JLabel lblVersion = new JLabel("0.9.4");
		lblVersion.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		lblVersion.setForeground(Color.LIGHT_GRAY);
		lblVersion.setBounds(358, 207, 36, 14);
		frmSportClubData.getContentPane().add(lblVersion);
	}
}
