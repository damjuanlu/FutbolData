package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Frame;
import java.awt.Insets;

public class VistaPrincipal extends Frame{

	public JFrame frmSportClubData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal window = new VistaPrincipal();
					window.frmSportClubData.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaPrincipal() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmSportClubData = new JFrame();
		frmSportClubData.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmSportClubData.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rballesterosa\\git\\FutbolData\\Repositorios\\icon-soccer\\026-strategy-1.png"));
		frmSportClubData.setTitle("SportClubData");
		frmSportClubData.getContentPane().setBackground(new Color(255, 255, 204));
		frmSportClubData.setBounds(100, 100, 721, 530);
		frmSportClubData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSportClubData.getContentPane().setLayout(null);
		
		JMenuBar menuPrincipal = new JMenuBar();
		menuPrincipal.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		menuPrincipal.setBounds(0, 0, 1362, 21);
		frmSportClubData.getContentPane().add(menuPrincipal);
		
		JMenu mnInicio = new JMenu("INICIO");
		mnInicio.setHorizontalAlignment(SwingConstants.CENTER);
		mnInicio.setMargin(new Insets(2, 10, 0, 10));
		mnInicio.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		menuPrincipal.add(mnInicio);
		
		JMenu mnJugadores = new JMenu("JUGADORES");
		mnJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		mnJugadores.setMargin(new Insets(2, 10, 0, 10));
		mnJugadores.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		menuPrincipal.add(mnJugadores);
		
		JMenuItem mntmFichas = new JMenuItem("FICHAS");
		mntmFichas.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnJugadores.add(mntmFichas);
		
		JMenuItem mntmAsistencia = new JMenuItem("ASISTENCIA");
		mntmAsistencia.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnJugadores.add(mntmAsistencia);
		
		JMenuItem mntmEstadisticas = new JMenuItem("ESTAD\u00CDSTICAS");
		mntmEstadisticas.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnJugadores.add(mntmEstadisticas);
		
		JMenu mnCompeticion = new JMenu("COMPETICI\u00D3N");
		mnCompeticion.setHorizontalAlignment(SwingConstants.CENTER);
		mnCompeticion.setMargin(new Insets(2, 10, 0, 10));
		mnCompeticion.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		menuPrincipal.add(mnCompeticion);
		
		JMenuItem mntmMantenimientoEquipos = new JMenuItem("MANTENIMIENTO EQUIPOS");
		mntmMantenimientoEquipos.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnCompeticion.add(mntmMantenimientoEquipos);
		
		JMenuItem mntmPartidosDisputados = new JMenuItem("PARTIDOS DISPUTADOS");
		mntmPartidosDisputados.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnCompeticion.add(mntmPartidosDisputados);
		
		JMenuItem mntmConvocatorias = new JMenuItem("CONVOCATORIAS");
		mntmConvocatorias.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnCompeticion.add(mntmConvocatorias);
		
		JMenuItem mntmCalendariosYResultados = new JMenuItem("CALENDARIOS Y RESULTADOS");
		mntmCalendariosYResultados.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnCompeticion.add(mntmCalendariosYResultados);
		
		JMenu mnEntrenamiento = new JMenu("ENTRENAMIENTO");
		mnEntrenamiento.setHorizontalAlignment(SwingConstants.CENTER);
		mnEntrenamiento.setMargin(new Insets(2, 10, 0, 10));
		mnEntrenamiento.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		menuPrincipal.add(mnEntrenamiento);
		
		JMenuItem mntmPlanificacionSesiones = new JMenuItem("PLANIFICACI\u00D3N SESIONES");
		mntmPlanificacionSesiones.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnEntrenamiento.add(mntmPlanificacionSesiones);
		
		JMenuItem mntmBaseDeDatos = new JMenuItem("BASE DE DATOS EJERCICIOS");
		mntmBaseDeDatos.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnEntrenamiento.add(mntmBaseDeDatos);
		
		JMenu mnAdministracion = new JMenu("ADMINISTRACI\u00D3N");
		mnAdministracion.setHorizontalAlignment(SwingConstants.CENTER);
		mnAdministracion.setMargin(new Insets(2, 10, 0, 10));
		mnAdministracion.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		menuPrincipal.add(mnAdministracion);
		
		JMenuItem mntmCuotasJugadores = new JMenuItem("CUOTAS JUGADORES");
		mntmCuotasJugadores.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnAdministracion.add(mntmCuotasJugadores);
		
		JMenu mnAyuda = new JMenu("AYUDA");
		mnAyuda.setHorizontalAlignment(SwingConstants.CENTER);
		mnAyuda.setMargin(new Insets(2, 10, 0, 10));
		mnAyuda.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		menuPrincipal.add(mnAyuda);
		
		JMenuItem mntmUsuario = new JMenuItem("USUARIO");
		mntmUsuario.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnAyuda.add(mntmUsuario);
		
		JMenuItem mntmContacto = new JMenuItem("CONTACTO");
		mntmContacto.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnAyuda.add(mntmContacto);
		
		JMenuItem mntmAcercaDe = new JMenuItem("ACERCA DE ...");
		mntmAcercaDe.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		mnAyuda.add(mntmAcercaDe);
		
		JButton btnCerrarSesion = new JButton("CERRAR SESI\u00D3N");
		menuPrincipal.add(btnCerrarSesion);
		btnCerrarSesion.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
	}
}
