package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Mensajes_AD {
	
	public Mensajes_AD() {
		
	}
	
	public ArrayList<Mensajes_TD> BuscarMensajes () {
		try {
			Mensajes_TD mensaje = null;
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("SELECT * FROM mensajes");
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			Statement stmt = miConexion.createStatement();
		    ResultSet result = stmt.executeQuery(InstruccionSQL);
		    ArrayList <Mensajes_TD> ALMensajes= new ArrayList <Mensajes_TD> ();
			while(result.next()) {
				int codigo=result.getInt(1);
				String mensaje_bd=result.getString(2);
				String usuario_mensaje=result.getString(3);
				mensaje = new Mensajes_TD(codigo,mensaje_bd,usuario_mensaje);
				ALMensajes.add(mensaje);
			  }
			miSentencia.close();
			miConexion.close();
			return ALMensajes;
		} catch (NullPointerException e){
			System.out.println("Error al buscar parametros");
			return null;
		} catch (SQLException e)  {
			System.out.println("Error");
			return null;
		}
		
	}
	public Mensajes_TD InsertaMensaje (String mensaje) {
		try {
			Mensajes_TD mensajenuevo = null;
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("INSERT INTO MENSAJES (cod_mensaje, mensaje, usu_mensaje) VALUES (10,'"+mensaje+"','usuario'");
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			miSentencia.execute();
			miSentencia.close();
			miConexion.close();
			return mensajenuevo;
		} catch (NullPointerException e){
			System.out.println("Error al buscar parametros");
			return null;
		} catch (SQLException e)  {
			System.out.println("Error");
			return null;
		}
		
	}

}
