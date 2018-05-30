package pruebas;


import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import org.apache.derby.tools.sysinfo;

import ficherosXML.PruebaSax1;
import AD_UT2_1.ConectarBDs;
import Ejercicios.Panelprincipal;



public class listener implements ActionListener{

 public static void main(String[] args) {
		 
		 
		connectBD conect=new connectBD(); // clase de conexion de base de datos
		conect.conexionSQLite(); // conectar base de datos
		conect.mostrarusuarios(); // muestra una consulta
		System.out.println(conect.comparausers("jefe")); // valida si exite dicho usuario
		System.out.println(conect.comparapassworsd("12345")); //valida si existe dicha contraseña 
	 }
		
 Loggin loggin;
 InterfazPrincpal principal;
 PanelProductos productos;
 PanelClientes clientes;
 PanelVentas ventas;
 PanelDepartamentos departamentos;
 PanelEmpleado empleados;
 static int valor=0; // valor de las posiciones de array empieza por 0
 static int opcionGBD=0; // valor de la opcion de la base de datos 1 Mysql 2 SQlite
 
 	
 	public listener(PanelEmpleado emple) {
 		this.empleados=emple;
 		
 	}
 	public listener (PanelDepartamentos depa) {
	
	this.departamentos=depa;
 	}	

 
 	public listener (PanelVentas venta) {
	 this.ventas=venta;
	 
 	}
 	public 	listener(PanelClientes client) {
 		
 		this.clientes=client;
 	}
 
	public listener(Loggin log){
		this.loggin=log;
	}
	
	public listener (InterfazPrincpal princi){
		
		this.principal=princi;
	}
	
