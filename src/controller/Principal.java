package controller;

import view.*;

import javax.swing.UIManager;
import javax.swing.UIManager.*;

public class Principal {

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
		VistaPartidosDisputados miVistaPartidosDisputados = new VistaPartidosDisputados();
		VistaFichaPartidos miVistaFichaPartidos = new VistaFichaPartidos();
		VistaConvocatorias miVistaConvocatorias = new VistaConvocatorias();
		VistaMensajes miVistaMensajes = new VistaMensajes();
		
		Controlador miControlador = new Controlador (miVistaLogin, miVistaRegistro, miVistaPrincipal, miVistaFichas, miVistaAsistencias, miVistaEstadisticas, miVistaGestionEquipos, miVistaPartidosDisputados, miVistaConvocatorias, miVistaFichaPartidos, miVistaMensajes);
		
//		ControladorVistaPrincipal miControladorPrincipal = new ControladorVistaPrincipal(miVistaLogin, miVistaRegistro, miVistaPrincipal, miVistaFichas, miVistaAsistencias, miVistaEstadisticas, miVistaGestionEquipos, miVistaPartidosDisputados, miVistaConvocatorias);
//		ControladorFichas  miControladorFichas = new ControladorFichas(miVistaLogin, miVistaPrincipal, miVistaFichas, miVistaAsistencias, miVistaEstadisticas, miVistaGestionEquipos, miVistaPartidosDisputados, miVistaConvocatorias);
//		ControladorAsistencias  miControladorAsistencias = new ControladorAsistencias(miVistaLogin, miVistaPrincipal, miVistaFichas, miVistaAsistencias, miVistaEstadisticas, miVistaGestionEquipos, miVistaPartidosDisputados, miVistaConvocatorias);
//		ControladorEstadisticas  miControladorEstadisticas = new ControladorEstadisticas(miVistaLogin, miVistaPrincipal, miVistaFichas, miVistaAsistencias, miVistaEstadisticas, miVistaGestionEquipos, miVistaPartidosDisputados, miVistaConvocatorias);
//		ControladorGestionEquipos  miControladorGestionEquipos = new ControladorGestionEquipos(miVistaLogin, miVistaPrincipal, miVistaFichas, miVistaAsistencias, miVistaEstadisticas, miVistaGestionEquipos, miVistaPartidosDisputados, miVistaConvocatorias);
//		ControladorPartidosDisputados  miControladorPartidosDisputados = new ControladorPartidosDisputados(miVistaLogin, miVistaPrincipal, miVistaFichas, miVistaAsistencias, miVistaEstadisticas, miVistaGestionEquipos, miVistaPartidosDisputados, miVistaFichaPartidos, miVistaConvocatorias);
//		ControladorFichaPartidos miControladorFichaPartidos = new ControladorFichaPartidos(miVistaLogin, miVistaPrincipal, miVistaFichas, miVistaAsistencias, miVistaEstadisticas, miVistaGestionEquipos, miVistaPartidosDisputados, miVistaFichaPartidos, miVistaConvocatorias);
//		ControladorConvocatorias miControladorConvocatorias = new ControladorConvocatorias(miVistaLogin, miVistaPrincipal, miVistaFichas, miVistaAsistencias, miVistaEstadisticas, miVistaGestionEquipos, miVistaPartidosDisputados, miVistaConvocatorias);
//		
		miVistaLogin.setVisible(true);
	}

}
