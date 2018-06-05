package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Estadisticas_AD {
	
	public Estadisticas_AD() {
		
	}
	
	public Estadisticas_TD BuscaEstadisticas(int cod_jugador) {
		try {
			
			Estadisticas_TD estadistica = null;

			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("SELECT * FROM estadisticas WHERE cod_jugador = "+cod_jugador);
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			Statement stmt = miConexion.createStatement();
		    ResultSet result = stmt.executeQuery(InstruccionSQL);
			while(result.next()) {
				int codigo=result.getInt(1);
				int partidos=result.getInt(2);
				int goles=result.getInt(3);
				int asistencias=result.getInt(4);
				int amarillas=result.getInt(5);
				int rojas=result.getInt(6);
				estadistica = new Estadisticas_TD(codigo, partidos, goles, asistencias, amarillas, rojas);
			  }
			
			miSentencia.close();
			miConexion.close();
			
			return estadistica;
			
		} catch (SQLException e) {
			System.out.println("Error al buscar parametros");
			return null;
		} catch (NullPointerException e) {
			System.out.println("Error");
			return null;
		}
	}
	
	public ArrayList<Estadisticas_TD> MuestraALLEStad() {
		try {
			
			Estadisticas_TD estadistica = null;
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("SELECT * FROM estadisticas");
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			Statement stmt = miConexion.createStatement();
		    ResultSet result = stmt.executeQuery(InstruccionSQL);
		    ArrayList <Estadisticas_TD> ALEstad= new ArrayList <Estadisticas_TD> ();
			while(result.next()) {
				int codigo=result.getInt(1);
				int partidos=result.getInt(2);
				int goles=result.getInt(3);
				int asistencias=result.getInt(4);
				int amarillas=result.getInt(5);
				int rojas=result.getInt(6);
				estadistica = new Estadisticas_TD(codigo,partidos,goles,asistencias,amarillas,rojas);
				ALEstad.add(estadistica);
			  }
			miSentencia.close();
			miConexion.close();
			return ALEstad;
			
		} catch (SQLException e) {
			System.out.println("Error al buscar parametros");
			return null;
		} catch (NullPointerException e) {
			System.out.println("Error");
			return null;
		}
	}

}