	public listener(PanelProductos pro){
		this.productos=pro;
	}
	
	
	
	
	public void actionPerformed(ActionEvent evento) {
		
		
		 Border rojo = BorderFactory.createLineBorder(Color.RED); // PARA ERRORES EN LOS DISTINTOS TEXTAREA
		 Border negro = BorderFactory.createLineBorder(Color.BLACK); // CUANDO SE HA SOLUCIONADO EL ERROR
		 connectBD conect=new connectBD(); // CONEXION DE BASE DE DATOS
		 
	
		 
/***/////////////////////////////////////////CLASE LOGGIN/////////////////////////////////////////////////////***/
		 
		 					/////////////// BOTON ACEPTAR /////////
		 if (evento.getActionCommand().equals("Aceptar")) {
			
			conect.conexionSQLite();
			System.out.println(conect.comparausers(loggin.getuser())); // COMPARA EL EL USUARIO QUE ES INTRODUCIDO EN EL TEXFIELD CON ELUSUARIO DE LA BASE DE DATOS
			System.out.println(conect.comparapassworsd(loggin.getpassaword()));
			if (conect.comparausers(loggin.getuser())==true){ // El usuario coincide con el usuario introducido en SQLite
				System.out.println("usuario Correcto"); // mensaje Usuario Correcto
				loggin.txtusuario.setBorder(negro); // borde negro
				if (conect.comparapassworsd(loggin.getpassaword())==false){  // si la contraseña es erronea
				loggin.txtcontrasena.setBorder(rojo);
				}else{ // SI LA CONTRASEÑA ES CORRECTA
					loggin.txtcontrasena.setBorder(negro);
					InterfazPrincpal principal=new InterfazPrincpal();
					principal.start();
					loggin.marco.setVisible(false);
				}
			}
			else{
			
				loggin.txtusuario.setBorder(rojo);
				System.out.println("Usuario Incorrecto");
			}

		}
		 ////////////////////7 BOTON SALIR ///////////////////
		 if (evento.getActionCommand().equals("Salir")) {
			 
			 
			 System.exit(0);
		 }
/************************************************************************************************************************/
		//////////////////////////////////////////JMENUSQLITE////////////////////////////////////////////////////////

		 
		 if (evento.getActionCommand().equals("SQLite")){ // SI HACE CLIC SOBRE EL ITEM SQLITE REALIZARA 
			 											 // LA FUNCION ESPEFICICADA DENTRO DE LAS LLAVES
			 this.opcionGBD=2; //SEGUN ESTA OPCION LA CONEXION SE REALIZARA A UNA BASE DE DATOS O A OTRA, EN ESTE CASO SE CONECTARA A SQLITE
			 Imagenfondo imagen;// CLASE QUE SIRVE PARA ESTABLECER UN FONDO Al JPANEL ESTA CLASE ESTA HUBICADA EN INTERFAZPRINCIPAL
				
			 try{ // INICIO DE CAPUTRACION DE EXEPCIONES
				 String seleccion = JOptionPane.showInputDialog("<HTML>SELECCIONA UNA DE ESTAS OPCIONES:  <br>  1.Producto <br> 2.Clientes <br> 3.Ventas </html>"); // LA CADENA DE TEXTO TIENE FORMATO HTML PARA IMPLEMENTAR LOS SALTOS DE LINEA
				 int opcion=Integer.parseInt(seleccion); 
				 switch  (opcion){ // EN CASO DE 
				 case 1: // PRODUCTOS
					 principal.Damemarco().setVisible(false);
					 PanelProductos JPproducto=new PanelProductos(); 
					 JPproducto.borrapanel();
					 imagen=new Imagenfondo();
					 imagen.setSize(400,300);
					 imagen.CambiaImagen("productos");
					 JPproducto.insertaPanel(imagen.damepanel());
					 JPproducto.setResizable(false);
				break;
					 
				 case 2:  // CLIENTES
					 principal.Damemarco().setVisible(false);
					 PanelClientes JPclientes=new PanelClientes(); 
					 JPclientes.borrapanel();
					 imagen=new Imagenfondo();
					 imagen.CambiaImagen("clientes");
					 imagen.setTamañoImagen(360, 420);
					 JPclientes.insertaPanel(imagen.damepanel());
					 JPclientes.setResizable(false);
				break;
				
				case 3: // VENTAS
					 principal.Damemarco().setVisible(false);
					 PanelVentas JPventas=new PanelVentas();
					 JPventas.borrapanel();
					 imagen=new Imagenfondo();
					 imagen.CambiaImagen("ventas");
					 imagen.setTamañoImagen(360, 420);
					 JPventas.insertaPanel(imagen.damepanel());
					
					 JPventas.setResizable(false);
					 
				break;
			
				default: // EN LOS DEMAS CASOS
					JOptionPane.showMessageDialog(null, "Selecciona una opcion valida", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
				break;
					 
				 }
				 
				 /// SI SE INTRODUCE UN TEXTO EN VEZ DE UNA VALOR NUMERICO
			 }catch(NumberFormatException e){
				 JOptionPane.showMessageDialog(null, "Inserte un numero", "Error", JOptionPane.ERROR_MESSAGE);
			
			 }
			 
		 }
		//////////////////////////////////////CLASE INTERFAZ PRINCIPAL //////////////////////////////////////////
		 				/////////////////// JMENUITEM MYSQL  CLASE INTERFAZ PRINCIPAL////////////////////
		 if (evento.getActionCommand().equals("MySQL")){
			 Imagenfondo imagen;
			 this.opcionGBD=1; // CUANDO SE SELECCIONA MYSQL CON ESTO ESTA VARIABLE OBTENDRA EL VALOR 1 PARA QUE TODOAS LAS 
			 try{				// CONSULTAS SE REALICEN SOBRE MYSQL O MARIADB
				 String seleccion = JOptionPane.showInputDialog("<HTML>SELECCIONA UNA DE ESTAS OPCIONES:  <br>  1.Producto <br> 2.Clientes <br> 3.Ventas </html>");
				 int opcion=Integer.parseInt(seleccion); 
				 switch  (opcion){
				 case 1: 
					 principal.Damemarco().setVisible(false);
					 PanelProductos JPproducto=new PanelProductos(); 
					 JPproducto.borrapanel();
					 imagen=new Imagenfondo();
					 imagen.setSize(400,300);
					 imagen.CambiaImagen("productos");
					 JPproducto.insertaPanel(imagen.damepanel());
					 JPproducto.setResizable(false);
						
				break;
				 case 2:  
					 principal.Damemarco().setVisible(false);
					 PanelClientes JPclientes=new PanelClientes(); 
					 JPclientes.borrapanel();
					 imagen=new Imagenfondo();
					 imagen.CambiaImagen("clientes");
					 imagen.setTamañoImagen(360, 420);
					 JPclientes.insertaPanel(imagen.damepanel());
					 JPclientes.setResizable(false);
				break;
				
				case 3: 
					 principal.Damemarco().setVisible(false);
					 PanelVentas JPventas=new PanelVentas();
					 JPventas.borrapanel();
					 imagen=new Imagenfondo();
					 imagen.CambiaImagen("ventas");
					 imagen.setTamañoImagen(360, 420);
					 JPventas.insertaPanel(imagen.damepanel());
					
					 JPventas.setResizable(false);
					 
				break;
			
				default:
					JOptionPane.showMessageDialog(null, "Selecciona una opcion valida", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
				break;
					 
				 }
				 
				 
			 }catch(NumberFormatException e){
				 JOptionPane.showMessageDialog(null, "Inserte un numero", "Error", JOptionPane.ERROR_MESSAGE);
			
			 }
			 
			 
			 
		 }
		 /**************************************************************************************************************/
		/////////// /////////////////////CLASE PANEL PRODUCTOS/////////////////////////////////////////////////////////
		 
		 ////////////////////////////////---------BOTON INSERTAR----/////////////////////////////////
		if (evento.getActionCommand().equals("Insertar")){ // CUANDO SE HACE CLIC EN EL BOTON INSERTAR DEL PANEL PRODUCTOS
			productos.borrapanel(); // BORRAR PANEL INSERTADO POR DEFECTO
			productos.JPanelInsertarProductos().setBounds(90,10,400,500); // SE MODIFICA EL  TAMAÑO DEL PANEL A TRAVES del metodo  
			productos.insertaPanel(productos.JPanelInsertarProductos()); // SE INSERTA EL PANEL QUE ES UN METODO DE LA CLASE PANEL PRODUCTO
			productos.setSize(400,401); //SE MODIFICA LAS MEDIDAS DE LA VENTANA PARA QUE SE ACTULICEN LOS CAMPOS
			
		 }
		 
		 		/*****------------PRODUCTOS BOTON CONSULTAR-----------*****/
		  // SE REALIZA UNA CONSULTA DE LOS PRODUCTOS REGISTRADOS EN LA BASE DE DATOS 
		 if (evento.getActionCommand().equals("Consultar")){
			 LogicaBDSQL logica=new LogicaBDSQL(); // CLASE QUE CONTIENE TODA LAS SENTICIAS SQL
			 logica.start(); // SE INICIA LA CLASE YA QUE ES UNA CLASE IMPLEMENTADA DE UN HILO
			 int numregistros=logica.numero_registros(this.opcionGBD); // NOS MUESTRA LOS REGISTROS QUE HAY EN TOTAL EN LA BD
			 Productos pro=new Productos(); // SE CREA UN OBJETO PRODUcTO
			 productos.borrapanel(); // SE BORRAR EL PANEL DE LA INTERFAZ DE PRODUCTOS
			 productos.insertaPanel(productos.JPanelInsertarProductos()); // SE INSERTA EL PANEL DONDE CONTIENE TODOS LOS DISTINTOS CAMPOS
			 productos.setSize(400,402); // SE REDIMENSIONA PARA ACTULIZR LOS COMPONENTES Y SE PINTEN GRAFICAMENTE DE FORMA CORRECTA
			 // CONFIGURAMOS QUE CADA UNO DE LOS CAMPOS NO SEA IDITABLE YA QUE SOLO ES UN BUSQUEDA Y NO TIENEN PORQUE MODIFCAR ALGUN PARAMENTRO
			 productos.txtid.setEditable(false); 
			 productos.txtdescrip.setEditable(false);
			 productos.txtpvp.setEditable(false);
			 productos.txtstock.setEditable(false);
			 // SE CAMBIA DE NOMBRE A LOS BOTONES PARA PODERLOS REUTILZAR PARA REALIZAR ESTA FUNCION SI NO HABRIA QUE CREAR NUEVOS BOTONES
			 productos.btnaceptar.setText("Adelante");
			 productos.btnaceptar.setBounds(210,260,100,30);
			 productos.bttnmodificar.setText("Atras");
			 // SE HACE VISIBLE AL BOTON DE ATRAS YA POR DEFECTO VIENE DESABILITADO
			 productos.bttnmodificar.setVisible(true);
			 productos.Damemarco().repaint();
			 // BUSCA EL REGISTRO Y EL RESUTLADO SE ALMACENA EN EL OBJETO PRO QUE DESCIENDE DE PRODUCTOS
			 pro=logica.busca_registro(1,this.opcionGBD);
			 	productos.txtid.setText(pro.getid()+"");
				productos.txtdescrip.setText(pro.getdescrip());
				productos.txtstock.setText(pro.getStock()+"");
				productos.txtpvp.setText(pro.getpvp()+"");
				productos.bttnmodificar.setEnabled(true);
				 productos.bttnmodificar.setEnabled(false);
				productos.numproductos.setText("Numero de registros: "+ numregistros);
			 
		 }
		
		 //MUESTRA EL SIGUIENTE REGISTRO DE LA CONSULTA ES DECIR CON ESTE BOTON PODEMOS CONTINUAR AL SIGUIENTE REGISTRO
		 if (evento.getActionCommand().equals("Adelante")){
			 LogicaBDSQL logica=new LogicaBDSQL();
			 Productos genero=new Productos();
			 logica.start();
			 genero=logica.busca_registro(productos.getID()+1,this.opcionGBD); // CADA VEZ QUE PULSA EL BOTON EL VALOR DEL CAMPO ID SE SUMARA UNA UNIDAD Y ESTE BUSCARA
			 if( genero.descripcion!=null){								// SI EXISTE DICHO PRODUCTO SI EL PRODUCTO EXISTE
					// SE INSERTAR EN CADA UNA DE LAS CASILLAS DEL PANEL LOS VALORES OBTENIDOS DE LA CONSULTA Y ALMACENADOS EN EL OBJETO
				 	productos.txtid.setText(genero.getid()+"");			
					productos.txtdescrip.setText(genero.getdescrip());
					productos.txtstock.setText(genero.getStock()+"");
					productos.txtpvp.setText(genero.getpvp()+"");
					productos.bttnmodificar.setEnabled(true);
				
				// EN CASO DE QUE NO EXISTIESE EL PRODUCTO VOLVERIA AL PRIMER REGISTRO
				}else {
					 JOptionPane.showMessageDialog(null, "No hay mas Registros", "Advertencia", JOptionPane.WARNING_MESSAGE);
				
					genero=logica.busca_registro(1,this.opcionGBD);
					productos.txtid.setText(genero.getid()+"");
					productos.txtdescrip.setText(genero.getdescrip());
					productos.txtstock.setText(genero.getStock()+"");
					productos.txtpvp.setText(genero.getpvp()+"");
					productos.bttnmodificar.setEnabled(false);
					
				}
			 
		 }
		 // PARA RETROCEDER A UN REGISTRO ANTERIOR
		 if (evento.getActionCommand().equals("Atras")){
			 
			 LogicaBDSQL logica=new LogicaBDSQL();
			 Productos genero=new Productos();
			 logica.start();
			 genero=logica.busca_registro(productos.getID()-1,this.opcionGBD);
			 if( genero.descripcion!=null){
					
					productos.txtid.setText(genero.getid()+"");
					productos.txtdescrip.setText(genero.getdescrip());
					productos.txtstock.setText(genero.getStock()+"");
					productos.txtpvp.setText(genero.getpvp()+"");
					productos.bttnmodificar.setEnabled(true);
					
				}else {
					
					productos.bttnmodificar.setEnabled(false);
					
				}
			 
			 
		 }
		 
		 ///////////////BOTON PAGINA PRINCIPAL/////////////////
		 if (evento.getActionCommand().equals("Pagina Principal")){ // RETROCEDE AL MENU PRINCIPAL 
			 productos.Damemarco().setVisible(false); 
			 principal=new InterfazPrincpal();
			 principal.start();
			 
		 }
		 
		 
		 				/*Boton Aceptar */
		 if (evento.getActionCommand().equals("Insertar Registro")){
			 
			 LogicaBDSQL logica=new LogicaBDSQL();
			 Productos genero=new Productos();
			 genero=logica.busca_registro(productos.getID(),opcionGBD);
			 
			 if(genero.getdescrip()==null) {
					if(productos.getDescpri().length()>0) {
						 logica.inserta_Registros(productos,this.opcionGBD);
						 logica.start();
						 this.borrarCampos();
					}else {
						JOptionPane.showMessageDialog(null, "Debes introducir una decripcion", "Error", JOptionPane.ERROR_MESSAGE); 
						 productos.txtdescrip.setBorder(rojo);	
					}

			 }else {
				 
				 JOptionPane.showMessageDialog(null, "Producto ya existente", "Error", JOptionPane.ERROR_MESSAGE); 
				 productos.txtid.setText("");
				 productos.txtid.setBorder(rojo);
			 }
			

		 }
	
	
	

				/***********************************--------PANEL CLIENTES---------------****************************************/
		 					////////////BOTON AGREGAR JTOOLBAR///
		 
		 if (evento.getActionCommand().equals("Agregar")){
			 
			 	clientes.borrapanel();
				clientes.insertaPanel(clientes.JPClientes());
				clientes.Damemarco().setSize(400,510);
		 }
		 
		 if (evento.getActionCommand().equals("Confirmar")){
			 LogicaBDSQL logica=new LogicaBDSQL();
			 Clientes compradores=new Clientes();
			 compradores=logica.busca_Clientes(clientes.getID(),this.opcionGBD);
			 
			 if(compradores.getnombre()==null) {
				 
		
					 
					if((clientes.getNombre().length()>0)&&(clientes.getID()>0)) {
						 logica.insertaClientes(clientes,this.opcionGBD);
						 logica.start();
						 clientes.txtdireccion.setText("");
							clientes.txtid.setText("");
							clientes.txtnombre.setText("");
							clientes.txtpoblacion.setText("");
							clientes.txttelefono.setText("");
							clientes.txtdni.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "Debes introducir un nombre e ID", "Error", JOptionPane.ERROR_MESSAGE); 
						 clientes.txtnombre.setBorder(rojo);
						 clientes.txtid.setBorder(rojo);
						
					}
					
			 }else {
				 
				 JOptionPane.showMessageDialog(null, "Producto ya existente", "Error", JOptionPane.ERROR_MESSAGE); 
				 productos.txtid.setText("");
				 productos.txtid.setBorder(rojo);
			 }
		
			
		 }
		 
		 
		 if (evento.getActionCommand().equals("Buscar")){
			 
			 LogicaBDSQL logica=new LogicaBDSQL();
			 logica.start();
			 int numregistros=logica.numero_registros(this.opcionGBD);
			 Clientes usuarios=new Clientes();
			 clientes.borrapanel();
			 clientes.insertaPanel(clientes.JPClientes());
			 
			 clientes.setSize(400,450);
			 clientes.txtid.setEditable(false);
			 clientes.txtnombre.setEditable(false);
			 clientes.txtdireccion.setEditable(false);
			 clientes.txtpoblacion.setEditable(false);
			 clientes.txttelefono.setEditable(false);
			 clientes.txtdni.setEditable(false);
			 clientes.btnaceptar.setText("Siguiente");
			 clientes.btnaceptar.setBounds(210,300,100,30);
			 clientes.bttnmodificar.setText("Anterior");
			 clientes.bttnmodificar.setVisible(true);
			 clientes.bttnmodificar.setBounds(100, 300, 100, 30);
			 clientes.Damemarco().repaint();
			
			usuarios=logica.busca_Clientes(1,this.opcionGBD);
			
			 	clientes.txtid.setText(usuarios.getid()+"");
				clientes.txtnombre.setText(usuarios.getnombre());
				clientes.txtdireccion.setText(usuarios.getdireccion());
				clientes.txtpoblacion.setText(usuarios.getdpoblacion());
				clientes.txttelefono.setText(usuarios.gettelefono()+"");
				clientes.txtdni.setText(usuarios.getnif());
				
				 clientes.bttnmodificar.setEnabled(false);
				 numregistros=logica.Clientes_totales(this.opcionGBD);
				clientes.numproductos.setText("Numero de registros: "+ numregistros);
			 
		 }
		 if (evento.getActionCommand().equals("Siguiente")){
			 LogicaBDSQL logica=new LogicaBDSQL();
			 Clientes usuarios=new Clientes();
			 logica.start();
			 usuarios=logica.busca_Clientes(clientes.getID()+1,this.opcionGBD);
			 if( usuarios.getnombre()!=null){
					
					clientes.txtid.setText(usuarios.getid()+"");
					clientes.txtnombre.setText(usuarios.getnombre());
					clientes.txtdireccion.setText(usuarios.getdireccion());
					clientes.txtpoblacion.setText(usuarios.getdpoblacion());
					clientes.txttelefono.setText(usuarios.gettelefono()+"");
					clientes.txtdni.setText(usuarios.getnif());
					clientes.bttnmodificar.setEnabled(true);
					
				}else {
					 JOptionPane.showMessageDialog(null, "No hay mas Registros", "Advertencia", JOptionPane.WARNING_MESSAGE);
				
					usuarios=logica.busca_Clientes(1,this.opcionGBD);
					clientes.txtid.setText(usuarios.getid()+"");
					clientes.txtnombre.setText(usuarios.getnombre());
					clientes.txtdireccion.setText(usuarios.getdireccion());
					clientes.txtpoblacion.setText(usuarios.getdpoblacion());
					clientes.txttelefono.setText(usuarios.gettelefono()+"");
					clientes.txtdni.setText(usuarios.getnif());
					clientes.bttnmodificar.setEnabled(false);
					
				}
			 
		 }
		 	if (evento.getActionCommand().equals("Anterior")){
			 
			 LogicaBDSQL logica=new LogicaBDSQL();
			 Clientes usuarios=new Clientes();
			 logica.start();
			 usuarios=logica.busca_Clientes(clientes.getID()-1,this.opcionGBD);
			 if( usuarios.getdireccion()!=null){
					
					clientes.txtid.setText(usuarios.getid()+"");
					clientes.txtnombre.setText(usuarios.getnombre());
					clientes.txtdireccion.setText(usuarios.getdireccion());
					clientes.txtpoblacion.setText(usuarios.getdpoblacion());
					clientes.txttelefono.setText(usuarios.gettelefono()+"");
					clientes.txtdni.setText(usuarios.getnif());
					//clientes.bttnmodificar.setEnabled(true);
					
					
				}else {
					
					clientes.bttnmodificar.setEnabled(false);
					
				}
			 			 
		 }
			 if (evento.getActionCommand().equals("Principal")){
				clientes.Damemarco().setVisible(false);
				principal=new InterfazPrincpal();
				principal.start();
				 
			 }
	
			////////////////////////////////////////////////////////// PANEL VENTAS /////////////////////////////////// ///////////////////////////////
			 
			 if (evento.getActionCommand().equals("Venta Nueva")){
			
				 ventas.borrapanel();
				 ventas.insertaPanel(ventas.PanelVentas());
			}
			 
			 if (evento.getActionCommand().equals("Insertar Venta")){
				 Productos producto=new Productos();
				 Clientes cliente=new Clientes();
				 Ventas venta=new Ventas();
				 LogicaBDSQL logica=new LogicaBDSQL();
				 producto=logica.busca_registro(ventas.getidproducto(),opcionGBD);
				 cliente=logica.busca_Clientes(ventas.getidCliente(),this.opcionGBD);
				 venta=logica.busca_ventas(ventas.getid(),this.opcionGBD);
				 
				 if(venta.getfecha()==null) {  // si el campo fecha del objeto venta se encuentra vacio
					 							// quiere decir que la venta aun no ha sido registrada
					 if (cliente.getnombre()==null) {
						 
						 JOptionPane.showMessageDialog(null, "No existe ningun cliente con tal ID", "Error", JOptionPane.ERROR_MESSAGE);
						 ventas.txtidcliente.setBorder(rojo);
						 ventas.txtidcliente.setText("");
					 }else {
						 if (producto.getdescrip()!=null) {
							 
							 if (ventas.txtfecha.getText().length()==0) {
								 JOptionPane.showMessageDialog(null, "Debes Insertar una fecha", "Error", JOptionPane.ERROR_MESSAGE);
								 ventas.txtfecha.setBorder(rojo);
								 ventas.txtfecha.setText("aaaa-mm-dd");
							 }else {
								 logica.Inserta_ventas(ventas,this.opcionGBD);
								 logica.start(); 
								 ventas.txtid.setText("");
								 ventas.txtfecha.setText("");
								 ventas.txtidcliente.setText("");
								 ventas.txtproductos.setText("");
								 ventas.txtCantidad.setText(""); 
							 }
						
						 }else {
							 
							 JOptionPane.showMessageDialog(null, "No existe ningun producto con tal ID", "Error", JOptionPane.ERROR_MESSAGE);
							 ventas.txtproductos.setBorder(rojo);
							 ventas.txtproductos.setText("");
						 }
					 }
						 
				 }else {
					 
					 JOptionPane.showMessageDialog(null, "Ya existe esa venta", "Error", JOptionPane.ERROR_MESSAGE);
					 ventas.txtid.setBorder(rojo);
					 ventas.txtid.setText("");
				 }
				 
			 }
			 
			 
			
		if (evento.getActionCommand().equals("Buscar Venta")){
				 
			 LogicaBDSQL logica=new LogicaBDSQL();
			 logica.start();
			 int numregistros=logica.ventas_totales(this.opcionGBD);
			 Ventas venta=new Ventas();
			 ventas.borrapanel();
			 ventas.insertaPanel(ventas.PanelVentas());
			 
			 
			 ventas.txtid.setEditable(false);
			 ventas.txtfecha.setEditable(false);
			 ventas.txtidcliente.setEditable(false);
			 ventas.txtproductos.setEditable(false);
			 ventas.txtCantidad.setEditable(false);
			 ventas.btnaceptar.setText("Venta Siguiente");
			 ventas.btnaceptar.setBounds(210,300,100,30);
			 ventas.bttnmodificar.setText("Venta Anterior");
			 ventas.bttnmodificar.setVisible(true);
			 ventas.bttnmodificar.setBounds(100, 300, 100, 30);
			 ventas.Damemarco().repaint();
			 	venta=logica.busca_ventas(1,this.opcionGBD);
			
			 	ventas.txtid.setText(venta.getid()+"");
				ventas.txtfecha.setText(venta.getfecha());
				ventas.txtidcliente.setText(venta.getidcliente()+"");
				ventas.txtproductos.setText(venta.getidproducto()+"");
				ventas.txtCantidad.setText(venta.getcantidad()+"");
				 ventas.bttnmodificar.setEnabled(false);
				 ventas.numproductos.setVisible(true);
				ventas.numproductos.setText("   Numero de registros: "+ numregistros);
			 
				 
		}
		
		if (evento.getActionCommand().equals("Venta Siguiente")){
			
			LogicaBDSQL logica=new LogicaBDSQL();
			 Ventas venta=new Ventas();
			 logica.start();
			 venta=logica.busca_ventas(ventas.getid()+1,this.opcionGBD);
			 if( venta.getfecha()!=null){
					
				 ventas.txtid.setText(venta.getid()+"");
					ventas.txtfecha.setText(venta.getfecha());
					ventas.txtidcliente.setText(venta.getidcliente()+"");
					ventas.txtproductos.setText(venta.getidproducto()+"");
					ventas.txtCantidad.setText(venta.getcantidad()+"");
					 ventas.bttnmodificar.setEnabled(true);
					
				}else {
					 JOptionPane.showMessageDialog(null, "No hay mas Registros", "Advertencia", JOptionPane.WARNING_MESSAGE);
					venta=logica.busca_ventas(1,this.opcionGBD);
					ventas.txtid.setText(venta.getid()+"");
					ventas.txtfecha.setText(venta.getfecha());
					ventas.txtidcliente.setText(venta.getidcliente()+"");
					ventas.txtproductos.setText(venta.getidproducto()+"");
					ventas.txtCantidad.setText(venta.getcantidad()+"");
					ventas.bttnmodificar.setEnabled(false);
					
				}
			
		}
		
		
		if (evento.getActionCommand().equals("Venta Anterior")){
			
			 LogicaBDSQL logica=new LogicaBDSQL();
			 Ventas venta=new Ventas();
			 logica.start();
			 venta=logica.busca_ventas(ventas.getid()-1,this.opcionGBD);
			 if( venta.getfecha()!=null){
					
				 	ventas.txtid.setText(venta.getid()+"");
					ventas.txtfecha.setText(venta.getfecha());
					ventas.txtidcliente.setText(venta.getidcliente()+"");
					ventas.txtproductos.setText(venta.getidproducto()+"");
					ventas.txtCantidad.setText(venta.getcantidad()+"");
					
					
				}else {
					
					ventas.bttnmodificar.setEnabled(false);
					
				}
		}
		if (evento.getActionCommand().equals("Menu")){
			ventas.Damemarco().setVisible(false);
			principal=new InterfazPrincpal();
			principal.start();
			 
		 }
		
		if (evento.getActionCommand().equals("Ventas de Cliente")){
			ventas.borrapanel();
			 ventas.insertaPanel(ventas.PanelVentas());
			 ventas.lblid.setText("ID CLIENTE");
			 ventas.lblfecha.setText("ID PRODUCTO");
			 ventas.lblidcliente.setText("ID VENTA");
			 ventas.lblidproducto.setText("NOMBRE");
			 ventas.lblcantidad.setText("PVP FINAL");
			 ventas.numproductos.setText("VENTAS TOTALES");
			 
			 
	
			 ventas.txtfecha.setEditable(false);
			 ventas.txtidcliente.setEditable(false);
			 ventas.txtproductos.setEditable(false);
			 ventas.txtCantidad.setEditable(false);
			 ventas.btnaceptar.setText("Ficha Siguiente");
			 ventas.btnaceptar.setBounds(290,300,100,30);
			 ventas.bttnmodificar.setText("Ficha Anterior");
			 ventas.bttnmodificar.setVisible(true);
			 ventas.bttnmodificar.setBounds(180, 300, 100, 30);
			 ventas.bttnmodificar.setEnabled(false);
			ventas.bttncosultar.setBounds(65, 300, 100, 30);
			
			
		}
		
	
		if (evento.getActionCommand().equals("Rastrea")){ 
			this.valor=0;
			LogicaBDSQL logica=new LogicaBDSQL();
			logica.start();
			Clientes cliente=new Clientes();
			InformeVentas infor=new InformeVentas();
			
			cliente=logica.busca_Clientes(ventas.getid(), this.opcionGBD);
					
				if(cliente.getnombre()!=null) {
					int numero=logica.Comprascliente(ventas.getid(), this.opcionGBD);
					infor=logica.listadoventas(ventas.getid(), this.opcionGBD).get(valor);

					ventas.numproductos.setVisible(true);
					ventas.numproductos.setText("   Numero de Ventas: " + numero);
					ventas.txtid.setBorder(null);
					ventas.txtfecha.setText(infor.idProductos+"");
					ventas.txtidcliente.setText(infor.idventas+"");
					ventas.txtproductos.setText(infor.getnombre());
					ventas.txtCantidad.setText(infor.getpreciofinal()+"");
				}else {
					
					JOptionPane.showMessageDialog(null, "No existe el cliente", "Advertencia", JOptionPane.WARNING_MESSAGE);
					ventas.txtid.setText("");
					ventas.txtid.setBorder(rojo);
				}
					
					
			
		}
		
		if (evento.getActionCommand().equals("Ficha Siguiente")){
			this.valor=0;
			LogicaBDSQL logica=new LogicaBDSQL();
			InformeVentas infor=new InformeVentas();
			logica.start();
			
			try {
				this.valor++;
				infor=logica.listadoventas(ventas.getid(), this.opcionGBD).get(this.valor);
				ventas.txtid.setBorder(null);
				ventas.txtfecha.setText(infor.getproducto()+"");
				ventas.txtidcliente.setText(infor.getventa()+"");
				ventas.txtproductos.setText(infor.getnombre());
				ventas.txtCantidad.setText(infor.getpreciofinal()+"");
				ventas.bttnmodificar.setEnabled(true);
			}catch(IndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "No hay mas registros", "Advertencia", JOptionPane.WARNING_MESSAGE);
				valor=0;
				ventas.txtid.setBorder(null);
				ventas.txtfecha.setText(infor.getproducto()+"");
				ventas.txtidcliente.setText(infor.getventa()+"");
				ventas.txtproductos.setText(infor.getnombre());
				ventas.txtCantidad.setText(infor.getpreciofinal()+"");
				 ventas.bttnmodificar.setEnabled(false);
			} // Captura la exception en caso de que la variable valor supere a la logitud del arrya list
			
			
		}
	
		
		////////////////////////////////////////////////////DEPARTAMENTOS//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		if (evento.getActionCommand().equals("DEPARTAMENTO")){
			departamentos=new PanelDepartamentos();
			principal.Damemarco().setVisible(false);
			departamentos.setVisible(true);
			Imagenfondo imagen=new Imagenfondo();
			imagen.CambiaImagen("departamentos");
			departamentos.borrapanel();
			departamentos.insertaPanel(imagen.damepanel());
			imagen.setTamañoImagen(410, 230);
			departamentos.setResizable(false);
		}
		
		
		if (evento.getActionCommand().equals("NUEVO DEPARTAMENTO")){
			departamentos.borrapanel();
			departamentos.insertaPanel(departamentos.PanelDepartamento());
			
		}
		
