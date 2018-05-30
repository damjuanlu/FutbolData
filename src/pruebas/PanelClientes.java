package pruebas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.Border;

public class PanelClientes extends JFrame{
	JLabel lblid, lblnombre,lbldireccion,lblpoblacion,lbltelefono, lblDNI,numproductos;
	JTextField txtid,txtdni, txtpoblacion, txttelefono;
	JTextArea txtnombre, txtdireccion;
	JButton bttninsertar, bttncosultar,btnaceptar,bttnprincipal, bttnmodificar;
	JPanel panel;
	JMenuBar Iconos;
	JToolBar botones;
	Border negro = BorderFactory.createLineBorder(Color.BLACK);

	public PanelClientes(){
	this.setTitle("Clientes");
	this.setSize(360,420);
	this.setLocationRelativeTo(null);
	setLayout(new BorderLayout());
    JFrame.setDefaultLookAndFeelDecorated(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setIconImage(Toolkit.getDefaultToolkit().createImage("imagenes/logo.png"));
	Iconos=new JMenuBar();
	botones=new JToolBar();
	botones.setBorder(negro);
	bttninsertar=new JButton("Agregar");
	bttninsertar.setIcon(new ImageIcon("imagenes/guardar.png"));
	bttninsertar.addActionListener(new listener(this));
	botones.add(bttninsertar);
	bttncosultar=new JButton("Buscar");
	bttncosultar.setIcon(new ImageIcon("imagenes/search.png"));
	bttncosultar.addActionListener(new listener(this));
	botones.add(bttncosultar);
	bttnprincipal=new JButton("Principal");
	bttnprincipal.setIcon(new ImageIcon("imagenes/principal.png"));
	bttnprincipal.addActionListener(new listener (this));
	botones.add(bttnprincipal);
	
	Iconos.add(botones);
	setJMenuBar(Iconos);
	JPanel panel=new JPanel();
	this.add(panel);
 
	this.setVisible(true);
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
	
	
	

	public static void main(String[] arg){
	PanelClientes apanel=new PanelClientes();
		apanel.borrapanel();
	apanel.insertaPanel(apanel.JPClientes());
		
		
	}
	
	////////------------- PANEL CLIENTES--------------------////////////////////
	
	public  JPanel JPClientes() {
		panel=new JPanel();
		panel.setBorder(negro);
		panel.setSize(400,500);
		panel.setLayout(null);
		
		lblid=new JLabel("ID:");
		lblid.setBounds(50,34,20,10);;
		panel.add(lblid);
		txtid=new JTextField(3);
		txtid.setBounds(130,30,40,20);
		panel.add(txtid);
		lblnombre=new JLabel("NOMBRE:");
		lblnombre.setBounds(50,75,75,15);
		panel.add(lblnombre);
		txtnombre=new JTextArea();
		txtnombre.setBounds(130,60,150,40);
		txtnombre.setLineWrap(true);
		panel.add(txtnombre);
		lbldireccion=new JLabel("DIRECCIÓN: ");
		lbldireccion.setBounds(50,130,75,15);
		panel.add(lbldireccion);
		
		txtdireccion=new JTextArea();
		txtdireccion.setBounds(130,120,150,40);
		txtdireccion.setLineWrap(true);
		panel.add(txtdireccion);
		
		lblpoblacion=new JLabel("POBLACIÓN: ");
		lblpoblacion.setBounds(50,190,75,15);
		panel.add(lblpoblacion);
		txtpoblacion=new JTextField();
		txtpoblacion.setBounds(130,187,150,20);
		panel.add(txtpoblacion);
		
		lbltelefono=new JLabel("TELÉFONO:");
		lbltelefono.setBounds(50, 230, 75,15);
		panel.add(lbltelefono);
		txttelefono=new JTextField();
		txttelefono.setBounds(130, 225, 150, 20);
		panel.add(txttelefono);
		
		lblDNI=new JLabel("DNI: ");
		lblDNI.setBounds(50, 260, 50, 20);
		panel.add(lblDNI);
		txtdni=new JTextField();
		txtdni.setBounds(130, 260, 90, 20);
		panel.add(txtdni);

		btnaceptar=new JButton("Confirmar");
		btnaceptar.setBounds(110, 300, 150, 40);
		btnaceptar.addActionListener(new listener (this));
		
		
		panel.add(btnaceptar);
		
		bttnmodificar=new JButton("Actualizar");
		bttnmodificar.setBounds(100,260,100,30);
		bttnmodificar.addActionListener(new listener(this));
		bttnmodificar.setVisible(false);
		panel.add(bttnmodificar);
		numproductos=new JLabel("");
		numproductos.setBounds(120,340,150,30);
		panel.add(numproductos);
		return panel;
	}
	

	public int getID(){
		int num;
		try{
		
			num=Integer.parseInt(this.txtid.getText());
		}catch( NumberFormatException e){
			num=0;
	
		}
		return num;
	}

	public String getNombre(){
		return this.txtnombre.getText();
	}

	public String getDireccion(){
		return this.txtdireccion.getText();
	}
	public String getpoblacion() {
		
		return this.txtpoblacion.getText();
	}
	
	public int getTelefono() {
		int numero;
	try {
		numero=Integer.parseInt(txttelefono.getText());
	}catch(NumberFormatException a) {
		numero=0;
	}
	return numero;	
	}
	
	public String getDNI() {
	
	return this.txtdni.getText();
	}
	
	
}

class Clientes{
	
	int id, telefono;
	String nombre,direccion,poblacion,nif;
	
	public void setid(int valor) {
		this.id=valor;
		
	}


	public void setnombre(String valor) {
		
		this.nombre=valor;
	}
	public void setdireccion(String valor) {
	
		this.direccion=valor;
		
	}
	
	public void setpoblacion(String valor) {
		
		this.poblacion=valor;
		
	}
	
	public void settelefono(int valor) {
		
		this.telefono=valor;
	}
	
	public void setnif(String valor) {
		
		this.nif=valor;
		
	}
	
	
	public int getid() {
		
		return this.id;
	}
	
	
	public int gettelefono() {
		
		return this.telefono;
	}
	
	public String getnombre() {
		return this.nombre;
	} 
	
	public String getdireccion() {
		
		return this.direccion;
	}
	
	public String getdpoblacion() {
		
		return this.poblacion;
	}
	
	public String getnif() {
		
		return this.nif;
	}
}
