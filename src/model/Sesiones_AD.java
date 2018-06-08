package model;

import java.sql.*;
import java.util.ArrayList;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

 
public class Sesiones_AD {
	
	public Sesiones_AD() {
		//vacío
	}

	public Sesiones_TD BuscarSesion(String diaBusc) {
		try {
			
			Sesiones_TD sesion = null;

			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("SELECT * FROM entrenamientos WHERE dia = " +diaBusc+"");
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			Statement stmt = miConexion.createStatement();
		    ResultSet result = stmt.executeQuery(InstruccionSQL);
			while(result.next()) {
				int cod_sesion=result.getInt(1);
				String nombre=result.getString(2);
				String dia=result.getString(3);
				String minutos=result.getString(4);
				String objetivo=result.getString(5);
				String material=result.getString(6);
				String observaciones_sesion=result.getString(7);
				String calentamiento=result.getString(8);
				String parte_principal=result.getString(9);
				String vuelta_calma=result.getString(10);
				
				sesion = new Sesiones_TD(cod_sesion, nombre, dia, minutos, objetivo, material, observaciones_sesion, calentamiento, parte_principal, vuelta_calma);
			  }
			
			miSentencia.close();
			miConexion.close();
			
			return sesion;
			
		} catch (SQLException e) {
			System.out.println("Error al buscar parametros");
			return null;
		} catch (NullPointerException e) {
			System.out.println("Error");
			return null;
		}
		
		

	}
	
	public boolean ModificaSesion (	int cod_sesionModif, String nombreModif, String diaModif, String minutosModif, 
									String objetivoModif, String materialModif, String observaciones_sesionModif, 
									String calentamientoModif, String parte_principalModif, String vuelta_calmaModif) {
		try {
			Sesiones_TD sesion = null;
	
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			
			String InstruccionSQL=("UPDATE entrenamientos SET nombre = '" +nombreModif+"',dia = '"+diaModif+
									"',minutos='"+minutosModif+"', objetivo='"+objetivoModif+"', material='"+materialModif+"', observaciones_sesion='"+observaciones_sesionModif+
									"', calentamiento='"+calentamientoModif+"', parte_principal='"+parte_principalModif+"', vuelta_calma='"+vuelta_calmaModif+"' WHERE cod_sesion="+cod_sesionModif);
			
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

	
//	public ArrayList <Sesiones_TD> BuscaJugadoresEquipo(String SesionesBusc) {
//		try {
//			
//			Jugadores_TD jugador = null;
//
//			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
//			System.out.println("Se ha conectado a la BD");
//			String InstruccionSQL=("SELECT * FROM jugadores WHERE equipo='"+equipoBusc+"'");
//			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
//			System.out.println(InstruccionSQL);
//			Statement stmt = miConexion.createStatement();
//		    ResultSet result = stmt.executeQuery(InstruccionSQL);
//			ArrayList <Jugadores_TD> arrayJugadores= new ArrayList <Jugadores_TD> ();
//			while(result.next()) {
//				int codigo=result.getInt(1);
//				String nombre=result.getString(2);
//				String apellido=result.getString(3);
//				Date fecha_nac=result.getDate(4);
//				String equipo=result.getString(5);
//				String posicion=result.getString(6);
//				int dorsal=result.getInt(7);
//				String observaciones=result.getString(8);
//				jugador = new Jugadores_TD(codigo,nombre,apellido,fecha_nac,equipo,posicion,dorsal,observaciones);
//				arrayJugadores.add(jugador);
//			  }
//			
//			miSentencia.close();
//			miConexion.close();
//			
//			return arrayJugadores;
//			
//		} catch (SQLException e) {
//			System.out.println("Error al buscar parametros");
//			return null;
//		} catch (NullPointerException e) {
//			System.out.println("Error");
//			return null;
//		}
//			
//
//	}
	
	public boolean InsertaSesion(	String nombre, String dia, String minutos, 
										String objetivo, String material, String observaciones_sesion, 
										String calentamiento, String parte_principal, String vuelta_calma) {
		try {
			Sesiones_TD sesion=null;
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String busquedaID=("SELECT MAX(cod_sesion) FROM entrenamientos");
			PreparedStatement miSentenciaID= miConexion.prepareStatement(busquedaID);
			ResultSet rst = miSentenciaID.executeQuery();
			rst.next();
			int ID=(int)rst.getInt(1);
			ID=ID+1;
			String InstruccionSQL=("INSERT INTO entrenamientos (cod_sesion, nombre, dia, minutos, objetivo, material, observaciones_sesion, calentamiento, parte_principal, vuelta_calma) "
					+ "VALUES ("+ID+", '" +nombre+"','"+dia+"','"+minutos+"','"+objetivo+"','"+material+"', '"+observaciones_sesion+"','"+calentamiento+"','"+parte_principal+"','"+vuelta_calma+"')");
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
	
	public boolean EliminaSesion (int cod_sesion) {
		try {
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("DELETE FROM entrenamientos WHERE cod_sesion = " +cod_sesion+"");
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
	
	/*
	 * CORREGIR!!!!
	 */
	public ArrayList<String> rellenaComboSesion(String nombre_equipo){

		try {
			ArrayList<String> ListSesion = new ArrayList();
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("SELECT dia FROM entrenamientos WHERE nombre = '"+nombre_equipo+"'");
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			Statement stmt = miConexion.createStatement();
		    ResultSet result = stmt.executeQuery(InstruccionSQL);
			while(result.next()) {
				ListSesion.add(result.getString("dia"));
			  }
			
			miSentencia.close();
			miConexion.close();
			
			return ListSesion;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} catch (NullPointerException e) {
			System.out.println("Error");
			return null;
		}

	}
	
	

}
