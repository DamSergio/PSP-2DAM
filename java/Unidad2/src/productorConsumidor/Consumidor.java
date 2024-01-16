package productorConsumidor;

public class Consumidor extends Thread{
	private Cinta c;
	private int id;
	
	public Consumidor(Cinta c, int id) {
		this.c = c;
		this.id = id;
	}
	
	public void run() {
		int valor;
		
		for (int i = 0; i < 5; i++) {
			valor = c.get();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
