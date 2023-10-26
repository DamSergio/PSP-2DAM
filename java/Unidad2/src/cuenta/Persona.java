package cuenta;

public class Persona extends Thread{
	private Cuenta cuenta;
	private String nombre;
	
	public Persona(Cuenta cuenta, String nombre) {
		super();
		this.cuenta = cuenta;
		this.nombre = nombre;
		this.setName(nombre);
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void run() {
		for (int i = 0; i < 2; i++) {
			int ingreso = (int) (Math.random()*500+1);
			cuenta.ingresarSaldo(ingreso, nombre);
			System.out.println(nombre + " SALDO ACTUAL ES: " + cuenta.getSaldo());
			
			try {
				this.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			int retirada = (int) (Math.random()*500+1);
			cuenta.retirarSaldo(retirada, nombre);
			System.out.println(nombre + " SALDO ACTUAL ES: " + cuenta.getSaldo());
		}
	}
}
