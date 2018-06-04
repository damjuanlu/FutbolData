package model;

import java.util.Calendar;

public class Estadisticas_TD {
	
	private int cod_jugador;
	private int partidos_jug;
	private int goles;
	private int asistencias;
	private int tarjetas_amarillas;
	private int tarjetas_rojas;
	
	public Estadisticas_TD(int cod_jugador, int partidos_jug, int goles, int asistencias, int tarjetas_amarillas, int tarjetas_rojas){
		this.cod_jugador=cod_jugador;
		this.partidos_jug=partidos_jug;
		this.goles=goles;
		this.asistencias=asistencias;
		this.tarjetas_amarillas=tarjetas_amarillas;
		this.tarjetas_rojas=tarjetas_rojas;
	}

	public int getCod_jugador() {
		return cod_jugador;
	}

	public void setCod_jugador(int cod_jugador) {
		this.cod_jugador = cod_jugador;
	}

	public int getPartidos_jug() {
		return partidos_jug;
	}

	public void setPartidos_jug(int partidos_jug) {
		this.partidos_jug = partidos_jug;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public int getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	public int getTarjetas_amarillas() {
		return tarjetas_amarillas;
	}

	public void setTarjetas_amarillas(int tarjetas_amarillas) {
		this.tarjetas_amarillas = tarjetas_amarillas;
	}

	public int getTarjetas_rojas() {
		return tarjetas_rojas;
	}

	public void setTarjetas_rojas(int tarjetas_rojas) {
		this.tarjetas_rojas = tarjetas_rojas;
	}

}
