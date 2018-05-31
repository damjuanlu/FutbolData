package model;

public class Equipos_TD {
	
	private int cod_equipo;
	private String nombre;
	private String campo;
	
	public Equipos_TD(int cod_equipo, String nombre, String campo) {
		this.cod_equipo=cod_equipo;
		this.nombre=nombre;
		this.campo=campo;
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

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}
	
	
}
