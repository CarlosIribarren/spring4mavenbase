package oiasso.systems.spring4mavenbasecorelib.facade;

import oiasso.systems.spring4mavenbasecorelib.beans.Calculadora;


public interface CalculadoraFacade {
  /**
   * Obtiene numeros para sumar
   * 
   * @return int con resultado de la suma
   */
  public int suma(Calculadora calculadora);

  /**
   * Obtiene numeros para restar
   * 
   * @return int con resultado de la resta
   */
  public int resta(Calculadora calculadora);

  /**
   * Obtiene numeros para multiplicar
   * 
   * @return int con resultado de la multiplicacion
   */
  public int multiplicacion(Calculadora calculadora);

  /**
   * Obtiene numeros para dividir
   * 
   * @return int con resultado de la division
   */
  public double division(Calculadora calculadora);
}
