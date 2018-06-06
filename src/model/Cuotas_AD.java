package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cuotas_AD {

	public Cuotas_AD() {
		
	}
	
	
	public Cuotas_TD muestraCuotas(String nombre, String apellido, String equipo) {
		
		try {
			
			Cuotas_TD cuota_jugador = null;

			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("SELECT * FROM cuotas WHERE nombre = '" +nombre+"' AND apellido = '"+apellido+"' AND equipo='"+equipo+"'");
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			Statement stmt = miConexion.createStatement();
		    ResultSet result = stmt.executeQuery(InstruccionSQL);
			while(result.next()) {
				int cod_cuota=result.getInt(1);
				int cod_jug=result.getInt(2);
				String nombre_cuota=result.getString(3);
				String apellido_cuota=result.getString(4);
				String equipo_cuota=result.getString(5);
				int cantidad=result.getInt(6);
				boolean bool_pagar=result.getBoolean(7);
				cuota_jugador = new Cuotas_TD(cod_cuota,cod_jug,nombre_cuota,apellido_cuota,equipo_cuota,cantidad,bool_pagar);
			  }
			
			miSentencia.close();
			miConexion.close();
			
			return cuota_jugador;
			
		} catch (SQLException e) {
			System.out.println("Error al buscar parametros");
			return null;
		} catch (NullPointerException e) {
			System.out.println("Error");
			return null;
		}
		
	}
}
