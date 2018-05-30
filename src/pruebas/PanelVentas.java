package pruebas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.Border;

public class PanelVentas extends JFrame{
	
	public static void  main(String [] args) {
		
		PanelVentas nuevo=new PanelVentas();
		nuevo.borrapanel();
		nuevo.insertaPanel(nuevo.PanelVentas());
		
	} 
	JLabel lblid, lblfecha,lblidcliente,lblidproducto,lblcantidad, lblDNI,numproductos;
	JTextField txtid,txtfecha, txtidcliente, txtproductos, txtCantidad;
	JButton bttninsertar, bttncosultar,btnaceptar,bttnprincipal, bttnmodificar,bttnVentasCliente,bttbuscar;
	JPanel panel;
	JMenuBar Iconos;
	JToolBar botones;
	Border negro = BorderFactory.createLineBorder(Color.BLACK);

	public PanelVentas(){
	this.setTitle("Ventas");
	this.setSize(424,430);
	this.setLocationRelativeTo(null);
	setLayout(new BorderLayout());
    JFrame.setDefaultLookAndFeelDecorated(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setIconImage(Toolkit.getDefaultToolkit().createImage("imagenes/logo.png"));
	Iconos=new JMenuBar();
	botones=new JToolBar();
	botones.setBorder(negro);
	bttninsertar=new JButton("Venta Nueva");
	bttninsertar.setIcon(new ImageIcon("imagenes/guardar.png"));
	bttninsertar.addActionListener(new listener(this));
	botones.add(bttninsertar);
	bttncosultar=new JButton("Buscar Venta");
	bttncosultar.setIcon(new ImageIcon("imagenes/search.png"));
	bttncosultar.addActionListener(new listener(this));
	botones.add(bttncosultar);
	bttnVentasCliente=new JButton("Ventas de Cliente");
	bttnVentasCliente.setIcon(new ImageIcon("imagenes/lista.png"));
	bttnVentasCliente.addActionListener(new listener(this));
	botones.add(bttnVentasCliente);
	bttnprincipal=new JButton("Menu");
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
	
	
	
	public JPanel PanelVentas() {
		
		panel=new JPanel();
		panel.setBorder(negro);
		panel.setSize(407,348);
		panel.setLayout(null);
		
		lblid=new JLabel("ID VENTA:");
		lblid.setBounds(50,34,60,10);;
		panel.add(lblid);
		txtid=new JTextField(3);
		txtid.setBounds(130,30,40,20);
		panel.add(txtid);
		
		lblfecha=new JLabel("FECHA VENTA:");
		lblfecha.setBounds(50,75,75,15);
		panel.add(lblfecha);
		txtfecha=new JTextField();
		txtfecha.setBounds(130,60,150,40);
		panel.add(txtfecha);
		
		lblidcliente=new JLabel("ID CLIENTE: ");
		lblidcliente.setBounds(50,130,75,15);
		panel.add(lblidcliente);
		txtidcliente=new JTextField();
		txtidcliente.setBounds(130,120,150,40);
		panel.add(txtidcliente);
		lblidproducto=new JLabel("ID PRODUCTO: ");
		lblidproducto.setBounds(50,190,75,15);
		panel.add(lblidproducto);
		
		txtproductos=new JTextField();
		txtproductos.setBounds(130, 185, 150, 20);
		panel.add(txtproductos);
		
		lblcantidad=new JLabel("CANTIDAD:");
		lblcantidad.setBounds(50, 230, 75,15);
		panel.add(lblcantidad);
		txtCantidad=new JTextField();
		txtCantidad.setBounds(130,227,150,20);
		panel.add(txtCantidad);
		

		btnaceptar=new JButton("Insertar Venta");
		btnaceptar.setBounds(110, 270, 150, 40);
		btnaceptar.addActionListener(new listener (this));
		
		
		panel.add(btnaceptar);
		
		bttnmodificar=new JButton("");
		bttnmodificar.setBounds(100,260,100,30);
		bttnmodificar.addActionListener(new listener(this));
		bttnmodificar.setVisible(false);
		panel.add(bttnmodificar);
		
		bttncosultar=new JButton("Rastrea");
		bttncosultar.addActionListener(new listener(this));
		panel.add(bttncosultar);
		
		numproductos=new JLabel("");
		numproductos.setBounds(127,255,150,30);
		numproductos.setBorder(negro);
		numproductos.setVisible(false);
		panel.add(numproductos);
		return panel;
		
		
	}
	
	public int getid() {
		int num;
		try {
			num=Integer.parseInt(txtid.getText());
		}catch(NumberFormatException e) {
			
			num=0;
		}
		return num;
		
	}
	
	public String getfecha() {
		
		return this.txtfecha.getText();
		
	}
	public int getidCliente(){
		int num;
		try {
			num=Integer.parseInt(txtidcliente.getText());
		}catch(NumberFormatException e) {
			
			num=0;
		}
		return num;
	}
	
	public int getidproducto() {
		int num;
		try {
			num=Integer.parseInt(txtproductos.getText());
		}catch(NumberFormatException e) {
			
			num=0;
		}
		return num;
		
	}
	
	public int getcantidad() {
		
		int num;
		try {
			num=Integer.parseInt(txtCantidad.getText());
		}catch(NumberFormatException e) {
			
			num=0;
		}
		return num;
	}
}

////////////////////////////////////////////VENTAS///////////////////////////////////////////////////


class Ventas {

int id,idcliente,idproducto,cantidad;
String fecha;

public void setid(int valor) {
this.id=valor;

}


public void setfecha(String valor) {

this.fecha=valor;
}
public void setidcliente(int valor) {

this.idcliente=valor;

}

public void setidproducto(int valor) {

this.idproducto=valor;

}

public void setcantidad(int valor) {

this.cantidad=valor;
}

public int getid() {

return this.id;
}


public String getfecha() {

return this.fecha;
}

public int getidcliente() {
return this.idcliente;
} 

public int getidproducto() {

return this.idproducto;
}

public int getcantidad() {

return this.cantidad;
}


}

class InformeVentas{
	
	int idcliente,idProductos,idventas,numventas;
	String nombre;
	double preciofinal;
	public InformeVentas(int p, int v ,String date, double pvp) {
		
	
		this.idProductos=p;
		this.idventas=v;
		
		this.nombre=date;
		this.preciofinal=pvp;
	}
	
	public InformeVentas() {}
	public int getcliente() {
		
		return this.idcliente;
		
	}
	
	public int getproducto() {
		
		return this.idProductos;
		
	}
	public int getventa() {
		
		return this.idventas;
		
	}
	
	public String  getnombre() {
		
		return this.nombre;
		
	}
	
	public double getpreciofinal() {
	
	return this.preciofinal;
	
}
	
	public void setidproducto(int valor) {
		this.idProductos=valor;
		
	}
	public void setidventa(int valor) {
		this.idventas=valor; 
		
	}
	
	public void setnombre(String valor) {
		this.nombre=valor;
		
	}
	
	public void setpvp(double valor) {
		this.preciofinal=valor;
		
	}
	
}

