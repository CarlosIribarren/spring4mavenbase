package oiasso.systems.spring4mavenbaseweb.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import oiasso.systems.spring4mavenbasecorelib.beans.Usuario;
import oiasso.systems.spring4mavenbasecorelib.facade.UsuarioFacade;


@RequestMapping("/inicio")
@Controller
public class InicioController {

  private static final Logger logger = LoggerFactory.getLogger(InicioController.class);

  @Autowired
  private UsuarioFacade usuarioFacade;

  @RequestMapping("")
  public String inicio(final Model model) {
    logger.debug("inicio");
    // mostrar listado de usuarios
    final List<Usuario> list = this.usuarioFacade.getAllForms();
    model.addAttribute("usuarios", list);
    return "index";
  }
}
