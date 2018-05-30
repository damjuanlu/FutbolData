package pruebas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.Border;
public class Empleados {
int id,comision,id_departa;
String apellido,oficio,director,fecha;
double salario;
	
	public void setid(int valor){
		this.id=valor;
	}
	
	public void setcomision(int valor) {
		
		this.comision=valor; 
	}
	
	public void setidperta(int valor) {
		
		this.id_departa=valor; 
	}
	
	public void setapellido(String valor) {
		
		this.apellido=valor; 
	}
	public void setoficio(String valor) {
		
		this.oficio=valor; 
	}
	public void setdirector(String valor) {
		this.director=valor;
		
	}
	public void setsalario(double valor) {
		
		this.salario=valor;
	}
	
	public int getid(){
		return this.id;
	}
	
	public int getcomision() {
		
		return this.comision; 
	}
	
	public int getidperta() {
		
	 return this.id_departa; 
	}
	
	public String getapellido() {
		
		 return this.apellido; 
	}
	public String getoficio() {
		
		return this.oficio; 
	}
	public String getdirector() {
		return this.director;
		
	}
	public double getsalario() {
		
		return this.salario;
	}
	
	public void setfecha(String valor) {
		this.fecha=valor;
		
	}
	
	public String getfecha() {
		
		return this.fecha;
	}
	
	public static void main(String args[]) {
		
		PanelEmpleado JPemple=new PanelEmpleado();
		JPemple.borrapanel();
		JPemple.insertaPanel(JPemple.PanelFichero());
	
	}
}

//////PANEL EMPELADO
class PanelEmpleado  extends JFrame{
	
	JLabel lbltitulo, lblEmpleado, lblApellido, lbloficio, lblsalario,lblcomision,lblfecha;
	JTextField txtidempleado,txtapellido, txtoficio, txtsalario, txtcomision,txtfecha;
	JButton bttninserta, bttneliminar,bttnmodificar,bttnsalir,bttnlimpiar, bttngenerarXML, bttnmostrarxml, bttnbuscar,bttnpanel, bttnmodificadepar,bttnescribefichero;
	JMenuBar barra;
	JToolBar iconos;
	LogicaBDSQL logica;
	JComboBox Departamentos,directo;
	JPanel panel;
	 JTextArea txtentrada;
     JTextField Nomfic;
     JButton escribir;
     JLabel descripcion;
     JLabel nomfichero;
     JScrollPane scroll;
     JButton bttnaceptar;
     
	
	String [] directores= {"Elige Director","ALEX","PAUL","FERNANDO","OMAR"};
	
	Border negro = BorderFactory.createLineBorder(Color.BLACK);

	
	 PanelEmpleado() {
		
		this.setTitle("EMPLEADOS");
		this.setSize(540,380);
		this.setLocationRelativeTo(null);
		setLayout(new BorderLayout());
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setIconImage(Toolkit.getDefaultToolkit().createImage("imagenes/logo.png"));
	    Color b=new Color(50,60,60); // COLOR (red,green,blue) 

	    iconos=new JToolBar();
	    iconos.setLayout(new FlowLayout(FlowLayout.CENTER)); // centrar los iconos 
	    iconos.setFloatable(false); //impide que se pueda mover de su sitio
	    iconos.setBackground(b);
	    barra=new JMenuBar();
	    bttnpanel=new JButton("Trabajadores");
	    bttnpanel.setIcon(new ImageIcon("imagenes/empleado.png"));
	    bttnpanel.addActionListener(new listener(this));
	    iconos.add(bttnpanel);
	    bttngenerarXML=new JButton("Generar XML");
	    bttngenerarXML.setIcon(new ImageIcon("imagenes/xml.png"));
	    bttngenerarXML.addActionListener(new listener(this));
	    iconos.add(bttngenerarXML);
	    bttnmostrarxml=new JButton("Mostar XML");
	    bttnmostrarxml.setIcon(new ImageIcon("imagenes/verXML.png"));
	   bttnmostrarxml.addActionListener(new listener(this));
	    iconos.add(bttnmostrarxml);
	   bttnescribefichero=new JButton("Entradas");
	   bttnescribefichero.setIcon(new ImageIcon("imagenes/escribir.png"));
	   bttnescribefichero.addActionListener(new listener(this));
	   iconos.add(bttnescribefichero);
	    
	    bttnmodificadepar=new JButton("Resultado");
	    bttnmodificadepar.setIcon(new ImageIcon("imagenes/leer.png"));
	   bttnmodificadepar.addActionListener(new listener(this));
	    iconos.add(bttnmodificadepar);
	    barra.add(iconos);
	    barra.setBorder(negro);
	   this.add(barra);
	   this.setJMenuBar(barra);
	   JPanel pane=new JPanel();
	   this.add(pane);
	   this.setVisible(true);
	}
	 
