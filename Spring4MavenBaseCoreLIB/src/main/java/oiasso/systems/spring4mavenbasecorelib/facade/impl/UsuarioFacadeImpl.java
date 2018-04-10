package oiasso.systems.spring4mavenbasecorelib.facade.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import oiasso.systems.spring4mavenbasecorelib.beans.Usuario;
import oiasso.systems.spring4mavenbasecorelib.facade.UsuarioFacade;

@Service
public class UsuarioFacadeImpl implements UsuarioFacade {

	/*
	 * Inicializar listado
	 */
	private List<Usuario> listado = new ArrayList<>();

	public UsuarioFacadeImpl() {
		Usuario form1 = new Usuario("nombre1", "apellido1", 10);
		Usuario form2 = new Usuario("nombre2", "apellido2", 20);
		Usuario form3 = new Usuario("nombre3", "apellido3", 30);

		listado.add(form1);
		listado.add(form2);
		listado.add(form3);
	}

	@Override
	public List<Usuario> getAllForms() {	
		return listado;
	}

	@Override
	public Usuario insertarUsuario(Usuario usuario) {
		Usuario nuevo = new Usuario (usuario.getNombre(),usuario.getApellido(),usuario.getEdad());
		
		Boolean existe = false;
		for (Usuario insertUsuario : listado) {
			if (insertUsuario.getNombre().equals(usuario.getNombre())){
				existe = true;
			}
		}
		if (existe == false){
			listado.add(nuevo);
			return nuevo;
		}else{
			return null;
		}
	}

	@Override
	public Boolean deleteUsuario(String nombre) {
		Boolean eliminado = false;
			
		Iterator<Usuario> recorrer = listado.iterator();
		while (recorrer.hasNext())
		{
			Usuario list = recorrer.next(); 
			if (list.getNombre().equals(nombre)) {
				recorrer.remove();
				eliminado = true;
				return eliminado;
			}
		}
		return eliminado;
	}

	@Override
	public Usuario getDatos(String nombre) {
		Usuario usuario = new Usuario();
		for (Usuario nombres : listado) {
			if (nombres.getNombre().equals(nombre)){
				usuario.setNombre(nombres.getNombre());
				usuario.setApellido(nombres.getApellido());
				usuario.setEdad(nombres.getEdad());
			}
		}
		return usuario;
	}

	@Override
	public Usuario updateUsuario(String nombre, Usuario usuario) {
		Usuario nuevo = new Usuario (usuario.getNombre(),usuario.getApellido(),usuario.getEdad());

		int index = -1;
		for (Usuario nombres : listado) {
			index++;
			if (nombres.getNombre().equals(nombre)){
				listado.set(index,nuevo);
				return nuevo;
			}
		}
		return null;
	}
}
