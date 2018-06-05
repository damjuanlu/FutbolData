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

}
