package oiasso.systems.spring4mavenbasecorelib.facade;

import oiasso.systems.spring4mavenbasecorelib.beans.Nacimiento;

public interface NacimientoFacade {
	/**
	 * Obtiene fecha de nacimiento
	 * @return int con resultado de la edad 
	 */
	public int obtenerEdad(Nacimiento nacimiento);
}
