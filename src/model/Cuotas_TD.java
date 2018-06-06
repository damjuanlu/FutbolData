package model;

public class Cuotas_TD {

	private int cod_cuota;
	private int cod_jugador;
	private String nombre;
	private String apellido;
	private String equipo;
	private int cantidad;
	private boolean pagado;
	
	public Cuotas_TD (int cod_cuota, int cod_jugador, String nombre, String apellido, String equipo, int cantidad, boolean pagado ) {
		 this.cod_cuota=cod_cuota;
		 this.cod_jugador=cod_jugador;
		 this.nombre=nombre;
		 this.apellido=apellido;
		 this.equipo=equipo;
		 this.cantidad=cantidad;
		 this.pagado=pagado;
	}

	public int getCod_cuota() {
		return cod_cuota;
	}

	public void setCod_cuota(int cod_cuota) {
		this.cod_cuota = cod_cuota;
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

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	
}
