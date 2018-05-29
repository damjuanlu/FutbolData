package controller;

import view.*;

import javax.swing.UIManager;
import javax.swing.UIManager.*;

public class ControladorPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			//UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel");
		}catch(Exception ex){
			System.out.println("Apariencia Look & Feel no cargada");
		}

		VistaLogin miVistaLogin = new VistaLogin();
		VistaRegistro miVistaRegistro = new VistaRegistro();
		VistaPrincipal miVistaPrincipal = new VistaPrincipal();
		VistaFichas miVistaFichas = new VistaFichas();
		VistaAsistencias miVistaAsistencias = new VistaAsistencias();
		VistaEstadisticas miVistaEstadisticas = new VistaEstadisticas();
		VistaGestionEquipos miVistaGestionEquipos = new VistaGestionEquipos();
		
		ControladorVistaPrincipal miControladorPrincipal = new ControladorVistaPrincipal(miVistaLogin, miVistaRegistro, miVistaPrincipal, miVistaFichas, miVistaAsistencias, miVistaEstadisticas, miVistaGestionEquipos);
		//ControladorFichas  miControladorFichas = new ControladorFichas(miVistaLogin, miVistaPrincipal, miVistaFichas, miVistaAsistencias, miVistaEstadisticas);
		ControladorAsistencias  miControladorAsistencias = new ControladorAsistencias(miVistaLogin, miVistaPrincipal, miVistaFichas, miVistaAsistencias, miVistaEstadisticas, miVistaGestionEquipos);
		ControladorEstadisticas  miControladorEstadisticas = new ControladorEstadisticas(miVistaLogin, miVistaPrincipal, miVistaFichas, miVistaAsistencias, miVistaEstadisticas, miVistaGestionEquipos);
		ControladorGestionEquipos  miControladorGestionEquipos = new ControladorGestionEquipos(miVistaLogin, miVistaPrincipal, miVistaFichas, miVistaAsistencias, miVistaEstadisticas, miVistaGestionEquipos);
		
		miVistaLogin.setVisible(true);
	}

}