	 public JPanel PanelFichero() {
		 
		 Border border = BorderFactory.createLineBorder(Color.BLACK);
         panel=new JPanel();
		 panel.setSize(500,500);
         panel.setLayout(null);
          nomfichero=new JLabel("Introduce el nombre del fichero", (int) CENTER_ALIGNMENT);
          nomfichero.setBounds(225, 10, 200,25);
          nomfichero.setBorder(border);
          panel.add(nomfichero);
          Nomfic=new JTextField(100);
          Nomfic.setBounds(200, 50, 250,20);
          panel.add(Nomfic);
          descripcion=new JLabel("Introduce el texto que deseas Escribir en el fichero", (int) CENTER_ALIGNMENT);
          descripcion.setBounds(170, 85, 300, 25);
          descripcion.setBorder(border);
          panel.add(descripcion);
          txtentrada=new JTextArea();
          txtentrada.setLineWrap(true);
          scroll = new JScrollPane (txtentrada );
          scroll.setBounds(80, 120, 500, 100);
          panel.add(scroll);
          bttnaceptar=new JButton("Escribir Fichero");
          bttnaceptar.setBounds(280,240,150,20);
          bttnaceptar.setIcon(new ImageIcon("imagenes/esfichero.png"));
          bttnaceptar.addActionListener(new listener (this));
          panel.add(bttnaceptar);
		 
          return panel;
	 }
	 
	   public  String getNombrefichero(){


		    return  this.Nomfic.getText();

		    

		    }
	   public String getContenidofichero(){

		    
		    String contenido=txtentrada.getText();
		    return contenido;

		}
	 
	 public void borrapanel(){
		 this.getContentPane().removeAll();
	
		 this.repaint();
	 }

	public JFrame Damemarco(){
		
		return this;
		
	}
	public void insertaPanel(JPanel nombre){

		this.getContentPane().add(nombre);
		this.repaint();
	}

