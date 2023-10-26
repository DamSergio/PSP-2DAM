package cuenta;

public class Cuenta {
	private double saldo;
	private final double MAX = 1000;

	public Cuenta(double saldo) {
		super();
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double getMAX() {
		return this.MAX;
	}
	
	public synchronized void retirarSaldo(double cantidad, String nombre) {
		System.out.println(nombre + " va a retirar " + cantidad);
		if (this.saldo - cantidad < 0) {
			System.out.println("La cuenta esta en numero rojos");
			System.out.println("El saldo es: " + this.getSaldo());
			return;
		} 
		this.setSaldo(this.saldo - cantidad);
		System.out.println("El saldo es: " + this.getSaldo());
	}

	public synchronized void ingresarSaldo(double cantidad, String nombre) {
		System.out.println(nombre + " va a ingresar " + cantidad);
		if (this.saldo + cantidad > MAX) {
			System.out.println("La cuenta se ha pasado");
			System.out.println("El saldo es: " + this.getSaldo());
			return;
		} 
		this.setSaldo(this.saldo + cantidad);
		System.out.println("El saldo es: " + this.getSaldo());
	}
}
