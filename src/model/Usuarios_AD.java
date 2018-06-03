package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Usuarios_AD {
	
	public Usuarios_AD() {
		
	}
	
	public void CreaUsuario(String user, String password) {
		try {
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("CREATE USER '"+user+"'@'localhost' IDENTIFIED BY '"+password+"'");
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			Statement stmt = miConexion.createStatement();
		    stmt.executeQuery(InstruccionSQL);
			InstruccionSQL=("GRANT ALL PRIVILEGES ON * . * TO '"+user+"'@'localhost'");
			miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			stmt = miConexion.createStatement();
		    stmt.executeQuery(InstruccionSQL);
		    
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Campos introducidos erróneos");
		}
	}

}
