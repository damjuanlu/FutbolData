package model;

import java.sql.*;

public class Equipos_AD {
	
	public Equipos_AD() {
		
	}
	
	public Equipos_TD BuscaEquiposGestion (String nombreEq) {
		try {
			
			Equipos_TD equipo = null;

			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("SELECT * FROM equipos WHERE nombre = '" +nombreEq+"'");
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			Statement stmt = miConexion.createStatement();
		    ResultSet result = stmt.executeQuery(InstruccionSQL);
		    while(result.next()) {
				int codigo=result.getInt(1);
				String nombre=result.getString(2);
				String campo=result.getString(3);
				String entrenamiento=result.getString(4);
				String horario=result.getString(5);
				equipo = new Equipos_TD(codigo,nombre,campo,entrenamiento,horario);
			  }
		    
		    miSentencia.close();
		    miConexion.close();
		    
		    return equipo;
		    
		} catch (SQLException e) {
			System.out.println("Error al buscar parametros");
			return null;
		} catch (NullPointerException e) {
			System.out.println("Error");
			return null;
		}
	}
	
	public Equipos_TD InsertaJugador(String nombre, String campo, String entrenamiento, String horario) {
		try {
			Equipos_TD equipo_nuevo=null;
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String busquedaID=("SELECT MAX(cod_equipo) FROM equipos");
			PreparedStatement miSentenciaID= miConexion.prepareStatement(busquedaID);
			ResultSet rst = miSentenciaID.executeQuery();
			rst.next();
			int ID=(int)rst.getInt(1);
			ID=ID+1;
			String InstruccionSQL=("INSERT INTO equipos (cod_equipo, nombre, campo, dias_entrenamiento, horario) VALUES ("+ID+", '" +nombre+"','"+campo+"','"+entrenamiento+"','"+horario+")");
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			miSentencia.execute();
			return null;
			
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} catch (NullPointerException e) {
			System.out.println("Error");
			return null;
		}
	}
	

}
