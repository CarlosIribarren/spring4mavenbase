package oiasso.systems.spring4mavenbaseweb.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import oiasso.systems.spring4mavenbasecorelib.beans.Nacimiento;
import oiasso.systems.spring4mavenbasecorelib.facade.NacimientoFacade;

@Controller
public class NacimientoController {

	private static final Logger logger = LoggerFactory.getLogger(NacimientoController.class);
	
	@Autowired
	private NacimientoFacade nacimientoFacade;
	
    @Autowired
    private MessageSource messageSource;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
		logger.debug("binder");
		//dependiendo del idioma tenemos que hacer una validaci�n diferente con el formato de la fecha
		String formato = messageSource.getMessage("nacimiento.formato",null,LocaleContextHolder.getLocale());
        DateFormat dateFormat = new SimpleDateFormat(formato);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	/*
	 * Fecha de nacimiento, para calcular la edad que tendr�a a fecha de hoy
	 */
	@RequestMapping("/nacimiento")
	public String mostrarNacimiento(Model model) {
		logger.debug("mostrarNacimiento");
		model.addAttribute("nacimiento", new Nacimiento());
		return "nacimiento";
	}

	@RequestMapping(value="/nacimiento", method = RequestMethod.POST)
	public String calcularEdad(@Validated@ModelAttribute Nacimiento nacimiento, BindingResult bindingResult, Model model) {
		logger.debug("calcularEdad");
		if (bindingResult.hasErrors()){
			logger.debug("binding");
			return "nacimiento";
		}
		int resEdad = nacimientoFacade.obtenerEdad(nacimiento);
		model.addAttribute("resEdad", resEdad);
		model.addAttribute("nacimiento", nacimiento);
		return "nacimiento";
	}
}
