package pspUnidad2;

public class Hilo2 implements Runnable{
	int id;
	
	public Hilo2(int id) {
		this.id = id;
	}
	@Override
	public void run() {
		System.out.println("Hilo " + id);
	}
}
