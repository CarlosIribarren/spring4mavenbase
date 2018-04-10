package oiasso.systems.spring4mavenbasecorelib.facade.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import oiasso.systems.spring4mavenbasecorelib.beans.Nacimiento;
import oiasso.systems.spring4mavenbasecorelib.facade.NacimientoFacade;

@Service
public class NacimientoFacadeImpl implements NacimientoFacade {

	@Override
	public int obtenerEdad(Nacimiento nacimiento) {
		
		Date fechaNac=nacimiento.getFechaNacimiento();
        Calendar fechaNacimiento = Calendar.getInstance();
        Calendar fechaActual = Calendar.getInstance();
        
        fechaNacimiento.setTime(fechaNac);
        int anno = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
        int mes =fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);

        //Se ajusta el a�o dependiendo el mes y el d�a
        if(mes<0 || (mes==0 && dia<0)){
            anno--;
        }
        //Regresa la edad en base a la fecha de nacimiento
        return anno;
	}

}
