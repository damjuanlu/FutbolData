package pruebas;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.lang.model.element.Element;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument.Content;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.swing.text.Document;

import com.mysql.*;

import AD_UT2_1.ConectarBDs;
import Ejercicios.Panelprincipal;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.net.URLPermission;
import java.io.*;
import java.util.*;
import java.sql.*;


public class LogicaBDSQL  extends Thread {

	connectBD conet;
	PanelProductos productos;
	PanelClientes clientes;
	PanelVentas ventas;
	PanelEmpleado empleados;
	ArrayList<InformeVentas> Informes;

//////////////////////////// LOGICA SQL PRODUCTOS//////////////////////////////////
	
	public void inserta_Registros(PanelProductos productos, int opcion){ //  JFRAME PRODUCTOS , OPCION DE BASE DE DATOS
		
		switch (opcion) {
			case 1:
				try{
					
					conet=new connectBD();
					conet.conexionMySQL();
					String instruccionSql="insert into productos values(?,?,?,?)";
					PreparedStatement miSentencia=conet.getConexion().prepareStatement(instruccionSql);
					miSentencia.setInt(1, productos.getID());
					System.out.println(productos.getID());
					miSentencia.setString(2, productos.getDescpri());
					System.out.println(productos.getDescpri());
					miSentencia.setInt(3, productos.getstock());
					miSentencia.setInt(4, productos.getpvp());
					System.out.println("se inserto de forma correcta");
					miSentencia.executeUpdate();
					conet.close();
						
				}catch(SQLException e){
					JOptionPane.showMessageDialog(null, "Error en la sentencia SQL", "Error",JOptionPane.ERROR_MESSAGE);
					
				}
			break;
			case 2:
				try {
				conet=new connectBD();
				conet.conexionSQlitepractica();
				String instruccionSql="insert into productos values(?,?,?,?)";
				PreparedStatement miSentencia=conet.getConexion().prepareStatement(instruccionSql);
				miSentencia.setInt(1, productos.getID());
				System.out.println(productos.getID());
				miSentencia.setString(2, productos.getDescpri());
				System.out.println(productos.getDescpri());
				miSentencia.setInt(3, productos.getstock());
				miSentencia.setInt(4, productos.getpvp());
				System.out.println("se inserto de forma correcta");
				miSentencia.executeUpdate();
				conet.close();
					
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, "Error en la sentencia SQL", "Error",JOptionPane.ERROR_MESSAGE);
				
			}
				
			break;
				
				
		}
		
		
			
		
		
		
	}

	public  Productos busca_registro (int id,int opcion){
		 ///Productos servicio;
		Productos productos=new Productos();

		switch (opcion) {
		case 1:
		
			try{
				conet=new connectBD();
				conet.conexionMySQL();
				PreparedStatement miSentencia = conet.getConexion().prepareStatement("SELECT * FROM PRODUCTOS WHERE ID=?");
				miSentencia.setInt(1, id);
				ResultSet miResultset=miSentencia.executeQuery(); 
				
		
					while(miResultset.next()){
	
						productos.setid(miResultset.getInt("ID"));
						//producto.txtid.setText(miResultset.getInt("ID")+"");
						System.out.println(miResultset.getInt("ID"));
						productos.setdescrip(miResultset.getString("DESCRIPCION"));
						//producto.txtdescrip.setText(miResultset.getString("DESCRIPCION"));
						productos.setStock(miResultset.getInt("STOCKANUAL"));
						productos.setpvp(miResultset.getDouble("PVP"));
						//producto.txtpvp.setText(miResultset.getDouble("PVP")+"");
						//producto.txtstock.setText(miResultset.getInt("STOCKANUAL")+"");
						}
				conet.close();
				
				
			} catch(Exception e){
				System.out.println("Error de conexión con la BD o en la sentencia SQL.");
			}
			
		
		break;
		
		case 2:
			
			try{
				conet=new connectBD();
				conet.conexionSQlitepractica();
				PreparedStatement miSentencia = conet.getConexion().prepareStatement("SELECT * FROM PRODUCTOS WHERE ID=?");
				miSentencia.setInt(1, id);
				ResultSet miResultset=miSentencia.executeQuery(); 
				
		
					while(miResultset.next()){
	
						productos.setid(miResultset.getInt("ID"));
						//producto.txtid.setText(miResultset.getInt("ID")+"");
						System.out.println(miResultset.getInt("ID"));
						productos.setdescrip(miResultset.getString("DESCRIPCION"));
						//producto.txtdescrip.setText(miResultset.getString("DESCRIPCION"));
						productos.setStock(miResultset.getInt("STOCKANUAL"));
						productos.setpvp(miResultset.getDouble("PVP"));
						//producto.txtpvp.setText(miResultset.getDouble("PVP")+"");
						//producto.txtstock.setText(miResultset.getInt("STOCKANUAL")+"");
						}
				conet.close();
				
			} catch(Exception e){
				System.out.println("Error de conexión con la BD o en la sentencia SQL.");
			}
			
			break;
		
		
		}
		
		

			
		
			return productos;
		
	}
	
	public int numero_registros(int opcion ){
		//Variables generales para el metodo get
		conet=new connectBD();
		int contador=0;
		
		
		switch(opcion) {//Si opcion valadria x se realiza un procedimiento u otro 
		
		case 1:	//entonces en caso de valor 1
			//Realiza la conexion a la base de datos "MariaDB"
			try { // capturamos la excencion en caso de fallo 
				conet.conexionMySQL();// se realiza la conexion del objeto contec y su parametro  
				PreparedStatement miSentencia2 = conet.getConexion().prepareStatement("SELECT * FROM PRODUCTOS"); // Nos ayuda a establcer la comunicacion con la base de datos
				ResultSet miResultset=miSentencia2.executeQuery();  // ejercutamos la setencia de conexion hacia la base de datos y la guardamos en un variable de tipo resultset
				
				
				while(miResultset.next()){// hasta que no exista nigun registro

					contador++; //por cada registro aumenta una unidad
				
					}
			}catch(SQLException e){
				System.out.println("Error de conexión con la BD o en la sentencia SQL :"	+e.getErrorCode());
		
			}
		
			break;
		
			case 2:
			
			try {
				conet.conexionSQlitepractica();
				PreparedStatement miSentencia2 = conet.getConexion().prepareStatement("SELECT * FROM PRODUCTOS");
				ResultSet miResultset=miSentencia2.executeQuery(); 
				while(miResultset.next()){

					contador++;
				
					}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Error en la sentencia SQL :"+ e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
			}
			conet.close();
			
		break;
		
		default:
			break;
		}
		
		return contador;
	}		

	public void modica_resgistro(PanelProductos producto){
		
		conet=new connectBD();
		conet.conexionMySQL();
		
		try{
			
			PreparedStatement miSentencia = conet.getConexion().prepareStatement("UPDATE productos SET descripcion=?, StockAnual=?,PVP=? where id="+producto.getID());
			//ResultSet miResultset=miSentencia.executeQuery(); 
			
			if (producto.getDescpri()!=null) {
			miSentencia.setString(2, productos.getDescpri());
			System.out.println(productos.getDescpri());
			}
			if (producto.getstock()!=0) {
				
			miSentencia.setInt(3, productos.getstock());
			}
			if (producto.getpvp()!=0) {
				miSentencia.setInt(4, productos.getpvp());
				System.out.println("se inserto de forma correcta");
				
			}
	
			int aja=miSentencia.executeUpdate();
			if(aja>0) {
				
				JOptionPane.showMessageDialog(null, "Se modifico de forma correcta");
			}
			conet.close();
			
			
		}catch(SQLException e){
			
			JOptionPane.showMessageDialog(null, "Error en la sentencia SQL :"+ e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);

			
		}
		
	}

	/********************************************************************************************************/
	//////////////////////LOGICA SQL CLIENTE///////////////////////////////
	
	public void insertaClientes(PanelClientes clientes, int opcion){
		conet=new connectBD();
		switch(opcion) {
		case 1:
			try{
			
				conet.conexionMySQL();
				String instruccionSql="insert into clientes values(?,?,?,?,?,?)";
				PreparedStatement miSentencia=conet.getConexion().prepareStatement(instruccionSql);
				miSentencia.setInt(1, clientes.getID());
				System.out.println(clientes.getID());
				miSentencia.setString(2, clientes.getNombre());
				miSentencia.setString(3, clientes.getDireccion());
				miSentencia.setString(4, clientes.getpoblacion());
				miSentencia.setString(5, clientes.getTelefono()+"");
				miSentencia .setString(6, clientes.getDNI());
				System.out.println("se inserto de forma correcta");
				miSentencia.executeUpdate();
				conet.close();
					
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, "Error en la sentencia SQL :"+ e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
				
			}
			
			break;
		case 2:
			try{
				
				conet.conexionSQlitepractica();
				String instruccionSql="insert into clientes values(?,?,?,?,?,?)";
				PreparedStatement miSentencia=conet.getConexion().prepareStatement(instruccionSql);
				miSentencia.setInt(1, clientes.getID());
				System.out.println(clientes.getID());
				miSentencia.setString(2, clientes.getNombre());
				miSentencia.setString(3, clientes.getDireccion());
				miSentencia.setString(4, clientes.getpoblacion());
				miSentencia.setString(5, clientes.getTelefono()+"");
				miSentencia .setString(6, clientes.getDNI());
				System.out.println("se inserto de forma correcta");
				miSentencia.executeUpdate();
				conet.close();
					
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, "Error en la sentencia SQL :"+ e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
				
			}
			break;
		default:
			break;
		
		
		}
		
		
		
		
		
		
	}
	
	public  Clientes busca_Clientes (int id,int opcion){
		conet=new connectBD();
		Clientes cliente=new Clientes();
		switch(opcion) {
		case 1:
				try{
					conet.conexionMySQL();
					PreparedStatement miSentencia = conet.getConexion().prepareStatement("SELECT * FROM clientes WHERE ID=?");
					miSentencia.setInt(1, id);
					ResultSet miResultset=miSentencia.executeQuery(); 
						while(miResultset.next()){
							cliente.setid(miResultset.getInt("ID"));
							//producto.txtid.setText(miResultset.getInt("ID")+"");
							System.out.println(miResultset.getInt("ID"));
							cliente.setnombre(miResultset.getString("Nombre"));
							//producto.txtdescrip.setText(miResultset.getString("DESCRIPCION"));
							cliente.setdireccion(miResultset.getString("direccion"));
							cliente.setpoblacion(miResultset.getString("Poblacion"));
							cliente.settelefono(Integer.parseInt(miResultset.getString("TELEF")));
							cliente.setnif(miResultset.getString("NIF"));
							//producto.txtpvp.setText(miResultset.getDouble("PVP")+"");
							//producto.txtstock.setText(miResultset.getInt("STOCKANUAL")+"");
							}
					conet.close();
					
				} catch(Exception e){
					System.out.println("Error de conexión con la BD o en la sentencia SQL.");
				}
		break;
		case 2:
			try{
				conet.conexionSQlitepractica();
				PreparedStatement miSentencia = conet.getConexion().prepareStatement("SELECT * FROM clientes WHERE ID=?");
				miSentencia.setInt(1, id);
				ResultSet miResultset=miSentencia.executeQuery(); 
					while(miResultset.next()){
						cliente.setid(miResultset.getInt("ID"));
						//producto.txtid.setText(miResultset.getInt("ID")+"");
						System.out.println(miResultset.getInt("ID"));
						cliente.setnombre(miResultset.getString("Nombre"));
						//producto.txtdescrip.setText(miResultset.getString("DESCRIPCION"));
						cliente.setdireccion(miResultset.getString("direccion"));
						cliente.setpoblacion(miResultset.getString("Poblacion"));
						cliente.settelefono(Integer.parseInt(miResultset.getString("TELEF")));
						cliente.setnif(miResultset.getString("NIF"));
						//producto.txtpvp.setText(miResultset.getDouble("PVP")+"");
						//producto.txtstock.setText(miResultset.getInt("STOCKANUAL")+"");
						}
				conet.close();
			} catch(Exception e){
				System.out.println("Error de conexión con la BD o en la sentencia SQL.");
			}
			break;
			default:
			break;
		
		
		}
		
		
			
			return cliente;
		
	}
	
	public int Clientes_totales(int opcion) {

		conet=new connectBD();
		int contador=0;
		switch(opcion) {
		case 1:
			try {
				conet.conexionMySQL();
				PreparedStatement miSentencia2 = conet.getConexion().prepareStatement("SELECT * FROM Clientes");
				ResultSet miResultset=miSentencia2.executeQuery(); 
				
				
				while(miResultset.next()){

					contador++;
				
					}

				
				
			
			conet.close();
				
				} catch(Exception e){
					System.out.println("Error de conexión con la BD o en la sentencia SQL.");
				}
			
			break;
		case 2:
			try {
				conet.conexionSQlitepractica();
				PreparedStatement miSentencia2 = conet.getConexion().prepareStatement("SELECT * FROM Clientes");
				ResultSet miResultset=miSentencia2.executeQuery(); 
				
				
				while(miResultset.next()){

					contador++;
				
					}

				
				
			
			conet.close();
				
				} catch(Exception e){
					System.out.println("Error de conexión con la BD o en la sentencia SQL.");
				}
			break;
		default:
			break;
		
		
		}
	
	
		
		
		return contador;
	}
	/********************************************************************************************************/
	///////////////////////////////////////*VENTAS*////////////////////////////////////////////
	
	public  void Inserta_ventas(PanelVentas venta,int opcion){

		conet=new connectBD();
		
			
			switch(opcion) {
			case 1:
				try {
					conet.conexionMySQL();
					
					String instruccionSql="insert into ventas values(?,?,?,?,?)";
					PreparedStatement miSentencia=conet.getConexion().prepareStatement(instruccionSql);
					miSentencia.setInt(1, venta.getid());
					miSentencia.setString(2, venta.getfecha());
					miSentencia.setInt(3, venta.getidCliente());
					miSentencia.setInt(4, venta.getidproducto());
					miSentencia.setInt(5, venta.getcantidad());
					int valor=miSentencia.executeUpdate();
					if (valor<0) {
						System.err.println("fallo al insertar");
						
					}else {
						
						System.out.println("se inserto de forma correcta");
					}
				conet.close();
					
				}catch(SQLException e){
				JOptionPane.showMessageDialog(null, "Error en la sentencia SQL: " +e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
				
				}
				
				break;
				case 2:
					try {
						conet.conexionSQlitepractica();
						
						String instruccionSql="insert into ventas values(?,?,?,?,?)";
						PreparedStatement miSentencia=conet.getConexion().prepareStatement(instruccionSql);
						miSentencia.setInt(1, venta.getid());
						miSentencia.setString(2, venta.getfecha());
						miSentencia.setInt(3, venta.getidCliente());
						miSentencia.setInt(4, venta.getidproducto());
						miSentencia.setInt(5, venta.getcantidad());
						int valor=miSentencia.executeUpdate();
						if (valor<0) {
							System.err.println("fallo al insertar");
							
						}else {
							
							System.out.println("se inserto de forma correcta");
						}
					conet.close();
						
					}catch(SQLException e){
					JOptionPane.showMessageDialog(null, "Error en la sentencia SQL", "Error",JOptionPane.ERROR_MESSAGE);
					
					}
				break;
			default:
				break;
			
			
			}
			
		
	}
	
	public  Ventas busca_ventas (int id,int opcion){

		
		Ventas venta=new Ventas();
		conet=new connectBD();
		
		switch(opcion) {
		case 1:
			try{
				conet.conexionMySQL();
				PreparedStatement miSentencia = conet.getConexion().prepareStatement("SELECT * FROM VENTAS WHERE IDVENTA=?");
				miSentencia.setInt(1, id);
				ResultSet miResultset=miSentencia.executeQuery(); 		
					while(miResultset.next()){
						venta.setid(miResultset.getInt("IDVENTA"));		
						venta.setfecha(miResultset.getString("FECHAVENTA"));
						venta.setidcliente(miResultset.getInt("IDCLIENTE"));
						venta.setidproducto(miResultset.getInt("IDPRODUCTO"));
						venta.setcantidad(miResultset.getInt("CANTIDAD"));
						}
					
				conet.close();
			
			
				
				
			} catch(Exception e){
				System.out.println("Error de conexión con la BD o en la sentencia SQL.");
			}
			
			break;
		case 2:
			try{
				conet.conexionSQlitepractica();
				PreparedStatement miSentencia = conet.getConexion().prepareStatement("SELECT * FROM VENTAS WHERE IDVENTA=?");
				miSentencia.setInt(1, id);
				ResultSet miResultset=miSentencia.executeQuery(); 		
					while(miResultset.next()){
						venta.setid(miResultset.getInt("IDVENTA"));		
						venta.setfecha(miResultset.getString("FECHAVENTA"));
						venta.setidcliente(miResultset.getInt("IDCLIENTE"));
						venta.setidproducto(miResultset.getInt("IDPRODUCTO"));
						venta.setcantidad(miResultset.getInt("CANTIDAD"));
						}
					
				conet.close();
			
			
				
				
			} catch(Exception e){
				System.out.println("Error de conexión con la BD o en la sentencia SQL.");
			}
			break;
		default:
			break;
		
		
		}
		
			
			
			return venta;
		
	}
	
	
	public int ventas_totales(int opcion) {


		conet=new connectBD();
		int contador=0;
		switch(opcion) {
		case 1:

			try {
				conet.conexionMySQL();
			PreparedStatement miSentencia2 = conet.getConexion().prepareStatement("SELECT * FROM ventas");
			ResultSet miResultset=miSentencia2.executeQuery(); 
			
			
			while(miResultset.next()){

				contador++;
			
				}

			
			
		
		conet.close();
			
			} catch(Exception e){
				System.out.println("Error de conexión con la BD o en la sentencia SQL.");
			}
			
			break;
		case 2:

			try {
				conet.conexionSQlitepractica();
			PreparedStatement miSentencia2 = conet.getConexion().prepareStatement("SELECT * FROM ventas");
			ResultSet miResultset=miSentencia2.executeQuery(); 
			
			
			while(miResultset.next()){

				contador++;
			
				}

			
			
		
		conet.close();
			
			} catch(Exception e){
				System.out.println("Error de conexión con la BD o en la sentencia SQL.");
			}
			break;
		default:
			break;
		
		
		}
		
		
		
		return contador;
	}
	
	public ArrayList<InformeVentas> listadoventas( int id ,int opcion ) {
	Informes=new ArrayList<>();	

	conet=new connectBD();
	
	switch (opcion) {
	case 1:
		try {
			conet.conexionMySQL();
				PreparedStatement sentencia=conet.getConexion().
						prepareStatement("select productos.ID, ventas.IDVENTA, productos.DESCRIPCION, productos.PVP*ventas.CANTIDAD as TOTAL from productos,ventas where ventas.idcliente=?");
				sentencia.setInt(1, id);
				ResultSet miResultset=sentencia.executeQuery();

				
				while (miResultset.next()) {
					
					int idpro=miResultset.getInt("ID");
					int idvent=miResultset.getInt("IDVENTA");
					String nom=miResultset.getString("DESCRIPCION");
					double totales=miResultset.getInt("TOTAL");
						InformeVentas infor=new InformeVentas(idpro, idvent, nom, totales);
						Informes.add(infor);

				}
				
		
			

			conet.close();
			
		}catch(SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Error en la sentencia SQL " + e.getLocalizedMessage(), "Error",JOptionPane.ERROR_MESSAGE);

			
		}

		break;
	case 2:
		try {
			conet.conexionSQlitepractica();;
				PreparedStatement sentencia=conet.getConexion().
						prepareStatement("select productos.id, ventas.IDVENTA, productos.DESCRIPCION, productos.PVP*ventas.CANTIDAD as TOTAL from productos,ventas where ventas.IDPRODUCTO=productos.id");
			
				ResultSet miResultset=sentencia.executeQuery();

				
				while (miResultset.next()) {
					
					int idpro=miResultset.getInt("ID");
					System.out.println(miResultset.getInt("IDPRODUCTO"));
					
					int idvent=miResultset.getInt("IDVENTA");
					System.out.println(miResultset.getInt("IDVENTA"));
					
					String nom=miResultset.getString("DESCRIPCION");
					System.out.println(miResultset.getString("DESCRIPCION"));
					
					double totales=miResultset.getInt("TOTAL");
					System.out.println(miResultset.getString("TOTAL"));
					System.out.println("--------------------");
				
						InformeVentas infor=new InformeVentas(idpro, idvent, nom, totales);
						Informes.add(infor);
					
					
				}
				
		
			

			conet.close();
			
		}catch(SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Error en la sentencia SQL " + e.getLocalizedMessage(), "Error",JOptionPane.ERROR_MESSAGE);

			
		}
		
		break;
	
	
	}

		return Informes;
		
		
	}

	public  int Comprascliente(int id, int opcion) {
		int totalventas=0;;
		Ventas venta=new Ventas();
		conet=new connectBD();
		
		switch(opcion) {
		case 1:
			try{
				conet.conexionMySQL();
				PreparedStatement miSentencia = conet.getConexion()
						.prepareStatement("select count(ventas.idproducto) as productos from ventas where idcliente=?");
				miSentencia.setInt(1, id);
				ResultSet miResultset=miSentencia.executeQuery(); 		
					while(miResultset.next()){
				totalventas=miResultset.getInt("productos");
						}	
					
				conet.close();
				
				
			
				
				
			} catch(SQLException e){
				System.out.println("Error de conexión con la BD o en la sentencia SQL.");
			}
			
			break;
		case 2:
			try{
				conet.conexionSQlitepractica();
				PreparedStatement miSentencia = conet.getConexion()
						.prepareStatement("select count(ventas.idproducto) as productos from ventas where idcliente=?");
				miSentencia.setInt(1, id);
				ResultSet miResultset=miSentencia.executeQuery(); 		
					while(miResultset.next()){
				totalventas=miResultset.getInt("productos");
						}
					
				conet.close();
			
			
				
				
			} catch(SQLException e){
				System.out.println("Error de conexión con la BD o en la sentencia SQL.");
			}
			break;
		default:
			break;
		
		
		}
		
			
			
			return totalventas;
		
		
	}
/***************************************************************************************/	
/////////////////////////////////////////////DEPARTAMENTOS////////////////////////
	
	public  void Inserta_departamento(PanelDepartamentos departa){
		
		try {
			conet=new connectBD();
			
			conet.conexionSQlitepractica();
			String instruccionSql="insert into departamentos values(?,?,?)";
			PreparedStatement miSentencia=conet.getConexion().prepareStatement(instruccionSql);
			miSentencia.setInt(1, departa.getid());
			miSentencia.setString(2, departa.getnom());
			miSentencia.setString(3, departa.getlocalidad());
		
			int valor=miSentencia.executeUpdate();
			if (valor<0) {
				System.err.println("fallo al insertar");
				
			}else {
				
				System.out.println("se inserto de forma correcta");
			}
		conet.close();
			
		}catch(SQLException e){
		JOptionPane.showMessageDialog(null, "Error en la sentencia SQL", "Error",JOptionPane.ERROR_MESSAGE);
		
		}
		
	}

	public  Departamentos busca_departa (int id){

		
		Departamentos departamento=new Departamentos();
		conet=new connectBD();
		conet.conexionSQlitepractica();
		
			try{
				PreparedStatement miSentencia = conet.getConexion().prepareStatement("SELECT * FROM departamentos where cod_departamento=? ");
				miSentencia.setInt(1, id);
				ResultSet miResultset=miSentencia.executeQuery(); 		
					while(miResultset.next()){
						 departamento.setid(miResultset.getInt("cod_departamento"));		
						 departamento.setnombre(miResultset.getString("nom_departamento"));
						 departamento.setlocalidad(miResultset.getString("localidad_deparmento"));
						}
					
				conet.close();
			
			
				
				
			} catch(Exception e){
				System.out.println("Error de conexión con la BD o en la sentencia SQL.");
			}
			
			return departamento;
		
	}
	
	public  ArrayList<Departamentos> departamentos(){
		ArrayList<Departamentos> depar=new ArrayList<>();
		Departamentos departamento;
		conet=new connectBD();
		conet.conexionSQlitepractica();
		
			try{
				PreparedStatement miSentencia = conet.getConexion().prepareStatement("SELECT * FROM departamentos");
				
				ResultSet miResultset=miSentencia.executeQuery(); 		
					while(miResultset.next()){
						 int i=miResultset.getInt("cod_departamento");		
						 String nom=miResultset.getString("nom_departamento");
						 String loca=miResultset.getString("localidad_deparmento");
						 departamento=new Departamentos(i,nom,loca);
						if (departamento!=null) {
							
							 depar.add(departamento);	
						}
						 
						
					}
				
				conet.close();
			
			
				
				
			} catch(Exception e){
				System.out.println("Error de conexión con la BD o en la sentencia SQL.");
			}
			
			
		return depar;
	}
	
	
	public void modifica_departamentos(int id, String nomb, String loca) {
		String contenido="";
	
		connectBD conet=new connectBD();
		
		try {
		
			conet.conexionSQlitepractica();
			
			
				String instruccionSql="Update departamentos set nom_departamento=?,localidad_deparmento=? where cod_departamento=? ";
				PreparedStatement miSentencia=conet.getConexion().prepareStatement(instruccionSql);
				miSentencia.setInt(3, id);
				miSentencia.setString(1, nomb);
				miSentencia.setString(2, loca);	
				int valor=miSentencia.executeUpdate();
				
				if (valor<0) {
					System.err.println("fallo al actualizar");
					
				}else {
					
					System.out.println("Se actualizo de forma correcta");
				}
				
			

		conet.close();
			
		}catch(SQLException e){
		JOptionPane.showMessageDialog(null, "Error en la sentencia SQL " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
		
		}

	}

/********************************************************************************************/
//////////////////////////////////////////EMPLEADOS//////////////////////////////////
	
	public void Insertar_empleado(PanelEmpleado emple) {
		
		conet=new connectBD();
		try {
			conet.conexionSQlitepractica();
			String instruccionSql="insert into empleados values(?,?,?,?,?,?,?,?)";
			PreparedStatement miSentencia=conet.getConexion().prepareStatement(instruccionSql);
			miSentencia.setInt(1, emple.getIdemple());
			miSentencia.setString(2, emple.getApellido());
			miSentencia.setString(3, emple.getoficio());
			miSentencia.setDouble(4, emple.getSalario());
			miSentencia.setInt(5, emple.getComision());
			miSentencia.setString(6, emple.gettxtFecha());
			miSentencia.setInt(7,emple.getdepar());
			miSentencia.setString(8, emple.getdirector());
		
			int valor=miSentencia.executeUpdate();
			if (valor<0) {
				System.err.println("fallo al insertar");
				
			}else {
				
				System.out.println("se inserto de forma correcta");
			}
		conet.close();
			
		}catch(SQLException e){
		JOptionPane.showMessageDialog(null, "Error en la sentencia SQL " + e.getErrorCode(), "Error",JOptionPane.ERROR_MESSAGE);
		
		}	
	}
	
	public  Empleados busca_empleado (int id){

		
		Empleados empleado=new Empleados();
		conet=new connectBD();
		
		
			try{
				conet.conexionSQlitepractica();
				PreparedStatement miSentencia = conet.getConexion().prepareStatement("SELECT * FROM Empleados where id_empleado=? ");
				miSentencia.setInt(1, id);
				ResultSet miResultset=miSentencia.executeQuery(); 		
					while(miResultset.next()){
						 empleado.setid(miResultset.getInt("id_empleado"));		
						 empleado.setapellido(miResultset.getString("apellido"));
						 empleado.setoficio(miResultset.getString("oficio"));
						 empleado.setsalario(miResultset.getDouble("salario"));
						 empleado.setcomision(miResultset.getInt("comision"));
						 empleado.setfecha(miResultset.getString("fecha_alta"));
						 empleado.setidperta(miResultset.getInt("id_departamento"));
						 empleado.setdirector(miResultset.getString("director"));
					}
					
				conet.close();
			
			
				
				
			} catch(Exception e){
				System.out.println("Error de conexión con la BD o en la sentencia SQL.");
			}
			
			return empleado;
		
	}


	public void Elimina_empleado(int id ) {

		conet=new connectBD();
		try {
			conet.conexionSQlitepractica();
			String instruccionSql="delete from empleados where id_empleado=?";
			PreparedStatement miSentencia=conet.getConexion().prepareStatement(instruccionSql);
			miSentencia.setInt(1, id);
			int valor=miSentencia.executeUpdate();
			
			if (valor<0) {
				System.err.println("fallo al Eliminar");
				
			}else {
				JOptionPane.showMessageDialog(null, "Eliminado Correctamente ", "INFORMACIÓN",JOptionPane.INFORMATION_MESSAGE);

			
			}
		conet.close();
			
		}catch(SQLException e){
		JOptionPane.showMessageDialog(null, "Error en la sentencia SQL " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
		
		}	
		
	}
	
	
	public ArrayList<Empleados> listaEmple(){
		ArrayList<Empleados> emple=new ArrayList<>();
		Empleados empleado=new Empleados();
		conet=new connectBD();
			try{
				conet.conexionSQlitepractica();
				PreparedStatement miSentencia = conet.getConexion().prepareStatement("SELECT * FROM empleados");
				ResultSet miResultset=miSentencia.executeQuery(); 		
				while(miResultset.next()){
					empleado.setid(miResultset.getInt("id_empleado"));		
					 empleado.setapellido(miResultset.getString("apellido"));
					 empleado.setoficio(miResultset.getString("oficio"));
					 empleado.setsalario(miResultset.getDouble("salario"));
					 empleado.setcomision(miResultset.getInt("comision"));
					 empleado.setfecha(miResultset.getString("fecha_alta"));
					 empleado.setidperta(miResultset.getInt("id_departamento"));
					 empleado.setdirector(miResultset.getString("director"));
					
				}
				
				if (empleado!=null) {
					
					 emple.add(empleado);	
				}

			} catch(Exception e){
				System.out.println("Error de conexión con la BD o en la sentencia SQL.");
			}
			
			
		return emple;
		
	}
	
	public void modifica_empleado(int id, PanelEmpleado emple) {

		
		conet=new connectBD();
		try {
			conet.conexionSQlitepractica();
			String instruccionSql="Update empleados set apellido=?,oficio=?, salario=?, comision=?,fecha_alta=?,id_departamento=?,director=? where id_empleado="+id;
			PreparedStatement miSentencia=conet.getConexion().prepareStatement(instruccionSql);
			miSentencia.setString(1, emple.getApellido());
			miSentencia.setString(2, emple.getoficio());
			miSentencia.setDouble(3, emple.getSalario());
			miSentencia.setInt(4, emple.getComision());
			miSentencia.setString(5, emple.gettxtFecha());
			miSentencia.setInt(6,emple.getdepar());
			miSentencia.setString(7, emple.getdirector());
		
			int valor=miSentencia.executeUpdate();
			if (valor<0) {
				System.err.println("fallo al modificar");
				
			}else {
				
				System.out.println("se modifico de forma correcta");
			}
		conet.close();
			
		}catch(SQLException e){
		JOptionPane.showMessageDialog(null, "Error en la sentencia SQL " + e.getErrorCode(), "Error",JOptionPane.ERROR_MESSAGE);
		
		}	
		
		
	}
	

}
/********************************************************************************************************/
///////////////////////////////////CONEXION BASE DE DATOS//////////////////////////

	class connectBD{
		String url="C:\\Users\\Alex\\Dropbox\\Acceso Datos\\sqlite-tools-win32-x86-3210000\\logeos.db";
		String urlCasa="E:\\Dropbox\\Acceso Datos\\sqlite-tools-win32-x86-3210000\\logeos.db";
		Connection conexion;
	
		public void conexionSQLite(){
		 try {
		     conexion = DriverManager.getConnection("jdbc:sqlite:"+url);
		     if (conexion!=null) {
		         System.out.println("Conectado");
		     }
		 }catch (SQLException ex) {
		    
		 System.err.print("Error de conexion de base de datos");
		 }
		} 
		
	 
		public void conexionSQlitepractica() {
		 String url="C:\\Users\\Alex\\Dropbox\\Acceso Datos\\sqlite-tools-win32-x86-3210000\\Unidad2.db";
		 String urlCasa="E:\\Dropbox\\Acceso Datos\\sqlite-tools-win32-x86-3210000\\Unidad2.db";
		 String urlportail="C:\\Users\\AlexDario\\Dropbox\\Acceso Datos\\sqlite-tools-win32-x86-3210000\\Unidad2.db";
		 try {
		     conexion = DriverManager.getConnection("jdbc:sqlite:"+url);
		     if (conexion!=null) {
		         System.out.println("Conectado");
		     }
		 }catch (SQLException ex) {
		    
		 System.err.print("Error de conexion de base de datos");
		 }
		
		 
	 }
		public void  conexionMySQL(){
		   String bd = "UNIDAD2"; //nombre base de datos
		   String login = "root"; //usuario BD
		   String password = ""; // CONTRASEÑA USUARIO
		   String url = "jdbc:mysql://localhost:3306/"+bd; // URL CONEXION

		   try{
		         //obtenemos la conexión
			   		System.out.println("Tratando de contectar a BD: "+url);
			   		conexion = DriverManager.getConnection(url,login,password);
		         if (conexion!=null){
		            System.out.println("Conexción a base de datos OK");
		         }
		      }
		      catch(SQLException e){
		         System.out.println("Error en la sintaxis de la conexion de la base de datos  ");
		      }catch(Exception e){
		         System.out.println("Error conexion");
		      }
		
		   }

		public void close(){
	        try {
	            conexion.close();
	        } catch (SQLException ex) {
	            Logger.getLogger(connectBD.class.getName()).log(Level.SEVERE, null, ex);
	        }
	      
	 }
	 
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
		// DEVUELVE LA CONEXION
		public Connection getConexion(){

			return this.conexion;
		}
}
