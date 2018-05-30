package pruebas;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class InterfazPrincpal extends Thread {
	
	JFrame marco;
	JPanel panel; 
	JMenuBar Contenedorbarramenu;
	JMenu basesdatos, ejercicio4;
	JMenuItem Sqllite, Mysql, departamentos, empleados; 
	JLabel lbltusuario;
	JLabel lblcontrasena;
	JTextField txtusuario;
	JPasswordField txtcontrasena;
	JMenu Opciones;
	JMenuItem borrar;
	Imagenfondo imagen;
	
	public void run(){
		 Border negro = BorderFactory.createLineBorder(Color.BLACK);
		marco=new JFrame("Panel Principal");
		  
	        marco.setLayout(new BorderLayout());
	        JFrame.setDefaultLookAndFeelDecorated(true);
	        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        marco.setIconImage(Toolkit.getDefaultToolkit().createImage("imagenes/logo.png"));
	        //marco.setLocationRelativeTo(null) ;
	        Contenedorbarramenu=new JMenuBar();
	        marco.add(Contenedorbarramenu);
	        basesdatos=new JMenu("Ejercicios 1,2,3");
	        basesdatos.setBorder(negro);
	        Mysql=new JMenuItem("MySQL");
	        Mysql.addActionListener(new listener(this));
	        basesdatos.add(Mysql);
	        
	        Sqllite=new JMenuItem("SQLite");
	        Sqllite.addActionListener(new listener(this));
	        basesdatos.add(Sqllite);
	        Contenedorbarramenu.add(basesdatos);
	        ejercicio4=new JMenu("Ejerecicios Restantes");
	        ejercicio4.setBorder(negro);
	        departamentos=new JMenuItem("DEPARTAMENTO");
	        departamentos.addActionListener(new listener(this));
	        ejercicio4.add(departamentos);
	        empleados=new JMenuItem("EMPLEADOS");
	        empleados.addActionListener(new listener(this));
	        ejercicio4.add(empleados);
	        
	        Contenedorbarramenu.add(ejercicio4);
	        
	        marco.setJMenuBar(Contenedorbarramenu);
	       // marco.setBounds(450,70,500,600);
	        marco.setSize(500, 500);
	        marco.setLocationRelativeTo(null);
	        imagen=new Imagenfondo();
	        imagen.CambiaImagen("sql");
	        marco.add(imagen.damepanel());
	        marco.setVisible(true);
	        
	   	 //JPanel panelprincipa=new JPanel();
	   	 //panelprincipa.setSize(400,500);
	   	 //marco.add(panelprincipa);
	     
	      
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Loggin pnlLoggin=new Loggin();
	pnlLoggin.start();
	
	}
	public void borrapanel(){
		 this.marco.getContentPane().removeAll();
		 this.marco.remove(imagen.damepanel());
		 this.marco.repaint();
	 }

	public JFrame Damemarco(){
		
		return marco;
		
	}
	public void insertaPanel(JPanel nombre){

		this.marco.getContentPane().add(nombre);
		this.marco.repaint();
	}

	
}


class Loggin extends Thread{
	JFrame marco;
	JPanel panel; 
	JMenuBar Contenedorbarramenu;
	JLabel lbltusuario;
	JLabel lblcontrasena;
	JTextField txtusuario;
	JPasswordField txtcontrasena;
	JButton bttnAceptar;
	JButton bttnSalir;
	ImageIcon fondo=new ImageIcon("imagenes/fondo.png"); 
	JLabel lblimagen;

	
public void run(){
		
			marco=new JFrame("Loggin");
		
	        marco.setLayout(new BorderLayout());
	        JFrame.setDefaultLookAndFeelDecorated(true);
	        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        marco.setIconImage(Toolkit.getDefaultToolkit().createImage("imagenes/logo.png"));
	        marco.setSize(350, 250);
	        // marco.setBounds(450,10,500,500);
	        marco.setVisible(true);
	        marco.setLocationRelativeTo(null) ;  //Para que nuestro frame aparezca en el centro de la pantalla. 
	   
	        panel=new JPanel();
	        panel.setLayout(null);
	     
	        marco.add(panel);
	        lbltusuario=new JLabel("Usuario");
	        lbltusuario.setBounds(30,30,50,20);
	        panel.add(lbltusuario);
	        lblcontrasena=new JLabel("contraseña");
	        lblcontrasena.setBounds(30,80,70,20);
	        panel.add(lblcontrasena);
	        txtusuario=new JTextField(20);
	        txtusuario.setBounds(130,30,170,20);
	        panel.add(txtusuario);
	        txtcontrasena=new JPasswordField(20);
	        txtcontrasena.setBounds(130,80,170,20);
	        panel.add(txtcontrasena);
	        bttnAceptar=new JButton("Aceptar");
	        bttnAceptar.setBounds(60,140,100,20);
	        bttnAceptar.addActionListener(new listener(this));
	        panel.add(bttnAceptar);
	        bttnSalir=new JButton("Salir");
	        bttnSalir.setBounds(180,140,100,20);
	        bttnSalir.addActionListener(new listener(this));
	        panel.add(bttnSalir);
	        marco.setResizable(false);
	        panel.repaint();

	}

	public String getuser(){

		return this.txtusuario.getText();
	}
	public String getpassaword(){
	
		return this.txtcontrasena.getText();
	}
	
	
}


/////////////////////////////CLASE DE INSERTA IMAGEN EN EL PANEL/////////////////////////////////////
class Imagenfondo extends JPanel{
	
	JPanel panel;
	JMenu menu,submenu;
	JMenuBar menubar;
	JMenuItem Ficheros, xml, salir;
	insertimagen imagen;
	
	Imagenfondo(){
	panel=new JPanel();
	panel.setSize(100,100);
	panel.setLayout(null);
	imagen=new insertimagen();
	panel.add(imagen);
		
	}
	public JPanel damepanel(){
	return this.panel;
	}
	
	public void CambiaImagen(String nombre){
		
		imagen.cambiaimagen(nombre);
	}
	public void setTamañoImagen(int ancho, int alto){
		
		imagen.setSize(ancho, alto);
		panel.setSize(ancho,alto);
		
	}
}

class insertimagen extends JPanel{

	ImageIcon Img ;
	String nombre="";
    insertimagen(){
   
    	this.setSize(500,500);
   }
   
   //Se crea un método cuyo parámetro debe ser un objeto Graphics
   public void paint(Graphics grafico) {
   Dimension height = getSize();
   //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
   Img = new ImageIcon("imagenes/"+nombre+".jpg"); 
   //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
   grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
   setOpaque(false);
   super.paintComponent(grafico);
   }
   
   public void cambiaimagen(String imagen){
	   
	   this.nombre=imagen;
	   
   }
   
   

   
}