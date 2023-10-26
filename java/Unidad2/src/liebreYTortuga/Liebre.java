package liebreYTortuga;

public class Liebre extends Thread{
	int id;
	
	public Liebre(int id) {
		this.id = id;
	}
	
	public void run() {
		int i = 0;
		System.out.println("Empieza la liebre" + id);
		while(i < 10) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.print(" L" + id + " ");
			i++;
		}
		
		System.out.println("\nLlega a la meta la liebre" + id);
	}
}