		if (evento.getActionCommand().equals("Registrar")){
			LogicaBDSQL logica=new LogicaBDSQL();
			Departamentos depar=new Departamentos();
			logica.start();
			if (departamentos.getid()!=0) {
				depar=logica.busca_departa(departamentos.getid());
				if (depar.getnom()==null) {
					
					 logica.Inserta_departamento(departamentos);
					 departamentos.txtid.setText("");
					 departamentos.txtnombre.setText("");
					 departamentos.txtlocalidad.setText("");
				}else {
					
					System.out.println("departamento ya existente");
				}
			
			
			}else {
				System.out.println("Debes escribir un ID");
				departamentos.txtid.setBorder(rojo);
				
			}	
			
		}
		
		if (evento.getActionCommand().equals("DEPARTAMENTOS")){
			LogicaBDSQL logica=new LogicaBDSQL();
			Departamentos depar=new Departamentos();
			logica.start();
			departamentos.borrapanel();
			departamentos.insertaPanel(departamentos.PanelDepartamento());
			departamentos.lbltitulo.setVisible(true);
			departamentos.bttnprimero.setVisible(true);
			departamentos.btnaceptar.setText("<<");
			departamentos.btnaceptar.setEnabled(false);
			departamentos.bttnmodificar.setVisible(true);
			departamentos.bttnultimo.setVisible(true);
			departamentos.txtid.setEnabled(false);
			departamentos.txtnombre.setEnabled(false);
			departamentos.txtlocalidad.setEnabled(false);
			departamentos.bttnmodificar.setEnabled(false);
			
		}
		
