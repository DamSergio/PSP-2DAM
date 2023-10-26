package pspUnidad2;

public class HilosRunnable {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("INICIO");
		
		Thread h1 = new Thread(new Hilo2(1));
		Thread h2 = new Thread(new Hilo2(2));
		Thread h3 = new Thread(new Hilo2(3));
		
		h1.start();
		h2.start();
		h3.start();
		
		h1.join();
		h2.join();
		h3.join();
		
		System.out.println("FIN");
	}

}
