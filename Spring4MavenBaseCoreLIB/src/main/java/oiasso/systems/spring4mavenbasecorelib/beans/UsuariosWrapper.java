package oiasso.systems.spring4mavenbasecorelib.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="usuarios")
public class UsuariosWrapper {
	
	private List<Usuario> usuarios;
	
	public UsuariosWrapper(){
		//constructor vacio
	}

	public UsuariosWrapper(List<Usuario> usuarios){
		this.usuarios = usuarios;
	}

	@XmlElement(name="usuario",type=Usuario.class)
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
