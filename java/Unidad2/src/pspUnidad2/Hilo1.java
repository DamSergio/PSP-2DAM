package pspUnidad2;

public class Hilo1 extends Thread{
	int id;
	
	public Hilo1(int id) {
		this.id = id;
	}
	//Funcionalidad
	public void run() {
		System.out.println("Hilo " + id);
	}
}
