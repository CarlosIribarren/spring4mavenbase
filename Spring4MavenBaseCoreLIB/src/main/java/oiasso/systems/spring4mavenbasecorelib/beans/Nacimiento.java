package oiasso.systems.spring4mavenbasecorelib.beans;

import java.io.Serializable;
import java.util.Date;

public class Nacimiento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Date fechaNacimiento;

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
