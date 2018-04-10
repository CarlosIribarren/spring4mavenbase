package oiasso.systems.spring4mavenbaseweb.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.jasperreports.engine.JRException;
import oiasso.systems.spring4mavenbasecorelib.beans.Usuario;
import oiasso.systems.spring4mavenbasecorelib.beans.UsuariosWrapper;
import oiasso.systems.spring4mavenbasecorelib.facade.UsuarioFacade;
import oiasso.systems.spring4mavenbaseweb.validators.UsuarioValidator;

@Controller
public class UsuarioController {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	private UsuarioFacade usuarioFacade;

	@InitBinder("usuario")
	protected void initBinder(WebDataBinder binder) {
		logger.debug("binder");
		binder.setValidator(new UsuarioValidator()); // registramos el validador
	}

	/*
	 * Resultado del listado de usuarios en XML y JSON
	 */
	@RequestMapping(value="/usuarios", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public UsuariosWrapper getUsuarios() {
		logger.debug("getUsuarios");
		List<Usuario> usuarios = usuarioFacade.getAllForms();
		return new UsuariosWrapper(usuarios);
	}
	
	/*
	 * Insertar Usuario
	 */
	@RequestMapping("/usuario/new")
	public String usuarioVacio(Model model) {
		logger.debug("usuarioVacio");
		model.addAttribute("usuario", new Usuario());
		return "formulario";
	}

	@RequestMapping(value="/usuario/new", method = RequestMethod.POST)
	public String insertarUsuario(@Validated@ModelAttribute Usuario usuario, BindingResult bindingResult) {
		logger.debug("insertarUsuario");
		if (bindingResult.hasErrors()){
			return "formulario";
		}
		usuarioFacade.insertarUsuario(usuario);
		return "redirect:/inicio";
	}

	/*
	 * Modificar Usuario
	 */

	@RequestMapping("/usuario/{nombre}/edit")
	public String mostrarUsuario(@PathVariable String nombre, Model model) {
		logger.debug("mostrarUsuario");
		Usuario usuario = usuarioFacade.getDatos(nombre);
		model.addAttribute("usuario", new Usuario(usuario));
		return "formulario";
	}

	@RequestMapping(value="/usuario/{nombre}/edit", method = RequestMethod.POST)
	public String modificarUsuario(@PathVariable String nombre, @Validated@ModelAttribute Usuario usuario, BindingResult bindingResult) {
		logger.debug("modificarUsuario");
		if (bindingResult.hasErrors()){	
			return "formulario";
		}
		usuarioFacade.updateUsuario(nombre, usuario);
		return "redirect:/inicio";
	}

	/*
	 * Visualizar Usuario
	 */
	@RequestMapping("/usuario/{nombre}")
	public String verUsuario(@PathVariable String nombre, Model model) {
		logger.debug("verUsuario");
		Usuario usuario = usuarioFacade.getDatos(nombre);

		if (usuario != null){			
			model.addAttribute("nombre", usuario.getNombre());
			model.addAttribute("apellido", usuario.getApellido());
			model.addAttribute("edad", usuario.getEdad());
		}else{	
			model.addAttribute("error", "No se ha encontrado ning�n usuario con ese nombre");
		}

		return "mostrar";
	}

	/*
	 * Eliminar un usuario
	 */	
	@RequestMapping(value="/usuario/{nombre}/delete")
	public String eliminarUsuario(@PathVariable String nombre) {
		logger.debug("eliminarUsuario");
		usuarioFacade.deleteUsuario(nombre);
		return "redirect:/inicio";
	}

	/*
	 * Mostrar listado de usuarios en pdf
	 */
	@RequestMapping(value = "/usuarios/pdf")
	public String crearInformePdf(Model model) throws JRException {
		logger.debug("crearInformePdf");
		
		List<Usuario> listaUsuarios = this.usuarioFacade.getAllForms();

		model.addAttribute("datasource", listaUsuarios);
		model.addAttribute("format", "pdf"); 
		return "informeGuiaRapida";  
	}
}
