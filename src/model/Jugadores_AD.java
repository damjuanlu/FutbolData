package model;

import java.sql.*;
import java.util.ArrayList;

 
public class Jugadores_AD {
	
	public Jugadores_AD() {
		//vac�o
	}

	public Jugadores_TD BuscarJugador(String nombreBusc, String apellidoBusc, String equipoBusc) {
		try {
			
			Jugadores_TD jugador = null;

			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("SELECT * FROM jugadores WHERE nombre_jugador = '" +nombreBusc+"' AND apellido_jugador = '"+apellidoBusc+"' AND equipo='"+equipoBusc+"'");
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			Statement stmt = miConexion.createStatement();
		    ResultSet result = stmt.executeQuery(InstruccionSQL);
			while(result.next()) {
				int codigo=result.getInt(1);
				String nombre=result.getString(2);
				String apellido=result.getString(3);
				Date fecha_nac=result.getDate(4);
				String equipo=result.getString(5);
				String posicion=result.getString(6);
				int dorsal=result.getInt(7);
				jugador = new Jugadores_TD(codigo,nombre,apellido,fecha_nac,equipo,posicion,dorsal);
			  }
			
			miSentencia.close();
			miConexion.close();
			
			return jugador;
			
		} catch (SQLException e) {
			System.out.println("Error al buscar parametros");
			return null;
		} catch (NullPointerException e) {
			System.out.println("Error");
			return null;
		}
		
		

	}
	
	public ArrayList <Jugadores_TD> BuscaJugadoresEquipo(String equipoBusc) {
		try {
			
			Jugadores_TD jugador = null;

			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("SELECT * FROM jugadores WHERE equipo='"+equipoBusc+"'");
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			Statement stmt = miConexion.createStatement();
		    ResultSet result = stmt.executeQuery(InstruccionSQL);
			ArrayList <Jugadores_TD> arrayJugadores= new ArrayList <Jugadores_TD> ();
			while(result.next()) {
				int codigo=result.getInt(1);
				String nombre=result.getString(2);
				String apellido=result.getString(3);
				Date fecha_nac=result.getDate(4);
				String equipo=result.getString(5);
				String posicion=result.getString(6);
				int dorsal=result.getInt(7);
				jugador = new Jugadores_TD(codigo,nombre,apellido,fecha_nac,equipo,posicion,dorsal);
				arrayJugadores.add(jugador);
			  }
			
			miSentencia.close();
			miConexion.close();
			
			return arrayJugadores;
			
		} catch (SQLException e) {
			System.out.println("Error al buscar parametros");
			return null;
		} catch (NullPointerException e) {
			System.out.println("Error");
			return null;
		}
		
		

	}
	
	

}