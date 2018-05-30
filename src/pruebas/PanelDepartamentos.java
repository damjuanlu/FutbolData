package pruebas;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.Border;
public class PanelDepartamentos extends JFrame{
	
	JLabel lbltitulo,lblid, lblnombre,lbllocalidad;
	JTextField txtid, txtnombre, txtlocalidad;
	JPanel panel;
	JButton bttninsertar, bttncosultar,bttnprincipal,btnaceptar, bttnmodificar,bttnprimero,bttnultimo;
	JMenuBar Iconos;
	JToolBar botones;
	Border negro = BorderFactory.createLineBorder(Color.BLACK);
	public PanelDepartamentos() {
	
		this.setTitle("DEPARTAMENTOS");
		this.setSize(417,292);
		this.setLocationRelativeTo(null);
		setLayout(new BorderLayout());
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setIconImage(Toolkit.getDefaultToolkit().createImage("imagenes/logo.png"));
		Iconos=new JMenuBar();
		botones=new JToolBar();
		botones.setBorder(negro);
		bttninsertar=new JButton("NUEVO DEPARTAMENTO");
		bttninsertar.setIcon(new ImageIcon("imagenes/guardar.png"));
		bttninsertar.addActionListener(new listener(this));
		botones.add(bttninsertar);
		bttncosultar=new JButton("DEPARTAMENTOS");
		bttncosultar.setIcon(new ImageIcon("imagenes/search.png"));
		bttncosultar.addActionListener(new listener(this));
		botones.add(bttncosultar);
		bttnprincipal=new JButton();
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
	
	public JPanel PanelDepartamento() {
		
		panel=new JPanel();
		panel.setBorder(negro);
		panel.setSize(400,220);
		panel.setLayout(null);
		
		lbltitulo=new JLabel("DATOS DE DEPARTAMENTOS");
		lbltitulo.setBounds(125,10,165,20);
		lbltitulo.setVisible(false);
		panel.add(lbltitulo);
		lblid=new JLabel("CÓDIGO DEPARTAMENTO:");
		lblid.setBounds(10, 50, 150, 20);
		panel.add(lblid);
		txtid=new JTextField();
		txtid.setBounds(220,50,150,20);
		panel.add(txtid);
		lblnombre=new JLabel("NOMBRE DEPARTAMENTO:");
		lblnombre.setBounds(10,90,152,20);
		panel.add(lblnombre);
		txtnombre=new JTextField();
		txtnombre.setBounds(220,92,150,20);
		panel.add(txtnombre);
		lbllocalidad=new JLabel("LOCALIDAD DEPARTAMENTO:");
		lbllocalidad.setBounds(10,130,168,20);
		panel.add(lbllocalidad);
		txtlocalidad=new JTextField();
		txtlocalidad.setBounds(220,130,150,20);
		panel.add(txtlocalidad);
		bttnprimero=new JButton("Primero");
		bttnprimero.setBounds(30,175,80,20);
		bttnprimero.addActionListener(new listener(this));
		bttnprimero.setVisible(false);
		panel.add(bttnprimero);
		btnaceptar=new JButton("Registrar");
		btnaceptar.setBounds(120, 175, 87, 20);
		btnaceptar.addActionListener(new listener(this));
		panel.add(btnaceptar);
		bttnmodificar=new JButton(">>");
		bttnmodificar.setBounds(210, 175, 80, 20);
		bttnmodificar.addActionListener(new listener(this));
		bttnmodificar.setVisible(false);
		panel.add(bttnmodificar);
		bttnultimo=new JButton("Ultimo");
		bttnultimo.setBounds(300, 175, 80, 20);
		bttnultimo.addActionListener(new listener(this));
		bttnultimo.setVisible(false);
		panel.add(bttnultimo);
		return panel;
	}
	
	public  static void main(String []args) {
		
		PanelDepartamentos depa=new PanelDepartamentos();
		depa.borrapanel();
		depa.insertaPanel(depa.PanelDepartamento());
		
		
		
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
	
	public String getnom() {
		
		return this.txtnombre.getText();
	}
public String getlocalidad() {
		
		return this.txtlocalidad.getText();
	}
}

///////////////////////////////////////////DEPARTAMENTOS//////////////
class Departamentos {
int id;
String nombre, locadidad;
public Departamentos() {

}

public Departamentos(int i, String nom,String loca) {
this.id=i;
this.nombre=nom;
this.locadidad=loca;


}



public void setid(int valor) {

this.id=valor;
}

public void setnombre(String valor) {

this.nombre=valor;
}
public void setlocalidad(String valor) {

this.locadidad=valor;
}

public int getid() {

return this.id;
}

public String getnom() {

return this.nombre;
}

public String getlocalidad() {

return this.locadidad;
}

}
