package model;

public class jugador {

	private String nombre;
	private String posicion;
	private String fecha_nac;
	private int edad;
	private String categoria;

	public jugador(String nombre, String posicion, String fecha_nac, int edad, String categoria) {
		this.nombre=nombre;
		this.posicion=posicion;
		this.fecha_nac=fecha_nac;
		this.edad=edad;
		this.categoria=categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
