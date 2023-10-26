package contador;

public class Contador {
	private int cont;
	
	public Contador(int cont) {
		this.cont = cont;
	}
	
	public synchronized void increase() {
		this.cont++;
	}
	
	public synchronized void decrease() {
		this.cont--;
	}

	public int getCont() {
		return cont;
	}
}
