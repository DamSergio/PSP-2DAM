package productorConsumidor;

public class Productor extends Thread {
	private Cinta c;
	private int id;
	
	public Productor(Cinta c, int id) {
		this.c = c;
		this.id = id;
	}
	
	public void run() {
		for (int i = 0; i < 5; i++) {
			c.set(i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
