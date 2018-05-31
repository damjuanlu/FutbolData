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
    public String contrase�a;
    
    public ConexionBD(String usuario, String contrase�a){
    	this.usuario=usuario;
    	this.contrase�a=contrase�a;
    }
    
    public boolean conexion (String usuario, String contrase�a) {
        try{
        	DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            Connection conexion = DriverManager.getConnection (
                "jdbc:mysql://localhost/sportclubdata",usuario, contrase�a);
            System.out.println("Conexi�n a la BD establecida");
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

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

}
