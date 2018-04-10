package oiasso.systems.spring4mavenbasecorelib.facade;

import java.util.List;

import oiasso.systems.spring4mavenbasecorelib.beans.Usuario;

public interface UsuarioFacade {

	/**
	 * Obtiene dfsfs
	 * @return List<Usuarios> Retorna una lista de 
	 */
	public List<Usuario> getAllForms();
	
	/**
	 * Inserta usuario en la lista 
	 * @return Usuario Retorna nuevo usuario creado
	 */
	public Usuario insertarUsuario(Usuario usuario);
	
	/**
	 * Elimina usuario en la lista 
	 * @return Boolean si ha conseguido eliminar
	 */
	public Boolean deleteUsuario(String nombre);
	
	/**
	 * Busca el nombre que se le pasa y 
	 *  @return Usuario Retorna los datos de ese usuario
	 */
	public Usuario getDatos(String nombre);
	
	/**
	 * Modificar contenido de usuario antiguo
	 * @return Usuario Retorna el usuario con los datos modificados
	 */
	public Usuario updateUsuario(String nombre, Usuario usuario);
}
