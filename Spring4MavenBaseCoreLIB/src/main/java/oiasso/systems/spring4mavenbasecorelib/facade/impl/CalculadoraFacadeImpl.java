package oiasso.systems.spring4mavenbasecorelib.facade.impl;

import org.springframework.stereotype.Service;

import oiasso.systems.spring4mavenbasecorelib.beans.Calculadora;
import oiasso.systems.spring4mavenbasecorelib.facade.CalculadoraFacade;


@Service
public class CalculadoraFacadeImpl implements CalculadoraFacade {

  @Override
  public int suma(final Calculadora calculadora) {
    final int resultado = calculadora.getNumero1() + calculadora.getNumero2() + calculadora.getNumero3();
    return resultado;
  }

  @Override
  public int resta(final Calculadora calculadora) {
    final int resultado = calculadora.getNumero1() - calculadora.getNumero2() - calculadora.getNumero3();
    return resultado;
  }

  @Override
  public int multiplicacion(final Calculadora calculadora) {
    final int resultado = calculadora.getNumero1() * calculadora.getNumero2() * calculadora.getNumero3();
    return resultado;
  }

  @Override
  public double division(final Calculadora calculadora) {
    double resultado = (double) calculadora.getNumero1() / (double) calculadora.getNumero2() / calculadora.getNumero3();
    resultado = Math.round(resultado * 100.0) / 100.0;
    return resultado;
  }
}
