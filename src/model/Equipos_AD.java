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
	
	public Equipos_TD InsertaJugador(String nombre, String apellido, /*Date fecha,*/ String equipo, String posicion, int dorsal) {
		try {
			Equipos_TD equipo_nuevo=null;
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String busquedaID=("SELECT MAX(cod_jugador) FROM jugadores");
			PreparedStatement miSentenciaID= miConexion.prepareStatement(busquedaID);
			ResultSet rst = miSentenciaID.executeQuery();
			rst.next();
			int ID=(int)rst.getInt(1);
			ID=ID+1;
			String InstruccionSQL=("INSERT INTO jugadores (cod_jugador, nombre_jugador, apellido_jugador, fecha_nacimiento, equipo, posicion, dorsal) VALUES ("+ID+", '" +nombre+"','"+apellido+"','2000-10-10','"+equipo+"','"+posicion+"', "+dorsal+")");
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