		if (evento.getActionCommand().equals("Primero")){
			LogicaBDSQL logica=new LogicaBDSQL();
			Departamentos depar=new Departamentos();
			logica.start();
			this.valor=0;
			depar=logica.departamentos().get(valor);
		
				
				departamentos.txtid.setText(depar.getid()+"");
				departamentos.txtnombre.setText(depar.getnom());
				departamentos.txtlocalidad.setText(depar.getlocalidad());
				departamentos.bttnmodificar.setEnabled(true);
				departamentos.btnaceptar.setEnabled(false);
			
			
		}
		
		if (evento.getActionCommand().equals(">>")) {
			LogicaBDSQL logica=new LogicaBDSQL();
			Departamentos depar=new Departamentos();
			logica.start();
			
			try {
			
				this.valor++;
				System.out.println("Variable valoR: "+valor);
				depar=logica.departamentos().get(valor);
				departamentos.txtid.setText(depar.getid()+"");
				departamentos.txtnombre.setText(depar.getnom());
				departamentos.txtlocalidad.setText(depar.getlocalidad());
				departamentos.btnaceptar.setEnabled(true);
				departamentos.bttnprimero.setEnabled(true);
			
			}catch(IndexOutOfBoundsException e) { // Captura la exception en caso de que la variable valor supere a la logitud del arrya list
			
				JOptionPane.showMessageDialog(null, "No hay mas registros", "Advertencia", JOptionPane.WARNING_MESSAGE);
				valor=0;
				depar=logica.departamentos().get(valor);
				departamentos.txtid.setText(depar.getid()+"");
				departamentos.txtnombre.setText(depar.getnom());
				departamentos.txtlocalidad.setText(depar.getlocalidad());
				departamentos.btnaceptar.setEnabled(false);
				departamentos.bttnprimero.setEnabled(false);
			}

		}
		
