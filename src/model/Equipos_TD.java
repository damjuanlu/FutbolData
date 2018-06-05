package model;

public class Equipos_TD {
	
	private int cod_equipo;
	private String nombre;
	private String campo;
	private String entrenamiento;
	private String horario;
	
	public Equipos_TD(int cod_equipo, String nombre, String campo, String entrenamiento, String horario) {
		this.cod_equipo=cod_equipo;
		this.nombre=nombre;
		this.campo=campo;
		this.entrenamiento=entrenamiento;
		this.horario=horario;
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

	public String getEntrenamiento() {
		return entrenamiento;
	}

	public void setEntrenamiento(String entrenamiento) {
		this.entrenamiento = entrenamiento;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
}
