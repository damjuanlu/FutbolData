package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.*;

import javax.swing.JOptionPane;

public class ConexionBD {
	
	public Connection conexion;
    public Statement statement;
    
    public String usuario;
    public String contrase�a;
    
    public ConexionBD(String usuario,String contrase�a){
    	this.usuario=usuario;
    	this.contrase�a=contrase�a;
    }
    
    public boolean ConexionBD(String usuario, String contrase�a){
        try{
            Class. forName ("com.mysql.jdbc.Driver");
            conexion= DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/sportdataclub",usuario,contrase�a);
            statement = conexion.createStatement(); 
    		return true;
        } catch(Exception e){
            Mensaje (" USUARIO O CONTRASE�A INCORRECTOS "+e);
            return false;
        }

        
    }
    void Mensaje (String ms){
     JOptionPane.showMessageDialog(null, ms);
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
