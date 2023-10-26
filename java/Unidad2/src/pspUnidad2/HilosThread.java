package pspUnidad2;

public class HilosThread {

	public static void main(String[] args) {
		// Creamos hilos
		Hilo1 h1 = new Hilo1(1);
		Hilo1 h2 = new Hilo1(2);
		Hilo1 h3 = new Hilo1(3);
		// Los lanzamos
		h1.start();
		h2.start();
		h3.start();
		
		System.out.println("FIN");
	}

}
