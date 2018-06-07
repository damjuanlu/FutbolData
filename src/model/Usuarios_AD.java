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
		String InstruccionSQL="";
		PreparedStatement miSentencia=null;
		Statement stmt=null;
		Connection miConexion;
		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			
			try {
				
				System.out.println("Se ha conectado a la BD");
				InstruccionSQL=("CREATE USER '"+user+"'@'localhost' IDENTIFIED BY '"+password+"'");
				miSentencia= miConexion.prepareStatement(InstruccionSQL);
				System.out.println(InstruccionSQL);
				stmt = miConexion.createStatement();
			    stmt.execute(InstruccionSQL);
			    
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Campos introducidos erróneos");
			}
			//NO SE PUEDEN DAR PRIVILEGIOS DESDE JAVA
//			try {
//				InstruccionSQL=("GRANT ALL PRIVILEGES ON sportclubdata TO '"+user+"'@'localhost'");
//				miSentencia= miConexion.prepareStatement(InstruccionSQL);
//				System.out.println(InstruccionSQL);
//				stmt = miConexion.createStatement();
//			    stmt.execute(InstruccionSQL);
//			} catch (Exception e) {
//				JOptionPane.showMessageDialog(null, "Campos introducidos erróneos");
//			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
