package oiasso.systems.spring4mavenbaseweb.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import oiasso.systems.spring4mavenbasecorelib.beans.Calculadora;
import oiasso.systems.spring4mavenbasecorelib.facade.CalculadoraFacade;
import oiasso.systems.spring4mavenbaseweb.validators.CalculadoraValidator;


@Controller
public class CalculadoraController {

  private static final Logger logger = LoggerFactory.getLogger(CalculadoraController.class);

  @Autowired
  private CalculadoraFacade calculadoraFacade;

  @InitBinder("calculadora")
  protected void initBinder(final WebDataBinder binder) {
    logger.debug("binder");
    binder.setValidator(new CalculadoraValidator()); // registramos el validador
  }

  /*
   * Calculadora, sumar
   */
  @RequestMapping("/calculadora/new")
  public String mostrarCalculadora(final Model model) {
    logger.debug("mostrarCalculadora");
    model.addAttribute("calculadora", new Calculadora());
    return "calculadora";
  }

  @RequestMapping(value = "/calculadora/new", method = RequestMethod.POST)
  public String operaciones(@Validated @ModelAttribute final Calculadora calculadora, final BindingResult bindingResult,
      final Model model, final HttpServletRequest request) {
    logger.debug("operaciones");
    if (bindingResult.hasErrors()) {
      logger.debug("binding");
      return "calculadora";
    }

    String resCalculadora = "";

    // detectar cual ha sido el boton seleccionado
    final Boolean sumar = WebUtils.hasSubmitParameter(request, "sumar");
    final Boolean restar = WebUtils.hasSubmitParameter(request, "restar");
    final Boolean multiplicar = WebUtils.hasSubmitParameter(request, "multiplicar");
    final Boolean dividir = WebUtils.hasSubmitParameter(request, "dividir");

    // accion a realizar dependiendo del boton seleccionado
    if (sumar) {
      logger.debug("suma");
      resCalculadora = String.valueOf(this.calculadoraFacade.suma(calculadora));
    } else if (restar) {
      logger.debug("resta");
      resCalculadora = String.valueOf(this.calculadoraFacade.resta(calculadora));
    } else if (multiplicar) {
      logger.debug("multiplicacion");
      resCalculadora = String.valueOf(this.calculadoraFacade.multiplicacion(calculadora));
    } else if (dividir) {
      logger.debug("division");
      resCalculadora = String.valueOf(this.calculadoraFacade.division(calculadora));
    }

    // pasar resultado de la operacion
    model.addAttribute("resCalculadora", resCalculadora);
    model.addAttribute("calculadora", calculadora);
    return "calculadora";
  }
}
