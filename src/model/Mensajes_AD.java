package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mensajes_AD {
	
	public Mensajes_AD() {
		
	}
	
	public Mensajes_TD BuscarMensajes () {
		try {
			Mensajes_TD mensaje = null;
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("SELECT * FROM mensajes");
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			Statement stmt = miConexion.createStatement();
		    ResultSet result = stmt.executeQuery(InstruccionSQL);
			while(result.next()) {
				int codigo=result.getInt(1);
				String mensaje_bd=result.getString(2);
				String usuario_mensaje=result.getString(3);
				mensaje = new Mensajes_TD(codigo,mensaje_bd,usuario_mensaje);
			  }
			miSentencia.close();
			miConexion.close();
			return mensaje;
		} catch (SQLException e) {
			System.out.println("Error al buscar parametros");
			return null;
		} catch (NullPointerException e) {
			System.out.println("Error");
			return null;
		}
	}

}
