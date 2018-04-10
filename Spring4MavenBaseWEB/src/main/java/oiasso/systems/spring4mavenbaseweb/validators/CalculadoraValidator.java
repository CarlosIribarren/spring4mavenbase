package oiasso.systems.spring4mavenbaseweb.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import oiasso.systems.spring4mavenbasecorelib.beans.Calculadora;

@Component
public class CalculadoraValidator implements Validator {
	
	private static final Logger logger = LoggerFactory.getLogger(CalculadoraValidator.class);

	public CalculadoraValidator(){
		//constructor
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Calculadora.class.equals(clazz); // clase del bean al que da soporte este validador
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.debug("validate");		
	}
}
