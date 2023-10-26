package controlHilos;

public class HiloCadena extends Thread{
	private Compartido c;
	private String cadena;
	
	public HiloCadena(Compartido c, String cadena) {
		super();
		this.c = c;
		this.cadena = cadena;
	}
	
	public void run() {
		synchronized(c) {
			for (int i = 0; i < 10; i++) {
				c.pintaCadena(cadena);
				c.notify(); // notificar que se ha imprimido
				
				try {
					c.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			c.notifyAll();
		}
	}
}