		if (evento.getActionCommand().equals("<<")){
			LogicaBDSQL logica=new LogicaBDSQL();
			Departamentos depar=new Departamentos();
			try {
				this.valor--;
				logica.start();
				depar=logica.departamentos().get(valor);
				departamentos.txtid.setText(depar.getid()+"");
				departamentos.txtnombre.setText(depar.getnom());
				departamentos.txtlocalidad.setText(depar.getlocalidad());
				departamentos.btnaceptar.setEnabled(true);
				
			}catch(ArrayIndexOutOfBoundsException e) { //CAPTURO LA EXCEPCION EN CASO DE QUE EL VALOR FUERA NEGATIVO 
				
				JOptionPane.showMessageDialog(null, "Se encuentra en el primer registro", "Advertencia", JOptionPane.WARNING_MESSAGE);
				this.valor=0;
				depar=logica.departamentos().get(valor);
				departamentos.txtid.setText(depar.getid()+"");
				departamentos.txtnombre.setText(depar.getnom());
				departamentos.txtlocalidad.setText(depar.getlocalidad());
				departamentos.btnaceptar.setEnabled(false);
				departamentos.bttnprimero.setEnabled(false);
				
			}
		
		}
		
		if (evento.getActionCommand().equals("Ultimo")){
			LogicaBDSQL logica=new LogicaBDSQL();
			Departamentos depar=new Departamentos();
			this.valor=logica.departamentos().size()-1;
			depar=logica.departamentos().get(valor);
			departamentos.txtid.setText(depar.getid()+"");
			departamentos.txtnombre.setText(depar.getnom());
			departamentos.txtlocalidad.setText(depar.getlocalidad());
			departamentos.bttnmodificar.setEnabled(false);
			departamentos.btnaceptar.setEnabled(true);
			
		}
		
		
		if (evento.getActionCommand().equals("")){
			departamentos.Damemarco().setVisible(false);
			principal=new InterfazPrincpal();
			principal.start();
			 
		 }
		
		
		/////////////////////////////////////////////EMPLEADO////////////////////////////////////////////////////////////////////////////////////////////////

