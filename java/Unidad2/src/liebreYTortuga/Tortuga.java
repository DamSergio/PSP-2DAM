package liebreYTortuga;

public class Tortuga extends Thread{
	int id;
	
	public Tortuga(int id) {
		this.id = id;
	}
	
	public void run() {
		int i = 0;
		System.out.println("Empieza la tortuga" + id);
		while(i < 10) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.print(" T" + id + " ");
			i++;
		}
		
		System.out.println("\nLlega a la meta la tortuga" + id);
	}
}
