package productorConsumidor;

public class Cinta {
	private int numero;
	private boolean disponible;
	
	public Cinta() {
		super();
		this.numero = 0;
		this.disponible = false;
	}
	
	public synchronized int get() {
		while (!disponible) {
			System.out.println("Cinta vacia");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Consumido " + this.numero);
		this.disponible = false;
		notify();
		return this.numero;
	}
	
	public synchronized void set(int numero) {
		while (disponible) {
			System.out.println("Cinta llena");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.disponible = true;
		this.numero = numero;
		System.out.println("Producido " + this.numero);
		notify();
	}
}
