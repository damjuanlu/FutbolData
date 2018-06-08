package model;

import java.sql.*;
import java.util.ArrayList;

 
public class Jugadores_AD {
	
	public Jugadores_AD() {
		//vacío
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
				String observaciones=result.getString(8);
				jugador = new Jugadores_TD(codigo,nombre,apellido,fecha_nac,equipo,posicion,dorsal,observaciones);
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
	
	public boolean ModificaJugador(int codigo, String nombre, String apellido, String equipo, String posicion, int dorsal, String observaciones) {
		try {
			Jugadores_TD jugador = null;
	
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("UPDATE jugadores SET nombre_jugador = '" +nombre+"',apellido_jugador = '"+apellido+"',equipo='"+equipo+"', posicion='"+posicion+"', dorsal='"+dorsal+"', observaciones='"+observaciones+"' WHERE cod_jugador="+codigo);
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			miSentencia.executeUpdate();
			miSentencia.close();
			miConexion.close();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Error al buscar parametros");
			return false;
		} catch (NullPointerException e) {
			System.out.println("Error");
			return false;
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
				String observaciones=result.getString(8);
				jugador = new Jugadores_TD(codigo,nombre,apellido,fecha_nac,equipo,posicion,dorsal,observaciones);
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
	
	public Jugadores_TD InsertaJugador(String nombre, String apellido, /*Date fecha,*/ String equipo, String posicion, int dorsal, String observaciones) {
		try {
			Jugadores_TD jugador=null;
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String busquedaID=("SELECT MAX(cod_jugador) FROM jugadores");
			PreparedStatement miSentenciaID= miConexion.prepareStatement(busquedaID);
			ResultSet rst = miSentenciaID.executeQuery();
			rst.next();
			int ID=(int)rst.getInt(1);
			ID=ID+1;
			String InstruccionSQL=("INSERT INTO jugadores (cod_jugador, nombre_jugador, apellido_jugador, fecha_nacimiento, equipo, posicion, dorsal) VALUES ("+ID+", '" +nombre+"','"+apellido+"','2000-10-10','"+equipo+"','"+posicion+"', "+dorsal+",'"+observaciones+"')");
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
	
	public boolean EliminaJugador (String nombre, String apellido, String equipo) {
		try {
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("DELETE FROM jugadores WHERE nombre_jugador = '" +nombre+"' AND apellido_jugador = '"+apellido+"' AND equipo='"+equipo+"'");
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			miSentencia.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		} catch (NullPointerException e) {
			System.out.println("Error");
			return false;
		}
	}
	
	public ArrayList<String> rellenaComboEquipos(){
		try {
			ArrayList<String> ListEquipo = new ArrayList();
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("SELECT nombre FROM equipos");
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			Statement stmt = miConexion.createStatement();
		    ResultSet result = stmt.executeQuery(InstruccionSQL);
			while(result.next()) {
				ListEquipo.add(result.getString("nombre"));
			  }
			
			miSentencia.close();
			miConexion.close();
			
			return ListEquipo;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} catch (NullPointerException e) {
			System.out.println("Error");
			return null;
		}

	}
	
	public ArrayList<String> rellenaComboJugadores(String nombre_equipo){

		try {
			ArrayList<String> ListJugador = new ArrayList();
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("SELECT nombre_jugador, apellido_jugador FROM jugadores WHERE equipo = '"+nombre_equipo+"'");
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			Statement stmt = miConexion.createStatement();
		    ResultSet result = stmt.executeQuery(InstruccionSQL);
			while(result.next()) {
				ListJugador.add(result.getString("nombre_jugador"+" "+"apellido_jugador"));
			  }
			
			miSentencia.close();
			miConexion.close();
			
			return ListJugador;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} catch (NullPointerException e) {
			System.out.println("Error");
			return null;
		}

	}
	
	
	

}