	 public JPanel panelEmpleado() {

			logica=new LogicaBDSQL();
		 	panel=new JPanel();
		
			panel.setSize(600,410);
			panel.setLayout(null);
		 
			lbltitulo=new JLabel("GESTION DE EMPLEADOS");
			lbltitulo.setBounds(190,10,165,20);
			panel.add(lbltitulo);
			
			lblEmpleado=new JLabel("Nº EMPLEADO: ");
			lblEmpleado.setBounds(20,40,100,20);
			panel.add(lblEmpleado);
			txtidempleado=new JTextField();
			txtidempleado.setBounds(150,40,50,20);
			panel.add(txtidempleado);
			
			lblApellido=new JLabel("APELLIDO:");
			lblApellido.setBounds(20,70,80,20);
			panel.add(lblApellido);
			
			txtapellido=new JTextField();
			txtapellido.setBounds(150,70,150,20);
			panel.add(txtapellido);
			
			lbloficio=new JLabel("OFICIO:");
			lbloficio.setBounds(20,101,50,20);
			panel.add(lbloficio);
			txtoficio=new JTextField();
			txtoficio.setBounds(150, 100, 150, 20);
			panel.add(txtoficio);
			lblsalario=new JLabel("SALARIO:");
			lblsalario.setBounds(20,131,60,20);
			panel.add(lblsalario);
			txtsalario=new JTextField();
			txtsalario.setBounds(150,130,60,20);
			panel.add(txtsalario);
			lblcomision=new JLabel("COMISION:");
			lblcomision.setBounds(20,160,70,20);
			panel.add(lblcomision);
			txtcomision=new JTextField();
			txtcomision.setBounds(150,160,50,20);
			panel.add(txtcomision);
			
			Departamentos=new JComboBox<>();
			Departamentos.setModel(new DefaultComboBoxModel(this.NomDep().toArray())); // 
			Departamentos.setBounds(350,100,155,20);
			panel.add(Departamentos);
			directo=new JComboBox<>(directores);
			directo.setBounds(350, 130, 155, 20);
			panel.add(directo);
			lblfecha=new JLabel("FECHA:");
			lblfecha.setBounds(240, 160, 70, 20);
			panel.add(lblfecha);
			txtfecha=new JTextField();
			txtfecha.setBounds(300, 160, 70, 20);
			txtfecha.setText(this.getFecha());
			txtfecha.setEnabled(false);
			panel.add(txtfecha);
			bttnbuscar=new JButton("CONSULTAR EMPLEADO");
			bttnbuscar.setBounds(270,40,200,20);
			bttnbuscar.setIcon(new ImageIcon("imagenes/search.png"));
			bttnbuscar.addActionListener(new listener(this));
			panel.add(bttnbuscar);
			
			
			bttninserta=new JButton("Inserta Empleado");
			bttninserta.setBounds(60,220,160,20);
			bttninserta.setIcon(new ImageIcon("imagenes/guarda.png"));
			bttninserta.addActionListener(new listener(this));
			panel.add(bttninserta);
			
			bttneliminar=new JButton("Eliminar");
			bttneliminar.setBounds(240, 220, 100, 20);
			bttneliminar.setIcon(new ImageIcon("imagenes/eliminar.png"));
			bttneliminar.addActionListener(new listener(this));
			panel.add(bttneliminar);
			
			bttnmodificar=new JButton("Modificar");
			bttnmodificar.setBounds(360,220,120,20);
			bttnmodificar.setIcon(new ImageIcon("imagenes/actualizar.png"));
			bttnmodificar.addActionListener(new listener(this));
			panel.add(bttnmodificar);
			
			bttnsalir=new JButton("Exit");
			bttnsalir.setBounds(170,260,90,20);
			bttnsalir.setIcon(new ImageIcon("imagenes/salir.png"));
			bttnsalir.addActionListener(new listener(this));
			panel.add(bttnsalir);
			
			bttnlimpiar=new JButton("Limpiar");
			bttnlimpiar.setBounds(280, 260, 110, 20);
			bttnlimpiar.setIcon(new ImageIcon("imagenes/limpiar.png"));
			bttnlimpiar.addActionListener(new listener(this));
			panel.add(bttnlimpiar);
			panel.repaint();
			return panel;
			
	 }
	 
	
	 public ArrayList<String> NomDep(){
		logica=new LogicaBDSQL();
		logica.start();
		Departamentos depar=new Departamentos();
		 ArrayList<String> nombres=new ArrayList<>();
		 nombres.add("Elige un departamento");
		 for (int contador=0;contador<logica.departamentos().size();contador++) {
			 
			 depar=logica.departamentos().get(contador);
			 
			 if (depar.getnom()!=null) {
				 nombres.add(depar.getid()+"/" +depar.getnom());
			
			 }else {
				 contador++;
			 }
			
		 }
		 
		return nombres; 
	 }

	 // Metodo get que nos devuelve la fecha del sistema en una cadena de valores
	 public String getFecha() {

		 
		 Calendar c1 = Calendar.getInstance();
		int dia = c1.get(Calendar.DATE);
		int mes = c1.get(Calendar.MONTH);
		 int annio = c1.get(Calendar.YEAR);
		 
		 String fecha=annio+"-"+mes+"-"+dia;
	return fecha;
		 
	 }
	 
	 public int getdepar() {
		 int numero=0;
		 String aux="";
		String cadena=(String)Departamentos.getSelectedItem();
		for(int contador=0;contador<cadena.length();contador++) {
			
			if(cadena.charAt(contador)==47) {
				
				contador=cadena.length();
			}else {
				aux+=cadena.charAt(contador)+"";
				
			}
			
		}
		numero=Integer.parseInt(aux);
		
	return numero;
	}
	 
	 public String getdirector() {
		 
		 String director;
		 
		 director=(String)directo.getSelectedItem();
		 
		 return director;
	 }

	 public int getIdemple() {
		 int numero;
		 try {
			 numero=Integer.parseInt(txtidempleado.getText());
		 }catch(NumberFormatException e) {
			 numero=0;
		 }
		 
		 return numero;
	 }
	
	 public String getApellido() {
		 
		 return this.txtapellido.getText();
		 
	 }
	 
	 public String getoficio() {
		 
		 return this.txtoficio.getText();
	 }
	 
	 public double getSalario() {
		 
		 double sueldo;
		
		 try {
			 
			 sueldo=Double.parseDouble(txtsalario.getText());
		 }catch(NumberFormatException e) {
			 
			 sueldo=0;
		 }
		 return sueldo;
	 }
	 
	 public int getComision() {
		 int numero;
		 try {
			 numero=Integer.parseInt(txtcomision.getText());
		 }catch(NumberFormatException e) {
			 numero=0;
		 }
		 
		 return numero;
	 }
	 
	 public String gettxtFecha() {

		 
		 return this.txtfecha.getText();
	 }
	 
	public void comprar(String texto) {
		
		
	}
}