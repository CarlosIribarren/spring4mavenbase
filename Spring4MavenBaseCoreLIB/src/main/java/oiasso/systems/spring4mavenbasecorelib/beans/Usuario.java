package oiasso.systems.spring4mavenbasecorelib.beans;

import java.io.Serializable;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String apellido;
	private int edad;

	public Usuario() {
		//constructor vacio
	}

	public Usuario(String nombre, String apellido, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public Usuario(Usuario usuario) {
		this.nombre = usuario.getNombre();
		this.apellido = usuario.getApellido();
		this.edad = usuario.getEdad();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}    
}
