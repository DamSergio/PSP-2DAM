package numerosTCP;

import java.io.Serializable;

public class Numero implements Serializable {
	private int numero;
	private long cuadrado;
	private long cubo;
	
	public Numero(int numero) {
		super();
		this.numero = numero;
		this.cuadrado = 0l;
		this.cubo = 0l;
	}
	
	public Numero() {
		super();
		this.numero = 0;
		this.cuadrado = 0;
		this.cubo = 0;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public long getCuadrado() {
		return cuadrado;
	}

	public void setCuadrado(long cuadrado) {
		this.cuadrado = cuadrado;
	}

	public long getCubo() {
		return cubo;
	}

	public void setCubo(long cubo) {
		this.cubo = cubo;
	}

	@Override
	public String toString() {
		return "Numero [numero=" + numero + ", cuadrado=" + cuadrado + ", cubo=" + cubo + "]";
	}
}
