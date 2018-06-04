package model;

public class Clasificacion_TD {
	
	private int cod_eq_clas;
	private String nombre_eq;
	private int puntos;
	private int partidos_jug;
	private int gol_favor;
	private int gol_contra;
	
	public Clasificacion_TD (int cod_eq_clas, String nombre_eq, int puntos, int partidos_jug, int gol_favor, int gol_contra) {
		this.cod_eq_clas=cod_eq_clas;
		this.nombre_eq=nombre_eq;
		this.puntos=puntos;
		this.partidos_jug=partidos_jug;
		this.gol_favor=gol_favor;
		this.gol_contra=gol_contra;
	}

	public int getCod_eq_clas() {
		return cod_eq_clas;
	}

	public void setCod_eq_clas(int cod_eq_clas) {
		this.cod_eq_clas = cod_eq_clas;
	}

	public String getNombre_eq() {
		return nombre_eq;
	}

	public void setNombre_eq(String nombre_eq) {
		this.nombre_eq = nombre_eq;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getPartidos_jug() {
		return partidos_jug;
	}

	public void setPartidos_jug(int partidos_jug) {
		this.partidos_jug = partidos_jug;
	}

	public int getGol_favor() {
		return gol_favor;
	}

	public void setGol_favor(int gol_favor) {
		this.gol_favor = gol_favor;
	}

	public int getGol_contra() {
		return gol_contra;
	}

	public void setGol_contra(int gol_contra) {
		this.gol_contra = gol_contra;
	}

}
