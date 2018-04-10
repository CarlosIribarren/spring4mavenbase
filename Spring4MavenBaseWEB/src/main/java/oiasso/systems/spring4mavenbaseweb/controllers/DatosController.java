package oiasso.systems.spring4mavenbaseweb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import oiasso.systems.spring4mavenbasecorelib.beans.Datos;

@Controller
public class DatosController {

	private static final Logger logger = LoggerFactory.getLogger(DatosController.class);
	
	/*
	 * valores por defecto para el checkbox
	 */
	@ModelAttribute("datosChkList")
	public List<String> datosChk(){
		List<String> datosList = new ArrayList<>();
		datosList.add("datoChk1");
		datosList.add("datoChk2");
		datosList.add("datoChk3");
		return datosList;
	}
	
	/*
	 * valores por defecto para el radiobutton
	 */
	@ModelAttribute("datosRadList")
	public List<String> datosRad(){
		List<String> datosList = new ArrayList<>();
		datosList.add("datoRad1");
		datosList.add("datoRad2");
		datosList.add("datoRad3");
		return datosList;
	}
	
	/*
	 * valores por defecto para el select
	 */
	@ModelAttribute("datosSelList")
	public List<String> datosSel(){
		List<String> datosList = new ArrayList<>();
		datosList.add("datoSel1");
		datosList.add("datoSel2");
		datosList.add("datoSel3");
		return datosList;
	}
	
	/*
	 * iniciar datos
	 */
	@RequestMapping(value= "datos",method = RequestMethod.GET)
	public String iniciarDatos(Model model){
		logger.debug("iniciarDatos");
		Datos datos = new Datos();
		
		//valores seleccionados por defecto
		String[] datosChkDefault = {"datoChk2"};
		datos.setDatosChk(datosChkDefault);
		datos.setDatosRad("datoRad1");
		datos.setDatosSel("datoSel3");
		datos.setDatosTextarea("datosTextarea1");
		
		model.addAttribute("datos",datos);
		return "datos";
	}
	
	/*
	 * escribir los datos obtenidos de cada selecci�n
	 */
	@RequestMapping(value= "datos",method = RequestMethod.POST)
	public String obtenerDatos(@ModelAttribute Datos datos, Model model){
		logger.debug("obtenerDatos");
		model.addAttribute("resChk",datos.getDatosChk());
		model.addAttribute("resRad",datos.getDatosRad());
		model.addAttribute("resSel",datos.getDatosSel());
		model.addAttribute("resTxt",datos.getDatosTextarea());
		return "datos";
	}
}
