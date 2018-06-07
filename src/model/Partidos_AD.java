package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Partidos_AD {
	
	public Partidos_AD() {
		
	}
	
	public ArrayList <Partidos_TD> BuscaPartidosEquipo(String nombreequipo) {
		
		try {
			
			Partidos_TD miPartido = null;
			
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("SELECT * FROM partidos WHERE eq_local='"+nombreequipo+"' OR eq_visit='"+nombreequipo+"'");
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			Statement stmt = miConexion.createStatement();
		    ResultSet result = stmt.executeQuery(InstruccionSQL);
			ArrayList <Partidos_TD> arrayPartidos= new ArrayList <Partidos_TD> ();
			while(result.next()) {
				int codigo=result.getInt(1);
				String eq_local=result.getString(2);
				String eq_visit=result.getString(3);
				int gol_loc=result.getInt(4);
				int gol_vis=result.getInt(5);
//				Date fecha=result.getDate(6);
//				Calendar cal = new GregorianCalendar();
//		        cal.setTime(fecha);
				String liga=result.getString(7);
				miPartido = new Partidos_TD(codigo,eq_local,eq_visit,gol_loc,gol_vis,liga);
				arrayPartidos.add(miPartido);
			  }
			
			miSentencia.close();
			miConexion.close();
			
			return arrayPartidos;
			
		} catch (SQLException e) {
			System.out.println("Error al buscar parametros");
			return null;
		} catch (NullPointerException e) {
			System.out.println("error");
			System.out.println(e);
			return null;
		}
		
	}
	
	public ArrayList <Partidos_TD> buscaTodosPartidos() {
		
		try {
			
			Partidos_TD miPartido = null;
			
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("SELECT * FROM partidos");
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			Statement stmt = miConexion.createStatement();
		    ResultSet result = stmt.executeQuery(InstruccionSQL);
			ArrayList <Partidos_TD> arrayPartidos= new ArrayList <Partidos_TD> ();
			while(result.next()) {
				int codigo=result.getInt(1);
				String eq_local=result.getString(2);
				String eq_visit=result.getString(3);
				int gol_loc=result.getInt(4);
				int gol_vis=result.getInt(5);
//				Date fecha=result.getDate(6);
//				Calendar cal = new GregorianCalendar();
//		        cal.setTime(fecha);
				String liga=result.getString(6);
				miPartido = new Partidos_TD(codigo,eq_local,eq_visit,gol_loc,gol_vis,liga);
				arrayPartidos.add(miPartido);
			  }
			
			miSentencia.close();
			miConexion.close();
			
			return arrayPartidos;
			
		} catch (SQLException e) {
			System.out.println("Error al buscar parametros");
			return null;
		} catch (NullPointerException e) {
			System.out.println("error");
			System.out.println(e);
			return null;
		}
		
	}
	
	public boolean InsertaPartido(String eq_local, String eq_visitante, int gol_local, int gol_visit, String liga) {
		try {
			Partidos_TD partido=null;
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String busquedaID=("SELECT MAX(cod_partido) FROM partidos");
			PreparedStatement miSentenciaID= miConexion.prepareStatement(busquedaID);
			ResultSet rst = miSentenciaID.executeQuery();
			rst.next();
			int ID=(int)rst.getInt(1);
			ID=ID+1;
			String InstruccionSQL=("INSERT INTO partidos (cod_partido, eq_local, eq_visit, gol_local, gol_visit, liga) VALUES ("+ID+", '" +eq_local+"','"+eq_visitante+"',"+gol_local+","+gol_visit+", '"+liga+"')");
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

}
