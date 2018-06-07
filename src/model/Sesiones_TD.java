package model;

import java.sql.Date;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Sesiones_TD {

	private int cod_equipo;
	private String nombre;
	private String dia;
	private String minutos;
	private String objetivo;
	private String material;
	private String observaciones_sesion;
	private String calentamiento;
	private String parte_principal;
	private String vuelta_calma;
	private int cod_sesion;

//	cod_equipo	nombre	dia	minutos	objetivo	material	observaciones_sesion	calentamiento	parte_principal	vuelta_calma

	public Sesiones_TD( int cod_equipo, String nombre, String dia, String minutos, String objetivo, 
						String material, String observaciones_sesion, String calentamiento, 
						String parte_principal, String vuelta_calma, int cod_sesion) {
		this.cod_equipo=cod_equipo;
		this.nombre=nombre;
		this.dia=dia;
		this.minutos=minutos;
		this.objetivo=objetivo;
		this.material=material;
		this.observaciones_sesion=observaciones_sesion;
		this.calentamiento=calentamiento;
		this.parte_principal=parte_principal;
		this.vuelta_calma=vuelta_calma;
		this.cod_sesion=cod_sesion;
	}

	public int getCod_equipo() {
		return cod_equipo;
	}

	public void setCod_equipo(int cod_equipo) {
		this.cod_equipo = cod_equipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMinutos() {
		return minutos;
	}

	public void setMinutos(String minutos) {
		this.minutos = minutos;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getObservaciones_sesion() {
		return observaciones_sesion;
	}

	public void setObservaciones_sesion(String observaciones_sesion) {
		this.observaciones_sesion = observaciones_sesion;
	}

	public String getCalentamiento() {
		return calentamiento;
	}

	public void setCalentamiento(String calentamiento) {
		this.calentamiento = calentamiento;
	}

	public String getParte_principal() {
		return parte_principal;
	}

	public void setParte_principal(String parte_principal) {
		this.parte_principal = parte_principal;
	}

	public String getVuelta_calma() {
		return vuelta_calma;
	}

	public void setVuelta_calma(String vuelta_calma) {
		this.vuelta_calma = vuelta_calma;
	}

	public int getCod_sesion() {
		return cod_sesion;
	}

	public void setCod_sesion(int cod_sesion) {
		this.cod_sesion = cod_sesion;
	}



	
}
