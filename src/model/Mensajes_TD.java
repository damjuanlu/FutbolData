package model;

public class Mensajes_TD {
	
	private int cod_mensaje;
	private String mensaje;
	private String usu_mensaje;
	
	public Mensajes_TD (int cod_mensaje, String mensaje, String usu_mensaje) {
		this.cod_mensaje=cod_mensaje;
		this.mensaje=mensaje;
		this.usu_mensaje=usu_mensaje;
	}

	public int getCod_mensaje() {
		return cod_mensaje;
	}

	public void setCod_mensaje(int cod_mensaje) {
		this.cod_mensaje = cod_mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getUsu_mensaje() {
		return usu_mensaje;
	}

	public void setUsu_mensaje(String usu_mensaje) {
		this.usu_mensaje = usu_mensaje;
	}

}
