package oiasso.systems.spring4mavenbaseweb.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import oiasso.systems.spring4mavenbasecorelib.beans.Usuario;

@Component
public class UsuarioValidator implements Validator {

	public UsuarioValidator(){
		//constructor
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.equals(clazz); // clase del bean al que da soporte este validador
	}

	@Override
	public void validate(Object target, Errors errors) {
		Usuario usuario = (Usuario) target;
		
		//no pueden ser vacios
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "validate.nombre.requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido", "validate.apellido.requerido");
		              		
        //no puede ser negativo o igual a cero
        if (usuario.getEdad() <= 0) {
            errors.rejectValue("edad", "validate.edad.negativo");
        }
	}
}
