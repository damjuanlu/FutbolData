package model;

import java.sql.Date;

public class Jugadores_TD {

	private int cod_jugador;
	private String nombre;
	private String apellido;
	private Date fecha_nac;
	private String posicion;
	private String equipo;
	private int dorsal;


	public Jugadores_TD(int cod_jugador, String nombre, String apellido, Date fecha_nac, String equipo, String posicion, int dorsal) {
		this.cod_jugador=cod_jugador;
		this.nombre=nombre;
		this.apellido=apellido;
		this.fecha_nac=fecha_nac;
		this.equipo=equipo;
		this.posicion=posicion;
		this.dorsal=dorsal;
	}


	public int getCod_jugador() {
		return cod_jugador;
	}


	public void setCod_jugador(int cod_jugador) {
		this.cod_jugador = cod_jugador;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Date getFecha_nac() {
		return fecha_nac;
	}


	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}


	public String getPosicion() {
		return posicion;
	}


	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}


	public String getEquipo() {
		return equipo;
	}


	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}


	public int getDorsal() {
		return dorsal;
	}


	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	
	public String toString (){
        String mensaje=""+ nombre+","+ apellido+","+posicion;
        return mensaje;
    }

	
}