		if (evento.getActionCommand().equals("EMPLEADOS")){
			empleados=new PanelEmpleado();
			principal.Damemarco().setVisible(false);
			empleados.setVisible(true);
			Imagenfondo imagen=new Imagenfondo();
			imagen.CambiaImagen("empleados");
			empleados.borrapanel();
			empleados.insertaPanel(imagen.damepanel());
			imagen.setTamañoImagen(540, 300);
			empleados.setResizable(false);
		
		}
		
		if (evento.getActionCommand().equals("Mostar XML")){
			
			empleados.borrapanel();
			empleados.insertaPanel(empleados.PanelFichero());
			empleados.descripcion.setText("Contenido del Fichero");
			empleados.txtentrada.setEnabled(false);
			empleados.bttnaceptar.setText("Visualizar");
			empleados.Damemarco().setSize(650,381);
			
		}
		if (evento.getActionCommand().equals("Generar XML")){
			
			String NombreFichero = JOptionPane.showInputDialog("Inserta el nombre del fichero ");
			
			if (NombreFichero.length()==0) {
				
				JOptionPane.showMessageDialog(null, "Inserta un nombre","Advertencia", JOptionPane.WARNING_MESSAGE);
			
			}else {
				
				try {
					XML xml=new XML(NombreFichero);
					JOptionPane.showMessageDialog(null, "Fichero Creado","Informacion", JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error al crear el fichero XML","Advertencia", JOptionPane.ERROR_MESSAGE);

				}
			
			}
			
		}
		
		if (evento.getActionCommand().equals("Visualizar")){
			
			XML xml=new XML();
			
	         Border border = BorderFactory.createLineBorder(Color.RED);
	       
	             if (empleados.getNombrefichero().length()!=0){
	           
	             String contenido=xml.leerXML(empleados.getNombrefichero());
	        
	             if (contenido.length()!=0){
	             empleados.txtentrada.setText(contenido);
	             
	             }else{
	                 JOptionPane.showMessageDialog(null, "No hay contenido en el fichero", "ERROR", JOptionPane.ERROR_MESSAGE);
	             }
	        
	             }else{
	              JOptionPane.showMessageDialog(null, "Inserta El nombre del fichero", "ERROR", JOptionPane.ERROR_MESSAGE);
	              empleados.Nomfic.setBorder(border);
	             }
	            
	             
	       
		}
		
		
		if (evento.getActionCommand().equals("Entradas")){
			
			empleados.borrapanel();
			empleados.insertaPanel(empleados.PanelFichero());
			empleados.Damemarco().setSize(650,382);
			
		}
		
		if (evento.getActionCommand().equals("Escribir Fichero")){
			
			  	File fichero;
	            BufferedWriter escritor;
	            
	           try{
	           Border border = BorderFactory.createLineBorder(Color.RED); // En caso de error el borde se pondra en rojo
	           String nombrefichero=empleados.getNombrefichero(); //almacena el titulo TextField el nombre del fichero en una variable
	           String contenido=empleados.getContenidofichero(); // almacena el contenido del TextArea en una variable

	            if (nombrefichero.length()!=0){ // Si  la longitud del a varaible es distinta a cero entonces
	                fichero=new File(nombrefichero+".txt"); // se crea un fichero con el nombre del contenido de la variable 
	                escritor=new BufferedWriter(new FileWriter(fichero)); // creamos un bufferWriter para escribir el contenido en el fichero
	             if(contenido.length()!=0){ // si existe contenido en el la variable entonces se escribira
	             escritor.write(contenido); // bufferWriter escribe 
	                 System.out.println(contenido); // imprime por consola el contendio de la variable
	             
	                 JOptionPane.showMessageDialog(null, "Fichero Creado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
	             }else{ // en caso de no contener contendido
	              JOptionPane.showMessageDialog(null, "Introduce Contenido en el fichero", "Error", JOptionPane.ERROR_MESSAGE);
	                        empleados.txtentrada.setBorder(border);
	                       
	             }
	            empleados.Nomfic.setText("");
	             empleados.txtentrada.setText("");
	             escritor.close();         
	                }else{
	                 JOptionPane.showMessageDialog(null, "Introduce El nombre del fichero", "Error", JOptionPane.ERROR_MESSAGE);
	                        empleados.Nomfic.setBorder(border);
	            }
	           
	           }catch(FileNotFoundException error){
	           JOptionPane.showMessageDialog(null, "Error Al intentar escribir en le fichero", "Error", JOptionPane.ERROR_MESSAGE);
	           } catch (IOException a){
				System.out.println("Error de E/S");
			}
	           
	     }

	        
		/// CUANDO SE HACE CLIC EN ESTE BOTON REALIZA LA LECTURA DEL
		// DE UN FICHERO CREADO PREVIAMENTE CON LA ESTRUCTURA IMPUESTA 
		//SE REALZIA LAS RESPECTIVAS MODIFICACIONES EN LOS DISTINTOS DEPARTAMENTOS
			
		if (evento.getActionCommand().equals("Resultado")){
			LogicaBDSQL logica=new LogicaBDSQL();
			logica.start();
			String contenido="", loca , nombre, NombreFichero = JOptionPane.showInputDialog("Inserta el nombre del fichero ");
			File fichero;
			Departamentos depar;
			int id=0;
			String	parametros[]= {};
			if (NombreFichero.length()!=0) {
				fichero=new File(NombreFichero+".txt");
				// INICIO DE CAPTURA DE EXCEPCIONES
				try {
					
				 // LEE EL FICHERO 
					BufferedReader lector=new BufferedReader(new FileReader(fichero));
					contenido=lector.readLine();
					parametros=contenido.split(","); // arrAY CARACTERES 
					// inicializa el departamento a modificar
					id=Integer.parseInt(parametros[0]);
					// Valida el departamento 	
					// INCIALIZAMOS EL OBJETO DE PARTAMENTO
				 	depar =new Departamentos();
				 	depar=logica.busca_departa(id);
					// Muesta la longitud del array 
					System.out.println(parametros.length);

					// comprueba si el departamento existe 
					if (depar.getnom()!=null) {
						// valida las posiciones de array ya que en caso de no tener  las 3 posiciones necesarias 
						// CUANTO CONTA CON DE DOS PSOCIONES EL ARRAY
						if (parametros.length==1) {
							nombre=depar.getnom();
							loca=depar.getlocalidad();
							logica.modifica_departamentos(id, nombre, loca);
						}
						if(parametros.length ==2) {;
							nombre=parametros[1];
							
							if (nombre.length()==0) {
								 nombre=depar.getnom();
								  
							}	// Primera posicion del array 
							
							loca=depar.getlocalidad();
							logica.modifica_departamentos(id, nombre, loca);
					           JOptionPane.showMessageDialog(null, "Se ha modificado el departamento correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);

						}else {
							// EN CASO DEQUE EL ARRAY FUERA MAYOR DE DOS POSICIONES
							nombre=parametros[1];
							loca=parametros[2];
							logica.modifica_departamentos(id, nombre, loca);
					           JOptionPane.showMessageDialog(null, "Se ha modificado el departamento correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);

						}
						
					}else {
						JOptionPane.showMessageDialog(null, "DEPARTAMENTO INEXISTENTE", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				
				}catch (FileNotFoundException a){
					JOptionPane.showMessageDialog(null, "FICHERO NO ENCONTRADO", "ERROR", JOptionPane.ERROR_MESSAGE);
					
				} catch (IOException a){
					System.out.println("Error de E/S");
				}catch(NumberFormatException e) {
					
					JOptionPane.showMessageDialog(null, "ERROR ID, DEBES INTRODUCIR UN NUMERO ANTES DE LA PRIMERA COMA", "ERROR", JOptionPane.ERROR_MESSAGE);
					
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("error longitud");
				
				}
				
			
			}else {
		           JOptionPane.showMessageDialog(null, "Introduce un nombre", "Error", JOptionPane.ERROR_MESSAGE);

				
			}
			
		}
		
		if (evento.getActionCommand().equals("Trabajadores")){
			
			empleados.borrapanel();
			empleados.insertaPanel(empleados.panelEmpleado());
		empleados.Damemarco().setSize(540,381);
		}
		
		
		
		if (evento.getActionCommand().equals("Exit")){
			empleados.Damemarco().setVisible(false);
			principal=new InterfazPrincpal();
			principal.start();
			
		}
		
		
		if (evento.getActionCommand().equals("Inserta Empleado")){
			LogicaBDSQL logica=new LogicaBDSQL();
			Empleados emple=new Empleados();
		
			logica.start();
			emple=logica.busca_empleado(empleados.getIdemple());
			
			if (emple.getapellido()==null) {
				
				if (empleados.Departamentos.getSelectedItem().equals("Elige un departamento")) {
					JOptionPane.showMessageDialog(null, "Selecciona un departamento","Advertencia", JOptionPane.WARNING_MESSAGE);
					empleados.Departamentos.setBorder(rojo);
					
				}else {
					if (empleados.getdirector().equals("Elige Director")) {
						
						JOptionPane.showMessageDialog(null, "Selecciona un Director","Advertencia", JOptionPane.WARNING_MESSAGE);
						empleados.directo.setBorder(rojo);
					
					}else {
						if ((empleados.getApellido()!=null)&&(empleados.getoficio()!=null)&&(empleados.getSalario()>0)) {
							
							logica.Insertar_empleado(empleados);
							empleados.txtidempleado.setText("");
							empleados.txtapellido.setText("");
							empleados.txtoficio.setText("");
							empleados.txtsalario.setText("");
							empleados.txtcomision.setText("");
							empleados.Departamentos.setSelectedIndex(0);
							empleados.directo.setSelectedIndex(0);
							JOptionPane.showMessageDialog(null, "Empleado Insertado correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);

						}else {
							
							JOptionPane.showMessageDialog(null, "Campos obligatorios: APELLIDO, OFICIO, SALARIO", "Advertencia", JOptionPane.WARNING_MESSAGE);
						}
					}
	
				}
			}else {
				
				JOptionPane.showMessageDialog(null, "Empleado Repetido", "Advertencia", JOptionPane.WARNING_MESSAGE);
				empleados.txtidempleado.setText("");
				empleados.txtidempleado.setBorder(rojo);
			}
			
		}
		
		if(evento.getActionCommand().equals("Eliminar")){
		
			
			LogicaBDSQL logica=new LogicaBDSQL();
			Empleados emple=new Empleados();
			Empleados emple2=new Empleados();
			logica.start();
			 boolean director=false;
			 if (empleados.txtidempleado.getText().length()>0) {
				 emple=logica.busca_empleado(empleados.getIdemple());
					if (emple.getapellido()!=null) {
						for (int contador=0;contador<logica.listaEmple().size();contador++) {
						emple2=logica.listaEmple().get(contador);
						if (emple.getapellido().equals(emple2.getdirector())) {
								director=true;
							}else {
								director=false;
							}
						}
						
						if (director==false) {
							
							logica.Elimina_empleado(emple.getid());
							JOptionPane.showMessageDialog(null, "Eliminado correctamente", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);

						}else {
							JOptionPane.showMessageDialog(null, "Este empleado es director de otro", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
							
							
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "No existe el empleado", "ERROR", JOptionPane.ERROR_MESSAGE);

						
					}
			 }else {
					
					JOptionPane.showMessageDialog(null, "Ingresa el ID del Empleado", "Advertencia", JOptionPane.WARNING_MESSAGE);
					empleados.txtidempleado.setBorder(rojo);
				}
			 
			
		
			
			
		}
			 
		
		if (evento.getActionCommand().equals("CONSULTAR EMPLEADO")){
			LogicaBDSQL logica=new LogicaBDSQL();
			Empleados emple=new Empleados();
			logica.start();
			if (empleados.txtidempleado.getText().length()>0) {
				
				emple=logica.busca_empleado(empleados.getIdemple());
				
				if (emple.getapellido()==null) {
					JOptionPane.showMessageDialog(null, "No existe dicho empleado", "Advertencia", JOptionPane.WARNING_MESSAGE);
					empleados.txtidempleado.setBorder(rojo);
					
				}else {
					
					empleados.txtapellido.setText(emple.getapellido());
					empleados.txtoficio.setText(emple.getoficio());
					empleados.txtsalario.setText(emple.getsalario()+"");
					empleados.txtcomision.setText(emple.getcomision()+"");
					empleados.txtfecha.setText(emple.getfecha());
					empleados.Departamentos.setSelectedIndex(emple.getidperta());
				}
				
			}else {
				
				JOptionPane.showMessageDialog(null, "Ingresa el ID del Empleado", "Advertencia", JOptionPane.WARNING_MESSAGE);
				empleados.txtidempleado.setBorder(rojo);
			}
			
		
		}
		
		if (evento.getActionCommand().equals("Modificar")){
			LogicaBDSQL logica=new LogicaBDSQL();
			Empleados emple=new Empleados();
		
			logica.start();
			if (empleados.txtidempleado.getText().length()>0) {
				
				emple=logica.busca_empleado(empleados.getIdemple());
				if (emple.getapellido()==null) {
					JOptionPane.showMessageDialog(null, "No existe dicho empleado", "Advertencia", JOptionPane.WARNING_MESSAGE);
					empleados.txtidempleado.setBorder(rojo);
					
				}else {
					if (empleados.Departamentos.getSelectedItem().equals("Elige un departamento")) {
						JOptionPane.showMessageDialog(null, "Selecciona un departamento","Advertencia", JOptionPane.WARNING_MESSAGE);
						empleados.Departamentos.setBorder(rojo);
						
					}else {
						if (empleados.getdirector().equals("Elige Director")) {
							
							JOptionPane.showMessageDialog(null, "Selecciona un Director","Advertencia", JOptionPane.WARNING_MESSAGE);
							empleados.directo.setBorder(rojo);
						
						}else {
							
							logica.modifica_empleado(emple.getid(), empleados);
							JOptionPane.showMessageDialog(null, "Se actualizo de forma correcta","INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
							empleados.txtidempleado.setText("");
							empleados.txtapellido.setText("");
							empleados.txtoficio.setText("");
							empleados.txtsalario.setText("");
							empleados.txtcomision.setText("");
							empleados.Departamentos.setSelectedIndex(0);
							empleados.directo.setSelectedIndex(0);
						
							}
						}
					
					
				}
				
				
			}else {
				
				JOptionPane.showMessageDialog(null, "Ingresa el ID del Empleado", "Advertencia", JOptionPane.WARNING_MESSAGE);
				empleados.txtidempleado.setBorder(rojo);
			}
		}
		
		if (evento.getActionCommand().equals("Limpiar")){
			
			empleados.txtidempleado.setText("");
			empleados.txtapellido.setText("");
			empleados.txtoficio.setText("");
			empleados.txtsalario.setText("");
			empleados.txtcomision.setText("");
			empleados.Departamentos.setSelectedIndex(0);
			empleados.directo.setSelectedIndex(0);
			
		}
	
 }


		public void borrarCampos() {
	
			productos.txtid.setText("");
			productos.txtdescrip.setText("");
			productos.txtstock.setText("");
			productos.txtpvp.setText("");
			
		}	

}


 




