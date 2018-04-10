package oiasso.systems.spring4mavenbasecorelib.beans;

import java.io.Serializable;


public class Calculadora implements Serializable {

  private static final long serialVersionUID = 1L;

  private int numero1;
  private int numero2;
  private int numero3;

  public int getNumero1() {
    return this.numero1;
  }

  public void setNumero1(final int numero1) {
    this.numero1 = numero1;
  }

  public int getNumero2() {
    return this.numero2;
  }

  public void setNumero2(final int numero2) {
    this.numero2 = numero2;
  }

  public int getNumero3() {
    return this.numero3;
  }

  public void setNumero3(final int numero3) {
    this.numero3 = numero3;
  }
}
