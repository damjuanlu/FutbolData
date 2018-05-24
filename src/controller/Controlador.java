package controller;
import view.*;
import model.*;
import java.awt.event.*;

public class Controlador implements ActionListener {
	
	private VistaLogin miVistaLogin;
	private VistaPrincipal miVistaPrincipal;
	
	//CONSTRUCTOR DEL CONTROLADOR
	public Controlador(VistaLogin miVL, VistaPrincipal miVP) {
		
		//INICIALIZAR ATRIBUTOS
		miVistaLogin = miVL;
		miVistaPrincipal = miVP;
		
		//ASOCIAR EL COMPONENTE Swing AL LISTENER
		miVistaLogin.btnLogin.addActionListener(this);
	}
	
	/*IMPLEMENTAR EL METODO ABSTRACTO QUE INDICA LAS ACCIONES A LLEVAR A CABO
	  CUANDO EL EVENTO SE PRODUCE Y ES ESCUCHADO.*/
	public void actionPerformed (ActionEvent e) {
		
		//SI EL EVENTO ESTÁ PAUSADO POR EL BOTON QUE ESTAMOS INTERESADOS, REALIZAR ACCIONES
		if (e.getSource()==miVistaLogin.btnLogin) {
			miVistaLogin.setVisible(false);
			miVistaPrincipal.setVisible(true);
		}
	}
}
