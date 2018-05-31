package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import view.*;

import javax.swing.JOptionPane;

public class ConexionBD {
	
	public Connection conexion;
    public Statement statement;
    
    public String usuario;
    public String contraseña;
    
    public ConexionBD(String usuario, String contraseña){
    	this.usuario=usuario;
    	this.contraseña=contraseña;
    }
    
    public boolean conexion (String usuario, String contraseña) {
        try{
        	DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            Connection conexion = DriverManager.getConnection (
                "jdbc:mysql://localhost/sportclubdata",usuario, contraseña);
            System.out.println("Conexión a la BD establecida");
            return true;
        } catch(Exception e){
          System.out.println(e);
          return false;
        }
    }

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

}
