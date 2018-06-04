package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Clasificacion_AD {
	
	public Clasificacion_AD(){
		
	}
	
	public ArrayList<Clasificacion_TD> CargaClasificacion (){
		try {
			
			Clasificacion_TD clasificacion = null;

			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
			System.out.println("Se ha conectado a la BD");
			String InstruccionSQL=("SELECT * FROM `clasificacion` ORDER BY puntos ASC, partidos_jug DESC, gol_favor ASC, gol_contra ASC");
			PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
			System.out.println(InstruccionSQL);
			Statement stmt = miConexion.createStatement();
		    ResultSet result = stmt.executeQuery(InstruccionSQL);
			ArrayList <Clasificacion_TD> arrayClasif= new ArrayList <Clasificacion_TD> ();
			while(result.next()) {
				int codigo=result.getInt(1);
				String nombre=result.getString(2);
				int puntos=result.getInt(3);
				int part_jug=result.getInt(4);
				int gol_fav=result.getInt(5);
				int gol_con=result.getInt(6);
				clasificacion = new Clasificacion_TD(codigo,nombre,puntos,part_jug,gol_fav,gol_con);
				arrayClasif.add(clasificacion);
			  }
			
			miSentencia.close();
			miConexion.close();
			
			return arrayClasif;
			
		} catch (SQLException e) {
			System.out.println("Error al buscar parametros");
			return null;
		} catch (NullPointerException e) {
			System.out.println("Error");
			return null;
		}
		
	}

}
