package model;

public class Usuarios_TD {
	
	private String nombre_usuario;
	private String password;
	
	public Usuarios_TD (String nombre_usuario, String password) {
		this.nombre_usuario=nombre_usuario;
		this.password=password;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
