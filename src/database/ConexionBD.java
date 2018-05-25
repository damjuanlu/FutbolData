package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {
	
    private String  maquina     = "localhost";
    private String  usuario     = "root";
    private String  clave       = "";
    private int puerto          = 3306;
    private String  servidor    = "";
    private static Connection conexion  = null;
    
    //CONSTRUCTOR
    //Recibe el nombre de la base de datos
    ConexionBD(String baseDatos){
        this.servidor="jdbc:mysql://"+this.maquina+":"+
                        this.puerto+"/"+baseDatos;
 
        //Registrar el driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR AL REGISTRAR EL DRIVER");
            System.exit(0); //parar la ejecución
        }
 
        //Establecer la conexión con el servidor
        try {
            conexion = DriverManager.getConnection(this.servidor,
                        this.usuario, this.clave);
        } catch (SQLException e) {
            System.err.println("ERROR AL CONECTAR CON EL SERVIDOR");
            System.exit(0); //parar la ejecución
        }
        System.out.println("Conectado a "+baseDatos);
    }
 
    //MOSTRAR USUARIOS
	public void mostrarusuarios(){

	       ResultSet result = null;
	       try {
	       	 
	       	String sql="select * from administradores";
	           PreparedStatement st = conexion.prepareStatement(sql);
	           result = st.executeQuery();
	           while (result.next()) {
	               System.out.print("User: ");
	               System.out.println(result.getString("usuario"));

	               System.out.print("Password: ");
	               System.out.println(result.getString("contraseña"));
	               System.out.println("=======================");
	           }
	       } catch (SQLException ex) {
	           System.err.println(ex.getMessage());
	       }
	   }
			//VERIFICACION DE USUARIOS ANTE LA BASE DE DATOS 	
			public boolean comparausers(String users){
	  
				boolean existe=false;
		 ResultSet result = null;
	    try {
	    	 
	    	String sql="select usuario from administradores";
	        PreparedStatement st = conexion.prepareStatement(sql);
	        result = st.executeQuery();
	        while (result.next()) {
	          String usu=result.getString("usuario");
	         
	         // AQUI SE INTRODUCE SI EL USUARIO FUERA EL ADMINISTRADOR ENVIARLO A OTRA VENTANDA DONDE 
	         //MUESTRE FUNCIONES ESPECIFICAS PARA ESE USUARIO COMO AGREGAR DIFERENTES USUARIOS AL SISTEMA 
	          
	          if(users.equals(usu)==true){
	       	   
	       	 existe=true;
	       	   
	          }else {
	       	  existe=false;
	       	   
	          }
	          
	        
	         
	        }
	    } catch (SQLException ex) {
	        System.err.println(ex.getMessage());
	    }
	    return existe;
	}
			// VERIFICACION DE CONTRASEÑA
			public boolean comparapassworsd(String contra){
		    boolean existe=false;
			 ResultSet result = null;
		     try {
		     	 
		     	String sql="select contraseña from administradores";
		         PreparedStatement st = conexion.prepareStatement(sql);
		         result = st.executeQuery();
		         while (result.next()) {
		           String pass=result.getString("contraseña");
		           if(pass.equals(contra)==true){
		        	   
		        	 existe=true;
		        	   
		           }else {
		        	  existe=false;
		        	   
		           }
		           
		         
		          
		         }
		     } catch (SQLException ex) {
		         System.err.println(ex.getMessage());
		     }
		     return existe;
		 }
    
    //Devuelve el objeto Connection que se usará en la clase Controller
    public static Connection getConexion() {
        return conexion;
    }

}
