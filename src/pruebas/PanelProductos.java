package pruebas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.Border;
 

public class PanelProductos extends JFrame{
	JLabel lblid, lbldescripcion,lblstoc,lblPVP,numproductos;
	JTextField txtid,txtstock,txtpvp;
	JTextArea txtdescrip;
	JButton bttninsertar, bttncosultar, btnactulizar,btnaceptar,bttnprincipal, bttnmodificar;
	JPanel panel;
	JMenuBar Iconos;
	JToolBar botones;
	Border negro = BorderFactory.createLineBorder(Color.BLACK);
	
	public PanelProductos(){
	this.setTitle("PRODUCTOS");
	this.setSize(425,400);
	this.setLocationRelativeTo(null);
	setLayout(new BorderLayout());
    JFrame.setDefaultLookAndFeelDecorated(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setIconImage(Toolkit.getDefaultToolkit().createImage("imagenes/logo.png"));
	Iconos=new JMenuBar();
	 botones=new JToolBar();
	 botones.setBorder(negro);
	 bttninsertar=new JButton("Insertar");
	bttninsertar.setIcon(new ImageIcon("imagenes/guardar.png"));
	bttninsertar.addActionListener(new listener(this));
	botones.add(bttninsertar);
	bttncosultar=new JButton("Consultar");
	bttncosultar.setIcon(new ImageIcon("imagenes/search.png"));
	bttncosultar.addActionListener(new listener(this));
	botones.add(bttncosultar);
	/*btnactulizar=new JButton("Modificar");
	btnactulizar.setIcon(new ImageIcon("imagenes/actualizar.png"));
	btnactulizar.addActionListener(new listener(this));
	botones.add(btnactulizar);*/
	bttnprincipal=new JButton("Pagina Principal");
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
	///////////// JPANEL //////////////////
	public JPanel JPanelInsertarProductos() {
	
		
	panel=new JPanel();
	panel.setBorder(negro);
	panel.setSize(400,500);
	panel.setLayout(null);
	lblid=new JLabel("ID:");
	lblid.setBounds(100,34,20,10);;
	panel.add(lblid);
	txtid=new JTextField(3);
	txtid.setBounds(130,30,40,20);
	panel.add(txtid);
	lbldescripcion=new JLabel("Descripción:");
	lbldescripcion.setBounds(50,95,75,15);
	panel.add(lbldescripcion);
	txtdescrip=new JTextArea();
	txtdescrip.setLineWrap(true);
	JScrollPane scroll=new JScrollPane(txtdescrip);
	scroll.setBounds(130,70,200,70);
	panel.add(scroll);
	lblstoc=new JLabel("Stock Anual:");
	lblstoc.setBounds(50, 170, 75, 15);
	panel.add(lblstoc);
	txtstock=new JTextField(20);
	txtstock.setBounds(130,168,50,20);
	panel.add(txtstock);
	panel.setVisible(true);
	lblPVP=new JLabel("P.V.P:");
	lblPVP.setBounds(50, 215, 50, 15);
	panel.add(lblPVP);
	txtpvp=new JTextField(10);
	txtpvp.setBounds(130,210,60,20);
	panel.add(txtpvp);
	bttnmodificar=new JButton("Actualizar");
	bttnmodificar.setBounds(100,260,100,30);
	bttnmodificar.addActionListener(new listener(this));
	bttnmodificar.setVisible(false);
	panel.add(bttnmodificar);

	btnaceptar=new JButton("Insertar Registro");
	btnaceptar.addActionListener(new listener(this));
	btnaceptar.setBounds(130,260,150,30);
	panel.add(btnaceptar);
	numproductos=new JLabel("");
	numproductos.setBounds(140,290,150,30);
	panel.add(numproductos);
	return panel;
	
	}
	
	public static void main(String[] arg){
		PanelProductos panel=new PanelProductos();
		
		
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
	
	public String getDescpri(){
	
		return this.txtdescrip.getText();
	}
	
	public int getstock(){
		
		int stock;
		try{
			stock=Integer.parseInt(this.txtstock.getText());
		}catch(NumberFormatException e){
			stock=0;
		}
		
		return stock;
	}
	public int getpvp(){
		
		int pvp;
		try{
			pvp=Integer.parseInt(this.txtpvp.getText());
		}catch(NumberFormatException e){
			pvp=0;
		}
		
		return pvp;
	}
	

}


//////////////////////////////////////*PRODUCTOS*///////////////////////////////
class Productos {

int id, stock;
double pvp;
String descripcion;

public Productos() {};
public Productos(int ide,int cantidad,double precio, String descrip) {

this.id=ide;
this.stock=cantidad;
this.pvp=precio;
this.descripcion=descrip;
}

public int getid() {
return this.id;

}
public int getStock() {

return this.stock;
}

public double getpvp() {

return this.pvp;
}

public String getdescrip() {

return this.descripcion;
}

public void setid(int valor) {
this.id=valor;

}
public void setStock(int valor) {

this.stock=valor;
}

public void setpvp(double valor) {

this.pvp=valor;
}
public void setdescrip(String valor) {

this.descripcion=valor;
}

}



