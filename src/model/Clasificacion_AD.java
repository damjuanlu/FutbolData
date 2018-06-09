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
	
	public boolean ActualizaClasificacion (String eq_local, String eq_visit, int gol_local, int gol_visit) {
		
		boolean booleano=false;
		
		if (gol_local<gol_visit) {
			try {
				Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
				System.out.println("Se ha conectado a la BD");
				String InstruccionSQL=("UPDATE clasificacion SET partidos_jug=partidos_jug+1, gol_favor = gol_favor +"+gol_local+", gol_contra = gol_contra + "+gol_visit+" WHERE nombre_eq='"+eq_local+"'");
				PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
				System.out.println(InstruccionSQL);
				miSentencia.executeUpdate();

				String InstruccionSQL2=("UPDATE clasificacion SET puntos = puntos + 3, partidos_jug=partidos_jug+1, gol_favor = gol_favor +"+gol_visit+", gol_contra = gol_contra + "+gol_local+" WHERE nombre_eq='"+eq_visit+"'");
				PreparedStatement miSentencia2= miConexion.prepareStatement(InstruccionSQL2);
				System.out.println(InstruccionSQL2);
				miSentencia2.executeUpdate();
				booleano=true;
				return booleano;
			} catch (SQLException eexc) {
				System.out.println("Error al buscar parametros");
				return booleano;
			} catch (NullPointerException e) {
				System.out.println("Error");
				return booleano;
			}
		}
		if (gol_local>gol_visit) {
			try {
				Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
				System.out.println("Se ha conectado a la BD");
				String InstruccionSQL=("UPDATE clasificacion SET puntos = puntos + 3, partidos_jug=partidos_jug+1, gol_favor = gol_favor +"+gol_local+", gol_contra = gol_contra + "+gol_visit+" WHERE nombre_eq='"+eq_local+"'");
				PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
				System.out.println(InstruccionSQL);
				miSentencia.executeUpdate();

				String InstruccionSQL2=("UPDATE clasificacion SET partidos_jug=partidos_jug+1, gol_favor = gol_favor +"+gol_visit+", gol_contra = gol_contra + "+gol_local+" WHERE nombre_eq='"+eq_visit+"'");
				PreparedStatement miSentencia2= miConexion.prepareStatement(InstruccionSQL2);
				System.out.println(InstruccionSQL2);
				miSentencia2.executeUpdate();
				booleano=true;
				return booleano;
			} catch (SQLException eexc) {
				System.out.println("Error al buscar parametros");
				return booleano;
			} catch (NullPointerException e) {
				System.out.println("Error");
				return booleano;
			}
		}
		if (gol_local==gol_visit) {
			try {
				Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost/sportclubdata", "presidente", "presidente");
				System.out.println("Se ha conectado a la BD");
				String InstruccionSQL=("UPDATE clasificacion SET puntos = puntos + 1, partidos_jug=partidos_jug+1, gol_favor = gol_favor +"+gol_visit+", gol_contra = gol_contra + "+gol_local+" WHERE nombre_eq='"+eq_local+"'");
				PreparedStatement miSentencia= miConexion.prepareStatement(InstruccionSQL);
				System.out.println(InstruccionSQL);
				miSentencia.executeUpdate();

				String InstruccionSQL2=("UPDATE clasificacion SET puntos = puntos + 1, partidos_jug=partidos_jug+1, gol_favor = gol_favor +"+gol_visit+", gol_contra = gol_contra + "+gol_local+" WHERE nombre_eq='"+eq_visit+"'");
				PreparedStatement miSentencia2= miConexion.prepareStatement(InstruccionSQL2);
				System.out.println(InstruccionSQL2);
				miSentencia2.executeUpdate();
				booleano=true;
				return booleano;
			} catch (SQLException eexc) {
				System.out.println("Error al buscar parametros");
				return booleano;
			} catch (NullPointerException e) {
				System.out.println("Error");
				return booleano;
			}
		}
		
		return booleano;
	}

}
